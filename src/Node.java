class Node {

    private boolean walkable;
    private int xPos;
    private int yPos;

    private int gCost;
    private int hCost;

    Node(boolean walkable, int x, int y) {
        this.walkable = walkable;
        xPos = x;
        yPos = y;
    }

    int xPosition(){
        return xPos;
    }
    int yPosition(){
        return  yPos;
    }
    boolean isWalkable(){
        return walkable;
    }
    int fCost() {
        return gCost + hCost;
    }
    int hCost() {
        return hCost;
    }
}
