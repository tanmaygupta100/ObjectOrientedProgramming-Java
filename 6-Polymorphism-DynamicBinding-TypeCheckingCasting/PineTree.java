import javafx.scene.paint.Color;
import wheelsFX.users.Frame.Animator;
import wheelsFX.users.Shapes.Rectangle;
import wheelsFX.users.Shapes.Triangle;

/**
 * Class that creates the first tree.
 *
 * @author Tanmay Gupta
 * @version 1.0 July 2nd, 2023
 * @see javafx.scene.paint.Color
 * @see wheelsFX.users.Frame.Animator
 * @see wheelsFX.users.Shapes.Rectangle
 * @see wheelsFX.users.Shapes.Triangle
 */
public class PineTree implements Seasonal, Animator // this implements the "Seasonal" interface.
{
    private int curSeason;
    private final int DELAY;
    private int callCount;

    // These are the private shapes used later.
    private Triangle leaf1;
    private Triangle leaf2;
    private Triangle leaf3;
    private Triangle leaf4;
    private Triangle leaf5;
    private Triangle leaf6;

    /**
     * Constructor for the timer and drawing the tree.
     *
     * @param x // Sets the x-values for either the shapes' locations or sizes.
     * @param y // Sets the y-values for either the shapes' locations or sizes.
     */
    public PineTree(int x, int y) // Tree constructor for the seasonal timer.
    // Tree constructor for creating the tree and setting a location.
    {
        this.curSeason = 0;
        this.DELAY = 40; // goes to the next season at every 40th call.
        this.callCount = 0;

        Rectangle treeTrunk = new Rectangle(Color.MAROON); // Setting the colour for the shape.
        treeTrunk.setLocation(x,y); // Setting the locations for the shape.
        treeTrunk.setSize(50,200); // Setting the size dimensions for the shape.
        Rectangle treeBranch1 = new Rectangle(Color.MAROON);
        treeBranch1.setLocation(x-120,y);
        treeBranch1.setSize(150,30);
        Rectangle treeBranch2 = new Rectangle(Color.MAROON);
        treeBranch2.setLocation(x+20,y);
        treeBranch2.setSize(150,30);
        Rectangle treeBranch3 = new Rectangle(Color.MAROON);
        treeBranch3.setLocation(x-70,y-70);
        treeBranch3.setSize(30,100);
        Rectangle treeBranch4 = new Rectangle(Color.MAROON);
        treeBranch4.setLocation(x+90,y-70);
        treeBranch4.setSize(30,100);

        // Leaves didn't need to be hidden here since the colour is changed later.
        this.leaf1 = new Triangle();
            leaf1.setLocation(580,260);
            leaf1.setSize(20,50);
        this.leaf2 = new Triangle();
            leaf2.setLocation(750,260);
            leaf2.setSize(20,50);
        this.leaf3 = new Triangle();
            leaf3.setLocation(720,210);
            leaf3.setSize(20,50);
        this.leaf4 = new Triangle();
            leaf4.setLocation(620,210);
            leaf4.setSize(20,50);
        this.leaf5 = new Triangle();
            leaf5.setLocation(670,180);
            leaf5.setSize(20,50);
        this.leaf6 = new Triangle();
            leaf6.setLocation(670,280);
            leaf6.setSize(20,50);
        spring(); // this is needed to set the base colour as mediumseagreen instead of the default red.
    }

    /**
     * Method for spring. Sets the colours to MediumSeaGreen and makes the leaf appear from its hidden state.
     */
    @Override public void spring()
    // "override" means that its overridden method from the child class.
    {
        leaf1.setColor(Color.MEDIUMSEAGREEN);
        leaf2.setColor(Color.MEDIUMSEAGREEN);
        leaf3.setColor(Color.MEDIUMSEAGREEN);
        leaf4.setColor(Color.MEDIUMSEAGREEN);
        leaf5.setColor(Color.MEDIUMSEAGREEN);
        leaf6.setColor(Color.MEDIUMSEAGREEN);
    }

    /**
     * Method for summer. Sets the colours to SeaGreen.
     */
    @Override public void summer()
    {
        leaf1.setColor(Color.SEAGREEN);
        leaf2.setColor(Color.SEAGREEN);
        leaf3.setColor(Color.SEAGREEN);
        leaf4.setColor(Color.SEAGREEN);
        leaf5.setColor(Color.SEAGREEN);
        leaf6.setColor(Color.SEAGREEN);
    }

    /**
     * Method for fall. Sets the colours to Teal.
     */
    @Override public void fall()
    {
        leaf1.setColor(Color.TEAL);
        leaf2.setColor(Color.TEAL);
        leaf3.setColor(Color.TEAL);
        leaf4.setColor(Color.TEAL);
        leaf5.setColor(Color.TEAL);
        leaf6.setColor(Color.TEAL);
    }

    /**
     * Method for Winter. Sets the colours to Snow.
     */
    @Override public void winter()
    {
        leaf1.setColor(Color.SNOW);
        leaf2.setColor(Color.SNOW);
        leaf3.setColor(Color.SNOW);
        leaf4.setColor(Color.SNOW);
        leaf5.setColor(Color.SNOW);
        leaf6.setColor(Color.SNOW);
    }

    /**
     * Animating method. Moves the counter and changes the season at the call delay.
     */
    @Override public void animate()
    {
        this.callCount++; // Counts how many times our method has been called.

        if(this.callCount % this.DELAY == 0)
        {
            this.curSeason++;

            if(this.curSeason % 4 == 1)
            {
                System.out.println("Spring");
                spring();
            }
            else if(this.curSeason % 4 == 2)
            {
                System.out.println("Summer");
                summer();
            }
            else if(this.curSeason % 4 == 3)
            {
                System.out.println("Fall");
                fall();
            }
            else if(this.curSeason % 4 == 0)
            {
                System.out.println("Winter");
                winter();
            }
        }
    }
}
