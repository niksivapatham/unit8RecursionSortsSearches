import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

/**
 * Counts words
 * 
 * @author Nikhil Sivapatham
 * @version 9 March 2015
 */
public class WordCount
{   
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in1 = new Scanner(System.in);
        System.out.println("What file do you want?: ");
        String fileName = in1.nextLine();
        File file = new File(fileName);
        Scanner in = new Scanner(file);
        int charCount = 0;
        int wordCount = 0;
        int linesCount = 0;
        in.useDelimiter("[^A-Za-z]+");
        while (in.hasNext())
        {

            wordCount++;
            in.next();
        }
        System.out.println("Words: " + wordCount);
        
        Scanner in2 = new Scanner("s.txt");
        in.useDelimiter(" ");
        in = in2.reset();
        while (in2.hasNext())
        {
            charCount++;
            in2.next();
        }
        System.out.println("Characters: " + charCount);
        
        while (in.hasNextLine()&&in.hasNext())
        {
            linesCount++;
            in.next();
        }
        System.out.println("Lines: "+linesCount); 
    } 
}
