package TheVeryBeginning;//导包找类
import java.util.Scanner;
public class Scanner_Math {
    public static void main (String args []){
        //创建使用类
        Scanner sc = new Scanner(System.in);
        //启动提示
        System.out.println("请输入需要计算的值<number + number>");
        //记录并录入
        int log1 = sc.nextInt();
        int log2 = sc.nextInt();
        //输出结果
        System.out.println("计算结果" + log1 + "+" + log2 + "=" + (log1 + log2));
        System.out.println("请输入需要计算的值<" + (log1 + log2) + " x number>");
        int log3 = sc.nextInt();
        System.out.println("计算结果" + (log1 + log2) + "x" + log3 + "=" + ((log1 + log2) * log3));
        sc.close();
    }
}