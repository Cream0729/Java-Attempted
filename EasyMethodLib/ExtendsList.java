package EasyMethodLib;

import java.util.ArrayList;

public class ExtendsList {
    static ArrayList<Integer> list1 = new ArrayList<>();
    static ArrayList<FU> list2 = new ArrayList<>();
    static ArrayList<Zi1> list3 = new ArrayList<>();
    static ArrayList<Zi2> list4 = new ArrayList<>();

    public static void main(String[] args) {
        // 泛型示例
        check1(list1);
        check1(list2);
        check1(list3);
        check1(list4);

        // 限定继承示例
        //check2(list1);
        check2(list2);
        check1(list3);
        check1(list4);

        // 限定父类示例 <FU>
        //check3(list1);
        check3(list2);
        //check3(list3);
        //check3(list4);

        // 限定父类示例 <Zi1>
        //check4(list1);
        check4(list2);
        check4(list3);
        //check4(list4);
    }

    public static <E> void check1(ArrayList<E> list) {
    }

    public static void check2(ArrayList<? extends FU> list) {
    }

    public static void check3(ArrayList<? super FU> list) {
    }

    public static void check4(ArrayList<? super Zi1> list) {
    }

    public static class FU {
    }

    public static class Zi1 extends FU {
    }

    public static class Zi2 extends FU {
    }
}