package EduInfoManageSystem;

import java.util.HashSet;

@SuppressWarnings("ALL")
public class Test_save {
    // 测试类，简单测试
    static FileControlStation temp = new FileControlStation("2024");

    public static void main(String[] args) {
        HashSet<DataStation.Student> studentsTemp = temp.getStudentsTemp();
        HashSet<DataStation.Teacher> teachersTemp = temp.getTeachersTemp();
        InfoInputStation ics = new InfoInputStation("2024");

        if (false) {
            // Student for text.
            studentsTemp.add(new DataStation.Student(1, null, "Alice", "Female", 20, "Math"));
            studentsTemp.add(new DataStation.Student(2, null, "Bob", "Male", 21, "History"));
            studentsTemp.add(new DataStation.Student(3, null, "Charlie", "Male", 22, "Science"));
            studentsTemp.add(new DataStation.Student(4, null, "Daisy", "Female", 23, "English"));
            studentsTemp.add(new DataStation.Student(5, null, "Eva", "Female", 24, "Art"));

            // Teacher for text.
            teachersTemp.add(new DataStation.Teacher(101, null, "Frank", "Male", 40, "Teacher", "Math"));
            teachersTemp.add(new DataStation.Teacher(102, null, "Alice", "Female", 32, "Teacher", "Chinese"));
            teachersTemp.add(new DataStation.Teacher(103, null, "Bob", "Male", 51, "Teacher", "History"));
            teachersTemp.add(new DataStation.Teacher(104, null, "Charlie", "Male", 37, "Teacher", "Math"));
            teachersTemp.add(new DataStation.Teacher(105, null, "Daisy", "Female", 43, "Teacher", "English"));

            temp.save(false);
        } else {
            temp.read();
        }
        //ics.inputInformation();
    }
}