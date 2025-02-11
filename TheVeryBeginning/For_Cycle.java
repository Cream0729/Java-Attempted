package TheVeryBeginning;

public class For_Cycle {
//tips:while可用布尔类，for只能用整数类-
    public static void main(String args[]) {
        for (int i = 1; i > 0; i++) {
            //if (i == N){continue;} //此为跳转控制语---插入跳过本次循环
            //if (i == N){break;} //此为跳转控制语---结束循环
            System.out.println("现在是第" + i + "次循环");
        }
    }
}