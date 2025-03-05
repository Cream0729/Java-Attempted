import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        checkPartitioning(sc.nextLine());
    }

    public static void checkPartitioning(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = true;
            }
        }
        for (boolean[] booleans : dp) {
            for (boolean aBoolean : booleans) {
                if (aBoolean) {
                    System.out.print("↙\t");
                } else {
                    System.out.print("•\t");
                }
            }
            System.out.println();
        }
    }
}
