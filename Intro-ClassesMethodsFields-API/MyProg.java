import java.util.Scanner;
    // Scanner API URL: https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html

/**
 * This class is meant to take in inputs and store them, and then send them over to
 * the "Accountant" class to be processed, calculated, and printed.
 *
 * @author Tanmay Gupta
 * @version 1.0, May 21st, 2023
 * @see java.util.Scanner
 */
    // There's a @see for the Scanner because it's a class not part of the compiler by default.

public class MyProg
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner( System.in ); // Telling the scanner what to pay attention to.
            // System.in is the standard input stream in Java.

        // Variables to hold values needed for this class:
        String name, company;
        int age;

        System.out.println( "What is the employee's name?" ); // println goes to the next line after printing.
        name = scanner.nextLine(); // takes in whatever the user types until the return carriage.

        System.out.println( "How old is the employee?" );
        age = scanner.nextInt();
        scanner.nextLine();
            // since scanner.nextInt(); took a number and the company's nextLine didn't get to be moved to, it skipped it.
            // this makes sure it "eats" the return carriage and lets you enter a company name.

        System.out.println( "What is the name of the company?" );
        company = scanner.nextLine();

        Accountant accountant = new Accountant( name, age, company ); // Creating an "accountant" object/pointer
            // "accountant.getCompany();" This would return the company name. We would use this if we weren't already using a pointer above.
            // This pointer points at the addresses of "name, age, and company" parameters
                // from the "Accountant" class in the same package.
        accountant.calculateAndPrint();
            // The pointer points at the values stored in the location of the
                // "calculateAndPrint()" method to give it the values that were inputted into this class.

        /* Lines below were for testing:
        System.out.println("age = " + age); // shortcut was "soutv" instead of "sout"
        System.out.println("name = " + name);
        System.out.println("company = " + company);
         */
    }
}
