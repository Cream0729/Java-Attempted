package EasyMethodLib.FileExample;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.Objects;

@SuppressWarnings("ALL")
public class FileExample2 {
    static String local = "C:\\Users\\Cream\\Desktop\\Java-Tried HistoryLib\\src\\EasyMethodLib\\FileExample\\example";

    public static void main(String[] args) {
        System.out.println("\n=====================》 get Files in directory 《=======================");
        File fileE4 = new File(local);
        File[] files = fileE4.listFiles();
        if (files != null) {
            for (File file : files) {
                System.out.println(file);
            }
        }

        System.out.println("\n=======================》 get roots and files《=========================");
        System.out.println(Arrays.toString(File.listRoots()));
        System.out.println();

        File fileE5 = new File("C:\\");
        System.out.println(">>> Root Directory C:\\");
        for (String s : Objects.requireNonNull(fileE5.list())) {
            System.out.println(s);
        }

        System.out.println("==================== Creative and delete directory ====================");
        File fileE1 = new File(local, "dir1");
        if (fileE1.mkdir()) {
            System.out.println("Directory created successfully");
        } else {
            if (fileE1.delete()) {
                System.out.println("Directory deleted successfully");
            }
        }

        File fileE2 = new File(local, "dir2\\dir\\dirInDir");
        if (fileE2.mkdirs()) {
            System.out.println("Directory created successfully");
        } else {
            File file = new File(local, "dir2\\dir");
            File file2 = new File(local, "dir2");
            if (fileE2.delete()) {
                if (file.delete()) {
                    if (file2.delete()) {
                        System.out.println("Directory deleted successfully");
                    }
                }
            }
        }

        System.out.println("\n============================ Stream File ==============================");
        File fileE3 = new File("C:\\Users\\Cream\\Desktop\\Java-Tried HistoryLib\\src\\EasyMethodLib\\FileExample\\example");
        File[] filesS = fileE3.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        });
        for (File file : filesS) {
            System.out.println(file);
        }
        if (filesS.length != 0) {
            for (File file : filesS) {
                file.delete();
            }
            System.out.println("Delete files successfully");
        } else {
            System.out.println("Could not found files");
        }
        System.out.println("\n=============================== End ===================================");
    }
}