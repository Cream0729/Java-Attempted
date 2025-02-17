package EduInfoManageSystem;

import java.io.*;
import java.util.HashSet;

public class FileControlStation {
    public FileControlStation(String fileName, HashSet<Person.StudentData> students, HashSet<Person.TeacherData> teachers) {
        HashSet<Person.StudentData> studentData = new HashSet<>(students);
        HashSet<Person.TeacherData> teacherData = new HashSet<>(teachers);

        File file = new File("src" + File.separator + "EduInfoManageSystem", fileName + ".data");
        (new Thread(new Save(fileName, studentData, teacherData, file))).start();
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