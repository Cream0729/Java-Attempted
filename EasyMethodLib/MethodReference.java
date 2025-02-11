package EasyMethodLib;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("SpellCheckingInspection")
public class MethodReference {
    // 方法引用     （类名::方法）
        /*
        1. 引用处必须是函数式接口
        2. 被引用的方法需存在
        3. 方法的形参和返回值要跟抽象方法的形参和返回值一致
        4. 被引用的方法的功能需要满足当前的要求

        抽象方法形参的详解:
            第一个参数:表示被引用方法的调用者，决定了可以引用哪些类中的方法
            在stream流当中，第一个参数一般都表示流里面的每一个数据
            假设流里面的数据是字符串，那么使用这种方式进行方法引用，只能引用string这个类中的方法
        第二个参数到最后一个参数:跟被引用方法的形参保持一致，如果没有第二个参数，说明被引用的方法需要是无参的成员方法

        局限性:
            不能引用所有类中的成员方法。
            是跟抽象方法的第一个参数有关，这个参数是什么类型的，那么就只能引用这个类中的方法。
         */
    public static void main(String[] args) {
        System.out.println("\n========================引用静态方法========================");
        // 已有的方法
        ArrayList<String> ls1 = new ArrayList<>();
        Collections.addAll(ls1, "1", "2", "3", "4", "5", "6", "7", "8", "9");
        ls1.stream().map(Integer::parseInt).forEach(s -> System.out.print(s + "  "));
        System.out.println();

        // 已有的方法
        ArrayList<String> ls2 = new ArrayList<>();
        Collections.addAll(ls2, "abc", "def", "ghi", "jkl", "mno");
        ls2.stream().map(String::toUpperCase).forEach(s -> System.out.print(s + "  "));

        // 本类中的静态方法
        Integer[] arr = {1, 4, 7, 2, 5, 8, 9, 4, 2, 6, 9, 0, 8, 5, 2, 6};
        Arrays.sort(arr, MethodReference::example);
        System.out.println("\n" + Arrays.toString(arr));

        System.out.println("\n========================引用成员方法========================");
        // 其他类中的方法
        ArrayList<String> ls3 = new ArrayList<>();
        Collections.addAll(ls3, "ABC", "CAB", "ABCD", "ABCD", "BAC", "ACBD", "CBA", "ACDB", "BCA", "ADBC", "ACB", "ADCB");
        ls3.stream().filter(new Example1()::asExample1).forEach(s -> System.out.print(s + "  "));

        // 其他类中的方法（重载）
        Integer[] ari = {1, 4, 6, 2, 4, 6, 4, 2, 4, 6, 2, 5, 7, 8, 2, 4};
        Arrays.sort(ari, new Example1()::asExample1);
        System.out.println("\n" + Arrays.toString(ari));

        System.out.println("\n========================引用构造方法========================");
        // 引用类的构造方法
        ArrayList<String> data = new ArrayList<>();
        Collections.addAll(data, "小红-17", "小明-17", "李华-19", "小丽-14");
        List<Example2> DataLib = data.stream().map(Example2::new).toList();
        for (Example2 example2 : DataLib) {
            System.out.println("Example { Name:" + example2.getName() + "; Age:" + example2.getAge() + " }");
        }

        // 引用数组的构造方法
        ArrayList<Integer> ls4 = new ArrayList<>();
        Collections.addAll(ls4, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        Integer[] itg = ls4.toArray(Integer[]::new);
        System.out.println(Arrays.toString(itg));

    }

    public static int example(int a, int b) {
        return b - a;
    }
}


/*====================================================*/
class Example1 {
    public boolean asExample1(String s) {
        return s.startsWith("A");
    }

    public int asExample1(int a, int b) {
        return b - a;
    }
}
/*====================================================*/


/*====================================================*/
class Example2 {
    private String Name;
    private int Age;

    public Example2(String s) {
        String[] NameAge = s.split("-");
        Name = NameAge[0];
        Age = Integer.parseInt(NameAge[1]);
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }
}
/*====================================================*/