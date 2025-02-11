package TheVeryBeginning;

import java.util.Scanner;
public class Scanner_If {
    public static void main (String args []){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要对比大小的值");
        int eg_1 = sc.nextInt();
        int eg_2 = sc.nextInt();
        if(eg_1 > eg_2 | eg_1 < eg_2)
        {if(eg_1 > eg_2){System.out.println("前者大于后者");}
         if(eg_2 > eg_1){System.out.println("后者大于前者");}
        }else{System.out.println("二者相同");}
        sc.close();
    }
}