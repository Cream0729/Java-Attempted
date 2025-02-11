package EasyMethodLib;

import java.util.Scanner;

@SuppressWarnings("ALL")

public class ExceptionExample {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("默认异常处理[1]");
        System.out.println("自定抛出异常[2]");
        System.out.println("捕获异常处理[3]");
        System.out.println("多重异常处理[4]");
        System.out.println("自定义异常[5]");
        System.out.print("Enter an ordinal: ");
        String ordinal = scan.nextLine();
        switch (ordinal) {
            case "1":
                int i = 2 / 0;
                break;
            case "2":
                or2();
                break;
            case "3":
                or3();
                break;
            case "4":
                or4();
                break;
            case "5":
                throw new DataFormatException("null");
        }
    }

    public static void or2() {
        System.out.print("Enter an Integer: ");
        int i = scan.nextInt();
        if (i >= 10) {
            throw new RuntimeException("it just a test");
        } else {
            System.out.println(i);
        }
    }

    public static void or3() {
        Integer[] ir = {1, 2, 3, 4, 5};
        try {
            System.out.print("Enter an Integer: ");
            System.out.println("Answer: " + ir[scan.nextInt()]);
            System.out.println("...");
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("Continue test successfully");
        }
        System.out.println("After catch south out successfully");
    }

    public static void or4() {
        int[] ir = {1, 2, 3, 4, 5};
        System.out.print("Enter an Integer[1/2/3]: ");
        int i = scan.nextInt();
        if (i == 1) {
            try {
                System.out.println(ir[10]);
                System.out.println("...");
                System.out.println(2 / 0);
                System.out.println("...");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Continue test successfully");
            }
            System.out.println("After catch south out successfully");
        } else if (i == 2) {
            try {
                System.out.println(2 / 0);
                System.out.println("...");
                System.out.println(ir[10]);
                System.out.println("...");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Continue test successfully");
            }
            System.out.println("After catch south out successfully");
        } else if (i == 3) {
            try {
                System.out.println("I could south out");
                System.out.println(2 / 0);
                System.out.println("...");
                System.out.println(ir[10]);
                System.out.println("...");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("IndexOutOfBoundsException catch successfully");
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException catch successfully");
            } catch (OutOfMemoryError | RuntimeException e) {
                System.out.println("Catch out together successfully");
            } catch (Exception e) {
                System.out.println("Exception catch successfully");
                System.out.println("Tips: it must be the last catch exception");
            }
            System.out.println("After catch south out successfully");
        }
    }
}

class DataFormatException extends RuntimeException {
    public DataFormatException(String message) {
        super(message);
    }
}