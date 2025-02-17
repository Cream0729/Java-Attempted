package SchoolInformationManagement;

import java.util.Scanner;

public class SIMS {
    static Scanner sc = new Scanner(System.in);


    public static void main(String[] args) {
        label:
        do {
            System.out.println("============== S I M S ==============");
            System.out.println("‖ <1> Add fresh personal information‖");
            System.out.println("‖ <2> Remove personal information - ‖");
            System.out.println("‖ <3> Modified personal information ‖");
            System.out.println("‖ <4> Search personal information - ‖");
            System.out.println("‖ <5> Exit the S.I.M.S. - - - - - - ‖");
            System.out.println("=====================================");
            inter:
            while (true) {
                System.out.print(">>> Now enter your choice : ");
                switch (sc.nextLine()) {
                    case "1":
                        break inter;
                    case "2":
                        break inter;
                    case "3":
                        break inter;
                    case "4":
                        break inter;
                    case "5":
                        System.out.println("Exiting program...");
                        break label;
                    default:
                        System.out.println("Wrong input. Please try again.");
                        break;
                }
            }
        } while (true);
    }
}
