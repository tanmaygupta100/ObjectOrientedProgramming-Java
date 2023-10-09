import javafx.scene.paint.Color;
import wheelsFX.users.Frame.Animator;
import wheelsFX.users.Shapes.Rectangle;

/**
 * Class that creates the second tree.
 *
 * @author Tanmay Gupta
 * @version 1.0 July 2nd, 2023
 * @see javafx.scene.paint.Color
 * @see wheelsFX.users.Frame.Animator
 * @see wheelsFX.users.Shapes.Rectangle
 */

public class CherryBlossom implements Seasonal, Animator // this implements the "Seasonal" interface.
{
    // These are the integers related to timing
    private int curSeason;
    private final int DELAY;
    private int callCount;

    // These are the private shapes used later.
    private Rectangle leaf1;
    private Rectangle leaf2;
    private Rectangle leaf3;
    private Rectangle leaf4;
    private Rectangle leaf5;
    private Rectangle leaf6;

    /**
     * Constructor for the timer and drawing the tree.
     *
     * @param x // Sets the x-values for either the shapes' locations or sizes.
     * @param y // Sets the y-values for either the shapes' locations or sizes.
     */
    public CherryBlossom(int x, int y) // Tree constructor for the seasonal timer.
    // Tree constructor for creating the tree and setting a location.
    {
        this.curSeason = 0; // Current season
        this.DELAY = 40; // Goes to the next season at every 40th call.
        this.callCount = 0; // Counter for the seasons.

        Rectangle treeTrunk = new Rectangle(Color.ROSYBROWN); // Setting the colour for the shape.
        treeTrunk.setLocation(x,y); // Setting the locations for the shape.
        treeTrunk.setSize(50,200); // Setting the size dimensions for the shape.
        Rectangle treeBranch1 = new Rectangle(Color.ROSYBROWN);
        treeBranch1.setLocation(x-120,y);
        treeBranch1.setSize(150,30);
        Rectangle treeBranch2 = new Rectangle(Color.ROSYBROWN);
        treeBranch2.setLocation(x+20,y);
        treeBranch2.setSize(150,30);
        Rectangle treeBranch3 = new Rectangle(Color.ROSYBROWN);
        treeBranch3.setLocation(x-70,y-70);
        treeBranch3.setSize(30,100);
        Rectangle treeBranch4 = new Rectangle(Color.ROSYBROWN);
        treeBranch4.setLocation(x+90,y-70);
        treeBranch4.setSize(30,100);

        this.leaf1 = new Rectangle();
            leaf1.setLocation(300,260);
            leaf1.setSize(70,70);
            leaf1.hide();
                // Leaves need to be hidden to be called for Spring and not have a default red colour.
        this.leaf2 = new Rectangle();
            leaf2.setLocation(470,260);
            leaf2.setSize(70,70);
            leaf2.hide();
        this.leaf3 = new Rectangle();
            leaf3.setLocation(440,210);
            leaf3.setSize(70,70);
            leaf3.hide();
        this.leaf4 = new Rectangle();
            leaf4.setLocation(340,210);
            leaf4.setSize(70,70);
            leaf4.hide();
        this.leaf5 = new Rectangle();
            leaf5.setLocation(390,280);
            leaf5.setSize(70,70);
            leaf5.hide();
        this.leaf6 = new Rectangle();
            leaf6.setLocation(390,170);
            leaf6.setSize(70,70);
            leaf6.hide();
    }

    /**
     * Method for spring. Sets the colours to Pink and makes the leaf appear from its hidden state.
     */
    @Override public void spring()
    // "override" means that its overridden method from the child class.
    {
        leaf1.setColor(Color.PINK);
        leaf1.show();
        leaf2.setColor(Color.PINK);
        leaf2.show();
        leaf3.setColor(Color.PINK);
        leaf3.show();
        leaf4.setColor(Color.PINK);
        leaf4.show();
        leaf5.setColor(Color.PINK);
        leaf5.show();
        leaf6.setColor(Color.PINK);
        leaf6.show();
    }

    /**
     * Method for summer. Sets the colours to Plum.
     */
    @Override public void summer()
    {
        leaf1.setColor(Color.PLUM);
        leaf2.setColor(Color.PLUM);
        leaf3.setColor(Color.PLUM);
        leaf4.setColor(Color.PLUM);
        leaf5.setColor(Color.PLUM);
        leaf6.setColor(Color.PLUM);
    }

    /**
     * Method for fall. Sets the colours to OliveDrab.
     */
    @Override public void fall()
    {
        leaf1.setColor(Color.OLIVEDRAB);
        leaf2.setColor(Color.OLIVEDRAB);
        leaf3.setColor(Color.OLIVEDRAB);
        leaf4.setColor(Color.OLIVEDRAB);
        leaf5.setColor(Color.OLIVEDRAB);
        leaf6.setColor(Color.OLIVEDRAB);
    }

    /**
     * Method for winter. Hides the leaves to show that they have fallen.
     */
    @Override public void winter()
    {
        leaf1.hide();
        leaf2.hide();
        leaf3.hide();
        leaf4.hide();
        leaf5.hide();
        leaf6.hide();
    }

    /**
     * Animating method. Moves the counter and changes the season at the call delay.
     */
    @Override public void animate()
    {
        this.callCount++; // counts how many times our method has been called.

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
