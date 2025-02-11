package EasyMethodLib.FileExample;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Scanner;

public class PathLength {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter path name: ");
        char path = sc.next().charAt(0);
        System.out.println("等待检索结果中......\n");
        File file = new File(path + ":\\");
        String[] dw = {"Bytes", "KB", "MB", "GB", "TB"};
        long bytes = getLength(file);

        // 若数字大于1024，则除以1024并dw的索引+1以改变单位
        int i = 0;
        double size = (double) bytes;
        while (size / 1024 > 1 && i < dw.length - 1) {
            size = size / 1024;
            i++;
        }

        DecimalFormat df = new DecimalFormat("#.##");
        System.out.print("【" + path + ":\\】盘大小为：" + df.format(size) + " " + dw[i]);
        if (path == 'C') System.out.println("\ntips: C盘有部分无法获取权限，最终结果可能不准确");
        else System.out.println();
    }

    public static long getLength(File file) {
        // 遍历目标路径以计算大小（Byte）
        long len = 0;
        if (file.isFile()) {
            len += file.length();
        } else {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    len += getLength(f);
                }
            }
        }
        return len;
    }
}