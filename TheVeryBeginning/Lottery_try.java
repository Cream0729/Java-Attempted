package TheVeryBeginning;

import java.security.SecureRandom;
import java.util.Scanner;

public class Lottery_try {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入抽奖次数：");
        SecureRandom r = new SecureRandom();
        int times = sc.nextInt();
        for (int i = 0; i < times; i++) {
            int end = r.nextInt(1000) + 1;
            if (end % 500 == 0) {
                System.out.println("恭喜你抽中了【一等奖】");
            } else if (end % 250 == 0) {
                System.out.println("恭喜你抽中了【二等奖】");
            } else if (end % 100 == 0) {
                System.out.println("恭喜你抽中了【三等奖】");
            } else if (end % 50 == 0) {
                System.out.println("恭喜你抽中了【安慰奖】");
            }
        }
        System.out.println("抽奖结束！！");
        sc.close();
    }
}