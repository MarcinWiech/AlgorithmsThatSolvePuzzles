import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFSString {

    private BoardString boardString;
    private long nodes = 1;

    public BFSString(int size){

        boardString = new BoardString(size);
        boardString.printBoard(this.solve());
        System.out.println("\n" + nodes);
    }

    private String solve(){

        Queue<String> queue = new LinkedList<String>();

        //Contains all the visited nodes. Helps escape infinite loops.
        HashSet<String> visited = new HashSet<>();
        queue.add(boardString.getBoard());

        while(!queue.isEmpty()){

            String queueTop = queue.remove();
            if(boardString.isValid(queueTop)){

                if(boardString.isFinal(queueTop)) return queueTop;

                if(!visited.contains(boardString.moveLeft(queueTop)) && boardString.isValid(boardString.moveLeft(queueTop))){
                    queue.add(boardString.moveLeft(queueTop));
                    nodes++;
                }
                if(!visited.contains(boardString.moveRight(queueTop)) && boardString.isValid(boardString.moveRight(queueTop))){
                    queue.add(boardString.moveRight(queueTop));
                    nodes++;
                }
                if(!visited.contains(boardString.moveUp(queueTop)) && boardString.isValid(boardString.moveUp(queueTop))){
                    queue.add(boardString.moveUp(queueTop));
                    nodes++;
                }
                if(!visited.contains(boardString.moveDown(queueTop)) && boardString.isValid(boardString.moveDown(queueTop))){
                    queue.add(boardString.moveDown(queueTop));
                    nodes++;
                }

                visited.add(queueTop);
            }
        }
        return null;
    }



}
