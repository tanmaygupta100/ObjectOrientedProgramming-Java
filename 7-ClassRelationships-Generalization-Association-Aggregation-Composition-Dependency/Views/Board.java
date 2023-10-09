package Views;

import Controllers.TicTacToeController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import wheelsFX.users.Shapes.Rectangle;

/**
 * View class that draws out the board and the rectangles that can be placed for each user.
 *
 * @author Tanmay Gupta
 * @version 1.0 July 7th, 2023
 * @see Views
 * @see Controllers.TicTacToeController
 * @see javafx.event.EventHandler
 * @see javafx.scene.input.MouseEvent
 * @see javafx.scene.paint.Color
 * @see wheelsFX.users.Shapes.Rectangle
 */

public class Board
{
    private TicTacToeController ticTacToeController; // calls an instance of the TicTacToeController class.

    /**
     * Public constructor for creating the tiles and players' pieces' designs.
     */
    public Board()
    {
        this.ticTacToeController = new TicTacToeController( this );
            // "this" by itself creates an instance of the current pointer.


        // This creates a loop in the x and y direction to make a multidimensional array of squares.
        for(int x=0;x<3;x++)
        {
            for(int y=0;y<3;y++)
            {

                // Creating the initial boxes and their layout/designs.
                Rectangle rectangles = new Rectangle(Color.WHITE);
                rectangles.setLocation(x*52,y*52);
                rectangles.setOutlineColor(Color.BLACK);

                int finalX = x;
                int finalY = y;
                // Reacts based on how the mouse interacts with the boxes.
                rectangles.setOnMouseClicked(new EventHandler<MouseEvent>()
                {
                    @Override
                    public void handle(MouseEvent event)
                    {
                        int value = ticTacToeController.makeSelection(finalX, finalY);
                        if (value == -1) // to check if a selection has already been made in a square.
                        {
                            return; // Return nothing, don't change square colour.
                        }
                        rectangles.setColor(value == 1 ? Color.DODGERBLUE : Color.INDIANRED);
                            // If-else statement.
                            // If a move has been made, be able to set a rectangle colour as blue. Else, set it as red.
                            // Basically, this is a way to let player 1 or 2 have their own turns.
                            // In the main TicTacToe code, it DOES have a way to let people have turns,
                                // but this allows you to have a different colour for each turn, distinguishing players.
                    }
                }); // end of mouse click detector
            }
        } // end of for loops
    }
}
