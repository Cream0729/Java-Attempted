package GamesAttempted.MineSweeper;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class MinesMap {
    // 对地图初始化
    private static Random rand = new Random();
    private int maxMines;
    private int mapX;
    private int mapY;
    private int[][] map;

    // 设置地图参数，并返回最终绘制结果
    public int[][] minesMapRule(int mapX, int mapY, int maxMines) {
        if (maxMines >= mapX * mapY || mapX < 1 || mapY < 1 || maxMines < 1) {
            System.out.println("游戏参数不合法，即将退出程序");
            System.exit(0);
        }
        this.mapX = mapX;
        this.mapY = mapY;
        this.maxMines = maxMines;
        this.map = generateMinesMap(maxMines);

        return this.map;
    }

    // 返回记录的地雷坐标
    public int[][] getMinesPositions() {
        if (maxMines >= mapX * mapY || mapX < 1 || mapY < 1 || maxMines < 1) {
            System.out.println("未设置游戏参数，即将退出程序");
            System.exit(0);
        }
        int[][] mines = new int[maxMines][2];
        int nextLabel = 0;

        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                if (map[x][y] == -1) {
                    mines[nextLabel][0] = x;
                    mines[nextLabel][1] = y;
                    nextLabel++;
                }
            }
        }

        return mines;
    }

    // 随机埋雷
    private int[][] generateMinesMap(int maxMines) {
        int[][] minesMap = new int[mapX][mapY];
        Set<String> minesSet = new HashSet<>();

        while (minesSet.size() < maxMines) {
            int x = rand.nextInt(mapX);
            int y = rand.nextInt(mapY);
            minesSet.add(x + "," + y);
        }
        for (String pos : minesSet) {
            String[] coords = pos.split(",");
            int x = Integer.parseInt(coords[0]);
            int y = Integer.parseInt(coords[1]);
            minesMap[x][y] = -1;
        }

        return calculateMines(minesMap);
    }

    // 遍历地雷并为地雷附近的格子参数+1
    private int[][] calculateMines(int[][] minesMap) {
        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

        for (int x = 0; x < mapX; x++) {
            for (int y = 0; y < mapY; y++) {
                if (minesMap[x][y] != -1) {
                    int mineCount = 0;
                    for (int[] dir : directions) {
                        int newX = x + dir[0];
                        int newY = y + dir[1];
                        if (newX >= 0 && newX < mapX && newY >= 0 && newY < mapY && minesMap[newX][newY] == -1) {
                            mineCount++;
                        }
                    }
                    minesMap[x][y] = mineCount;
                }
            }
        }

        return minesMap;
    }
}