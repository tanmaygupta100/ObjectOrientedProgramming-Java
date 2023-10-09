/**
 * Class that holds the main method to test the generic class MyArrayList.
 * @author Tanmay Gupta
 * @version 1.0, July 28th, 2023
 */

public class MyProg
{
    /**
     * Main method that tests the generic class.
     * @param args
     */
    public static void main(String[] args)
    {
        // Instantiating the object that stores 2 integer-type objects.
        MyArrayList<Integer> integerObjects = new MyArrayList<>();
        integerObjects.add(5); // The first element in the object.
        integerObjects.add(10); // The second element in the object.
        System.out.println("Integer List:");
        integerObjects.display(integerObjects); // integerObjects.display() can only take an interger-type and nothing else as an argument.

        // Instantiating the object that stores 2 double-type objects.
        MyArrayList<Double> doubleObjects = new MyArrayList<>();
        doubleObjects.add(3.5); // The first element in the object.
        doubleObjects.add(5.1); // The second element in the object.
        System.out.println("Double List:");
        doubleObjects.display(doubleObjects); // doubleObjects.display() can only take a double-type and nothing else as an argument.
    }
}
/*
SAMPLE OUTPUT:
_______________
Integer List:
5
10
Double List:
3.5
5.1
_______________
 */
