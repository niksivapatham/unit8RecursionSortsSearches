import java.util.Scanner;


/**
 * I am an engine that can search
 * 
 * @author Nikhil Sivapatham
 * @version 11 March 2015
 */
public class SearchEngine
{
    public static void main(String[] args)
    {
        System.out.println("I'm done searching , do your own searching.");
        System.out.prinln("What website does thoughest beleive I shalt have to peruse?: ")
        Scanner in = new Scanner(System.in);
        Url url = new Url(in.next());
        
    }   
}
