import java.util.Scanner;

/**
 * Main class that does the grading calculations and printing, throws the exceptions for invalid responses.
 * @author Tanmay Gupta
 * @version 1.0, July 16, 2023
 *
 * @see java.util.Scanner
 */

public class TestScores
{

    // Creating a constructor for the Assignment object that is used in "try"
    public TestScores(String assignmentName, int pointsPossible, int pointsEarned) {}

    public static void main(String[] args) throws Exception
    {
        Scanner scanner = new Scanner(System.in);

        int totalPointsPossible = 0;
        int totalPointsEarned = 0;

        do // Goes until a "break"
        {
            // Geting the name value.
            System.out.print("What is the name of the assignment: ");
                String assignmentName = scanner.next();
                if( assignmentName.equalsIgnoreCase("stop") ) // Way to stop the entire loop/
                {
                    break;
                }

            // Geting the value of points possible.
            System.out.print("Enter the total points possible: ");
                int pointsPossible = scanner.nextInt();
                totalPointsPossible += pointsPossible; // cumulative points possible

            // Geting the value of points earned.
            System.out.print("Enter the total points earned: ");
                int pointsEarned = scanner.nextInt();
                totalPointsEarned += pointsEarned; // cumulative points earned

            try
            {
                //Assignment object that holds the values for the constructor.
                TestScores Assignment = new TestScores(assignmentName, pointsPossible, pointsEarned);
                if( pointsPossible <= 0) // If points possible are less than or equal to 0.
                {
                    throw new InvalidPossibleScoreException("ERROR: THE TOTAL POINTS POSSIBLE IS INVALID");
                }
                else if ( pointsEarned < 0 || pointsEarned > pointsPossible) // If
                {
                    throw new InvalidScoreEarnedException("ERROR: THE TOTAL POINTS EARNED IS INVALID");
                }
            }
            catch (InvalidPossibleScoreException ipse) // Exception for invalid points possible.
            {
                System.out.println(ipse.getMessage());
            }
            catch ( InvalidScoreEarnedException isee) // Exception for invalid points earned.
            {
                System.out.println(isee.getMessage());
            }

            // Calculating the average grade:
            int finalGrade = totalPointsEarned / totalPointsPossible * 100;

            // Printing the values:
            System.out.println("The grade earned from these assignments is " + totalPointsEarned
                    + " / " + totalPointsPossible + " ("+finalGrade+"%)");

            System.out.println(); // Printing an empty line as the loop continues.
        }
        while(true); // condition for the do-while.
    }
}

/*
SAMPLE OUTPUT:
__________________________________________________
What is the name of the assignment: Assignment1
Enter the total points possible: 0
Enter the total points earned: 0
ERROR: THE TOTAL POINTS POSSIBLE IS INVALID

What is the name of the assignment: Assignment1
Enter the total points possible: 40
Enter the total points earned: -1
ERROR: THE TOTAL POINTS EARNED IS INVALID

What is the name of the assignment: Assignment1
Enter the total points possible: 40
Enter the total points earned: 20
The grade earned from these assignments is 20 / 40 (50%)

What is the name of the assignment: stop
 */
