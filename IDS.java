import java.util.ArrayList;
import java.util.Stack;

public class IDS {

    private BoardString boardString;
    private long nodes = 1;

    public IDS(int size){

        boardString = new BoardString(size);
    }
    /*
    public String solve(){

        int depth = 0;

        while(true){



        }

        return null;

    }
    */
    public String DLS(String boardSignature, int limit){

        Stack<String> stack = new Stack<String>();
        //ArrayList<String> visitedNodes = new ArrayList<>();
        stack.add(boardSignature);

        int depth = 0;

        while(!stack.isEmpty()){

            if(depth <= limit) {
                String stackTop = stack.pop();
                if (boardString.isFinal(stackTop)) {
                    return stackTop;
                } else {
                    //visitedNodes.add(stackTop);
                    
                    String up = boardString.moveUp(stackTop);
                    if (boardString.isValid(up)) {
                        stack.push(up);
                        nodes++;
                    }

                    String down = boardString.moveDown(stackTop);
                    if (boardString.isValid(down)) {
                        stack.push(down);
                        nodes++;
                    }

                    String left = boardString.moveLeft(stackTop);
                    if (boardString.isValid(left)) {
                        stack.push(left);
                        nodes++;
                    }

                    String right = boardString.moveRight(stackTop);
                    if (boardString.isValid(right)) {
                        stack.push(right);
                        nodes++;
                    }
                }

                depth++;

            } else {
                return null;
            }
        }

        return null;
    }



}
