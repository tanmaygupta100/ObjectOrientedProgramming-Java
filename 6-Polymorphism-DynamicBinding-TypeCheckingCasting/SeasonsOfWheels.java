import wheelsFX.users.Frame.AnimationTimer;
import wheelsFX.users.Frame.Frame;

/**
 * Class that creates the first tree.
 *
 * @author Tanmay Gupta
 * @version 1.0 July 2nd, 2023
 * @see wheelsFX.users.Frame.AnimationTimer
 * @see wheelsFX.users.Frame.Frame
 */

public class SeasonsOfWheels
{
    /**
     * Main code running method.
     * Here, locations are set for the trees, and they're printed on a frame window.
     * @param args
     */
    public static void main(String[] args)
    {
        // Instantiating and timing the Tree object
        Tree tree = new Tree(150,300); // Instantiates the object.
        AnimationTimer timerTree = new AnimationTimer(tree); // Connect object to timer.
            // Because the "tree" object imports an animator, "tree" can be used as an argument for the animator.
            // Everytime the timer ticks, the "animate" method from "Tree.java" is called.

        // Instantiating and timing the CherryBlossom object
        CherryBlossom cherryBlossom = new CherryBlossom(400,300);
        AnimationTimer timerCherry = new AnimationTimer(cherryBlossom);

        // Instantiating and timing the PineTree object
        PineTree pineTree = new PineTree(650,300);
        AnimationTimer timerPine = new AnimationTimer(pineTree);

        Frame.createFrame(); // Create the frame for the object.
    }
}
