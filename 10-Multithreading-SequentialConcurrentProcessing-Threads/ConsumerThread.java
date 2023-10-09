import java.util.LinkedList;

/**
 * Class that deals with consumer the data for analyzing.
 * Goes through the file and checks for word frequencies, calculating the value.
 * @author Tanmay Gupta
 * @version 1.0 July 23rd, 2023
 *
 * @see java.util.LinkedList;
 */

public class ConsumerThread extends Thread
{
    // Field for buffer's instance variable:
    private LinkedList<String> buffer;

    /**
     * Constructor for the class:
     *
     * @param buffer // common buffer string
     */
    public ConsumerThread(LinkedList<String> buffer) // Same "buffer" string for LinkedList.
    {
        this.buffer = buffer; // Instance variable for buffer.
    }

    public void run() // Or "start()" depending on if an interface OR an inheritance was used.
    {
        String word; // Creating a string variable separate from the ProducerThread.

        // Creating a linked list of the extra words present.
        LinkedList<String> extraWords = new LinkedList<>();
            // This separates the data we need, and the data we don't need.
        // Creating a linked list of the repeated words we actually want to track.
        LinkedList<Integer> repeatedWords = new LinkedList<>();

        // do-while loop for checking if the buffer list is empty yet or not. Until then, it keeps analyzing.
        do
        {
            synchronized (buffer)
            {
                while (buffer.isEmpty())
                {
                    try
                    {
                        buffer.wait(); // Waits until new words are added by the ProducerThread class.
                    }
                    catch (InterruptedException ie)
                    {
                        throw new RuntimeException("Error has occurred: " + ie.getMessage());
                    }
                }

                // Getting the first words from the shared buffer linked list.
                word = buffer.poll(); // due to the loop, we go to the next and next words with every loop.
            }

            // Updating the frequency of the repeated words in the linked lists
            updateWordFrequencies(extraWords, repeatedWords, word);
                // the 2 linked lists: extraWords, repeatedWords
                // word is the current words that is being analyzed.

        } while (word != null);

        // Finding the most frequent word in the file:
        String mostFrequentWord = null;
        int mostFrequentWordCount = 0;
            // For each repeated word, we'll record its frequency in the array
        for (int frequent : repeatedWords)
        {
            if (frequent > mostFrequentWordCount) // checks if the current word's frequency has surpassed the previous most frequent word.
            {
                mostFrequentWordCount = frequent; // sets a new "high score" for frequency.
            }
        }


        // Looking at the location of the most frequent word and getting the value associated with it.
        int index = repeatedWords.indexOf(mostFrequentWordCount);
            // repeatedWords is the list that stores the counts, while index finds the location.
        if (index != -1) // indexOf will return -1 if the highest frequency is not found.
        {
            mostFrequentWord = extraWords.get( index );
                // true for when the highest frequency is found, then reassigns a value to the string.
        }
        if (!mostFrequentWord.isEmpty()) // true for if the highest frequency has been found and recorded in the array.
        {
            System.out.println( "Most frequent word in your file: " + mostFrequentWord );
            System.out.println( "Frequency of '" + mostFrequentWord + "': " + mostFrequentWordCount );
        }
        else
        {
            System.out.println( "0 words found." );
        }
    }

    /**
     * Method that updates the frequency of each word from the file as it goes through it.
     *
     * @param extraWords // linked list that stores the non-repeated words present
     * @param repeatedWords // linked list that stores the value for repeated words
     * @param word // looks at the current word for each process
     */
    private void updateWordFrequencies(LinkedList<String> extraWords, LinkedList<Integer> repeatedWords, String word)
    {
        // Finding the locations of the non-repeated words
        int index = extraWords.indexOf(word);
        if (index != -1) // true for if the word is already in the list for non-repeated words
        {
            repeatedWords.set(index, repeatedWords.get(index) + 1); // adds frequency to the location storing the value for the repeated word.
        }
        else // for new words not in the list of non-repeated words.
        {
            extraWords.add(word); // shifts the non-repeated word to the separate list, as it is not needed to be analyzed anymore.
            repeatedWords.add(1); // initializes the frequency to 1 in the repeated-words list.
        }
    }
}
