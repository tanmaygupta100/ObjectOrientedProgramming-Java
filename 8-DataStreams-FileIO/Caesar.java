import java.util.Scanner;

public class Translator
{
    TranslationMatrix m; // Creates variable m of type "TranslationMatrix, package.

    // Constructor
    public Translator(TranslationMatrix m)
    {
        this.m = m;
    }

    // Method
    public String translateText(String text)
    {
        String[] words = text.split("\\s+"); // "\s+" splits a string by the spaces between the words.
            // "\s+" is used instead of "\s" because the 2nd format only allows for 1 space. The 1st allows for a sequence.
        return m.translate(words); // comes from "TranslationMatrix"
    }

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
            System.out.println("Choose your cipher translator!");
            System.out.println("Caesar Cipher: (1)");
            System.out.println("Substitution Cipher: (2)");
            System.out.println("Vigenere Cipher: (3)");
        int cipherSelection = input.nextInt();
        input.nextLine();

        TranslationMatrix m;
        switch (cipherSelection)
        {
            case 1:
            {
                m = new Caesar();
                break;
            }
            case 2:
            {
                m = new Subtitution();
                break;
            }
            case 3:
            {
                m = new Vigenere();
                break;
            }

            Translator translator = new Translator(m);
            while(true)
            {
                System.out.println("Enter the path to your file or 'quit'.");
                String filePath = input.nextLine();
                if (filePath.equals("quit"))
                {
                    break;
                }
                else
                {
                    String text = fileReader(filePath);
                    String translated = translator.translateText(text);
                }
            }
        }
        input.close();
    }

    private static String fileReader(String filePath)
    {
        StringBuilder string = new StringBuilder()
        {

        }
    }
}
