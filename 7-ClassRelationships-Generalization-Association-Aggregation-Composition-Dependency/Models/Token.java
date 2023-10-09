package Models;

/**
 * Model logic class is for representing the spaces on the board.
 *
 * @author Tanmay Gupta
 * @version 1.0 July 7th, 2023
 * @see Models
 */

public class Token
{
    private int value; // value field

    /**
     * Token constructor that sets a value to each player.
     *
     * @param value // The value being set for the player.
     */
    public Token( int value )
    {
        this.value = value; // 0 = X, 1 = O
    }

    /**
     * Getter for values of each square
     *
     * @return // returns the value of an individual square.
     */
    public int getValue()
    {
        return value;
    }
}
