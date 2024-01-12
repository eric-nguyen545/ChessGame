public class Bishop {
    int row;
    int col;
    boolean isBlack;
    public Bishop(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    //check if move is legal for bishop and return possible positions
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        int rowDiff = endRow - this.row;
        int colDiff = endCol - this.col;
        //move piece to empty space and check if space between are empty
        if (board.verifyDiagonal(this.row, this.col, endRow, endCol) && board.getPiece(endRow, endCol) == null){
            return ((endRow == this.row + rowDiff) && (endCol == this.col + colDiff))
                    ||((endRow == this.row - rowDiff) && (endCol == this.col - colDiff))
                    || ((endRow == this.row - rowDiff) && (endCol == this.col + colDiff))
                    || ((endRow == this.row + rowDiff) && (endCol == this.col - colDiff));
        //move the piece to capture a piece of opposite color and check if space between are empty
        } else if (board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack && board.verifyDiagonal(this.row, this.col, endRow, endCol)) {
            return ((endRow == this.row + rowDiff) && (endCol == this.col + colDiff))
                    ||((endRow == this.row - rowDiff) && (endCol == this.col - colDiff))
                    || ((endRow == this.row - rowDiff) && (endCol == this.col + colDiff))
                    || ((endRow == this.row + rowDiff) && (endCol == this.col - colDiff));
        }
        return false;
    }
}
