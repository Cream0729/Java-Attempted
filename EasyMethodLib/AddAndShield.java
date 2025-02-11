package EasyMethodLib;

import java.util.Scanner;

public class AddAndShield {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("序号[1]等差数列程序例子；");
        System.out.println("序号[2]手机号屏蔽程序例子；");
        System.out.println("输入[3]将启动敏感词测试");
        System.out.println("输入[4]switch置换例子");
        System.out.print("请输入需要运行程序的序号：");
        int Open = scan.nextInt();
        if (Open == 1) {
            ArithmeticSequence();
        } else if (Open == 2) {
            String output = NumberShield();
            System.out.println("屏蔽号码后输出：" + output);
        } else if (Open == 3) {
            String Out = SensitiveWords();
            System.out.println(">>>输出内容：" + Out);
        } else if (Open == 4) {
            Switch();
        }
        scan.close();
    }

    public static void ArithmeticSequence() {
        System.out.print("请输入从0到N的数N：");
        int Into = scan.nextInt();
        System.out.print("请输入从0到N的可被X整除的X：");
        int By = scan.nextInt();
        int End = 0;
        for (int i = 0; i <= Into; i = i + By) {
            System.out.println("+" + i);
            End = End + i;
        }
        System.out.println("最终结果为" + End);
    }

    public static String NumberShield() {
        System.out.print("请输入11位电话号码：");
        String Number = scan.next();
        boolean isValid = true;
        for (int i = 0; i < Number.length(); i++) {
            char Check = Number.charAt(i);
            if (Check < '0' || Check > '9') {
                isValid = false;
                break;
            }
        }

        while (Number.length() != 11 || !isValid) {
            System.out.print("您输入的号码不合法，请重新输入：");
            Number = scan.next();
            isValid = true;
            for (int i = 0; i < Number.length(); i++) {
                char Check = Number.charAt(i);
                if (Check < '0' || Check > '9') {
                    isValid = false;
                    break;
                }
            }
        }

        String head = Number.substring(0, 3);
        String end = Number.substring(7);
        return head + "****" + end;
    }

    public static String SensitiveWords() {
        System.out.print("输入内容：");
        String talk = scan.next();
        String[] Pack = {"敏感词库", "例子", "测试", "服务器", "网站"};
        for (String s : Pack) {
            talk = talk.replace(s, "***");
        }
        return talk;
    }

    public static void Switch() {
        System.out.print("现在请输入数字：");
        String Number = scan.next();
        StringBuilder end = new StringBuilder();
        for (int i = 0; i < Number.length(); i++) {
            char Check = Number.charAt(i);
            if (Check < '0' || Check > '9') {
                System.out.print("您输入的号码不合法，请重新输入：");
                Number = scan.next();
                break;
            }
        }

        for (int i = 0; i < Number.length(); i++) {
            char Check = Number.charAt(i);
            switch (Check) {
                case '0' -> end.append("零");
                case '1' -> end.append("壹");
                case '2' -> end.append("贰");
                case '3' -> end.append("叁");
                case '4' -> end.append("肆");
                case '5' -> end.append("伍");
                case '6' -> end.append("陆");
                case '7' -> end.append("柒");
                case '8' -> end.append("捌");
                case '9' -> end.append("玖");
            }
        }
        System.out.println(end);
    }
}