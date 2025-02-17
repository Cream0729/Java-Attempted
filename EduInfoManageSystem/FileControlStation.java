package EduInfoManageSystem;

import java.io.*;
import java.util.HashSet;

public class FileControlStation {
    private final HashSet<Person.StudentData> studentData = new HashSet<>();
    private final HashSet<Person.TeacherData> teacherData = new HashSet<>();
    private final boolean control;

    public FileControlStation() {
        control = true;
    }

    public FileControlStation(String date, HashSet<Person.StudentData> students, HashSet<Person.TeacherData> teachers) {
        control = false;
        try {
            File file = new File("src" + File.separator + "EduInfoManageSystem", date + ".data");
            if (file.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                studentData.addAll((HashSet<Person.StudentData>) ois.readObject());
                teacherData.addAll((HashSet<Person.TeacherData>) ois.readObject());
                ois.close();
            } else {
                studentData.add(new Person.StudentData(0L, "editDate", "name", "gender", 0, "job"));
                teacherData.add(new Person.TeacherData(0L, "editDate", "name", "gender", 0, "type", "job"));
            }
            if (students != null) {
                studentData.addAll(students);
            }
            if (teachers != null) {
                teacherData.addAll(teachers);
            }
            (new Thread(new Save(date, studentData, teacherData, file))).start();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *  只读已有数据，无法进行数据修改
     * @param date 文件名（日期 - 已规范输入）
     */
    public void checkData(String date) {
        // 拒绝带参构造使用方法
        if (!control) throw new IllegalStateException("checkData method cannot be used after initializing with parameters.");

        try {
            if (date.equals("All")) {
                File[] files = new File("src", "EduInfoManageSystem").listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.getName().endsWith(".data")) {
                            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                            studentData.addAll((HashSet<Person.StudentData>) ois.readObject());
                            teacherData.addAll((HashSet<Person.TeacherData>) ois.readObject());
                            ois.close();
                        }
                    }
                }
            } else {
                File file = new File("src" + File.separator + "EduInfoManageSystem", date + ".data");
                if (file.exists()) {
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                    studentData.addAll((HashSet<Person.StudentData>) ois.readObject());
                    teacherData.addAll((HashSet<Person.TeacherData>) ois.readObject());
                    ois.close();
                } else {
                    System.err.println(">>> No such file or directory");
                }
            }

            System.out.println("\n>>> Searching\n");
            for (Person.StudentData student : studentData) {
                System.out.println(student.toString());
            }
            System.out.println();
            for (Person.TeacherData teacher : teacherData) {
                System.out.println(teacher.toString());
            }
            System.out.println("\n>>> End...\n");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 更新传入的数据
     * @param date 文件名（日期 - 已规范输入）
     * @param students 学生数据 - HashSet
     * @param teachers 教职数据 - HashSet
     */
    public void refreshData(String date, HashSet<Person.StudentData> students, HashSet<Person.TeacherData> teachers) {
        // 拒绝带参构造使用方法
        if (!control) throw new IllegalStateException("checkData method cannot be used after initializing with parameters.");

        File file = new File("src" + File.separator + "EduInfoManageSystem", date + ".data");
        if (file.exists()) {
            (new Thread(new Save(date, students, teachers, file))).start();
        } else {
            System.err.println(">>> No such file or directory");
        }
    }

    private static class Save implements Runnable {
        private final HashSet<Person.StudentData> studentData;
        private final HashSet<Person.TeacherData> teacherData;
        private final String fileName;
        private final File file;

        public Save(String fileName, HashSet<Person.StudentData> students, HashSet<Person.TeacherData> teachers, File file) {
            this.fileName = fileName;
            this.studentData = students;
            this.teacherData = teachers;
            this.file = file;
        }

        @Override
        public void run() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(studentData);
                oos.writeObject(teacherData);
                oos.close();
                System.out.println(">>> Saved [" + fileName + ".data] successfully.");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}