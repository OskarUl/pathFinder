import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Grid {

    private int R;
    private int C;
    private int K;
    private Node[][] grid;

    Grid() {

        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();

        C  = sc.nextInt();

        K = sc.nextInt();

        grid = new Node[C + 2][R + 2];

        for (int r = 1; r <= (R + 2); r++) {
            grid[0][r - 1] = new Node(false, 0, r - 1);
            grid[C + 2 - 1][r - 1] = new Node(false, C + 2 - 1, r - 1);
        }

        for (int c = 1; c <= (C + 2); c++) {
            grid[c - 1][0] = new Node(false, c - 1, 0);
            grid[c - 1][R + 2 - 1] = new Node(false, c - 1, R + 2 - 1);
        }

        for (int r = 1; r <= R; r++) {
            String row[] = sc.next().split("");
            for (int c = 1; c <= C; c++) {
                boolean walkable = !row[c - 1].equals("#");
                grid[c][r] = new Node(walkable, c, r);
            }
        }
    }

    List<Node> getNeighbours(Node node){
        List<Node> getNeighbours = new ArrayList<>();
        return null;
    }

    int getRows(){
        return R;
    }
    int getColumns(){
        return C;
    }
    int getK(){
        return K;
    }
    Node[][] getGrid(){
        return grid;
    }

}
