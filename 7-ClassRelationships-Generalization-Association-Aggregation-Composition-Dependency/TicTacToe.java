import Views.Board;
import wheelsFX.users.Frame.Frame;

/**
 * Main class that runs the entirety of the program.
 *
 * @author Tanmay Gupta
 * @version 1.0 July 7th, 2023
 * @see Views.Board
 * @see wheelsFX.users.Frame.Frame
 */

public class TicTacToe
{
    /**
     * Main method.
     * Creates an instance of the Board class, prints messages for user, and creates the frame.
     * @param args
     */
    public static void main(String[] args)
    {
        Board b = new Board(); // creates an instance of the Board class.

        System.out.println("Click once on a square for X, Click twice for O.");
        System.out.println("Get 3 squares of the same colour in a row/column/diagonal to win!");
        System.out.println(); // Empty space before printing the result using another class.

        Frame.createFrame(); // Creates the frame window for printing.
    }
}

/*
SAMPLE RUNS:
_________________________________________________________________
Click once on a square for X, Click twice for O.
Get 3 squares of the same colour in a row/column/diagonal to win!

TIED!
_________________________________________________________________
Click once on a square for X, Click twice for O.
Get 3 squares of the same colour in a row/column/diagonal to win!

Player 1 WON!
_________________________________________________________________
Click once on a square for X, Click twice for O.
Get 3 squares of the same colour in a row/column/diagonal to win!

Player 2 WON!
_________________________________________________________________
 */
