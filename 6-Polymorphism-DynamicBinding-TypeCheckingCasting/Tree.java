import javafx.scene.paint.Color;
import wheelsFX.users.Frame.Animator;
import wheelsFX.users.Shapes.Ellipse;
import wheelsFX.users.Shapes.Rectangle;

/**
 * Class that creates the first tree.
 *
 * @author Tanmay Gupta
 * @version 1.0 July 2nd, 2023
 * @see javafx.scene.paint.Color
 * @see wheelsFX.users.Frame.Animator
 * @see wheelsFX.users.Shapes.Ellipse
 * @see wheelsFX.users.Shapes.Rectangle
 */

public class Tree implements Seasonal, Animator // this implements the "Seasonal" interface.
    // If I didn't list the interface's methods, I could've made this class abstract.
{
    // These are the integers related to timing
    private int curSeason;
    private final int DELAY; // any implementations/extensions of this class can't be modified.
    private int callCount;

    // These are the private shapes used later.
    private Ellipse leaf1;
    private Ellipse leaf2;
    private Ellipse leaf3;
    private Ellipse leaf4;
    private Ellipse leaf5;

    /**
     * Constructor for the timer and drawing the tree.
     *
     * @param x // Sets the x-values for either the shapes' locations or sizes.
     * @param y // Sets the y-values for either the shapes' locations or sizes.
     */
    public Tree(int x, int y) // Tree constructor for the seasonal timer.
        // Tree constructor for creating the tree and setting a location.
    {
        this.curSeason = 0; // Current season
        this.DELAY = 40; // Goes to the next season at every 40th call.
        this.callCount = 0; // Counter for the seasons.

        Rectangle treeTrunk = new Rectangle(Color.SADDLEBROWN); // Setting the colour for the shape.
            treeTrunk.setLocation(x,y); // Setting the locations for the shape.
            treeTrunk.setSize(50,200); // Setting the size dimensions for the shape.
        Rectangle treeBranch1 = new Rectangle(Color.SADDLEBROWN);
            treeBranch1.setLocation(x-120,y);
            treeBranch1.setSize(150,30);
        Rectangle treeBranch2 = new Rectangle(Color.SADDLEBROWN);
            treeBranch2.setLocation(x+20,y);
            treeBranch2.setSize(150,30);
        Rectangle treeBranch3 = new Rectangle(Color.SADDLEBROWN);
            treeBranch3.setLocation(x-70,y-70);
            treeBranch3.setSize(30,100);
        Rectangle treeBranch4 = new Rectangle(Color.SADDLEBROWN);
            treeBranch4.setLocation(x+90,y-70);
            treeBranch4.setSize(30,100);

        this.leaf1 = new Ellipse();
            leaf1.setLocation(75,260);
            leaf1.setSize(50,50);
            leaf1.hide();
                // Leaves need to be hidden to be called for Spring and not have a default red colour.
        this.leaf2 = new Ellipse();
            leaf2.setLocation(265,260);
            leaf2.setSize(50,50);
            leaf2.hide();
        this.leaf3 = new Ellipse();
            leaf3.setLocation(205,210);
            leaf3.setSize(50,50);
            leaf3.hide();
        this.leaf4 = new Ellipse();
            leaf4.setLocation(135,210);
            leaf4.setSize(50,50);
            leaf4.hide();
        this.leaf5 = new Ellipse();
            leaf5.setLocation(170,280);
            leaf5.setSize(50,50);
            leaf5.hide();
    }

    /**
     * Method for spring. Sets the colours to YellowGreen and makes the leaf appear from its hidden state.
     */
    @Override public void spring()
    // "override" means that its overridden method from the child class.
    {
        leaf1.setColor(Color.YELLOWGREEN);
        leaf1.show();
        leaf2.setColor(Color.YELLOWGREEN);
        leaf2.show();
        leaf3.setColor(Color.YELLOWGREEN);
        leaf3.show();
        leaf4.setColor(Color.YELLOWGREEN);
        leaf4.show();
        leaf5.setColor(Color.YELLOWGREEN);
        leaf5.show();
    }

    /**
     * Method for summer. Sets the colours to ForestGreen.
     */
    @Override public void summer()
    {
        leaf1.setColor(Color.FORESTGREEN);
        leaf2.setColor(Color.FORESTGREEN);
        leaf3.setColor(Color.FORESTGREEN);
        leaf4.setColor(Color.FORESTGREEN);
        leaf5.setColor(Color.FORESTGREEN);
    }

    /**
     * Method for fall. Sets the colours to Peru.
     */
    @Override public void fall()
    {
        leaf1.setColor(Color.PERU);
        leaf2.setColor(Color.PERU);
        leaf3.setColor(Color.PERU);
        leaf4.setColor(Color.PERU);
        leaf5.setColor(Color.PERU);
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
                spring(); // Instantiates and calls the season.
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
