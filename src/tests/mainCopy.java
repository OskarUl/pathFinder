package tests;

import java.util.*;

import static java.lang.StrictMath.sqrt;

public class mainCopy {
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

        String map[][] = new String[C + 2][R + 2];

        for (int r = 1; r <= (R + 2); r++) {
            map[0][r - 1] = "#";
            map[C + 2 - 1][r - 1] = "#";
        }

        for (int c = 1; c <= (C + 2); c++) {
            map[c - 1][0] = "#";
            map[c - 1][R + 2 - 1] = "#";
        }

        for (int r = 1; r <= R; r++) {
            String row[] = sc.next().split("");
            for (int c = 1; c <= C; c++) {
                map[c][r] = row[c - 1];
            }
        }
        long startTime = System.nanoTime();
        Path(map);
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }

    public static void Path(String map[][]) {

        // lägg till en array som sparar alla vägar som datorn kan gå

        List<String[][]> Paths = new ArrayList<>();

        String DOWN = "down";
        String UP = "up";
        String RIGHT = "right";
        String LEFT = "left";



        boolean possible = true;

        String usedPath[][] = map;

        int x = 1;
        int y = 1;
        int count = 0;


        String direction = DOWN;
        double test[][] = new double[C + 2][R + 2];

        for (int Y = 1; Y <= R; Y++){
            for (int X = 1; X <= C; X++){
                int dx = C - X;
                int dy = R - Y;
                double heuristic = sqrt((dx*dx)+(dy*dy));
                test[X][Y] = heuristic;
            }
        }
        System.out.println(Arrays.deepToString(test).replace("], ", "]\n").replace("[[", "[").replace("]]", "]"));

        while (!(x == C && y == R)) {

            //test++;
            //TEST.add(usedPath);
            //Paths.add(openPath(usedPath));

            switch (direction) {
                case "down":
                    y++;
                    if (y <= R && y >= 1 && x <= C && x >= 1 && map[x][y].equals(".") && !usedPath[x][y].equals("x")) {
                        usedPath[x][y] = "x";
                        openPath(map);
                        //Paths.add(openPath(usedPath));
                        reset();
                        count++;

                    } else if ((!up && !right && !left) && usedPath[x][y].equals("x")) {
                        //usedPath[x][y - 1] = "#";
                        reset();
                        count--;

                    } else {
                        y--;
                        direction = UP;
                        down = false;
                    }
                    break;

                case "up":
                    y--;
                    if (y <= R && y >= 1 && map[x][y].equals(".") && !usedPath[x][y].equals("x")) {
                        usedPath[x][y] = "x";
                        openPath(map);
                        //Paths.add(openPath(usedPath));
                        reset();
                        count++;

                    } else if ((!down && !right && !left) && usedPath[x][y].equals("x")) {
                        //usedPath[x][y + 1] = "#";
                        reset();
                        count--;

                    } else {
                        y++;
                        up = false;
                        direction = RIGHT;
                    }
                    break;

                case "right":
                    x++;
                    if (y <= R && y >= 1 && x <= C && x >= 1 && map[x][y].equals(".") && !usedPath[x][y].equals("x")) {
                        usedPath[x][y] = "x";
                        openPath(map);
                        //Paths.add(openPath(usedPath));
                        reset();
                        count++;

                    } else if ((!up && !down && !left) && usedPath[x][y].equals("x")) {
                        //usedPath[x - 1][y] = "#";
                        reset();
                        count--;

                    } else {
                        x--;
                        right = false;
                        direction = LEFT;
                    }
                    break;

                case "left":
                    x--;
                    if (y <= R && y >= 1 && x <= C && x >= 1 && map[x][y].equals(".") && !usedPath[x][y].equals("x")) {
                        usedPath[x][y] = "x";
                        openPath(map);
                        reset();
                        count++;

                    } else if ((!up && !right && !down) && usedPath[x][y].equals("x")) {
                        //usedPath[x + 1][y] = "#";
                        reset();
                        count--;

                    } else {
                        x++;
                        left = false;
                        direction = DOWN;
                    }
                    break;
            }
            if (usedPath[x + 1][y].equals("#") && usedPath[x - 1][y].equals("#") && usedPath[x][y + 1].equals("#") && usedPath[x][y - 1].equals("#")) {
                possible = false;
                break;
            } else if (count == (R + C)) {
                //break;
            }
        }
        if (possible) {
            System.out.println(count);
        } else {
            System.out.println("nej");
        }
        //System.out.println(TEST);
        //System.out.println("\n" + Arrays.deepToString(TEST.toArray()).replace("], ", "]\n").replace("[[", "[").replace("]]", "]").replace(",", ""));
    }

    public static void openPath(String[][] x) {
        System.out.println("\n" + Arrays.deepToString(x).replace("], ", "]\n").replace("[[", "[").replace("]]", "]").replace(",", ""));
    }

    public static void reset() {
        up = true;
        down = true;
        right = true;
        left = true;
    }

    public static int shortestPath(List<String[][]> Paths) {

        return 0;
    }
}