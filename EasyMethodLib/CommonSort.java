package EasyMethodLib;

import java.util.Random;

public class CommonSort {
    public static Random rand = new Random();

    /*  注：快速排序需要利用栈，容易导致栈溢出，需谨慎使用   */
    public static void main(String[] args) {

        int[] flag1 = setArr(new int[30]);
        int[] flag2 = setArr(new int[30]);
        int[] flag3 = setArr(new int[30]);
        int[] flag4 = setArr(new int[30]);


        System.out.println("==========================初---始==========================");
        System.out.println("flag1 for bubbleSort(冒泡排序使用数组): ");
        listArr(flag1);
        System.out.println("flag2 for InsertionSort(插入排序使用): ");
        listArr(flag2);
        System.out.println("flag3 for chooseSort(选择排序使用): ");
        listArr(flag3);
        System.out.println("flag4 for quickSort(快速排序使用): ");
        listArr(flag4);


        System.out.println("==========================整---理==========================");
        System.out.println(">>> 冒泡排序：");
        bubbleSort(flag1);
        listArr(flag1);
        System.out.println(">>> 插入排序：");
        insertionSort(flag2);
        listArr(flag2);
        System.out.println(">>> 选择排序：");
        chooseSort(flag3);
        listArr(flag3);
        System.out.println(">>> 快速排序：");
        quickSort(flag4, 0, flag4.length - 1);
        listArr(flag4);


        System.out.println("==========================结---束==========================");
    }

    public static int[] setArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(99) + 1;
        }
        return arr;
    }

    public static void listArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
            if ((i + 1) % 15 == 0 || i == arr.length - 1) {
                System.out.println();
            }
        }
        System.out.println();
    }

    // 冒泡排序
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }


    // 插入排序
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // 选择排序
    public static void chooseSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 快速排序
    public static void quickSort(int[] arr, int i, int j) {
        if (i >= j) {
            return;
        }

        int base = arr[i];
        int start = i;
        int end = j;

        while (start < j) {
            while (start < j && arr[j] >= base) {
                j--;
            }
            if (start < j) {
                arr[start] = arr[j];
                start++;
            }

            while (start < j && arr[start] < base) start++;
            if (start < j) {
                arr[j] = arr[start];
                j--;
            }
        }

        arr[start] = base; // 将基准值放到正确的位置
        quickSort(arr, i, start - 1); // 递归排序左半部分
        quickSort(arr, start + 1, end); // 递归排序右半部分
    }
}