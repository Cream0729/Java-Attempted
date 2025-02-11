package EasyMethodLib.IOExample;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("ALL")
public class CharStream {
    /* 创建缓冲区    （tips：GB受限于JVM将很可能无法达到此速度，且字符流底层自带缓冲区，是否创建均可）  */
    static char[] Bt = new char[1];
    static char[] KB = new char[1024];
    static char[] MB = new char[1024 * 1024];
    static char[] GB = new char[1024 * 1024 * 1024];
    // 初始化全局变量
    static FileReader fr = null;
    static FileWriter fw = null;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        writeFile("src\\EasyMethodLib\\IOExample\\Example.txt", null);
        readFile(KB, "src\\EasyMethodLib\\IOExample\\Example.txt");
        copyFile(KB, "src\\EasyMethodLib\\IOExample\\Example.txt", "src\\copy.txt");
    }

    /**
     * 设置自动换行，使之末尾输入/#/时结束，并释放缓存
     *
     * @param file    目标文件路径的字符串
     * @param charset 编码格式设置，若设置为null，则使用默认方式
     * @throws IOException
     */
    public static void writeFile(String file, String charset) throws IOException {
        try {
            fw = new FileWriter(file, control());   // control：续写开关
            System.out.println(">>> 输入“/#/”以结束，写入开始：");
            while (charset != null) {
                String text = sc.nextLine();
                if (text.equals("/#/")) break;
                fw.write(text);
                fw.write("\r\n");
            }
            while (charset == null) {
                String text = sc.nextLine();
                if (text.equals("/#/")) break;
                fw.write(text);
                fw.write("\r\n");
            }
        } catch (IOException ignored) {
        } finally {
            fw.close();
            System.out.println("写入完成\n\n");
        }
    }

    /**
     * 选定文件路径以读取数据（只限于打印到控制台）
     *
     * @param speed 设置阅读速度（缓冲区）
     * @param file  写入目标文件
     * @throws IOException
     */
    public static void readFile(char[] speed, String file) throws IOException {
        try {
            fr = new FileReader(file);
            int len = fr.read(speed);
            while (len != -1) {
                System.out.print(new String(speed, 0, len));
                len = fr.read(speed);
            }
        } catch (IOException ignored) {
        } finally {
            fr.close();
        }
    }

    /**
     * 通过传入缓冲区（speed）来调整复制速度（单文件）
     *
     * @param speed 设置复制速度（缓冲区）
     * @param from  复制源文件路径
     * @param to    复制目标路径
     * @throws IOException
     */
    public static void copyFile(char[] speed, String from, String to) throws IOException {
        try {
            fr = new FileReader(from);
            fw = new FileWriter(to);
            int len = fr.read(speed);
            while (len != -1) {
                fw.write(speed, 0, len);
                len = fr.read(speed);
            }
        } catch (IOException ignored) {
        } finally {
            fr.close();
            fw.close();
            System.out.println(">>> 复制完成！");
        }
    }

    /**
     * 规范输入，并为之判断
     *
     * @return boolean
     */
    public static boolean control() {
        System.out.print("想要对此文件进行“续写”还是“重写”：");
        String command = sc.nextLine();
        if (!(command.equals("续写") || command.equals("重写"))) {
            System.out.println("非法输入，请重试");
            return control();
        }
        System.out.println();
        return command.equals("续写");
    }
}