package EasyMethodLib.FileExample;

import java.io.File;
import java.io.IOException;

public class FileExample1 {
    static final String local = System.getProperty("user.dir");

    public static void main(String[] args) throws IOException {
        System.out.println("Current directory: " + local);

        System.out.println("\n===================== if it's file and exist ==========================");
        File fileE1 = new File(local, "src\\EasyMethodLib\\FileExample\\example\\ezp.txt");
        if (!fileE1.exists()) System.out.print(fileE1.createNewFile());
        System.out.println("ezp.txt is file? : " + fileE1.isFile());
        System.out.println("ezp.txt is directory? : " + fileE1.isDirectory());
        System.out.println("ezp.txt is exists? : " + fileE1.exists());

        System.out.println("\n===================== if it's directory and exist =====================");
        File fileE2 = new File(local, "src\\EasyMethodLib\\FileExample\\example");
        if (!fileE2.exists()) System.out.print(fileE2.mkdirs());
        System.out.println("FileExample is file? : " + fileE2.isFile());
        System.out.println("FileExample is directory? : " + fileE2.isDirectory());
        System.out.println("FileExample is exists? : " + fileE2.exists());

        System.out.println("\n====================== if isn't exist =================================");
        File fileE3 = new File(local, "src\\haveIm？.txt");
        System.out.println("haveIm？.txt is directory? : " + fileE3.isDirectory());
        System.out.println("haveIm？.txt is file? : " + fileE3.isFile());
        System.out.println("haveIm？.txt is exists? : " + fileE3.exists());

        System.out.println("\n========================》 creation and delete《========================");
        try {
            File file = new File(local, "src\\EasyMethodLib\\FileExample\\example\\test.txt");
            if (file.exists()) {
                if (file.delete()) {
                    System.out.println("delete success");
                }
            } else {
                if (file.createNewFile()) {
                    System.out.println("create success");
                }
            }
            System.out.println(file.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("\n========================》 to be continued 《===========================");
    }
}