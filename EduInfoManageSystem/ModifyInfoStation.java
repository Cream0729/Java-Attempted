package EduInfoManageSystem;

import java.io.File;
import java.util.Scanner;

public class ModifyInfoStation {
    private static final Scanner sc = new Scanner(System.in);
    private static final StanderControl control = new StanderControl();

    public ModifyInfoStation(String mov) {
        label:
        while (true) {
            ty:
            try {
                // 选择操作数据的类型
                System.out.println("\n======= Types =======");
                System.out.println("‖ <1> Students data ‖");
                System.out.println("‖ <2> Teachers data ‖");
                System.out.println("‖ <3> Exit - - - - -‖");
                System.out.println("=====================");

                System.out.print(">>> Now, enter your choice: ");
                switch (sc.next()) {
                    case "1":
                        System.out.print("\n>>> Now, enter ID: ");
                        InfoControl(sc.next(), mov, "student");
                        break ty;
                    case "2":
                        System.out.print("\n>>> Now, enter ID: ");
                        InfoControl(sc.next(), mov, "teacher");
                        break ty;
                    case "3":
                        break label;
                    default:
                        throw new IllegalArgumentException();
                }
            } catch (IllegalArgumentException ignored) {
                System.out.println("\nentered the wrong choice, please try again.");
            }

            if (mov.equals("modify")) {
                if (control.isValid(">>> 是否退出更改信息程序？")) break;
            } else if (mov.equals("remove")) {
                if (control.isValid(">>> 是否退出信息删除程序？")) break;
            }
        }
    }

    /**
     *
     * @param id 传入目标id
     * @param mov 操作方式，默认modify & remove
     * @param type 数据类型选择，方便对单操作，默认student & teacher
     */
    private void InfoControl(String id, String mov, String type) {
        if (control.id(id)) {
            File[] files = new File("src" + File.separator + "EduInfoManageSystem").listFiles();
            if (files != null) {
                // 遍历并分配文件
                for (File file : files) {
                    // 传入对象，使之引用地址以直接操作对象
                    if (FileSearch(id, mov, type, file)) break;
                    System.err.println("\n>>> ID not found - - - - -");
                }
            }
        } else {
            System.err.println("\n>>> ID not found - - - - -");
        }
    }

    private boolean FileSearch(String id, String mov, String type, File file) {
        FileControlStation fcs = new FileControlStation(file.getName().split("\\.")[0]);

        // student数据操作，第一次读取fcs为student
        for (DataStation.Student student : fcs.getStudentsTemp()) {
            // 非目标type则中断搜索，节约空间时间
            if (!(type.equals("student"))) break;
            if (student.getId() == Long.parseLong(id)) {
                System.out.println();
                System.out.println(student);

                if (mov.equals("modify")) {
                    if (control.isValid(">>> 是否修改这个数据？")) {
                        new InfoModifyControl(fcs, student);
                    } else {
                        System.out.println(">>> 数据未更改");
                    }
                } else if (mov.equals("remove")) {
                    if (control.isValid(">>> 你确定要删除这个数据吗？")) {
                        System.err.println(">>> 数据删除成功");
                        fcs.getStudentsTemp().remove(student);
                        fcs.save(false);
                    } else {
                        System.out.println(">>> 数据没有更改");
                    }
                }
                return true;
            }
        }

        // teacher数据操作，第二次读取fcs为teacher
        for (DataStation.Teacher teacher : fcs.getTeachersTemp()) {
            // 非目标type则中断搜索，节约空间时间
            if (!(type.equals("teacher"))) break;
            if (teacher.getId() == Long.parseLong(id)) {
                System.out.println();
                System.out.println(teacher);

                if (mov.equals("modify")) {
                    if (control.isValid(">>> 是否修改这个数据？")) {
                        new InfoModifyControl(fcs, teacher);
                    } else {
                        System.out.println(">>> 数据未更改");
                    }
                } else if (mov.equals("remove")) {
                    if (control.isValid(">>> 你确定要删除这个数据吗？")) {
                        System.err.println(">>> 数据删除成功");
                        fcs.getTeachersTemp().remove(teacher);
                        fcs.save(false);
                    } else {
                        System.out.println(">>> 数据没有更改");
                    }
                }
                return true;
            }
        }

        // 未找到数据的返回
        return false;
    }
}