package EduInfoManageSystem;

import java.util.HashSet;
import java.util.Scanner;

public class InfoControlStation {
    private InputControlStation check = new InputControlStation();
    private HashSet<Person.StudentData> studentsTemp = null;
    private HashSet<Person.TeacherData> teachersTemp = null;
    private Scanner input = new Scanner(System.in);
    private TempStation temp = null;

    public InfoControlStation(String date) {
        temp = new TempStation(date);
        studentsTemp = temp.getStudentsTemp();
        teachersTemp = temp.getTeachersTemp();
    }

    public void inputInformation() {
        label:
        while (true) {
            try {
                System.out.println("\n=====信息录入=====");
                System.out.println("‖ <1>学生信息录入 ‖");
                System.out.println("‖ <2>教职信息录入 ‖");
                System.out.println("‖ <3>结束本次录入 ‖");
                System.out.println("================");
                System.out.print("\n>>> 输入序号以执行：");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        personInformation("studentsData");
                        break;
                    case 2:
                        personInformation("teachersData");
                        break;
                    case 3:
                        break label;
                    default:
                        throw new Exception();
                }

                if (check.isValid("是否退出本次录入程序？")) {
                    temp.save();
                    break;
                }
            } catch (Exception ignored) {
                System.err.println("\n非法输入，请重试");
            }
        }
    }

    private void personInformation(String type) {
        do {
            System.out.println("\n>>> Class [" + type + "] input start.");
            long id = check.id();
            System.out.print("Now, Enter name: ");
            String name = input.next();
            String gender = check.gender();
            int age = check.age();
            if (type.equals("studentsData")) {
                System.out.print("Now, Enter job: ");
                String job = input.next();
                System.out.println("\n" + type + "{id=" + id + ", editDate='null'" + ", name=" + name + ", gender=" + gender + ", age=" + age + ", job=" + job + "}");
                if (check.isValid(">>> 是否录入本次数据？")) {
                    studentsTemp.add(new Person.StudentData(id, "null", name, gender, age, job));
                } else {
                    System.out.println(">>> 本次数据未录入...\n");
                }
            } else if (type.equals("teachersData")) {
                System.out.print("Now, Enter type: ");
                String tType = input.next();
                System.out.print("Now, Enter job: ");
                String job = input.next();
                System.out.println("\n" + type + "{id=" + id + ", editDate='null'" + ", name=" + name + ", gender=" + gender + ", age=" + age + ", type=" + tType + ", job=" + job + "}");
                if (check.isValid(">>> 是否录入本次数据？")) {
                    teachersTemp.add(new Person.TeacherData(id, "null", name, gender, age, tType, job));
                } else {
                    System.out.println(">>> 本次数据未录入...\n");
                }
            }
        } while (check.isValid(">>> 是否继续录入 [" + type + "] 数据？"));
    }
}