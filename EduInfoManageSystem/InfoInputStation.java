package EduInfoManageSystem;

import java.util.HashSet;
import java.util.Scanner;

public class InfoInputStation {
    private final StanderControl stan = new StanderControl();
    private final Scanner input = new Scanner(System.in);
    private final HashSet<DataStation.Student> studentsTemp;
    private final HashSet<DataStation.Teacher> teachersTemp;
    private final FileControlStation temp;
    private final String date;

    public InfoInputStation(String date) {
        this.date = date;
        temp = new FileControlStation(this.date);
        studentsTemp = temp.getStudentsTemp();
        teachersTemp = temp.getTeachersTemp();
    }

    public void inputInformation() {
        label:
        while (true) {
            try {   // 依选择分流
                System.out.println("\n=====信息录入=====");
                System.out.println("‖ <1>学生信息录入 ‖");
                System.out.println("‖ <2>教职信息录入 ‖");
                System.out.println("‖ <3>结束本次录入 ‖");
                System.out.println("================");

                System.out.print("\n>>> 输入序号以执行：");
                int choice = input.nextInt();
                switch (choice) {
                    case 1:
                        personInformation("Student");
                        break;
                    case 2:
                        personInformation("Teacher");
                        break;
                    case 3:
                        break label;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException ignored) {
                System.err.println("\n非法输入，请重试");
            }

            if (stan.isValid(">>> 是否退出本次录入程序？")) {
                temp.save(false);
                break;
            }
        }
    }

    /**
     * 传入预定的数据类型以保存数据
     *
     * @param type 数据类型
     */
    private void personInformation(String type) {
        do {
            System.out.println("\n>>> Class [" + type + "] input start.");
            long id = stan.id();
            System.out.print("Now, Enter name: ");
            String name = input.next();
            String gender = stan.gender();
            int age = stan.age();

            if (type.equals("Student")) {

                System.out.print("Now, Enter job: ");
                String job = input.next();

                System.out.println("\n" + type + " {id=" + id + ", editDate='" + this.date + "', name=" + name + ", gender=" + gender + ", age=" + age + ", job=" + job + "}");
                if (stan.isValid(">>> 是否录入以上数据？")) {
                    // 对所搜索到的数据进行处理
                    studentsTemp.add(new DataStation.Student(id, this.date, name, gender, age, job));
                } else {
                    System.out.println(">>> 本次数据未录入...");
                }

            } else if (type.equals("Teacher")) {

                System.out.print("Now, Enter type: ");
                String tType = input.next();
                System.out.print("Now, Enter job: ");
                String job = input.next();

                System.out.println("\n" + type + " {id=" + id + ", editDate='" + this.date + "', name=" + name + ", gender=" + gender + ", age=" + age + ", type=" + tType + ", job=" + job + "}");
                if (stan.isValid(">>> 是否录入以上数据？")) {
                    // 对所搜索到的数据进行处理
                    teachersTemp.add(new DataStation.Teacher(id, this.date, name, gender, age, tType, job));
                } else {
                    System.out.println(">>> 本次数据未录入...");
                }

            } else {
                // 非预定下异常传入（非输入）数据的异常抛出
                throw new RuntimeException();
            }
        } while (stan.isValid(">>> 是否继续录入 [" + type + "] 数据？"));
    }
}