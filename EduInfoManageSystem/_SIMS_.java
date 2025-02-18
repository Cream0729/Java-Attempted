package EduInfoManageSystem;

import java.util.Scanner;

public class _SIMS_ {
    static Scanner sc = new Scanner(System.in);
    static StanderControl control = new StanderControl();

    public static void main(String[] args) {
        label:
        while (true) {
            System.out.println("\n============== S.I.M.S ==============");
            System.out.println("‖ <1> Add fresh personal information‖");
            System.out.println("‖ <2> Remove personal information - ‖");
            System.out.println("‖ <3> Modified personal information ‖");
            System.out.println("‖ <4> Search personal information - ‖");
            System.out.println("‖ <5> Exit the S.I.M.S. - - - - - - ‖");
            System.out.println("=====================================");
            inter:
            while (true) {
                try {
                    System.out.print(">>> Now, enter your choice : ");
                    switch (sc.next()) {
                        case "1":
                            new InfoInputStation(control.date()).inputInformation();
                            break inter;
                        case "2":
                            break inter;
                        case "3":
                            break inter;
                        case "4":
                            new SearchStation();
                            break inter;
                        case "5":
                            System.out.println("Exiting program...");
                            break label;
                        default:
                            throw new IllegalArgumentException();
                    }
                } catch (IllegalArgumentException ignored) {
                    System.err.println("\n非法输入，请重试");
                }
            }
            if (control.isValid(">>> 是否退出 [S.I.M.S] 系统？")) {
                System.out.println("\n>>> S.I.M.S 已退出...");
                break;
            }
        }
    }
}