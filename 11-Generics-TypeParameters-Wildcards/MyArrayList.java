import java.util.ArrayList;

/**
 * Generic class that extends ArrayList
 * Uses a method to display elements stored in an object, provided by main class MyProg.
 * @author Tanmay Gupta
 * @version 1.0, July 28th, 2023
 *
 * @param <E> // type-parameter, placeholder for elements.
 * @see java.util.ArrayList
 */
public class MyArrayList<E> extends ArrayList<E>
{
    /**
     * Generic method that takes in an object of the class and displays the contents of the elements in the object.
     * @param objectList // The object itself.
     */
    public void display(MyArrayList<E> objectList)
    {
        // Goes through each index/location based on how big the object array is.
        for(int i = 0; i<objectList.size(); i++)
        {
            System.out.println(objectList.get(i)); // For each location, prints the element at the location.
        }
    }
}
