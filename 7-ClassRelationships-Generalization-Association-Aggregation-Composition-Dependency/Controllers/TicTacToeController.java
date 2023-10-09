package Controllers;

import Models.Token;
import Views.Board;

/**
 * Controller class that's responsible for the logic.
 *
 * @author Tanmay Gupta
 * @version 1.0 July 7th, 2023
 * @see Controllers
 * @see Models.Token
 * @see Views.Board
 */

public class TicTacToeController
{
    private Board ticTacToeBoard; // "private final" makes it constant. We don't want this in case we decide to alter it later.
    private Token[][] board; // instance of arguments for Token Class.
        // Our way of storing the current state of the board.
        // The board should never know about the token.
    private boolean isPlayerOneTurn = true;
        // checks if it's player 1's turn based on the board token value, which is looked at later.
    private boolean victoryScreen; // this is a bool to check the directionalVictories later.

    int turnsTaken = 0; // counts turns taken.


    /**
     * Public constructor for interacting with the token, board, and indicating which player just played their turn.
     *
     * @param ticTacToeBoard // intereacts with the board to get its GUI that was made.
     */
    public TicTacToeController( Board ticTacToeBoard ) // the argument allows this class to interact with the Board class.
    {
        this.board = new Token[ 3 ][ 3 ]; // Sets the dimensions for spaces from Token on the board.
        this.ticTacToeBoard = ticTacToeBoard;
    }

    /**
     * Method that creates a token for the first and second player that checks which locations on the board are taken/empty.
     * The method also counts turns, as well as switches turns, and also decides the winner based on another method.
     *
     * @param x // x-array-locations of the squares placed.
     * @param y // y-array-locations of the squares placed.
     * @return // Returns a value that indicates if a move has been made by either player 1 or 2,
     *            to let the other methods know what to do next based on which player just had their turn session.
     */
    public int makeSelection(int x, int y)
    {
        int value = isPlayerOneTurn ? 0 : 1; // if-statement for if player1turn is false or true
            // checks if-else for if the playerTokenValue (player number) is 0 or 1

        if(board[x][y] == null) // if nothing has been played yet, allow a selection for player 1.
        {
            board[x][y] = new Token(value); // Creates a token value depending on which player move session.

            turnsTaken++; // adds 1 to turn counter for every time it loops through for every input.

            victoryScreen = horizontalVictory(value) || verticalVictory(value) || diagonalVictory(value);
                // initializes gameOver possibilities for either player.
                // if I had "0" instead of "value", then it would only check for the 1st player.


            // Output victory messages for either players.
            if (victoryScreen) // this means victory has been achieved (or victory is TRUE).
            {
                // Check if victory was achieved in player 1 or player 2's turn session.
                if (isPlayerOneTurn) // Is it true that player 1 had their turn session?
                {
                    System.out.println("Player 1 WON!");
                }
                else
                {
                    System.out.println("Player 2 WON!");
                }
            }
            else if (turnsTaken == 9) // if no victory within 9 turns, the game is a tie.
            {
                System.out.println("TIED!");
            }

            isPlayerOneTurn = !isPlayerOneTurn; // switch from player 1 to 2's turn or vice versa.

            return value; // returns value of if player played their turn or not.
        }

        return -1; // This means a selection was already made at this position. No action to take
    }

    /**
     * Method that checks for if the tile tokens match up horizontally in any row.
     * AKA checks for any 3-in-a-row.
     *
     * @param playerTokenValue // Token value to check for which player has won.
     * @return // Returns the winning player's value to then be used in an earlier method to print a victory result.
     */
    public boolean horizontalVictory(int playerTokenValue)
    {
        boolean playerWon = false; // starts off by having no winner.
            // Checks if a box is empty and if it's filled, to check with player clicked it.
            if ((board[0][0] != null && board[0][0].getValue() == playerTokenValue)
                    && (board[1][0] != null && board[1][0].getValue() == playerTokenValue)
                    && (board[2][0] != null && board[2][0].getValue() == playerTokenValue))
            {
                playerWon = true;
                // If a winner is found for the above criteria, the checking is over.
                // If a winner is not found, it moves onto the next else-if checks for the next set of spaces.
            }
            else if ((board[0][1] != null && board[0][1].getValue() == playerTokenValue)
                    && (board[1][1] != null && board[1][1].getValue() == playerTokenValue)
                    && (board[2][1] != null && board[2][1].getValue() == playerTokenValue))
            {

                playerWon = true;
            }
            else if ((board[0][2] != null && board[0][2].getValue() == playerTokenValue)
                    && (board[1][2] != null && board[1][2].getValue() == playerTokenValue)
                    && (board[2][2] != null && board[2][2].getValue() == playerTokenValue))
            {

                playerWon = true;
            }
        return playerWon; // Returns a value to indicate that a winner has indeed been found.
        // A different method looks at who won and based on that, moves on.
    }

    /**
     * Method that checks for if the tile tokens match up vertically in any column.
     * AKA checks for any 3-in-a-column.
     *
     * @param playerTokenValue // Token value to check for which player has won.
     * @return // Returns the winning player's value to then be used in an earlier method to print a victory result.
     */
    public boolean verticalVictory(int playerTokenValue)
    {
        boolean playerWon = false;
        if ((board[0][0] != null && board[0][0].getValue() == playerTokenValue)
                && (board[0][1] != null && board[0][1].getValue() == playerTokenValue)
                && (board[0][2] != null && board[0][2].getValue() == playerTokenValue))
        {
            playerWon = true;
        }
        else if ((board[1][0] != null && board[1][0].getValue() == playerTokenValue)
                && (board[1][1] != null && board[1][1].getValue() == playerTokenValue)
                && (board[1][2] != null && board[1][2].getValue() == playerTokenValue))
        {

            playerWon = true;
        }
        else if ((board[2][0] != null && board[2][0].getValue() == playerTokenValue)
                && (board[2][1] != null && board[2][1].getValue() == playerTokenValue)
                && (board[2][2] != null && board[2][2].getValue() == playerTokenValue))
        {

            playerWon = true;
        }
        return playerWon;
    }

    /**
     * Method that checks for if the tile tokens match up diagonally in either direction.
     * AKA checks for any 3-in-a-diagonal.
     *
     * @param playerTokenValue // Token value to check for which player has won.
     * @return // Returns the winning player's value to then be used in an earlier method to print a victory result.
     */
    public boolean diagonalVictory(int playerTokenValue)
    {
        boolean playerWon = false;
        if ((board[0][0] != null && board[0][0].getValue() == playerTokenValue)
                && (board[1][1] != null && board[1][1].getValue() == playerTokenValue)
                && (board[2][2] != null && board[2][2].getValue() == playerTokenValue))
        {
            playerWon = true;
        }
        else if ((board[2][0] != null && board[2][0].getValue() == playerTokenValue)
                && (board[1][1] != null && board[1][1].getValue() == playerTokenValue)
                && (board[0][2] != null && board[0][2].getValue() == playerTokenValue))
        {

            playerWon = true;
        }
        return playerWon;
    }
}
