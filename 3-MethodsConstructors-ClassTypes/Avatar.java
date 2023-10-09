import javafx.scene.paint.Color;
import wheelsFX.users.Frame.Frame;
import wheelsFX.users.Shapes.Ellipse;
import wheelsFX.users.Shapes.Rectangle;
import wheelsFX.users.Shapes.Triangle;
import java.util.Scanner;

/**
 * Main program class for creating the Avatar, setting its location, and moving it.
 *
 * @author Tanmay Gupta
 * @version 1.0, June 4th, 2023
 * @see wheelsFX.users.Frame.Frame
 * @see wheelsFX.users.Shapes.Ellipse
 * @see wheelsFX.users.Shapes.Triangle
 * @see wheelsFX.users.Shapes.Rectangle
 * @see java.util.Scanner
 */

public class Avatar
{
    // These are the variables for each shape used/
    private Ellipse ellipse;
    private Triangle triangle;
    private Rectangle rectangleArm1;
    private Rectangle rectangleArm2;
    private Rectangle rectangleLeg1;
    private Rectangle rectangleLeg2;

    /**
     * Basic no-argument CONSTRUCTOR.
     * This will set a default location of the Avatar to the specified x and y location
     */
    public Avatar()
    {
        makeAvatar(0,0); // object for the "makeAvatar" method
    }

    /**
     * A constructor that will build the avatar's pieces and assign colours at the (0,0) coordinates.
     *
     * @param x // x value of the avatar location
     * @param y // y value of the avatar location
     */
    public void makeAvatar(int x, int y)
    {
        rectangleLeg1 = new Rectangle(Color.CORNFLOWERBLUE);
        rectangleLeg2 = new Rectangle(Color.CORNFLOWERBLUE);
        triangle = new Triangle(Color.CRIMSON);
        ellipse = new Ellipse(Color.BURLYWOOD); // Creates an ellipse shape at default coordinates (0,0).
        rectangleArm1 = new Rectangle(Color.BURLYWOOD);
        rectangleArm2 = new Rectangle(Color.BURLYWOOD);


    }

    /**
     * A constructor that will set the location of the Avatar to the specified x and y location
     *
     * @param x // initial x location for the avatar's pieces
     * @param y // initial y location for the avatar's pieces
     */
    public void setLocation(int x, int y)
    {
        x = 0;
        y = 0;
    }

    /** This will move the Avatar up or down dy pixels.
     * Also uses the setLocation method to set a general location, with ability to accept a move.
     *  Sets a location for each limb of the avatar.
     */
    public void moveDown(int dy)
    {
        //dy = 0;
        triangle.setLocation(400, 300+dy);
        ellipse.setLocation(402.5,200+dy);
        rectangleArm1.setLocation(450,275+dy);
        rectangleArm2.setLocation(310,275+dy);
        rectangleLeg1.setLocation(335,400+dy);
        rectangleLeg2.setLocation(425,400+dy);
    }


    /**
     * For holding all the methods and instance variables,
     *  as well as the frame/window for the shapes to be displayed in.
     * @param args
     */
    public static void main(String[] args)
    {
        Avatar avatar = new Avatar(); // Instance of Avatar class.
        //int dy = 20;
        Scanner moveAmount = new Scanner(System.in);
        System.out.println("By how many units would you like to move your avatar in the y-direction?");
        int dy = moveAmount.nextInt(); // Takes an integer value for how much to be moved by.
        avatar.moveDown(dy); // Moves the avatar by the chosen amount (20 spaces for example).
        System.out.println("Avatar moved by " + dy + " units.");
        Frame.createFrame(); // Creates a canvas window which allows for drawing the shapes in.
            // (0,0) is the top left-hand corner. +x is to the right. +y is downwards.
            // This HAS to be the last thing in the main method
                // because all shapes need to be created before creating the frame.
    }
}

/*
SAMPLE RUNS:
_________________________________________________________________________
By how many units would you like to move your avatar in the y-direction?
20
Avatar moved by 20 units.

By how many units would you like to move your avatar in the y-direction?
-150
Avatar moved by -150 units.

By how many units would you like to move your avatar in the y-direction?
0
Avatar moved by 0 units.
_________________________________________________________________________
 */
