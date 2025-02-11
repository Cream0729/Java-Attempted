package TheVeryBeginning;

import java.util.*;

public class List {
    private static Scanner sc = new Scanner(System.in);

    public static void main() {
        System.out.println(System.currentTimeMillis());// 时间戳
        ArrList();
        sc.close();
    }

    public static void ArrList() {
        ArrayList<String> ArList = new ArrayList<>();
        // 打印非地址值，而是内容；展示时会用[]包裹，<>内是数据类型
        System.out.println(ArList);
        boolean Chack = ArList.add("aaaa");
        ArList.add("aaaa");
        ArList.add("bbbb");
        ArList.add("aaaa");
        ArList.add("cccc");
        System.out.println("Arlist.add返回的是布尔值(本例)：" + Chack);
        System.out.println(ArList);
        //
        System.out.println(">>>");
        boolean Ck1 = ArList.remove("aaaa");
        boolean Ck2 = ArList.remove("abskd");
        System.out.println("删除返回例子，Ck1：" + Ck1 + "；|| Ck2：" + Ck2);
        System.out.println(ArList);
        //
        System.out.println(">>>");
        String TBk = ArList.remove(0);
        System.out.println("指定删除索引数据，返回数据类型[remove(0)]：" + TBk);
        System.out.println(ArList);
        //
        System.out.println(">>>");
        String CAng = ArList.set(1, "kkkk");
        System.out.println("指定替换索引数据，返回替换目标数据[set(1)]：" + CAng);
        System.out.println(ArList);
        //
        System.out.println(">>>遍历集合内容");
        for (int i = 0; i < ArList.size(); i++) {
            System.out.println(ArList.get(i));
        }
    }
}