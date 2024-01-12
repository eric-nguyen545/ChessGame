import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        // initialize tracking for the turn and color
        int num = 1;
        String color = "white";
        //create the board and set the starting position of the pieces
        Board game = new Board();
        Fen.load("k7/8/4P3/8/2P1r1P1/8/4P3/K7", game);
        //loop that tracks the game status/number of kings
        while (!game.isGameOver()) {
            //update the current color's turn
            if ((num % 2) == 0) {
                color = "black";
            } else {
                color = "white";
            }
            num += 1;
            System.out.print(game);
            System.out.println("It is currently " + color + "'s turn");
            System.out.println("What is your move? (format [start row] [start col] [end row] [end col]");
            Scanner myScanner = new Scanner(System.in);
            String input = myScanner.nextLine();
            //take the input, and add it to a String array which then is split by the spaces and then the rows and columns are assigned
            String[] inputNum = input.split(" ");
            //if the player puts in more or less than four integers, give them another chance
            if (input.length() != 4 ) {
                System.out.println("Please input a valid move");
                Scanner misScanner = new Scanner(System.in);
                String misInput = misScanner.nextLine();
                String[] misInputNum = misInput.split(" ");
                int misStartRow = Integer.parseInt(misInputNum[0]);
                int misStartCol = Integer.parseInt(misInputNum[1]);
                int misEndRow = Integer.parseInt(misInputNum[2]);
                int misEndCol = Integer.parseInt(misInputNum[3]);
                game.movePiece(misStartRow, misStartCol, misEndRow, misEndCol);
            }
            int startRow = Integer.parseInt(inputNum[0]);
            int startCol = Integer.parseInt(inputNum[1]);
            int endRow = Integer.parseInt(inputNum[2]);
            int endCol = Integer.parseInt(inputNum[3]);
            //if the player makes an illegal move, give them one more chance, otherwise move on to next person
            if (((game.getPiece(startRow, startCol) == null) || !game.movePiece(startRow, startCol, endRow, endCol))) {
                System.out.println("It is currently " + color + "'s turn");
                System.out.println("Please input a valid move");
                Scanner misScanner = new Scanner(System.in);
                String misInput = misScanner.nextLine();
                String[] misInputNum = misInput.split(" ");
                int misStartRow = Integer.parseInt(misInputNum[0]);
                int misStartCol = Integer.parseInt(misInputNum[1]);
                int misEndRow = Integer.parseInt(misInputNum[2]);
                int misEndCol = Integer.parseInt(misInputNum[3]);
                game.movePiece(misStartRow, misStartCol, misEndRow, misEndCol);
            }
        }
        //print out the winner
        if (game.isGameOver())
            System.out.println("The winner is " + color + "!");
    }
}

