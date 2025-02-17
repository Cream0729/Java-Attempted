package EduInfoManageSystem;

import java.util.HashSet;

public class TempStation {
    private final HashSet<Person.StudentData> studentsTemp = new HashSet<>();
    private final HashSet<Person.TeacherData> teachersTemp = new HashSet<>();

    public void add(HashSet<Person.StudentData> students, HashSet<Person.TeacherData> teachers) {
        if (students != null) {
            studentsTemp.addAll(students);
        } else if (teachers != null) {
            teachersTemp.addAll(teachers);
        } else {
            System.err.println("Warning: Haven't get any data here.");
        }
    }

    public void add(Person.StudentData student) {
        if (student != null) {
            studentsTemp.add(student);
        } else {
            System.err.println("Warning: Haven't get any data here.");
        }
    }

    public void add(Person.TeacherData teacher) {
        if (teacher != null) {
            teachersTemp.add(teacher);
        } else {
            System.err.println("Warning: Haven't get any data here.");
        }
    }

    public void save(String date) {
        new FileControlStation(date, this.studentsTemp, this.teachersTemp);
        studentsTemp.clear();
        teachersTemp.clear();
    }

    public void read(String date) {
        new FileControlStation().checkData(date);
    }
}