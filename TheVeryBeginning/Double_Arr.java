package TheVeryBeginning;

public class Double_Arr {
    public static void main(String[] args) {
        int[][] D_arr = { { 1, 2, 3, 4, 5 }, { 7, 8, 9, 10, 11 }, { 12, 13, 14, 15, 16 } };
        int[][] D_arr1 = new int[3][9];// 赋予数组长度
        int Darr_All = 0;
        // 引用打印出结果
        System.out.println("D_arr1的地址值：" + D_arr1);
        System.out.printf("二维数组中的一维数组内容：%d \n二维数组中的二维数组内容：%d \n以此类推 \n>>>\n", D_arr[0][0], D_arr[1][0]);
        for (int i = 0; i < D_arr.length; i++) {
            // 拆分二维数组
            int[] arr = D_arr[i];
            int Arr_all = Add_end(arr);
            System.out.println("此数组第[" + i + "]行一维度总和为" + Arr_all);
            Darr_All = Darr_All + Arr_all;
        }
        System.out.println("此二维数组所有元素总和为：" + Darr_All);
    }

    // 总和单维数组
    public static int Add_end(int[] arr) {
        int end = 0;
        for (int i = 0; i < arr.length; i++) {
            end = end + arr[i];
        }
        return end;
    }
}