public class Queen {
        int row;
        int col;
        boolean isBlack;
        public Queen(int row, int col, boolean isBlack) {
            this.row = row;
            this.col = col;
            this.isBlack = isBlack;
        }
        //check if move is legal for queen and return possible positions
        public boolean isMoveLegal(Board board, int endRow, int endCol) {
            int absRowDiff = Math.abs(endRow - this.row);
            int absColDiff = Math.abs(endCol - this.col);
            int rowDiff = endRow - this.row;
            int colDiff = endCol - this.col;
            //check if row is the same, then return a new column
            if (endRow == this.row) {
                //move piece to empty space and check if space between are empty
                if (board.verifyHorizontal(this.row, this.col, endRow, endCol) && board.getPiece(endRow, endCol) == null)
                    return ((endRow == this.row) && (endCol == this.col + absColDiff))
                            || ((endRow == this.row) && (endCol == this.col - absColDiff));
                //move the piece to capture a piece of opposite color and check if space between are empty
                else if (board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack && board.verifyHorizontal(this.row, this.col, endRow, endCol))
                    return ((endRow == this.row) && (endCol == this.col - absColDiff))
                            || ((endRow == this.row) && (endCol == this.col + absColDiff));
            //check if column is the same, then return a new row
            } if (endCol == this.col) {
                //move piece to empty space and check if space between are empty
                if (board.verifyVertical(this.row, this.col, endRow, endCol) && board.getPiece(endRow, endCol) == null)
                    return ((endRow == this.row + absRowDiff) && (endCol == this.col))
                            || ((endRow == this.row - absRowDiff) && (endCol == this.col));
                //move the piece to capture a piece of opposite color and check if space between are empty
                else if (board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack && board.verifyVertical(this.row, this.col, endRow, endCol))
                    return ((endRow == this.row + absRowDiff) && (endCol == this.col))
                            || ((endRow == this.row - absRowDiff) && (endCol == this.col));

            } if (board.verifyDiagonal(this.row, this.col, endRow, endCol) && board.getPiece(endRow, endCol) == null){
                //move piece to empty space and check if space between are empty
                return ((endRow == this.row + rowDiff) && (endCol == this.col + colDiff))
                        ||((endRow == this.row - rowDiff) && (endCol == this.col - colDiff))
                        || ((endRow == this.row - rowDiff) && (endCol == this.col + colDiff))
                        || ((endRow == this.row + rowDiff) && (endCol == this.col - colDiff));
                //move the piece to capture a piece of opposite color and check if space between are empty
            } if (board.getPiece(endRow, endCol) != null && board.getPiece(endRow, endCol).getIsBlack() != this.isBlack && board.verifyDiagonal(this.row, this.col, endRow, endCol)) {
                return ((endRow == this.row + rowDiff) && (endCol == this.col + colDiff))
                        ||((endRow == this.row - rowDiff) && (endCol == this.col - colDiff))
                        || ((endRow == this.row - rowDiff) && (endCol == this.col + colDiff))
                        || ((endRow == this.row + rowDiff) && (endCol == this.col - colDiff));
                }
            return false;
            }
        }

