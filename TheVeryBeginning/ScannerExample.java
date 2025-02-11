package TheVeryBeginning;

import java.util.Scanner;
 
public class ScannerExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();  // 读取整数
        // 注意：这里没有调用 scanner.nextLine() 来消费换行符
 
        System.out.print("Enter a string: ");
        String text = scanner.nextLine();  // 这里会立即读取到换行符，返回空字符串
 
        System.out.println("输出结果:");
        System.out.println("Number: " + number);
        System.out.println("Text: " + text);  // 这里会打印出空字符串
 
        scanner.close();
    }
}