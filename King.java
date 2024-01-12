public class King {
    int row;
    int col;
    boolean isBlack;
    public King(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    //check if move is legal for king and return possible positions
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        if (board.verifyAdjacent(this.row, this.col, endRow, endCol) && board.getPiece(endRow, endCol) == null) {
            //move to adjacent empty space
            return ((endRow == this.row + 1) && (endCol == this.col))
                    || ((endRow == this.row) && (endCol == this.col + 1))
                    || ((endRow == this.row + 1) && (endCol == this.col + 1))
                    || ((endRow == this.row - 1) && (endCol == this.col))
                    || ((endRow == this.row) && (endCol == this.col - 1))
                    || ((endRow == this.row - 1) && (endCol == this.col - 1))
                    || ((endRow == this.row + 1) && (endCol == this.col - 1))
                    || ((endRow == this.row - 1) && (endCol == this.col + 1));
            //move to space and take a piece of opposite color
        } else if (board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack && board.verifyAdjacent(this.row, this.col, endRow, endCol))
            return ((endRow == this.row + 1) && (endCol == this.col))
                    || ((endRow == this.row) && (endCol == this.col + 1))
                    || ((endRow == this.row + 1) && (endCol == this.col + 1))
                    || ((endRow == this.row - 1) && (endCol == this.col))
                    || ((endRow == this.row) && (endCol == this.col - 1))
                    || ((endRow == this.row - 1) && (endCol == this.col - 1))
                    || ((endRow == this.row + 1) && (endCol == this.col - 1))
                    || ((endRow == this.row - 1) && (endCol == this.col + 1));
        return false;
    }
}
