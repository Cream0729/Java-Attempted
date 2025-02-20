package EduInfoManageSystem;

import java.io.*;
import java.util.HashSet;

public class FileControlStation {
    private final HashSet<DataStation.Student> studentsTemp = new HashSet<>();
    private final HashSet<DataStation.Teacher> teachersTemp = new HashSet<>();
    private boolean control = false;
    private final String date;

    public FileControlStation(String date) {
        if (!(new StanderControl().date(date))) throw new IllegalArgumentException(">>> Invalid date");

        try {
            this.date = date;
            File file = new File("src" + File.separator + "EduInfoManageSystem", this.date + ".data");
            if (file.exists()) {
                // 若在创建对象时文件存在，则读取目标文件读取至对象中
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                studentsTemp.addAll((HashSet<DataStation.Student>) ois.readObject());
                teachersTemp.addAll((HashSet<DataStation.Teacher>) ois.readObject());
                ois.close();
            } else {
                // 若在创建对象时文件不存在，则生成一个默认数据，由于id是0而无法被搜索到
                studentsTemp.add(new DataStation.Student(0L, "editDate", "name", "gender", 99, "job"));
                teachersTemp.add(new DataStation.Teacher(0L, "editDate", "name", "gender", 99, "type", "job"));
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 直接搜索已传入本类构造的数据
     */
    public void read() {
        if (control) {
            System.out.println("\n>>> Search [" + this.date + ".data] failed\n");
            throw new RuntimeException();
        }
        System.out.println("\n>>> Searching [" + this.date + ".data] ...\n");

        for (DataStation.Student student : this.studentsTemp) {
            System.out.println(student.toString());
        }
        System.out.println();
        for (DataStation.Teacher teacher : this.teachersTemp) {
            System.out.println(teacher.toString());
        }
    }

    /**
     * 对本类中已缓存的数据进行保存，并清理缓存（最终操作）
     *
     * @param prompt 提示文本控制
     */
    public void save(boolean prompt) {
        if (control) {
            System.out.println("\n>>> Save [" + this.date + ".data] failed\n");
            throw new RuntimeException();
        }
        (new Thread(new Save(this.date, this.studentsTemp, this.teachersTemp, prompt))).start();
        // 执行新线程后清理数据，简单防止线程安全问题，并使执行save后整个类无法使用
        studentsTemp.clear();
        teachersTemp.clear();
        control = true;
    }

    public HashSet<DataStation.Student> getStudentsTemp() {
        // 获取本对象所依据date读取的对象students
        return studentsTemp;
    }

    public HashSet<DataStation.Teacher> getTeachersTemp() {
        // 获取本对象所依据date读取的对象teachers
        return teachersTemp;
    }

    // 线程站
    private static class Save implements Runnable {
        private final HashSet<DataStation.Student> studentData;
        private final HashSet<DataStation.Teacher> teacherData;
        private final String fileName;
        private final boolean prompt;
        private final File file;

        // 将FileControlStation.save中的数据复制到类中，以保存数据
        public Save(String fileName, HashSet<DataStation.Student> students, HashSet<DataStation.Teacher> teachers, boolean prompt) {
            this.prompt = prompt;
            this.fileName = fileName;
            this.studentData = new HashSet<>(students);
            this.teacherData = new HashSet<>(teachers);
            this.file = new File("src" + File.separator + "EduInfoManageSystem", this.fileName + ".data");
            File lb = new File("src", "EduInfoManageSystem");
            if (!(lb.exists())) {
                if (lb.mkdirs()) {  // 文件夹不存在，则新建一个数据保存库的文件夹
                    System.out.println(">>> Creating " + lb.getAbsolutePath());
                }
            }
        }

        @Override
        public void run() {
            // 序列化并写入本地文件（路径暂不支持更改）
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(studentData);
                oos.writeObject(teacherData);
                oos.close();
                if (prompt) System.out.println(">>> Saved [" + fileName + ".data] successfully.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}