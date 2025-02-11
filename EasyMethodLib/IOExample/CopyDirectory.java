package EasyMethodLib.IOExample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;

public class CopyDirectory {
    static long getLength = 0;
    static FileOutputStream fos = null;
    static FileInputStream fis = null;
    static byte[] MB = new byte[1024 * 1024];
    static String[] sizes = {"B", "KB", "MB", "GB", "TB"};

    public static void main(String[] args) throws IOException {
        copyDirectory(MB, "T:\\a.txt", "T:\\copyExample\\end");
    }

    /**
     * 对最终结果进行输出，但不具备文件/文件夹复制能力
     *
     * @param speed 复制文件速度
     * @param from  复制源文件/文件夹
     * @param to    复制至目标路径
     */
    public static void copyDirectory(byte[] speed, String from, String to) throws IOException {
        long start = System.currentTimeMillis();    // 计时器（起）
        if ((new File(to)).exists()) {
            throw new IOException("Directory/File already, copy default: " + to);
        } else {
            System.out.println("\n>>> Start: copy \"" + from + "\", to \"" + to + "\".\n");
        }
        copy(speed, new File(from), new File(to));
        long end = System.currentTimeMillis();      // 计时器（终）

        String size = null;
        for (byte unit = 0; unit < speed.length; unit++) {
            if (getLength > 1024 * 1024) {
                getLength /= 1024;  // 若长度过长，则/=1024
            } else if (getLength > 1024) {
                size = (new DecimalFormat("#.##")).format(getLength / 1024.0) + sizes[unit + 1];
                break;  // 大于1024但在1024*1024之间的数字则输出一个 double->String
            } else {
                size = (new DecimalFormat("#.##")).format(getLength) + sizes[unit];
                break;  // 若不足1024，则直接输出xxB
            }
        }

        String time = (new DecimalFormat("#.##")).format((end - start) / 1000.0);
        System.out.println("\n>>> Finished, had spend [ Times:" + time + "s; Size:" + size + " ]");
        fos.close();
        fis.close();
    }

    /**
     * 内容文件/文件夹判断，并指引至fileCopy以执行复制
     *
     * @param speed 复制文件速度
     * @param from  复制源文件/文件夹
     * @param to    复制至目标路径
     */
    public static void copy(byte[] speed, File from, File to) throws IOException {
        File[] files = from.listFiles();
        // 复制源文件夹判断
        if (files != null) {    // 若为文件夹则开始递归
            for (File file : files) {
                if (to.mkdirs()) System.out.println("> Directory created: " + to.getAbsolutePath());
                if (file.isDirectory()) {
                    copy(speed, file, new File(to, file.getName()));
                } else if (file.isFile()) {
                    fileCopy(speed, file, to);
                }
            }
        } else {    // 若为文件则立即执行复制文件
            if (to.mkdirs()) {
                System.out.println("> Directory created: " + to.getAbsolutePath());
            }
            fileCopy(speed, from, to);
        }
    }

    private static void fileCopy(byte[] speed, File from, File to) throws IOException {
        getLength += from.length();
        fis = new FileInputStream(from);
        fos = new FileOutputStream(new File(to, from.getName()));
        System.out.println("File copying: " + from.getAbsolutePath());
        int len;
        while ((len = fis.read(speed)) > 0) {
            fos.write(speed, 0, len);
        }
    }
}