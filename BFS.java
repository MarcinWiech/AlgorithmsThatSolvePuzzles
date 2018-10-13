import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private Board board;
    private long nodes = 1;
    private HashSet visited = new HashSet<String>();

    public BFS(int size){
        board = new Board(size);
    }

    public Board solve() {

        Queue<Board> queue = new LinkedList<>();
        queue.add(board);
        //visited.put(board.getBoard(),new Point(board.getX(),board.getY()));

        while(!queue.isEmpty()){

            Board firstInQueue = queue.remove();
            String boardSignature = firstInQueue.boardSignature();
/*
            firstInQueue.printBoard();
            System.out.println();
*/
            if(!visited.contains(boardSignature)) {

                visited.add(boardSignature);

                if (firstInQueue.isFinal()) return firstInQueue;

                if (firstInQueue.canMoveDown()) {

                    queue.add(firstInQueue.deepCopy().moveDown());
                    nodes++;
                }

                if (firstInQueue.canMoveUp()) {
                    queue.add(firstInQueue.deepCopy().moveUp());
                    nodes++;
                }

                if (firstInQueue.canMoveLeft()) {
                    queue.add(firstInQueue.deepCopy().moveLeft());
                    nodes++;
                }

                if (firstInQueue.canMoveRight()) {
                    queue.add(firstInQueue.deepCopy().moveRight());
                    nodes++;
                }
            }
        }


        return null;
    }

    public Board getBoard() {
        return board;
    }

    public long getNodes() {
        return nodes;
    }
}
