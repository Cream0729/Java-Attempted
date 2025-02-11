package EasyMethodLib;

import java.io.PrintStream;

public class HelloWorld {
    public static void main(String[] args) {
        int ID = 1236123124;
        String helloWorld = "Hello World";
        // printf
        System.out.println();
        System.out.printf("（整形例子<1000>）十进制：%d ; 八进制: %o ; 十六进制: %x\n", 1000, 1000, 1000);
        System.out.printf("（控制宽度<1234567>）: %20d%s%n", 1234567, "HH");
        System.out.printf("（向左对齐<1234567>）: %-20d%s%n", 1234567, "HH");
        System.out.printf("（基本）：%d,%s,%f,%n%s%n", 17, "Hello", 12.55, "换行");

        // print println
        System.out.print("Hello! ");
        System.out.print("World! ");
        System.out.println("My wonderful world!");
        System.out.println("this is My ID:" + ID + "; it 1+1=" + (1 + 1));
        System.out.println("case you want to know how long by \"Hello world!\"? , it length:" + helloWorld.length());
        System.out.print("End:");

        // print stream ==>eg.>== system.out.println
        PrintStream ps = new PrintStream(System.out);
        ps.println(helloWorld);
        PrintStream ps2 = System.out;
        ps2.println(helloWorld);
    }
}