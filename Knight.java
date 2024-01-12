public class Knight {
    int row;
    int col;
    boolean isBlack;
    public Knight(int row, int col, boolean isBlack) {
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }
    //check if move is legal for knight and return possible positions
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        //move piece to empty space and check if space between are empty
        if (board.getPiece(endRow, endCol) == null) {
                return ((endRow == this.row + 2) && (endCol == this.col + 1))
                        || ((endRow == this.row + 2) && (endCol == this.col - 1))
                        || ((endRow == this.row + 1) && (endCol == this.col + 2))
                        || ((endRow == this.row + 1) && (endCol == this.col - 2))
                        ||((endRow == this.row - 2) && (endCol == this.col - 1))
                        || ((endRow == this.row - 2) && (endCol == this.col + 1))
                        || ((endRow == this.row - 1) && (endCol == this.col - 2))
                        || ((endRow == this.row - 1) && (endCol == this.col + 2));
        //move the piece to capture a piece of opposite color and check if space between are empty
        } else if (board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack) {
                return ((endRow == this.row + 2) && (endCol == this.col + 1))
                        || ((endRow == this.row + 2) && (endCol == this.col - 1))
                        || ((endRow == this.row + 1) && (endCol == this.col + 2))
                        || ((endRow == this.row + 1) && (endCol == this.col - 2))
                        ||((endRow == this.row - 2) && (endCol == this.col - 1))
                        || ((endRow == this.row - 2) && (endCol == this.col + 1))
                        || ((endRow == this.row - 1) && (endCol == this.col - 2))
                        || ((endRow == this.row - 1) && (endCol == this.col + 2));
        }
        return false;
        }
    }
