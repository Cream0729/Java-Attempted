package EasyMethodLib;

import java.util.Arrays;
import java.util.Comparator;

@SuppressWarnings("ALL")
public class ListSortRule {
    public static void main(String[] args) {
        Integer[] arr = {2, 1, 4, 5, 3, 7, 1, 6, 4};
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override   // 更改排序方式(倒序)
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(arr));
        System.out.println();

        // limbda表达式(正序)
        Arrays.sort(arr, (o1, o2) -> o1 - o2);
        System.out.println(Arrays.toString(arr));
        System.out.println();

        // 方法引用,    ::是方法引用符
        /*
        1. 引用处必须是函数式接口
        2. 被引用的方法需存在
        3. 方法的形参和返回值要跟抽象方法的形参和返回值一致
        4. 被引用的方法的功能需要满足当前的要求
         */
        Integer[] arr2 = {1, 5, 7, 3, 2, 6, 8, 3, 6, 3, 2, 8, 0, 3, 1, 6, 8};
        Arrays.sort(arr2, ListSortRule::example);
        System.out.println(Arrays.toString(arr2));
    }

    public static int example(int A, int B) {
        return A - B;
    }
}