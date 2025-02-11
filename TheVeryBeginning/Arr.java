package TheVeryBeginning;

public class Arr {
    public static void main (String[] args){
        int [] array_int = {1,2,3,4,5,6,7,8,9,10};
        //创建数组，后续可用int [X] 名 = N来修改数组内对应值
        System.out.println(array_int.length);
        //获取数组长度(个数)---组名.length
        System.out.println(array_int);
        //获取数组地址---是什么-什么类-@-地址
        System.out.println((array_int[0]) + (array_int[1]));
        //引用数组(索引)并计算
        //+
        //测试数组内可被X整除的个数
        int Temp = 0;
        for (int j : array_int) {
            if (j % 2 == 0) {
                Temp++;
            }
        }
        System.out.println("数组中有" + Temp + "个元素可被2整除");
        //赋予相同地址值
        int[] Array_out = array_int;
        System.out.println("Array_out的地址为：" + Array_out);
        System.out.println("array_int的地址为：" + array_int);
        //对Array_out赋值
        Array_out[2] = 77;
        System.out.println("Array_out[2]：" + Array_out[2]);
        System.out.println("array_int[2]：" + array_int[2]);
    }
}