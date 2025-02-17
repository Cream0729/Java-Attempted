package EduInfoManageSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashSet;

public class TempStation {
    private final HashSet<Person.StudentData> studentsTemp = new HashSet<>();
    private final HashSet<Person.TeacherData> teachersTemp = new HashSet<>();
    private final String date;

    public TempStation(String date) {
        this.date = date;
        try {
            File file = new File("src" + File.separator + "EduInfoManageSystem", this.date + ".data");
            if (file.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                studentsTemp.addAll((HashSet<Person.StudentData>) ois.readObject());
                teachersTemp.addAll((HashSet<Person.TeacherData>) ois.readObject());
                ois.close();
            } else {
                studentsTemp.add(new Person.StudentData(0L, "editDate", "name", "gender", 0, "job"));
                teachersTemp.add(new Person.TeacherData(0L, "editDate", "name", "gender", 0, "type", "job"));
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public HashSet<Person.StudentData> getStudentsTemp() {
        return studentsTemp;
    }

    public HashSet<Person.TeacherData> getTeachersTemp() {
        return teachersTemp;
    }

    public void save() {
        new FileControlStation(this.date, this.studentsTemp, this.teachersTemp);
        studentsTemp.clear();
        teachersTemp.clear();
    }

    public void read() {
        System.out.println("\n>>> Searching [" + this.date + ".data] ...\n");

        for (Person.StudentData studentData : this.studentsTemp) {
            System.out.println(studentData.toString());
        }
        System.out.println();
        for (Person.TeacherData teacherData : this.teachersTemp) {
            System.out.println(teacherData.toString());
        }

        System.out.println("\n>>> End ...\n");
    }
}