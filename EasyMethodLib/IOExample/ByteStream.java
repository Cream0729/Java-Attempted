package EasyMethodLib.IOExample;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings("All")
public class ByteStream {
    /* 创建缓冲区    （tips：GB受限于JVM将很可能无法达到此速度）  */
    static byte[] Bt = new byte[1];
    static byte[] KB = new byte[1024];
    static byte[] MB = new byte[1024 * 1024];
    static byte[] GB = new byte[1024 * 1024 * 1024];
    // 初始化全局变量
    static FileInputStream fis = null;
    static FileOutputStream fos = null;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        writeFile("src\\EasyMethodLib\\IOExample\\Example.txt", null);
        readFile(MB, "src\\EasyMethodLib\\IOExample\\Example.txt");
        // copyFile(MB, "T:\\EV-CaseData.zip", "src\\copy.zip");
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
            fos = new FileOutputStream(file, control());    // control：续写开关
            System.out.println(">>> 输入“/#/”以结束，写入开始：");
            while (charset != null) {
                String text = sc.nextLine();
                if (text.equals("/#/")) break;
                fos.write(text.getBytes(charset));
                fos.write("\r\n".getBytes(charset));
            }
            while (charset == null) {
                String text = sc.nextLine();
                if (text.equals("/#/")) break;
                fos.write(text.getBytes());
                fos.write("\r\n".getBytes());
            }
        } catch (IOException ignored) {
        } finally {
            fos.close();
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
    public static void readFile(byte[] speed, String file) throws IOException {
        try {
            fis = new FileInputStream(file);
            int len = fis.read(speed);
            while (len != -1) {
                System.out.print(new String(speed, 0, len));
                len = fis.read(speed);
            }
        } catch (IOException ignored) {
        } finally {
            fis.close();
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
    public static void copyFile(byte[] speed, String from, String to) throws IOException {
        try {
            fis = new FileInputStream(from);
            fos = new FileOutputStream(to);
            int len = fis.read(speed);
            while (len != -1) {
                fos.write(speed, 0, len);
                len = fis.read(speed);
            }
        } catch (IOException ignored) {
        } finally {
            fis.close();
            fos.close();
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