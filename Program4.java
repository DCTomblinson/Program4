import java.util.Scanner;
/**
 * Has user select a graph file theavailable options, then performs Prim's min spanning tree algorithm and writes the resulting graph file to results.txt
 * @author Devon Tomblinson
 */
public class Program4 {
    public static void main(String[] args){
        
        //Print introductory messages and options
        System.out.println("Welcome to Program4");
        System.out.println("By: Devon Tomblinson");
        Decider decider = new Decider();

        //Use scanner and boolean to set up user input
        Scanner sc = new Scanner(System.in);
        Boolean done = false;

        while(!done){
            //print directions
            decider.directions();
            
            //Get user input
            String input = sc.nextLine();

            //Use the file that the user chooses or exit depending on the input
            decider.execute(input);
            
            //close the scanner and end the program
            if(input.equals("Exit")){
            sc.close();
            System.exit(0);
            }
        }
    }
}