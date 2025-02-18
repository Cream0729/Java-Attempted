package EduInfoManageSystem;

import java.io.File;
import java.util.Scanner;

public class SearchStation {
    static Scanner sc = new Scanner(System.in);
    static StanderControl control = new StanderControl();

    public SearchStation() {
        label:
        while (true) {
            System.out.println("\n==== S e a r c h ====");
            System.out.println("‖ <1> Date search - ‖");
            System.out.println("‖ <2> ID search - - ‖");
            System.out.println("‖ <3> Search All- - ‖");
            System.out.println("‖ <4> Out of search ‖");
            System.out.println("=====================");
            inter:
            try {
                System.out.print("\nNow, enter your choice: ");
                String choice = sc.next();
                switch (choice) {
                    case "1":
                        search(control.date());
                        break inter;
                    case "2":
                        System.out.print("Now, enter ID: ");
                        String id = sc.next();
                        searchID(id);
                        break inter;
                    case "3":
                        search("All");
                        break inter;
                    case "4":
                        break label;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException ignored) {
                System.err.println("\n非法输入，请重试");
            }
            if (control.isValid(">>> 是否退出本次搜索程序？")) break;
        }
    }

    private void search(String date) {
        if (date.equals("All")) {
            File[] files = new File("src", "EduInfoManageSystem").listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().endsWith(".data")) new FileControlStation(file.getName().split("\\.")[0]).read();
                }
            } else {
                System.err.println(">>> Has no files");
            }
        } else if (control.date(date)) {
            if ((new File("src" + File.separator + "EduInfoManageSystem", date + ".data")).exists()) {
                new FileControlStation(date).read();
            } else {
                System.err.println(">>> Couldn't find file\n");
                return;
            }
        } else {
            throw new RuntimeException();
        }
        System.out.println("\n>>> End ...\n");
    }

    private void searchID(String id) {
        System.out.println("\n>>> Waiting for search ID...");
        if (!control.id(id)) {
            System.err.println(">>> ID not found\n");
        } else {
            File[] files = new File("src" + File.separator + "EduInfoManageSystem").listFiles();
            if (files != null) {
                boolean sFound = false, tFound = false;
                for (File file : files) {
                    FileControlStation fcs = new FileControlStation(file.getName().split("\\.")[0]);
                    for (DataStation.Student student : fcs.getStudentsTemp()) {
                        if (student.getId() == Long.parseLong(id)) {
                            System.out.println();
                            System.out.println(student);
                            sFound = true;
                        }
                    }
                    for (DataStation.Teacher teacher : fcs.getTeachersTemp()) {
                        if (teacher.getId() == Long.parseLong(id)) {
                            System.out.println();
                            System.out.println(teacher);
                            tFound = true;
                        }
                    }
                    if (sFound || tFound) break;
                    System.err.println(">>> ID not found\n");
                }
            }
        }
    }
}