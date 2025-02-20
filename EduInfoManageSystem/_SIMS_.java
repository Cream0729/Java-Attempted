package EduInfoManageSystem;

import java.util.Scanner;

/**
 * 本系统为自行学习阶段测验，后续不进行维护
 * <p> 开始时间：2025-2-15[14:30]
 * <p> 完成时间：2025-2-19[10:55]
 * <p> 注释更新：2025-2-20[9:50]
 *
 * @author Cream - 炫
 * @version 3.00.00v（旧版文件已无法找到）
 */
public class _SIMS_ {
    static Scanner sc = new Scanner(System.in);
    static StanderControl control = new StanderControl();

    public static void main(String[] args) {
        label:
        while (true) {
            System.out.println("\n============== S.I.M.S ==============");
            System.out.println("‖ <1> Add fresh personal information‖");
            System.out.println("‖ <2> Remove personal information - ‖");
            System.out.println("‖ <3> Modify personal information - ‖");
            System.out.println("‖ <4> Search personal information - ‖");
            System.out.println("‖ <5> Exit the S.I.M.S. - - - - - - ‖");
            System.out.println("=====================================");
            inter:
            while (true) {
                try {
                    // 依选择分流，直接进行操作
                    System.out.print(">>> Now, enter your choice : ");
                    switch (sc.next()) {
                        case "1":
                            new InfoInputStation(control.date()).inputInformation();
                            break inter;
                        case "2":
                            new ModifyInfoStation("remove");
                            break inter;
                        case "3":
                            new ModifyInfoStation("modify");
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
                    System.err.println("\nentered the wrong choice, please try again.");
                }
            }
            // 输入判断是否结束程序
            if (control.isValid(">>> 是否退出 [S.I.M.S] 系统？")) {
                System.out.println("\n>>> S.I.M.S 已退出...");
                break;
            }
        }
    }
}