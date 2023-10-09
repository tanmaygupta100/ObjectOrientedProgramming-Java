import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Class that deals with producing the data for analyzing.
 * Goes through the text file and organizes the words in an array.
 * @author Tanmay Gupta
 * @version 1.0 July 23rd, 2023
 *
 * @see java.io.BufferedReader;
 * @see java.io.FileReader;
 * @see java.io.IOException;
 * @see java.util.LinkedList;
 */

public class ProducerThread extends Thread
{
    // Field for buffer:
    private LinkedList<String> buffer; // Created when buffer instance variable was created
    // Field for file path:
    private String filePath;

    /**
     * Constructor:
     *
     * @param filePath // takes in the file path from the user.
     * @param buffer // creates a common buffer.
     */
    public ProducerThread( String filePath, LinkedList<String> buffer ) // Takes in a file path, and a linked list that handles strings.
        // It's a buffer because we can treat a LinkedList like a queue. Add/remove items in a first-in, first-out manner.
        // It's going to be in the producer AND consumer.
    {
        // Instance variable to hold the buffer:
        this.buffer = buffer;
        this.filePath = filePath;
    }

    /**
     * Runs the process of this class
     */
    public void run()
    {
        // We need a try/catch for the FileReader.
        try
        {
            BufferedReader reader = new BufferedReader( new FileReader( filePath ) );
            String line; //= reader.readLine();

            // Do-while loop that goes until the read-lines are empty.
            while ((line = reader.readLine()) != null)
            {
                // String array that takes each word from the text file.
                String[] words = line.split("\\s+"); // "\s+" splits a string by the spaces between the words.

                // This loop goes through each "word" in "words".
                // For EACH run of the loop, it goes through each "word" in the array.
                for (String word : words) // "word" is just for each individual word in the entire array.
                {
                    synchronized (buffer) // done so ProducerThread and ConsumerThread take turns and work sequentially rather than compete.
                    {
                        buffer.add(word); // Places the word string at the end of the linked list. Then ConsumerThread will use it.
                        buffer.notify(); // Notifies ConsumerThread that the state is ready.
                    }
                }

            } // condition if we reach the end. Cleaner to write in the while loop instead of a separate if-statement.

            // To let ConsumerThread know that the loop is over, and stop waiting.
            synchronized (buffer)
            {
                buffer.add(null); // Marks off the end of the buffer.
                buffer.notify();
            }

            reader.close();
        }
        catch (IOException ioe) // Exception for accessing files.
        {
            throw new RuntimeException( "Error encountered while reading file: " + ioe.getMessage() );
        }
    }
}
