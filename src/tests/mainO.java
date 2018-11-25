package tests;

import java.util.Scanner;

public class mainO {
    static int R;
    static int C;
    static int K;

    static boolean down = true;
    static boolean up = true;
    static boolean right = true;
    static boolean left = true;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();

        C = sc.nextInt();

        K = sc.nextInt();

        String map[][] = new String[C][R];

        for (int a = 1; a <= R; a++) {
            String row[] = sc.next().split("");
            for (int i = 1; i <= C; i++) {
                map[i - 1][a - 1] = row[i - 1];
            }
        }
        Path(map);
    }

    public static void Path(String map[][]) {
        int x = 1;
        int y = 1;
        String usedPath[][] = map;

        String DOWN = "down";
        String UP = "up";
        String RIGHT = "right";
        String LEFT = "left";

        String direction = DOWN;
        int count = 0;
        while (!(x == C && y == R)) {
            switch (direction) {
                case "down":
                    y++;
                    if (y <= R && y >= 1 && x <= C && x >= 1 && map[x - 1][y - 1].equals(".") && !usedPath[x - 1][y - 1].equals("x")) {
                        usedPath[x - 1][y - 1] = "x";
                        openPath(x, y);
                        reset();
                        count++;
                    } else if (!(y <= R && y >= 1 && x <= C && x >= 1)) {
                        y--;
                        direction = UP;
                        down = false;

                    } else if (!up && !right && !left) {
                        usedPath[x - 1][y - 1] = ".";
                        y--;
                        usedPath[x - 1][y - 1] = "x";
                    } else {
                        y--;
                        direction = UP;
                        down = false;
                    }
                    break;

                case "up":
                    y--;
                    if (y <= R && y >= 1 && map[x - 1][y - 1].equals(".") && !usedPath[x - 1][y - 1].equals("x")) {
                        usedPath[x - 1][y - 1] = "x";
                        openPath(x, y);
                        reset();
                        count++;

                    } else if (!(y <= R && y >= 1)) {
                        y++;
                        up = false;
                        direction = RIGHT;

                    } else if (!down && !right && !left) {
                        usedPath[x - 1][y - 1] = ".";
                        y++;
                        usedPath[x - 1][y - 1] = "x";

                    } else {
                        y++;
                        up = false;
                        direction = RIGHT;
                    }
                    break;

                case "right":
                    x++;
                    if (y <= R && y >= 1 && x <= C && x >= 1 && map[x - 1][y - 1].equals(".") && !usedPath[x - 1][y - 1].equals("x")) {
                        usedPath[x - 1][y - 1] = "x";
                        openPath(x, y);
                        reset();
                        count++;

                    } else if (!(y <= R && y >= 1 && x <= C && x >= 1)) {
                        x--;
                        right = false;
                        direction = LEFT;

                    } else if (!up && !down && !left) {
                        usedPath[x - 1][y - 1] = ".";
                        x--;
                        usedPath[x - 1][y - 1] = "x";

                    } else {
                        x--;
                        right = false;
                        direction = LEFT;
                    }
                    break;

                case "left":
                    x--;
                    if (y <= R && y >= 1 && x <= C && x >= 1 && map[x - 1][y - 1].equals(".") && !usedPath[x - 1][y - 1].equals("x")) {
                        usedPath[x - 1][y - 1] = "x";
                        openPath(x, y);
                        reset();
                        count++;

                    } else if (!(y <= R && y >= 1 && x <= C && x >= 1)) {
                        x++;
                        left = false;
                        direction = DOWN;

                    } else if (!up && !right && !down) {
                        usedPath[x - 1][y - 1] = ".";
                        x++;
                        usedPath[x - 1][y - 1] = "x";

                    } else {
                        x++;
                        left = false;
                        direction = DOWN;
                    }
                    break;
            }
        }
        System.out.println(count);
    }

    public static void openPath(int x, int y) {
        System.out.println("x: " + x + ", y: " + y);
    }

    public static void reset() {
        up = true;
        down = true;
        right = true;
        left = true;
    }
}