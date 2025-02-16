package SchoolInformationManagement;

import java.util.HashSet;

public class Test_FileControl {
    public static void main(String[] args) {
        re();
    }

    public static void in (){
        // 创建一些示例学生和老师数据
        HashSet<PersonData.Student> students = new HashSet<>();
        students.add(new PersonData.Student("2022-02-16", "Alice", "Female", 20, 1, "Math"));
        students.add(new PersonData.Student("2022-02-16", "Bob", "Male", 21, 2, "History"));
        students.add(new PersonData.Student("2022-02-16", "Charlie", "Male", 22, 3, "Science"));
        students.add(new PersonData.Student("2022-02-16", "Daisy", "Female", 23, 4, "English"));
        students.add(new PersonData.Student("2022-02-16", "Eva", "Female", 24, 5, "Art"));

        HashSet<PersonData.Teacher> teachers = new HashSet<>();
        teachers.add(new PersonData.Teacher("2022-02-16", "Frank", "Male", 40, 101, "Math"));
        teachers.add(new PersonData.Teacher("2022-02-16", "Grace", "Female", 38, 102, "History"));
        teachers.add(new PersonData.Teacher("2022-02-16", "Henry", "Male", 42, 103, "Science"));
        teachers.add(new PersonData.Teacher("2022-02-16", "Ivy", "Female", 45, 104, "Art"));
        teachers.add(new PersonData.Teacher("2022-02-16", "Jack", "Male", 39, 105, "Physical Education"));

        // 创建FileControl对象并调用inputData方法
        FileControlStation fileControlStation = new FileControlStation();
        fileControlStation.inputData(students, teachers, "2022-02-16");
    }

    public static void re(){
        FileControlStation fileControlStation = new FileControlStation();
        fileControlStation.readData("2022-02-16");
    }
}