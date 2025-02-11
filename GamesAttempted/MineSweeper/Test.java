package GamesAttempted.MineSweeper;

import java.util.Scanner;

public class Test {
    static MinesMap msMap = new MinesMap();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] msm = msMap.minesMapRule(20, 15, 100);
        int[][] msp = msMap.getMinesPositions();
        System.out.println("底层地图：");
        for (int Y = 0; Y < msm[Y].length; Y++) {
            for (int[] X : msm) System.out.printf("%5d", X[Y]);
            System.out.println();
        }
        System.out.println();
        System.out.println("地雷坐标");
        for (int[] ignored : msp) {
            for (int anInt : ignored) System.out.printf("%-5d", anInt);
            System.out.println();
        }
        System.out.println(msm[scan.nextInt()][scan.nextInt()]);
    }
}