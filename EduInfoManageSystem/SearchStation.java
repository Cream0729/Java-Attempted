package EduInfoManageSystem;

import java.io.File;
import java.util.Scanner;

public class SearchStation {
    static Scanner sc = new Scanner(System.in);
    static StanderControl control = new StanderControl();

    public SearchStation() {
        label:
        while (true) {
            System.out.println("\n======= Search =======");
            System.out.println("‖ <1> Date search  - ‖");
            System.out.println("‖ <2> ID search  - - ‖");
            System.out.println("‖ <3> Search all - - ‖");
            System.out.println("‖ <4> Exit the search‖");
            System.out.println("======================");
            inter:
            try {   // 依选择分流
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

    /**
     * 依照传入日期搜索数据
     *
     * @param date 传入搜索日期（年）范围
     */
    private void search(String date) {
        if (date.equals("All")) {
            // 若为“All”则在规定放置文件夹中全局搜索
            File[] files = new File("src", "EduInfoManageSystem").listFiles();
            if (files != null) {
                for (File file : files) {   // 判断文件是否合法，若合法则执行所调用FileControlStation中的read
                    if (file.getName().endsWith(".data")) new FileControlStation(file.getName().split("\\.")[0]).read();
                }
            } else {
                System.err.println(">>> Couldn't find directory\n");
            }
        } else if (control.date(date)) {
            // 若与正则表达式相符，则成功执行搜索
            if ((new File("src" + File.separator + "EduInfoManageSystem", date + ".data")).exists()) {
                new FileControlStation(date).read();
            } else {
                System.err.println(">>> Couldn't find file\n");
                return;
            }
        } else { // 异常输入处理
            throw new RuntimeException();
        }
        System.out.println("\n>>> End ...\n");
    }

    /**
     * 依照传入ID搜索全局数据
     *
     * @param id 传入id
     */
    private void searchID(String id) {
        System.out.println("\n>>> Waiting for search ID...");
        if (!control.id(id)) {
            // 若与规范ID的正则表达式不符，则直接无法搜索，节约时间
            System.err.println(">>> ID not found\n");
        } else {
            File[] files = new File("src" + File.separator + "EduInfoManageSystem").listFiles();
            if (files != null) {
                // 创建记录以完整搜索ID下的成员数据
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