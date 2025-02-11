package TheVeryBeginning;

import java.security.SecureRandom;
import java.util.Scanner;

public class LotteryAndInversion {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入[1]将启动抽奖程序；");
        System.out.println("输入[2]将启动字符串倒改程序；");
        System.out.print("请输入你所想启动的程序：");
        int Open = sc.nextInt();
        String Out = "";

        if (Open == 1) {
            RandomChack();
        } else if (Open == 2) {
            String Recording = "";
            Out = StringInversion(Recording);
            System.out.println(">>> " + Out);
        }
        sc.close();
    }

    public static void RandomChack() {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入抽奖次数：");
        SecureRandom r = new SecureRandom();
        int times = sc.nextInt();
        System.out.println("抽[" + times + "]次的结果如下：");
        for (int i = 0; i < times; i++) {
            int end = r.nextInt(1000) + 1;
            if (end % 500 == 0) {
                System.out.println(">>恭喜你抽中了【一等奖】");
            } else if (end % 250 == 0) {
                System.out.println(">>恭喜你抽中了【二等奖】");
            } else if (end % 100 == 0) {
                System.out.println(">>恭喜你抽中了【三等奖】");
            } else if (end % 50 == 0) {
                System.out.println(">>恭喜你抽中了【安慰奖】");
            }
        }
        sc.close();
    }

    public static String StringInversion(String Recording) {
        Scanner sc = new Scanner(System.in, "GBK");
        System.out.print("请输入一个字符串以测试倒置：");
        String ST = sc.next();
        for (int i = ST.length() - 1; i >= 0; i--) {
            char Temp = ST.charAt(i);
            Recording = Recording + Temp;
        }
        sc.close();
        return Recording;
    }

}