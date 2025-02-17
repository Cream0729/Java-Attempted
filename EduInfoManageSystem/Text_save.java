package EduInfoManageSystem;

@SuppressWarnings("ALL")
public class Text_save {
    static TempStation temp = new TempStation();

    public static void main(String[] args) {
        if (false) {
            // StudentData for text.
            temp.add(new Person.StudentData(1L, null, "Alice", "Female", 20, "Math"));
            temp.add(new Person.StudentData(2L, null, "Bob", "Male", 21, "History"));
            temp.add(new Person.StudentData(3L, null, "Charlie", "Male", 22, "Science"));
            temp.add(new Person.StudentData(4L, null, "Daisy", "Female", 23, "English"));
            temp.add(new Person.StudentData(5L, null, "Eva", "Female", 24, "Art"));

            // TeacherData for text.
            temp.add(new Person.TeacherData(101L, null, "Frank", "Male", 40, "Teacher", "Math"));
            temp.add(new Person.TeacherData(102L, null, "Alice", "Female", 32, "Teacher", "Chinese"));
            temp.add(new Person.TeacherData(103L, null, "Bob", "Male", 51, "Teacher", "History"));
            temp.add(new Person.TeacherData(104L, null, "Charlie", "Male", 37, "Teacher", "Math"));
            temp.add(new Person.TeacherData(105L, null, "Daisy", "Female", 43, "Teacher", "English"));

            temp.save("2024");
        } else {
            temp.read("2024");
        }
    }
}
