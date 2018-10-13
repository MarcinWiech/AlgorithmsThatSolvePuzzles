public class BoardString {

    private char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toUpperCase().toCharArray();
    private int x,y, size;
    private String  board;
    private String finalState;


    public BoardString (int size){
        this.size = size;
        this.x = size-1;
        this.y = size-1;
        initialise();
        generateFinal();
    }

    private void generateFinal(){

        StringBuilder finalState = new StringBuilder();
        finalState.append(size);
        finalState.append(x);
        finalState.append(y);
        int column = size % 2 == 0 ? (int)Math.ceil((size-1)/2) : ((size-1)/2);

        for(int i=1; i<size; i++){
            finalState.append(alphabet[i-1]);
            finalState.append(i);
            finalState.append(column);
        }

        this.finalState = finalState.toString();
    }

    public boolean isFinal(String boardSignature){

        return boardSignature.substring(3).equals(new BoardString(Character.getNumericValue(boardSignature.charAt(0))).getFinalState().substring(3));
    }

    private void initialise(){

        StringBuilder initialBoard = new StringBuilder();
        initialBoard.append(size);
        initialBoard.append(x);
        initialBoard.append(y);
        for (int i = 0; i < size-1; i++) {
            initialBoard.append(alphabet[i]);
            initialBoard.append(size-1);
            initialBoard.append(i);
        }

        board = initialBoard.toString();
    }

    public void printBoard(String boardSignature){

        char[][] board = new char[Character.getNumericValue(boardSignature.charAt(0))][Character.getNumericValue(boardSignature.charAt(0))];
        board[Character.getNumericValue(boardSignature.charAt(1))][Character.getNumericValue(boardSignature.charAt(2))] = 'X';
        for (int i = 3; i < boardSignature.length(); i++) {

            board[Character.getNumericValue(boardSignature.charAt(i+1))][Character.getNumericValue(boardSignature.charAt(i+2))] = boardSignature.charAt(i);
            i += 2;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j] == 0){
                    System.out.print("+ ");
                }else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    
    public boolean isValid(String boardSignature){
        
        int size = Character.getNumericValue(boardSignature.charAt(0));

        if(Character.getNumericValue(boardSignature.charAt(1)) >= size) return false;
        if(Character.getNumericValue(boardSignature.charAt(2)) >= size) return false;

        for (int i = 4; i < boardSignature.length(); i+=3) {
            if(Character.getNumericValue(boardSignature.charAt(i)) >= size) return false;
            if(Character.getNumericValue(boardSignature.charAt(i+1)) >= size) return false;
        }
        
        return true;
    }

    public String moveLeft(String boardSignature){

        StringBuilder moved = new StringBuilder(boardSignature);

        int y = Character.getNumericValue(boardSignature.charAt(1));
        int x = Character.getNumericValue(boardSignature.charAt(2));
        for (int i = 4; i < boardSignature.length(); i+=3) {
            if(Character.getNumericValue(boardSignature.charAt(i)) == y && Character.getNumericValue(boardSignature.charAt(i+1)) == x-1){
                moved.replace(i,i+1, String.valueOf(y));
                moved.replace(i+1,i+2, String.valueOf(x));
            }
        }
        moved.replace(2,3, String.valueOf(x-1));
        return moved.toString();
    }

    public String moveRight(String boardSignature){

        StringBuilder moved = new StringBuilder(boardSignature);

        int y = Character.getNumericValue(boardSignature.charAt(1));
        int x = Character.getNumericValue(boardSignature.charAt(2));
        for (int i = 4; i < boardSignature.length(); i+=3) {
            if(Character.getNumericValue(boardSignature.charAt(i)) == y && Character.getNumericValue(boardSignature.charAt(i+1)) == x+1){
                moved.replace(i,i+1, String.valueOf(y));
                moved.replace(i+1,i+2, String.valueOf(x));
            }
        }
        moved.replace(2,3, String.valueOf(x+1));
        return moved.toString();
    }

    public String moveUp(String boardSignature){

        StringBuilder moved = new StringBuilder(boardSignature);

        int y = Character.getNumericValue(boardSignature.charAt(1));
        int x = Character.getNumericValue(boardSignature.charAt(2));
        for (int i = 4; i < boardSignature.length(); i+=3) {
            if(Character.getNumericValue(boardSignature.charAt(i)) == y-1 && Character.getNumericValue(boardSignature.charAt(i+1)) == x){
                moved.replace(i,i+1, String.valueOf(y));
                moved.replace(i+1,i+2, String.valueOf(x));
            }
        }
        moved.replace(1,2, String.valueOf(y-1));
        return moved.toString();
    }

    public String moveDown(String boardSignature){

        StringBuilder moved = new StringBuilder(boardSignature);

        int y = Character.getNumericValue(boardSignature.charAt(1));
        int x = Character.getNumericValue(boardSignature.charAt(2));
        for (int i = 4; i < boardSignature.length(); i+=3) {
            if(Character.getNumericValue(boardSignature.charAt(i)) == y+1 && Character.getNumericValue(boardSignature.charAt(i+1)) == x){
                moved.replace(i,i+1, String.valueOf(y));
                moved.replace(i+1,i+2, String.valueOf(x));

            }
        }
        moved.replace(1,2, String.valueOf(y+1));
        return moved.toString();
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBoard() {
        return board;
    }

    public void setBoard(String board) {
        this.board = board;
    }

    public String getFinalState() {
        return finalState;
    }

    public void setFinalState(String finalState) {
        this.finalState = finalState;
    }
}
