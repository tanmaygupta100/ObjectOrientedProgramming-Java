/**
 * Seasonal.java;
 * Interface that represents the 4 seasons.
 *
 * @author Tanmay Gupta
 * @version 1.0, July 2nd, 2023
 */

public interface Seasonal
{
    // all the methods here will be void // aka no direct output

    /**
     * Method to change the object to its "fall" look.
     */
    public void fall(); // writing "public" is redundant for interfaces, because they're automatically public.
        // Only the methods for the classes need to be public.

    /**
     * Method to change the object to its "spring" look.
     */
    public void spring();

    /**
     * Method to change the object to its "summer" look.
     */
    public void summer();

    /**
     * Method to change the object to its "winter" look.
     */
    public void winter();
}
