package EasyMethodLib;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        int key = rand.nextInt(101);    // 随机一个0~100的数字
        int times = 5;  // 尝试次数上限
        System.out.println("|=+=+=+=》 猜数字游戏开始！你将有【" + times + "】次机会！《=+=+=+=|");
        System.out.println();
        System.out.print(">>> 现在，请输入你猜测的答案：[0~100]：");
        int guess = check(sc.next());

        while (times > 1) {
            times--;
            int square = rand.nextInt(6) + 10;  // 随机提示范围大小

            if (guess == key) {
                System.out.println(">>> 恭喜你猜对啦！！");
                break;
            } else if (guess > key && guess - key >= square) {
                System.out.print("你猜的数字太大啦！还有[" + times + "]次机会，请继续输入[0~100]：");
                guess = check(sc.next());
            } else if (guess < key && key - guess >= square) {
                System.out.print("你猜的数字太小啦！还有[" + times + "]次机会，请继续输入[0~100]：");
                guess = check(sc.next());
            } else if (guess > key && guess - key < square) {
                System.out.print("你猜的数字偏大啦！还有[" + times + "]次机会，请继续输入[0~100]：");
                guess = check(sc.next());
            } else if (guess < key && key - guess < square) {
                System.out.print("你猜的数字偏小啦！还有[" + times + "]次机会，请继续输入[0~100]：");
                guess = check(sc.next());
            }
        }

        if (guess != key) {
            System.out.println("很遗憾，游戏失败。正确答案是【" + key + "】");
        } else {
            System.out.println(">>> 恭喜你猜对啦！！");
        }
    }

    // 规范输入控制
    public static int check(String answer) {
        while (!(answer.matches("100|[1-9]?[1-9]"))) {
            System.out.print("非法答案，请重新输入[0~100]：");
            answer = sc.next();
        }
        return Integer.parseInt(answer);
    }
}