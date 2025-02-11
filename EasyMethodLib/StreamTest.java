package EasyMethodLib;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;
import java.util.function.Function;

@SuppressWarnings("ALL")
public class StreamTest {
    public static void main(String[] args) {
        ArrayList<String> example1 = new ArrayList<>();
        Collections.addAll(example1, "ABC-1", "ACB-2", "BAC-3", "BCA-4", "CAB-5", "CBA-6", "ABC-7", "CBA-8");
        ArrayList<String> example2 = new ArrayList<>();
        Collections.addAll(example2, "ABCD-9", "ABDC-10", "ACBD-11", "ACDB-12", "ADBC-13", "ADCB-14");
        System.out.println("==========================过滤==========================");

        example1.stream()
                .filter(s -> s.startsWith("C"))
                .forEach(System.out::println);

        System.out.println();
        System.out.println("==========================去重==========================");

        example1.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println();
        System.out.println("==========================并滤==========================");

        Stream.concat(example1.stream(), example2.stream())
                .filter(s -> s.startsWith("A"))
                .forEach(System.out::println);

        System.out.println();
        System.out.println("==========================数据==========================");
        System.out.println("example1: " + example1);
        System.out.println("example2: " + example2);

        System.out.println();
        System.out.println("==========================转类=========================");

        example1.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String strings) {
                        String[] arr = strings.split("-");
                        int age = Integer.parseInt(arr[1]);
                        return age;
                    }
                })
                .forEach(I -> System.out.print(I + ", "));
        System.out.println();

        System.out.println();
        System.out.println("==========================转出1========================");

        ArrayList<Integer> num = new ArrayList<>();
        example2.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String strings) {
                        String[] arr = strings.split("-");
                        int age = Integer.parseInt(arr[1]);
                        return age;
                    }
                })
                .forEach(I -> num.add(I));
        System.out.println(num);

        System.out.println();
        System.out.println("==========================转出2========================");
        Object[] arr = example2.stream().toArray();
        System.out.println(Arrays.toString(arr));

        System.out.println();
    }
}