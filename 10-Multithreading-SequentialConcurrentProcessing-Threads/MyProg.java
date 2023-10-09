import java.util.LinkedList;
import java.util.Scanner;

/**
 * Main class that runs the program, using ConsumerThread and ProducerThread
 * @author Tanmay Gupta
 * @version 1.0 July 23rd, 2023
 *
 * @see java.util.LinkedList;
 * @see java.util.Scanner
 */

public class MyProg
{
    public static void main(String[] args)
    {
        LinkedList<String> buffer = new LinkedList< String >();
            // I could've just written "new LinkedList<>()", because java is smart enough to read the other side.

        // Prompt for file path:
        System.out.println("Welcome! Please enter the path to get to your file below!");
        Scanner scanner = new Scanner(System.in);
            System.out.print("File path: ");
            String filePath = scanner.nextLine();
            scanner.close();

        // Instantiate the objects:
        ProducerThread producerThread = new ProducerThread(filePath, buffer);
        ConsumerThread consumerThread = new ConsumerThread(buffer);

        // Run the threads:
        producerThread.start();
        consumerThread.start();
        // start is used instead of run because it creates a new thread to run simultaneously instead of blocking other tasks.

        // Making the main thread wait for the Producer and Consumer threads to complete their tasks.
        try
        {
            producerThread.join();
            consumerThread.join();
        }
        catch (InterruptedException ie)
        {
            throw new RuntimeException("Error has occurred: " + ie.getMessage());
        }
    }
}

/*
Sample Trials:
______________________________________________________________________________________________________________
Welcome! Please enter the path to get to your file below!
File path: /Users/tanmaygupta/Desktop/SWENG 311/M13 - Text Analysis/M13 - Text Analysis/src/gettysburg.txt
Most frequent word in your file: that
Frequency of 'that': 10
______________________________________________________________________________________________________________
Welcome! Please enter the path to get to your file below!
File path: /Users/tanmaygupta/Desktop/SWENG 311/M13 - Text Analysis/M13 - Text Analysis/src/thewhitemail.txt
Most frequent word in your file: the
Frequency of 'the': 3224
 */
