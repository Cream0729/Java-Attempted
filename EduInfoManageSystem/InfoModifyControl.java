package EduInfoManageSystem;

import java.util.Scanner;

public class InfoModifyControl {
    static Scanner sc = new Scanner(System.in);
    static StanderControl control = new StanderControl();

    /**
     *
     * @param fcs 传入执行保存的对象（更改文件使用）
     * @param student 传入的个体对象student
     */
    public InfoModifyControl(FileControlStation fcs, DataStation.Student student) {
        do {
            System.out.println("==============");
            System.out.println("‖ <1> Name - ‖");
            System.out.println("‖ <2> Age - -‖");
            System.out.println("‖ <3> Gender ‖");
            System.out.println("‖ <4> Job - -‖");
            System.out.println("==============");

            System.out.print(">>> Now, enter your choice: ");
            contChoice:
            while (true) {  // 选择分流，并依据选择调用传入对象的set
                switch (sc.next()) {
                    // 更改已保存对象的数据（预设的set）
                    case "1":
                        System.out.print(">>> Now, enter Name: ");
                        student.setName(sc.next());
                        break contChoice;
                    case "2":
                        System.out.print(">>> Now, enter Age: ");
                        student.setAge(control.age());
                        break contChoice;
                    case "3":
                        System.out.print(">>> Now, enter Gender: ");
                        student.setGender(control.gender());
                        break contChoice;
                    case "4":
                        System.out.print(">>> Now, enter Job: ");
                        student.setJob(sc.next());
                        break contChoice;
                    default:
                        System.out.println("\nentered the wrong choice, please try again.");
                        break;
                }
            }
        } while (control.isValid(">>> 是否继续修改？"));

        System.out.println(student);
        if (control.isValid(">>> 是否保存本次修改")) {
            fcs.save(false);
        } else {
            System.out.println(">>> 数据未保存");
        }
    }

    /**
     *
     * @param fcs 传入执行保存的对象（更改文件使用）
     * @param teacher 传入的个体对象teacher
     */
    public InfoModifyControl(FileControlStation fcs, DataStation.Teacher teacher) {
        do {
            System.out.println("==============");
            System.out.println("‖ <1> Name - ‖");
            System.out.println("‖ <2> Age - -‖");
            System.out.println("‖ <3> Gender ‖");
            System.out.println("‖ <4> Job - -‖");
            System.out.println("‖ <5> Type - ‖");
            System.out.println("==============");

            System.out.print(">>> Now, enter your choice: ");
            contChoice:
            while (true) {  // 选择分流，并依据选择调用传入对象的set
                switch (sc.next()) {
                    // 更改已保存对象的数据（预设的set）
                    case "1":
                        System.out.print(">>> Now, enter Name: ");
                        teacher.setName(sc.next());
                        break contChoice;
                    case "2":
                        System.out.print(">>> Now, enter Age: ");
                        teacher.setAge(control.age());
                        break contChoice;
                    case "3":
                        System.out.print(">>> Now, enter Gender: ");
                        teacher.setGender(control.gender());
                        break contChoice;
                    case "4":
                        System.out.print(">>> Now, enter Job: ");
                        teacher.setJob(sc.next());
                        break contChoice;
                    case "5":
                        System.out.print(">>> Now, enter Type: ");
                        teacher.setType(sc.next());
                        break contChoice;
                    default:
                        System.out.println("\nentered the wrong choice, please try again.");
                        break;
                }
            }
        } while (control.isValid(">>> 是否继续修改？"));

        System.out.println(teacher);
        if (control.isValid(">>> 是否保存本次修改")) {
            fcs.save(false);
        } else {
            System.out.println(">>> 数据未保存");
        }
    }
}