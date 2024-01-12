public class Board {

    // Instance variables
    public Piece[][] board;

    public Board() {
        this.board = new Piece[8][8];
    }

    // Accessor Methods
    //get the location of a piece
    public Piece getPiece(int row, int col) {
        return board[row][col];
    }
    //set the piece location on the board
    public void setPiece(int row, int col, Piece piece) {
        this.board[row][col] = piece;
    }

    // Game functionality methods
    //move the given piece and if a pawn is in promo zone then promote it
    public boolean movePiece(int startRow, int startCol, int endRow, int endCol) {
        Piece startPiece = this.getPiece(startRow, startCol);
        if (startPiece.isMoveLegal(this, endRow, endCol)) {
            if (startPiece.character == '\u2659' && endRow == 0) {
                this.board[endRow][endCol] = startPiece;
                this.board[startRow][startCol] = null;
                startPiece.promotePawn(endRow, false);
                return true;
            } else if (startPiece.character == '\u265f' && endRow == 7) {
                this.board[endRow][endCol] = startPiece;
                this.board[startRow][startCol] = null;
                startPiece.promotePawn(endRow, true);
                return true;
            } else {
                startPiece.setPosition(endRow, endCol);
                this.board[endRow][endCol] = startPiece;
                this.board[startRow][startCol] = null;
                return true;
            }
        }
        return false;
    }
    //check number of kings to report if game is still going
    public boolean isGameOver() {
        int numKings = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (this.getPiece(i, j) != null && (this.getPiece(i, j).character == '\u265a' || this.getPiece(i, j).character == '\u2654'))
                    numKings += 1;
            }
        }
        if (numKings < 2) {
            return true;
        }
        return false;
    }

    // Constructs a String that represents the Board object's 2D array.
    // Returns the fully constructed String.
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(" ");
        for (int i = 0; i < 8; i++) {
            out.append(" ");
            out.append(i);
        }
        out.append('\n');
        for (int i = 0; i < board.length; i++) {
            out.append(i);
            out.append("|");
            for (int j = 0; j < board[0].length; j++) {
                out.append(board[i][j] == null ? "\u2001|" : board[i][j] + "|");
            }
            out.append("\n");
        }
        return out.toString();
    }
    //clear board
    public void clear() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = null;
            }
        }
    }

    // Movement helper functions
    //check if move is in bounds
    public boolean verifySourceAndDestination(int startRow, int startCol, int endRow, int endCol, boolean isBlack) {
        if (startRow >= 8 || startCol >= 8 || endRow >= 8 || endCol >= 8 || startRow < 0 || startCol < 0 || endRow < 0 || endCol < 0)
            return false;
        else if (board[startRow][startCol] == null)
            return false;
        else if (this.getPiece(startRow, startCol).getIsBlack() != isBlack)
            return false;
        else if (board[endRow][endCol] != null)
            if (this.getPiece(endRow, endCol).getIsBlack() == isBlack)
                return false;
            else
                return true;
        return true;
    }
    //check if adjacent move is valid and if there are any pieces between start and end
    public boolean verifyAdjacent(int startRow, int startCol, int endRow, int endCol) {
        int rowDiff = Math.abs(startRow - endRow);
        int colDiff = Math.abs(startCol - endCol);
        if ((rowDiff <= 1) && (colDiff <= 1))
            return true;
        else
            return false;
    }
    //check if horizontal move is valid and if there are any pieces between start and end
    public boolean verifyHorizontal(int startRow, int startCol, int endRow, int endCol) {
        int minCol = Math.min(startCol, endCol);
        int maxCol = Math.max(startCol, endCol);
        if (startRow != endRow)
            return false;
        for (int i = minCol + 1; i < maxCol; i++)
            if (board[endRow][i] != null)
                return false;
        return true;
    }
    //Check if vertical move is valid and if there are any pieces between start and end
    public boolean verifyVertical(int startRow, int startCol, int endRow, int endCol) {
        int minRow = Math.min(startRow, endRow);
        int maxRow = Math.max(startRow, endRow);
        if (startCol != endCol)
            return false;
        for (int i = minRow + 1; i < maxRow; i++)
            if (board[i][endCol] != null)
                return false;
        return true;
    }
    //Check if diagonal move is valid and if there are any pieces between start and end
    public boolean verifyDiagonal(int startRow, int startCol, int endRow, int endCol) {
        int rowDiff = Math.abs(startRow - endRow);
        int colDiff = Math.abs(startCol - endCol);

        if (rowDiff != colDiff)
            return false;

        int rowIncrement = Integer.compare(endRow, startRow);
        int colIncrement = Integer.compare(endCol, startCol);

        int row = startRow + rowIncrement;
        int col = startCol + colIncrement;

        if (row == endRow && col == endCol) {
            return true;
        }
        while (row != endRow && col != endCol) {
            if (row < 0 || row >= 8 || col < 0 || col >= 8) {
                return false;
            }
            if (board[row][col] != null) {
                return false;
            }
            row += rowIncrement;
            col += colIncrement;
        }
        return true;
    }
}
