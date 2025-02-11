package TheVeryBeginning;

import java.util.Scanner;

public class AddAndShield {
    private static Scanner sc = new Scanner(System.in,"GBK");
    public static void main(String args[]) {
        System.out.println("序号[1]等差数列程序例子；");
        System.out.println("序号[2]手机号屏蔽程序例子；");
        System.out.println("输入[3]将启动敏感词测试");
        System.out.println("输入[4]swich置换例子");
        System.out.print("请输入需要运行程序的序号：");
        int Open = sc.nextInt();
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
        sc.close();
    }

    

    public static void ArithmeticSequence() {
        System.out.print("请输入从0到N的数N：");
        int Into = sc.nextInt();
        System.out.print("请输入从0到N的可被X整除的X：");
        int By = sc.nextInt();
        int End = 0;
        for (int i = 0; i <= Into; i = i + By) {
            System.out.println("+" + i);
            End = End + i;
        }
        System.out.println("最终结果为" + End);
    }

    public static String NumberShield() {
        System.out.print("请输入11位电话号码：");
        String Number = sc.next();
        boolean TrF = true;
        for (int i = 0; i < Number.length(); i++) {
            char Chack = Number.charAt(i);
            if (Chack < '0' || Chack > '9') {
                TrF = false;
                break;
            }
        }

        while (Number.length() != 11 || !TrF) {
            System.out.print("您输入的号码不合法，请重新输入：");
            Number = sc.next();
            TrF = true;
            for (int i = 0; i < Number.length(); i++) {
                char Chack = Number.charAt(i);
                if (Chack < '0' || Chack > '9') {
                    TrF = false;
                    break;
                }
            }
        }

        String head = Number.substring(0, 3);
        String end = Number.substring(7);
        String Out = head + "****" + end;
        return Out;
    }

    public static String SensitiveWords() {
        System.out.print("输入内容：");
        String talk = sc.next();
        String[] Pack = { "敏感词库", "例子", "测试", "服务器", "网站" };
        for (int i = 0; i < Pack.length; i++) {
            talk.getBytes();
            talk = talk.replace(Pack[i], "***");
        }
        return talk;
    }

    public static void Switch() {
        System.out.print("现在请输入数字：");
        String Number = sc.next();
        StringBuilder AfChange = new StringBuilder("");
        boolean TrF = false;
        while (TrF) {
            for (int i = 0; i < Number.length(); i++) {
                char Chack = Number.charAt(i);
                if (Chack < '0' || Chack > '9') {
                    System.out.print("您输入的号码不合法，请重新输入：");
                    Number = sc.next();
                    TrF = true;
                    break;
                }
            }
        }

        for (int i = 0; i < Number.length(); i++) {
            char Chack = Number.charAt(i);
            switch (Chack) {
                case '0' -> AfChange.append("零");
                case '1' -> AfChange.append("壹");
                case '2' -> AfChange.append("贰");
                case '3' -> AfChange.append("叁");
                case '4' -> AfChange.append("肆");
                case '5' -> AfChange.append("伍");
                case '6' -> AfChange.append("陆");
                case '7' -> AfChange.append("柒");
                case '8' -> AfChange.append("捌");
                case '9' -> AfChange.append("玖");
            }
        }
        System.out.println(AfChange);
    }
}