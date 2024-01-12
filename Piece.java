import java.util.Scanner;

public class Piece {
    char character;
    int row;
    int col;
    boolean isBlack;

    /**
     * Constructor.
     *
     * @param character The character representing the piece.
     * @param row       The row on the board the piece occupies.
     * @param col       The column on the board the piece occupies.
     * @param isBlack   The color of the piece.
     */
    public Piece(char character, int row, int col, boolean isBlack) {
        this.character = character;
        this.row = row;
        this.col = col;
        this.isBlack = isBlack;
    }

    /**
     * Determines if moving this piece is legal.
     *
     * @param board  The current state of the board.
     * @param endRow The destination row of the move.
     * @param endCol The destination column of the move.
     * @return If the piece can legally move to the provided destination on the board.
     */
    public boolean isMoveLegal(Board board, int endRow, int endCol) {
        switch (this.character) {
            case '\u2659':
            case '\u265f':
                Pawn pawn = new Pawn(row, col, isBlack);
                return pawn.isMoveLegal(board, endRow, endCol);
            case '\u2656':
            case '\u265c':
                Rook rook = new Rook(row, col, isBlack);
                return rook.isMoveLegal(board, endRow, endCol);
            case '\u265e':
            case '\u2658':
                Knight knight = new Knight(row, col, isBlack);
                return knight.isMoveLegal(board, endRow, endCol);
            case '\u265d':
            case '\u2657':
                Bishop bishop = new Bishop(row, col, isBlack);
                return bishop.isMoveLegal(board, endRow, endCol);
            case '\u265b':
            case '\u2655':
                Queen queen = new Queen(row, col, isBlack);
                return queen.isMoveLegal(board, endRow, endCol);
            case '\u265a':
            case '\u2654':
                King king = new King(row, col, isBlack);
                return king.isMoveLegal(board, endRow, endCol);
            default:
                return false;
        }
    }

    /**
     * Sets the position of the piece.
     *
     * @param row The row to move the piece to.
     * @param col The column to move the piece to.
     */
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    /**
     * Return the color of the piece.
     *
     * @return The color of the piece.
     */
    public boolean getIsBlack() {
        return this.isBlack;
    }

    /**
     * Handle promotion of a pawn.
     *
     * @param row     Current row of the pawn
     * @param isBlack Color of the pawn
     */
    public void promotePawn(int row, boolean isBlack) {
        if (isBlack && row == 7) {
            System.out.println("What would you like to promote the pawn to?");
            System.out.println("Your options are: Queen, Rook, Bishop, or Knight");
            Scanner blackScanner = new Scanner(System.in);
            String blackInput = blackScanner.nextLine();
            if (blackInput.equalsIgnoreCase("Rook")) {
                this.character = '\u265c';
                new Rook(row, this.col, true);
            } else if (blackInput.equalsIgnoreCase("Bishop")) {
                this.character = '\u265d';
                new Bishop(row, this.col, true);
            } else if (blackInput.equalsIgnoreCase("Knight")) {
                this.character = '\u265e';
                Knight knight = new Knight(row, this.col, true);
            } else if (blackInput.equalsIgnoreCase("Queen")) {
                this.character = '\u265b';
                new Queen(row, this.col, true);
            }
        } else if (!isBlack && row == 0) {
            System.out.println("What would you like to promote the pawn to?");
            System.out.println("Your options are: Queen, Rook, Bishop, or Knight");
            Scanner whiteScanner = new Scanner(System.in);
            String whiteInput = whiteScanner.nextLine();
            if (whiteInput.equalsIgnoreCase("Rook")) {
                this.character = '\u2656';
                new Rook(row, this.col, false);
            } else if (whiteInput.equalsIgnoreCase("Bishop")) {
                this.character = '\u2657';
                new Bishop(row, this.col, false);
            } else if (whiteInput.equalsIgnoreCase("Knight")) {
                this.character = '\u2658';
                new Knight(row, this.col, false);
            } else if (whiteInput.equalsIgnoreCase("Queen")) {
                this.character = '\u2655';
                new Queen(row, this.col, false);
            }
        }
    }

    /**
     * Returns a string representation of the piece.
     * @return  A string representation of the piece.
     */
    public String toString() {
        return Character.toString(this.character);
    }
}
