package EasyMethodLib;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class RandSelect {
    static ArrayList<String> girls = new ArrayList<>();
    static ArrayList<String> boys = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();
    static int girlNext = 0;    // 为girls设置索引标记
    static int boyNext = 0;     // 为boys设置索引标记

    public static void main(String[] args) {
        // 创建基础数据以分辨
        Collections.addAll(boys, "男A", "男B", "男C", "男D", "男E", "男F", "男G", "男H", "男I");
        Collections.addAll(girls, "女A", "女B", "女C", "女D", "女E", "女F");

        // 设置不平衡（简单权重）操作
        int[] resale = {1, 1, 1, 1, 1, 1, 1, 0, 0, 0};

        // 随机打乱集合顺序
        Collections.shuffle(boys);
        Collections.shuffle(girls);
        while (true) {
            String flag = sc.nextLine();
            if (flag.equals(" ")) break;
            randSelect(resale[rand.nextInt(resale.length)]);
        }
    }

    // 调用索引标记以做到“单性别轮次不重复点名”的随机
    public static void randSelect(int sex) {
        if (sex == 0) {
            System.out.print(girls.get(girlNext) + ", index:" + girlNext);
            girlNext++;
            if (girlNext == girls.size()) {
                girlNext = 0;
                Collections.shuffle(girls);
                System.out.print(" ->本轮结束，girls已重新洗牌");
            }
        } else if (sex == 1) {
            System.out.print(boys.get(boyNext) + ", index:" + boyNext);
            boyNext++;
            if (boyNext == boys.size()) {
                boyNext = 0;
                Collections.shuffle(boys);
                System.out.print(" ->本轮结束，boys已重新洗牌");
            }
        }
    }
}