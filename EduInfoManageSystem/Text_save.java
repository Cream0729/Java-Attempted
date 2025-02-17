package EduInfoManageSystem;

import java.util.HashSet;

@SuppressWarnings("ALL")
public class Text_save {
    static TempStation temp = new TempStation("2024");

    public static void main(String[] args) {
        HashSet<Person.StudentData> studentsTemp = temp.getStudentsTemp();
        HashSet<Person.TeacherData> teachersTemp = temp.getTeachersTemp();
        InfoControlStation ics = new InfoControlStation("2024");

        if (false) {
            // StudentData for text.
            studentsTemp.add(new Person.StudentData(1, null, "Alice", "Female", 20, "Math"));
            studentsTemp.add(new Person.StudentData(2, null, "Bob", "Male", 21, "History"));
            studentsTemp.add(new Person.StudentData(3, null, "Charlie", "Male", 22, "Science"));
            studentsTemp.add(new Person.StudentData(4, null, "Daisy", "Female", 23, "English"));
            studentsTemp.add(new Person.StudentData(5, null, "Eva", "Female", 24, "Art"));

            // TeacherData for text.
            teachersTemp.add(new Person.TeacherData(101, null, "Frank", "Male", 40, "Teacher", "Math"));
            teachersTemp.add(new Person.TeacherData(102, null, "Alice", "Female", 32, "Teacher", "Chinese"));
            teachersTemp.add(new Person.TeacherData(103, null, "Bob", "Male", 51, "Teacher", "History"));
            teachersTemp.add(new Person.TeacherData(104, null, "Charlie", "Male", 37, "Teacher", "Math"));
            teachersTemp.add(new Person.TeacherData(105, null, "Daisy", "Female", 43, "Teacher", "English"));

            temp.save();
        } else {
            temp.read();
        }
        //ics.inputInformation();
    }
}