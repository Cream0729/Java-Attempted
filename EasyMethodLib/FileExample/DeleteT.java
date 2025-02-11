package EasyMethodLib.FileExample;

import java.io.File;
import java.util.Random;
import java.util.Scanner;

public class DeleteT {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {
        System.out.print("你是否清楚你在干什么？（是）：");
        String check = sc.next();
        if (check.equals("是")) {
            System.out.print("再次确认删除T盘？（确认）：");
            check = sc.next();
            if (check.equals("确认")) {
                int A = rand.nextInt(100) + 1;
                int B = rand.nextInt(100) + 1;
                System.out.print(A + "+" + B + "=");
                int ans = sc.nextInt();
                if (ans == (A + B)) {
                    File DT = new File("T:\\");
                    de(DT);
                    System.out.println("T:\\ has been deleted");
                }
            }
        } else {
            System.out.println("验证失败，T盘无任何改动");
        }
    }

    public static void de(File fs) {
        // 遍历目标文件以逐一清理
        File[] files = fs.listFiles();
        if (files != null) {
            for (File file : files) {
                if (!file.delete()) {
                    de(file);
                }
            }
        }
        if (fs.delete()) System.out.print("");
    }
}