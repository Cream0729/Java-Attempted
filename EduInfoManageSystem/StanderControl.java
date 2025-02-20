package EduInfoManageSystem;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 信息输入规范控制站点（工具类）
 * <p> 基础硬性检测，为减免错误产生
 */
public class StanderControl {
    static Scanner sc = new Scanner(System.in);

    // 对省份代码，专业代码，唯一标识常量化
    // 以提升在正则表达式中代码可读及维护性
    final String PROVINCE = "((11|12|13|14|15|21|22|23|31|32|33|34|35|36|37|41|42|43|44|45|46|50|51|52|53|61|62|63|64|65|71|81|82|91)0)";
    final String SUBJECT_COURSE = "((\\d0\\d)0)";
    final String UNIQUE_CODE = "((?!00000)\\d{5})";

    public void admin() {
        while (true) {
            // 管理员通行证，目前使用硬编码，暂不进行操作
            System.out.print("Enter your account: ");
            String account = sc.next();
            System.out.print("Enter your password: ");
            String password = sc.next();
            if (account.equals("admin") && password.equals("2025year")) {
                System.out.println("You have successfully logged in!");
                break;
            } else {
                System.out.println("Wrong information!");
            }
        }
    }

    /**
     * 传入message以提示操作目的
     *
     * @param message 提示信息
     * @return boolean
     */
    public boolean isValid(String message) {
        while (true) {  // 规范检测（Yes/No）
            System.out.println("\n" + message);
            System.out.print("Now, enter \"yes\\Y\" or \"no\\N\" : ");
            String input = sc.next();
            if (input.equals("yes") || input.equals("Y") || input.equals("no") || input.equals("N")) {
                return (input.equals("yes") || input.equals("Y"));
            } else {
                System.out.println("\n>>> Wrong Enter! Please enter again! ");
            }
        }
    }

    /**
     * 性别输入规范（限定）
     *
     * @return gender
     */
    public String gender() {
        while (true) {  // 规范检测（性别）
            System.out.print("Now, enter \"male\" or \"female\" : ");
            String gender = sc.next();
            if (gender.equals("male") || gender.equals("female")) {
                return gender;
            }
            System.out.println("\n>>> Wrong Enter! Please enter again! ");
        }
    }

    /**
     * 规范年龄输入检测
     *
     * @return age
     */
    public int age() {
        while (true) {
            try {
                System.out.print("Now, enter age (0 - 100): ");
                int age = sc.nextInt();
                if (age > 100 || age < 0) {
                    throw new InputMismatchException("Age must be between 0 and 100");
                }
                return age;
            } catch (InputMismatchException e) {
                System.out.println("\n>>> Wrong Enter! Please enter again! ");
            }
        }
    }

    /**
     * 基础向ID规范（初步检测）
     *
     * @return id
     */
    public long id() {
        System.out.print("Now, enter ID: ");
        String id = sc.next();
        while (!(id.matches("^" + PROVINCE + SUBJECT_COURSE + UNIQUE_CODE + "$"))) {
            System.out.println("\n>>> Wrong Enter! Please enter again! ");
            System.out.print("Now, enter ID: ");
            id = sc.next();
        }
        return Long.parseLong(id);
    }

    public String date() {
        System.out.print("Now, enter date (yyyy): ");
        String date = sc.next();
        while (!(date.matches("^" + "(20)(\\d{2})" + "$"))) {
            System.out.println("\n>>> Wrong Enter! Please enter again! ");
            System.out.print("Now, enter date (yyyy): ");
            date = sc.next();
        }
        return date;
    }

    public boolean id(String id) {
        return (id.matches("^" + PROVINCE + SUBJECT_COURSE + UNIQUE_CODE + "$"));
    }

    public boolean date(String date) {
        return (date.matches("^" + "(20)(\\d{2})" + "$"));
    }
}