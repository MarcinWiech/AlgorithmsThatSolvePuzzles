import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {

        Board board = new Board(3);
        //BFSString test = new BFSString(6);
        System.out.println();
        DFS testD = new DFS(8);
        /*
        board.moveUp();
        board.moveLeft();
        board.moveLeft();
        board.moveDown();
        board.moveRight();
        board.moveUp();
        board.moveLeft();
        board.moveUp();
        board.moveRight();
        board.moveRight();
        board.moveDown();
        board.moveDown();
        board.moveLeft();
        board.moveLeft();
        board.printBoard();
        */
        /*
        BFS test = new BFS(6);
        test.solve().printBoard();
        System.out.println(test.getNodes());
*/
        BoardString boardString = new BoardString(4);
        /*
        boardString.printBoard(boardString.getBoard());
        boardString.printBoard(boardString.moveDown(boardString.moveLeft(boardString.moveUp(boardString.moveLeft(boardString.getBoard())))));
        boardString.printBoard(boardString.moveUp(boardString.moveLeft(boardString.getBoard())));
        */
    }
}
