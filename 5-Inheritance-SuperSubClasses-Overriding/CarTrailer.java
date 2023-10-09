import javafx.scene.paint.Color;
import wheelsFX.users.Shapes.Ellipse;
import wheelsFX.users.Shapes.Rectangle;

/**
 * Subclass that extends the "Car" superclass to add a trailer and extended wheels to the back.
 *
 * @author Tanmay Gupta
 * @version 1.0 , June 25th, 2023
 * @see javafx.scene.paint.Color
 * @see wheelsFX.users.Shapes.Ellipse
 * @see wheelsFX.users.Shapes.Rectangle
 */

public class CarTrailer extends Car
{
    /**
     * Package method that uses the "makeBackWheels" method already created in the "Car" class.
     * This is useful so that the wheels don't have to be recreated here.
     *
     * @param x // x-location of the back wheels.
     * @param y // y-location of the back wheels.
     */
    void makeTrailerWheels(int x, int y)
    {
        this.makeBackWheels(-112+x,y); // Moving the existing wheels back. Not affecting the superclass wheels.
            // "this" is used instead of "super",
                // because if the original is moved, "super" would make this instance move as well.
    }

    /**
     * Package method that creates the trailer body and decals.
     *
     * @param x // x-locations of the trailer and designs.
     * @param y // y-locations of the trailer and designs.
     */
    void makeTrailerBody(int x, int y)
    {
        Rectangle trailerBody = new Rectangle(Color.DIMGREY);
            trailerBody.setLocation(10+x,77+y);
            trailerBody.setSize(200,125);


        Rectangle trailerBodyStripe = new Rectangle(Color.GREY);
            trailerBodyStripe.setLocation(10+x,112+y);
            trailerBodyStripe.setSize(200,37);
        Ellipse trailerLogo = new Ellipse(Color.FIREBRICK);
            trailerLogo.setLocation(162+x,130+y);
            trailerLogo.setSize(15,15);
    }

    /**
     * Package method that instantiates the car already created in the "Car" superclass without having to recreate it manually.
     * Written at the end to properly be drawn around the trailer design.
     *
     * @param x // x-locations of the parts of the car.
     * @param y // y-locations of the parts of the car.
     */
    void redrawCar(int x, int y)
    {
        this.makeBody(x,y); // "this" allows us to use the car parts without affecting the superclass.
        this.makeBackWheels(x,y);
        this.makeFrontWheel(x,y);
    }
}
