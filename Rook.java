public class Rook {
    int row;
    int col;
    boolean isBlack;
    public Rook(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    //check if move is legal for rook and return possible positions
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        int rowDiff = Math.abs(endRow - this.row);
        int colDiff = Math.abs(endCol - this.col);
        //check if row is the same, then return a new column
        if (endRow == this.row) {
            //move piece to empty space
            if (board.verifyHorizontal(this.row, this.col, endRow, endCol) && board.getPiece(endRow, endCol) == null)
                return ((endRow == this.row) && (endCol == this.col + colDiff))
                        || ((endRow == this.row) && (endCol == this.col - colDiff));
            //move the piece to capture a piece of opposite color
            else if (board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack && board.verifyHorizontal(this.row, this.col, endRow, endCol))
                return ((endRow == this.row) && (endCol == this.col - colDiff))
                        || ((endRow == this.row) && (endCol == this.col + colDiff));
        //check if column is the same, then return a new row
        }if (endCol == this.col)
            //move piece to empty space
            if (board.verifyVertical(this.row, this.col, endRow, endCol) && board.getPiece(endRow, endCol) == null)
                return ((endRow == this.row + rowDiff) && (endCol == this.col))
                        || ((endRow == this.row - rowDiff) && (endCol == this.col));
            //move the piece to capture a piece of opposite color
            else if (board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack && board.verifyVertical(this.row, this.col, endRow, endCol))
                return ((endRow == this.row + rowDiff) && (endCol == this.col))
                        || ((endRow == this.row - rowDiff) && (endCol == this.col));

        return false;
    }
}