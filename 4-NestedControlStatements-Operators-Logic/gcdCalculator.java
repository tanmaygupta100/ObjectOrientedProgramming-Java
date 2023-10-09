import java.util.Scanner;
    // Scanner API URL: https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html

/**
 * Calculating the Greatest Common Denominator (GCD) using user inputs.
 * Meant to be used as examples for understanding nested control statements, operators, and logical operations.
 *
 * @author Tanmay Gupta
 * @version 1.0 June 11th, 2023
 * @see java.util.Scanner
 */

public class MyClass
{

    public static void main(String[] args)
    {
        int num, den, gcd; // integers for numerator and denominator

        // Requesting inputs from the user for numerator and denominator:
        Scanner scan = new Scanner(System.in); // Scanner needed for inputs
        System.out.println("Enter numerator value: ");
        num = scan.nextInt();
        System.out.println("Enter denominator value: ");
        den = scan.nextInt();

        // Initializing original values for the num and den because integers num and den will be changed.
            // We need the original inputs for the final output.
        int numOrig = num;
        int denOrig = den;
        gcd = 0;

        // If - for errors
        // Else - to proceed after checking for errors
        if(num == 0)
        {
            System.out.println("Invalid numerator!"); // Error checking output.
        }
        else
        {
            while(num != den)
            {
                if(num > den) // calculations for when the numerator is greater than the denominator
                {
                    num = num - den;
                    gcd = num; // Setting a GCD value
                }
                else // calculations for when the numerator is the same or smaller than the denominator
                {
                    den = den - num;
                    gcd = den; // Setting a GCD value

                }
            }

            // Initializing a value for the final results
            int numNew = numOrig/num;
            int denNew = denOrig/den;

            // Printing the final results
            System.out.println(numOrig + " / " + denOrig + " = " + numNew + " / " + denNew);
            System.out.println("GCD: " + gcd);
        }

    }
}

/*
Sample Runs:
________________________
Enter numerator value:
36
Enter denominator value:
48
36 / 48 = 3 / 4
GCD: 12
________________________
Enter numerator value:
124
Enter denominator value:
64
124 / 64 = 31 / 16
GCD: 4
________________________
Enter numerator value:
7
Enter denominator value:
9
7 / 9 = 7 / 9
GCD: 1
________________________
 */
