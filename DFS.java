import java.util.Stack;

public class DFS {

    private BoardString boardString;
    private long nodes = 1;

    public DFS(int size){

        boardString = new BoardString(size);
        boardString.printBoard(this.solve());
        System.out.println("\n" + nodes);
    }

    /**
     * In this case DFS always finds a solution. That is, each node has children and some of them may be a solution to the problem.
     * Therefore, I store in Stack always one or zero nodes.
     * @return solution
     */

    public String solve(){

        if(!boardString.isValid(boardString.getBoard())) return null;
        Stack<String> path = new Stack<>();
        path.push(boardString.getBoard());

        while(!path.isEmpty()){

            String topStack = path.pop();
            if(boardString.isFinal(topStack)) return topStack;

            while (true) {

                /*
                I can add other nodes to the stack in different order for each case.
                 */

                double random = Math.random();
                if (random > 0.75) {
                    String up = boardString.moveUp(topStack);
                    if (boardString.isValid(up)) {
                        path.push(up);
                        nodes++;
                        break;
                    }
                } else if (random > 0.5) {
                    String down = boardString.moveDown(topStack);
                    if (boardString.isValid(down)) {
                        path.push(down);
                        nodes++;
                        break;
                    }
                } else if (random > 0.25) {
                    String left = boardString.moveLeft(topStack);
                    if (boardString.isValid(left)) {
                        path.push(left);
                        nodes++;
                        break;
                    }
                } else {
                    String right = boardString.moveRight(topStack);
                    if (boardString.isValid(right)) {
                        path.push(right);
                        nodes++;
                        break;
                    }
                }
            }
        }

        return null;
    }

    public String getBoardSignature(){

        return boardString.getBoard();
    }

}
