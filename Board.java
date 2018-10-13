import java.io.*;
import java.util.Arrays;

public class Board implements Serializable{

    private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
    private int x,y;
    private char[][] board;
    private char[][] finalState;

    public Board (int size){
        initialise(size);
        generateFinal();
    }

    private void initialise(int size){

       board = new char[size][size];
       x = size-1;
       y = size-1;

       for(int i=0; i<size-1; i++){

           board[size-1][i] = alphabet[i];
       }
    }

    public void printFinalState(){
        print(finalState);
    }

    public void printBoard(){
        print(board);
    }

    private void print(char[][] board){

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){

                if(i == y && x == j) {
                    System.out.print("X ");
                } else {
                    if(board[i][j] == 0){
                        System.out.print("+ ");
                    }
                    else
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    //char[][]
    public void generateFinal(){

        char[][] finalState = new char[board.length][board.length];

        int column = finalState.length % 2 == 0 ? (int)Math.ceil((finalState.length-2)/2) : ((finalState.length-2)/2);

        for(int i=1; i<finalState.length; i++){
            finalState[i][column] = alphabet[i-1];
        }

        this.finalState = finalState;
    }

    public boolean isFinal(){

        if(Arrays.deepEquals(board,finalState)){
            return true;
        }

        return false;
    }

    public boolean canMoveLeft(){
        return !(x-1 < 0);
    }

    public Board moveLeft(){

        if(board[y][x-1] != 0){
            board[y][x] = board[y][x-1];
            board[y][x-1] = 0;
        }
        x--;
        return this;
    }

    public boolean canMoveRight(){
        return !(x+1 >= board.length);
    }

    public Board moveRight(){

        if(board[y][x+1] != 0){
            board[y][x] = board[y][x+1];
            board[y][x+1] = 0;
        }
        x++;

        return this;
    }

    public boolean canMoveDown(){
        return !(y+1 >= board.length);
    }

    public Board moveDown(){

        if(board[y+1][x] != 0){
            board[y][x] = board[y+1][x];
            board[y+1][x] = 0;
        }

        y++;

        return this;
    }

    public boolean canMoveUp(){
        return !(y-1 < 0);
    }

    public Board moveUp(){

        if(board[y-1][x] != 0){
            board[y][x] = board[y-1][x];
            board[y-1][x] = 0;
        }
        y--;

        return this;
    }

    public char[][] getFinalState() {
        return finalState;
    }

    public String boardSignature(){

        StringBuilder boardAsString = new StringBuilder();

        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board.length; j++) {
                if(board[i][j] != 0){
                    boardAsString.append(board[i][j]);
                    boardAsString.append(i);
                    boardAsString.append(j);
                }
            }
        }
        boardAsString.append(x);
        boardAsString.append(y);
        return boardAsString.toString();
    }

    public Board deepCopy() {
        try {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            ObjectOutputStream outputStrm = new ObjectOutputStream(outputStream);
            outputStrm.writeObject(this);
            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            ObjectInputStream objInputStream = new ObjectInputStream(inputStream);
            return (Board) objInputStream.readObject();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //new approach operate on strings


    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
