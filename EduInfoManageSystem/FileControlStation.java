package EduInfoManageSystem;

import java.io.*;
import java.util.HashSet;

public class FileControlStation {
    private final HashSet<DataStation.Student> studentsTemp = new HashSet<>();
    private final HashSet<DataStation.Teacher> teachersTemp = new HashSet<>();
    private final String date;

    public FileControlStation(String date) {
        if (!(new StanderControl().date(date))) throw new IllegalArgumentException(">>> Invalid date");

        try {
            this.date = date;
            File file = new File("src" + File.separator + "EduInfoManageSystem", this.date + ".data");
            if (file.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                studentsTemp.addAll((HashSet<DataStation.Student>) ois.readObject());
                teachersTemp.addAll((HashSet<DataStation.Teacher>) ois.readObject());
                ois.close();
            } else {
                studentsTemp.add(new DataStation.Student(0L, "editDate", "name", "gender", 0, "job"));
                teachersTemp.add(new DataStation.Teacher(0L, "editDate", "name", "gender", 0, "type", "job"));
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public HashSet<DataStation.Student> getStudentsTemp() {
        return studentsTemp;
    }

    public HashSet<DataStation.Teacher> getTeachersTemp() {
        return teachersTemp;
    }

    public void save(boolean prompt) {
        (new Thread(new Save(this.date, this.studentsTemp, this.teachersTemp, prompt))).start();
        studentsTemp.clear();
        teachersTemp.clear();
    }

    public void read() {
        System.out.println("\n>>> Searching [" + this.date + ".data] ...\n");

        for (DataStation.Student student : this.studentsTemp) {
            System.out.println(student.toString());
        }
        System.out.println();
        for (DataStation.Teacher teacher : this.teachersTemp) {
            System.out.println(teacher.toString());
        }

        System.out.println("\n>>> End ...\n");
    }

    private static class Save implements Runnable {
        private final HashSet<DataStation.Student> studentData;
        private final HashSet<DataStation.Teacher> teacherData;
        private final String fileName;
        private final boolean prompt;
        private final File file;

        public Save(String fileName, HashSet<DataStation.Student> students, HashSet<DataStation.Teacher> teachers, boolean prompt) {
            this.prompt = prompt;
            this.fileName = fileName;
            this.studentData = new HashSet<>(students);
            this.teacherData = new HashSet<>(teachers);
            this.file = new File("src" + File.separator + "EduInfoManageSystem", this.fileName + ".data");
        }

        @Override
        public void run() {
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