package TheVeryBeginning;

import java.util.Scanner;
public class ForAdd {
    public static void main (String args []){
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入从0到N的数N：");
        int Into = sc.nextInt();
        System.out.print("请输入从0到N的可被X整除的X：");
        int By = sc.nextInt();
        int End = 0;
        for (int i = 0 ; i <= Into ; i = i + By){
            System.out.println("+" + i);
            End = End + i;
        }
        System.out.println("最终结果为" + End);
        sc.close();
    }
}