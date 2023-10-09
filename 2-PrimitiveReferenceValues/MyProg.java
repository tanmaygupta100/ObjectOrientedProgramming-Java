import java.util.Scanner;

/**
 * Main program meant for collecting m and b values for 2 lines, sending them to another class to be stored,
 * and then calculating the coordinates at which the lines intersect.
 *
 * @author Tanmay Gupta
 * @version 1.0, May 28th, 2023
 * @see java.util.Scanner
 */

public class MyProg
{
    /**
     * Main method that takes in inputs, creates pointer objects, and calculates the intercept coordinates,
     * as well as outputting values to the user.
     * @param args
     */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        // Linear equation variables:
        LinearEquation linearEquation1;
        LinearEquation linearEquation2;

        // Prompting for and reading values:
        System.out.print("Enter an m value for the first line: ");
        float mline1 = scan.nextFloat();
        System.out.print("Enter an b value for the first line: ");
        float bline1 = scan.nextFloat();
        System.out.print("Enter an m value for the second line: ");
        float mline2 = scan.nextFloat();
        System.out.print("Enter an b value for the second line: ");
        float bline2 = scan.nextFloat();

        // Instantiate objects:
            // Fills in values for m1 and b1 parameters in the other class
        LinearEquation line1 = new LinearEquation(mline1,bline1);
        LinearEquation line2 = new LinearEquation(mline2,bline2);

        // Find result:
        System.out.println("First line: y = " + mline1 + "x + " + bline1);
        System.out.println("Second line: y = " + mline2 + "x + " + bline2);

        if (mline1 == mline2) // "if" statement for if the lines are parallel.
        {
            System.out.println("Lines are parallel.");
        }
        else // "else" statement to start calculating the line intersection.
        {
            float x = (bline2 - bline1) / (mline1 - mline2);
            float y = mline1 * x + bline1;
            System.out.println("The lines intersect at (" +x+ "," +y+ ")");
        }
    }
};

/*
Sample runs are in the sample1.txt file. A copy is in the sample2.txt as well.
 */
