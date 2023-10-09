import java.lang.Math;
// Math API URL: https://docs.oracle.com/javase/8/docs/api/java/lang/Math.html

/**
 * Class to represent an Accountant
 * Receives values for the "name, company, and age" variables from the "MyProg" class,
 * and calculates a salary using them.
 *
 * @author Tanmay Gupta
 * @version 1.0, May 21st, 2023
 * @see java.lang.Math
 */
// There's a @see for the Scanner because it's a class not part of the compiler by default.

public class Accountant
{
    // Create the fields here (also called Instance Variables)
    private String name, company; // We wrote "private" to encapsulate the fields.
    private int age;

    /**
     * Constructor for the Accountant class
     * @param n The name of the employee   // @param is for the parameter values.
     * @param a The age of the employee
     * @param c The name of the employee's company
     */
    public Accountant( String n, int a, String c ) // The variables in the parentheses ares listing the parameters of this method.
    {
        name = n;
        age = a;
        company = c;
        // These take in the public variables and stores them as private for the use of this class.
    }

    // Creating a "getter":
        // String is the 'return type'. getName is the 'method name'.
        // Anything in the (parentheses) would be arguments.
    // The getters are ways to get these variables back out.
    /**
     * getName getter for "name" variable.
     *
     * @return returns value given to "name".
     */
    public String getName()
    {
        return name;
    }

    /**
     * getAge getter for "age" variable.
     *
     * @return returns value given to "age".
     */
    public int getAge()
    {
        return age;
    }

    /**
     * getCompany getter for "age" variable.
     *
     * @return returns value given to "company".
     */
    public String getCompany()
    {
        return company;
    }

    /**
     * getSalary getter for "salary" variable.
     *
     * @return returns a 0.0 value for "salary" for the moment.
     */
    public double getSalary() // "double" because we're dealing with money, so we need the decimals.
    {
        return 0.0;
    }


    /**
     * method "calculateAndPrint()" is for calculating and printing salary,
     * as well as print the inputs from the "MyProg" class.
     */
    public void calculateAndPrint()
    {
        double salary = 40000 * Math.sqrt(Math.exp(0.04295 * age + 0.141)); // Given equation
        System.out.println("Name: " + name + ",    Age: " + age + ",    Company Name: " + company);
        System.out.printf("Salary: $" + "%.2f", salary); // the comma (,) puts salary inside the "%.2".
            // % with a number is for formatting the amount of numbers before/after a decimal place.
            // This one only lets you have 2 digits after the decimal place.
        System.out.println(); // This is to move the cursor to a new line
    }
}
