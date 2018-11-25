import java.util.ArrayList;
import java.util.List;

public class PathFinding {

    public static void main(String[] args){
        Grid grid = new Grid();
        Node startPos = grid.getGrid()[1][1];
        Node endPos = grid.getGrid()[grid.getColumns()][grid.getRows()];
        FindPath(startPos, endPos);
    }
    private static void FindPath(Node startNode, Node endNode) {
        List <Node> open = new ArrayList<>();
        List <Node> closed = new ArrayList<>();
        open.add(startNode);

        while (!open.isEmpty()){
            Node currentNode = open.get(0);
            for (int i = 1; i < open.size(); i++){
                if(open.get(i).fCost() < currentNode.fCost() || open.get(i).fCost() == currentNode.fCost() && open.get(i).hCost() < currentNode.hCost()) {
                    currentNode = open.get(i);
                }
            }

            open.remove(currentNode);
            closed.add(currentNode);

            if(currentNode == endNode){
                return;
            }


        }
    }
}
