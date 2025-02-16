package SchoolInformationManagement;

import java.io.*;
import java.util.HashSet;

/**
 * 文件操作控制站点
 * <p>对数据进行存储
 */
public class FileControlStation {
    ObjectOutputStream out = null;
    HashSet<PersonData.Student> students = new HashSet<>();
    HashSet<PersonData.Teacher> teachers = new HashSet<>();

    public void inputData(HashSet<PersonData.Student> studentsTemp, HashSet<PersonData.Teacher> teachersTemp, String date) {
        try {
            // 读&写
            File file = new File("src\\SchoolInformationManagement", date + ".data");
            if (file.exists()) {
                ObjectInputStream oj = new ObjectInputStream(new FileInputStream(file));
                students.addAll((HashSet<PersonData.Student>) oj.readObject());
                students.addAll(studentsTemp);
                teachers.addAll((HashSet<PersonData.Teacher>) oj.readObject());
                teachers.addAll(teachersTemp);
                oj.close();
            }
            (new Thread(new inputDataThread(students, teachers, date))).start();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        for (PersonData.Student student : students) {
            System.out.println(student.toString());
        }

        for (PersonData.Teacher teacher : teachers) {
            System.out.println(teacher.toString());
        }
    }

    public void readData(File file) {
        try {
            if (file.exists()) {
                ObjectInputStream oj = new ObjectInputStream(new FileInputStream(file));
                for (PersonData.Student student : ((HashSet<PersonData.Student>) oj.readObject())) {
                    System.out.println(student.toString());
                }
                for (PersonData.Teacher teacher : ((HashSet<PersonData.Teacher>) oj.readObject())) {
                    System.out.println(teacher.toString());
                }
            } else {
                System.out.println("File does not exist");
            }
        } catch (IOException | ClassNotFoundException ignored) {
        }
    }

    private class inputDataThread implements Runnable {
        HashSet<PersonData.Student> students;
        HashSet<PersonData.Teacher> teachers;
        String date;

        public inputDataThread(HashSet<PersonData.Student> students, HashSet<PersonData.Teacher> teachers, String date) {
            this.students = students;
            this.teachers = teachers;
            this.date = date;
        }

        @Override
        public void run() {
            try {
                out = new ObjectOutputStream(new FileOutputStream(new File("src\\SchoolInformationManagement", date + ".data"), false));
                out.writeObject(students);
                out.writeObject(teachers);
                System.out.println("Data had inserted...");
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (out != null) {
                        out.close();
                    }
                } catch (IOException ignored) {
                }
            }
        }
    }
}