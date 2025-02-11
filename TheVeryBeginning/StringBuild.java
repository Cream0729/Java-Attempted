package TheVeryBeginning;

import java.util.*;
public class StringBuild {
    public static void main(String args[]) {
        // 设置了有args则如此进行，非则运行关于StringBuilder例子
        if (args.length > 0) {
            StringBuilder fullInput = new StringBuilder();
            for (String arg : args) {
                fullInput.append(arg).append(" ");
            }
            System.out.println(fullInput.toString().trim());
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("序号【1】以进入基础StringJoiner例子");
        System.out.println("序号【2】以进入基础StringBuilder例子");
        System.out.print(">>> 现在输入序号：");
        int OpenID = sc.nextInt();
        if (OpenID == 1){
            SJ();
        } else if (OpenID == 2){
            SB();
        }
        sc.close();
    }

    public static void SJ(){
        StringJoiner StJ = new StringJoiner(", " , "[" , "]");
        // 隔间 + 开头 + 末尾
        StJ.add("第一个").add("第二个").add("第三个");
        System.out.println(StJ);
    }

    public static void SB() {
        StringBuilder sb = new StringBuilder("可输入可不输入。");
            sb.append("添加的字符串，于后面开始。").append("效率高于String xx = “xxx”，且避免了内存浪费。：）串符字转反（");
            // 以上为链式编程，可拆解为
            // sb.append("添加的字符串，于后面开始。");
            // sb.append("效率高于String xx = “xxx”，且避免了内存浪费。");
            System.out.println("获取长度：" + sb.length());
            System.out.println(sb);
            sb.reverse();
            String ST = sb.toString();// 变成字符串
            System.out.println(">>>");
            System.out.println(ST);
            char[] ToChar = ST.toCharArray();
            System.out.println("以下为转换成字符数组结果：");
            for (int i = 0; i < ToChar.length - 1; i++){
            System.out.print(ToChar[i]);
            }
    }
}