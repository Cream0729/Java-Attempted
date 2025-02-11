package SchoolInformationManagement;

import java.util.ArrayList;
import java.util.Scanner;

public class InformationControlStation {
    static InputControlStation check = new InputControlStation();
    static ArrayList<StudentData> student = new ArrayList<>();
    static ArrayList<TeacherData> teacher = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public void inputInformation() {
        label:
        while (true) {
            try {
                System.out.println("=====信息录入=====");
                System.out.println("‖ <1>学生信息录入 ‖");
                System.out.println("‖ <2>教职信息录入 ‖");
                System.out.println("‖ <3>结束本次录入 ‖");
                System.out.println("================");
                System.out.print("\n>>> 输入序号以执行：");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        personInformation("student");
                        break;
                    case 2:
                        personInformation("teacher");
                        break;
                    case 3:
                        break label;
                    default:
                        throw new Exception();
                }
                if (!check.isValid("是否继续录入数据？")) {
                    break;
                }
            } catch (Exception ignored) {
                System.err.println("\n非法输入，请重试");
            }
        }
    }

    private void personInformation(String types) {
        System.out.println(types + "录入开始，现在请按照指示输入信息：");
        System.out.print("姓名<Name>：");
        String name = input.next();
        System.out.println("性别<Gender>：");
        String gender = check.gender();
        System.out.println("年龄<Age>");
        int age = check.age();
        System.out.println("ID：");
        long id = check.id();
        if (types.equals("student")) {
            System.out.println("管理<Job>：");
            String job = input.next();
            System.out.println("student { name:" + name + ", gender:" + gender + ", age:" + age + ", id:" + id + ", job:" + job + "}");
            if (check.isValid("是否确定录入？")) {
                student.add(new StudentData(null, name, gender, age, id, job));
            } else {
                System.err.println("录入失败<IEntry failed>");
            }
        } else if (types.equals("teacher")) {
            System.out.println("职位<Type>：");
            String type = input.next();
            System.out.println("teacher {name:" + name + ", gender:" + gender + ", age:" + age + ", id:" + id + ", type:" + type + "}");
            if (check.isValid("是否确定录入？")) {
                teacher.add(new TeacherData(null, name, gender, age, id, type));
            } else {
                System.err.println("录入失败<IEntry failed>");
            }
        } else {
            throw new RuntimeException("Unknown exception");
        }
    }
}
