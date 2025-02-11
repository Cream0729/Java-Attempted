package EasyMethodLib;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

@SuppressWarnings("ALL")
public class TraversalExample {
    public static void main(String[] args) {
        System.out.println();
        ArrayList<String> list = new ArrayList<>();
        list.add("Hello, ");
        list.add("World! ");
        list.add("My ");
        list.add("wonderful ");
        list.add("world!");
        System.out.println(list);
        System.out.println();

        System.out.print("【普通for】：");
        for (int i = 0; i < list.size(); i++) {
            String element = list.get(i);
            System.out.print(element);
        }
        System.out.println();
        System.out.println();

        System.out.print("【增强for】：");
        for (String s : list) {
            System.out.print(s);
        }
        System.out.println();
        System.out.println();

        System.out.print("【迭代器】：");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next());
        }
        System.out.println();
        System.out.println();

        System.out.print("【lambda示例】：");
        list.forEach(s -> System.out.print(s));
        System.out.println();
        System.out.println();

        System.out.print("【ListIterator】：");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            String element = listIterator.next();
            System.out.print(element);
        }
        System.out.println();
        System.out.println();

        System.out.print("【forEachRemaining】：");
        iterator = list.iterator();
        iterator.forEachRemaining(System.out::print);
        System.out.println();
        System.out.println();

        System.out.print("【Stream API遍历】：");
        list.stream().forEach(System.out::print);
        System.out.println();
        System.out.println();

        System.out.print("【保证元素顺序版】：");
        list.stream().forEachOrdered(System.out::print);
        System.out.println();
    }
}