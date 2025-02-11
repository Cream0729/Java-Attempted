package TheVeryBeginning;

import java.security.SecureRandom;

public class Main_exchange {

    public static void main(String args[]) {
        int[] arrays = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        
        System.out.println("原始数组如下所示：");
        printArray(arrays);
        //反转
        reverseArray(arrays);
        System.out.println("反转数组如下所示：");
        printArray(arrays);
        // 打乱
        shuffleArray(arrays);
        System.out.println("打乱数组如下所示：");
        printArray(arrays);
    }
        //类
    public static void reverseArray(int[] arrays) {
        for (int i = 0, j = arrays.length - 1; i < j; i++, j--) {
            int temp = arrays[i];
            arrays[i] = arrays[j];
            arrays[j] = temp;
        }
    }

    public static void shuffleArray(int[] arrays) {
        SecureRandom r = new SecureRandom();
        for (int i = 0; i < arrays.length; i++) {
            int randomIndex = r.nextInt(arrays.length);
            int temp = arrays[i];
            arrays[i] = arrays[randomIndex];
            arrays[randomIndex] = temp;
        }
    }

    public static void printArray(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(" |" + arrays[i] + "| ");
        }
        System.out.println();
    }
}