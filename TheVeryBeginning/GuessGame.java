package TheVeryBeginning;

import java.security.*;
import java.util.*;

public class GuessGame {
    public static void main(String[] args) {
        SecureRandom r = new SecureRandom();
        Scanner sc = new Scanner(System.in);
        int key = r.nextInt(101);
        System.out.println("猜字游戏正式开始！");
        for (int i = 4; i >= 0; i--) {
            System.out.print(">>>现在输入你所猜的数字(0~100)：");
            int guess = sc.nextInt();
            if (guess < 0 || guess > 100) {
                System.out.println("所猜的数字不在合法范围内");
                i++;
            } else if (key == guess) {
                System.out.println("【恭喜你猜对啦！！】");
            } else if (guess > key && i > 0) {
                System.out.println("您猜的数字偏大了哦，当前剩余[ " + i + " ]次机会");
            } else if (guess < key && i > 0) {
                System.out.println("您猜的数字偏小了哦，当前剩余[ " + i + " ]次机会");
            } else if (guess != key && i == 0) {
                System.out.println("很遗憾，您未在规定次数内猜中正确答案，正确答案为：" + key);
            }
        }
        sc.close();
    }
}