package EasyMethodLib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Groups {
    static Scanner sc = new Scanner(System.in);
    static int g = 0;

    public static void main(String[] args) {
        extracted((new ArrayList<String>()));
    }

    private static void extracted(ArrayList<String> names) {
        Collections.shuffle(names);
        ArrayList<Integer> groups = new ArrayList<>();
        System.out.println("Enter the group size: ");
        for (int i = sc.nextInt(); i != 20250222; i = sc.nextInt()) {
            if (!groups.isEmpty()) {
                groups.add(i + groups.getLast());
            } else {
                groups.add(i);
            }
        }

        System.out.print("\nGroups [" + (g + 1) + "] :");
        for (int i = 0; i < names.size(); i++) {
            System.out.print(names.get(i) + " ");
            if (g < groups.size() && groups.get(g) == i + 1) {
                g++;
                System.out.print("\nGroups [" + (g + 1) + "] :");
            }
        }
    }
}
