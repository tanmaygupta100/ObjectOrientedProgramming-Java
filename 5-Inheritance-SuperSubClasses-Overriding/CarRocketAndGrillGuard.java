import javafx.scene.paint.Color;
import wheelsFX.users.Shapes.Rectangle;
import wheelsFX.users.Shapes.Triangle;

/**
 * Class that extends the "Car" class to add a rocket on the truck bed and a grill guard onto the front.
 *
 * @author Tanmay Gupta
 * @version 1.0 , June 25th, 2023
 * @see javafx.scene.paint.Color
 * @see wheelsFX.users.Shapes.Rectangle
 * @see wheelsFX.users.Shapes.Triangle
 */

public class CarRocketAndGrillGuard extends Car
{

    /**
     * Package method that instantiates the car already created in the "Car" superclass without having to recreate it manually.
     *
     * @param x // x-locations of the parts of the car.
     * @param y // y-locations of the parts of the car.
     */
    void redrawCar(int x, int y)
    {
        this.makeBody(x,y);
        this.makeBackWheels(x,y);
        this.makeFrontWheel(x,y);
    }

    /**
     * Package method that adds a rocket to the bed of the truck.
     *
     * @param x // x-locations for the parts of the rocket.
     * @param y // y-locations for the parts of the rocket.
     */
    void rocket(int x, int y)
    {
        Triangle rocketBase = new Triangle(Color.GREY);
            rocketBase.setLocation(180+x,139+y);
            rocketBase.setSize(12,12);
        Rectangle rocketFire2 = new Rectangle(Color.ORANGE);
            rocketFire2.setLocation(120+x,122+y);
            rocketFire2.setSize(40,15);
        Rectangle rocketFire1 = new Rectangle(Color.ORANGERED);
            rocketFire1.setLocation(130+x,120+y);
            rocketFire1.setSize(45,20);
        Rectangle rocketBarrel = new Rectangle(Color.GREY);
            rocketBarrel.setLocation(140+x,118+y);
            rocketBarrel.setSize(55,25);
    }

    /**
     * Package method that adds a grill-guard to the front of the truck.
     *
     * @param x // x-locations for the parts of the grill-guard.
     * @param y // y-locations for the parts of the grill-guard.
     */
    void grillGuard(int x, int y)
    {
        Rectangle grill1 = new Rectangle(Color.DARKGREY);
            grill1.setLocation(380+x,142+y);
            grill1.setSize(8,60);
        Rectangle grill2 = new Rectangle(Color.DARKGREY);
            grill2.setLocation(375+x,170+y);
            grill2.setSize(8,8);
        Rectangle grill3 = new Rectangle(Color.DARKGREY);
            grill3.setLocation(375+x,190+y);
            grill3.setSize(8,8);
    }
}
