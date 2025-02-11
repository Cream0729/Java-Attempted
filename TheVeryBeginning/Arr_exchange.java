package TheVeryBeginning;

import java.util.Random;

public class Arr_exchange {

    public static void main(String args[]) {
        Random r = new Random();
        int[] arrays = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println("原始数组如下所示：");
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(" |" + arrays[i] + "| ");
        }
        System.out.println();
        System.out.println("反转数组如下所示：");
        for (int i = 0, j = arrays.length - 1; i < j; i++, j--) {
            int Temp = arrays[i];
            arrays[i] = arrays[j];
            arrays[j] = Temp;
        }
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(" |" + arrays[i] + "| ");
        }
        System.out.println();
        System.out.println("打乱数组如下所示：");
        for (int i = 0, j = arrays.length - 1; i < j; i++, j--) {
            int Random = r.nextInt(arrays.length);
            int Temp = arrays[i];
            arrays[Random] = arrays[i];
            arrays[i] = Temp;
        }
        for (int i = 0; i < arrays.length; i++) {
            System.out.print(" |" + arrays[i] + "| ");
        }
    }
}