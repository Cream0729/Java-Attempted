package EasyMethodLib;

public class LoopTest {
    /**
     * 简单循环测试
     */
    public static void main(String[] args) {
        System.out.println();

        // 简单for循环
        int result = 0;
        for (int i = 0; i <= 10; i++) {
            result += i;
        }
        System.out.println("for loop (for循环) : 1+2+...+10= " + result);
        System.out.println();

        // 简单while循环
        result = 0;
        int i = 0;
        while (i <= 10) {
            result += i;
            i++;
        }
        System.out.println("while loop (while循环) : 1+2+...+10= " + result);
        System.out.println();

        // 简单 do-while循环
        result = 0;
        i = 0;
        do {
            result += i;
            i++;
        } while (i <= 10);
        System.out.println("do-while loop (do-while循环) : 1+2+...+10= " + result);
        System.out.println();

        // 增强for循环 一维数组
        result = 0;
        int[] sums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int getSum : sums) {
            result += getSum;
        }
        System.out.println("enhance for loop (增强for循环<等级1>) : 1+2+...+10= " + result);
        System.out.println();

        // 增强for循环 二维数组 遍历赋值
        result = 0;
        int label = 1;
        int[][] Sums = new int[10][10];
        for (int x = 0; x < Sums.length; x++) {
            for (int y = 0; y < Sums[x].length; y++) {
                Sums[x][y] = label;
                label++;
            }
        }
        for (int[] X : Sums) {
            for (int XY : X) {
                result += XY;
            }
        }
        System.out.println("enhance for loop (增强for循环<等级2>) : 1+2+3+4+...+100= " + result);
    }
}