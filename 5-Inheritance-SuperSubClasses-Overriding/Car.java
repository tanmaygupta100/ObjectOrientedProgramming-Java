import javafx.scene.paint.Color;
import wheelsFX.users.Shapes.Ellipse;
import wheelsFX.users.Shapes.Rectangle;

/**
 * Car superclass meant for building the main parts of the car using public and package methods.
 *
 * @author Tanmay Gupta
 * @version 1.0 , June 25th, 2023
 * @see javafx.scene.paint.Color
 * @see wheelsFX.users.Shapes.Ellipse
 * @see wheelsFX.users.Shapes.Rectangle
 */

public class Car
{
    /**
     * Public method meant for creating the back wheels that can be reused in subclasses.
     *
     * @param x // x-locations of the back wheels that can be edited in the main class.
     * @param y // y-locations of the back wheels that can be edited in the main class.
     */
    public void makeBackWheels(int x, int y)
    {
        Ellipse wheel1 = new Ellipse(Color.BLACK); // Setting a colour
            wheel1.setLocation(150+x,200+y); // Setting a location that can be edited in the main class
            wheel1.setSize(20,20); // Setting a size
        Ellipse wheel2 = new Ellipse(Color.BLACK);
            wheel2.setLocation(200+x,200+y);
            wheel2.setSize(20,20);

        Ellipse wheelRim1 = new Ellipse(Color.DARKGREY);
            wheelRim1.setLocation(150+x,200+y);
            wheelRim1.setSize(13,13);
        Ellipse wheelRim2 = new Ellipse(Color.DARKGREY);
            wheelRim2.setLocation(200+x,200+y);
            wheelRim2.setSize(13,13);
    }

    /**
     * Package method meant for creating the front wheels.
     *
     * @param x // x-locations of the front wheels that can be edited in the main class.
     * @param y // y-locations of the front wheels that can be edited in the main class.
     */
    void makeFrontWheel(int x, int y)
    {
        Ellipse wheel3 = new Ellipse(Color.BLACK);
        wheel3.setLocation(350+x,200+y);
        wheel3.setSize(20,20);
        Ellipse wheelRim3 = new Ellipse(Color.DARKGREY);
        wheelRim3.setLocation(350+x,200+y);
        wheelRim3.setSize(13,13);
    }

    /**
     * Package method meant for creating the truck body, decals, exhaust pipe, and gas tank, and truck bed.
     *
     * @param x // x-locations of the truck components
     * @param y // y-locations of the truck components
     */
    void makeBody(int x, int y)
    {
        Rectangle truckBody = new Rectangle(Color.FIREBRICK);
            truckBody.setLocation(275+x,90+y);
            truckBody.setSize(100,225/2);
        Rectangle truckStripe = new Rectangle(Color.GREY);
            truckStripe.setLocation(275+x,145+y);
            truckStripe.setSize(100,20);
        Rectangle truckExhaust = new Rectangle(Color.DARKGREY);
            truckExhaust.setLocation(260+x,66+y);
            truckExhaust.setSize(15,80);

        Rectangle truckBed = new Rectangle(Color.DARKSLATEBLUE);
            truckBed.setLocation(125+x,165+y);
            truckBed.setSize(150,37);
        Rectangle truckGasTank = new Rectangle(Color.DARKGREY);
            truckGasTank.setLocation(240+x,165+y);
            truckGasTank.setSize(35,37);

        Rectangle truckWindow = new Rectangle(Color.STEELBLUE);
            truckWindow.setLocation(325+x,100+y);
            truckWindow.setSize(38,33);
    }
}
