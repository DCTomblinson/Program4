import java.util.Scanner;
/**
 * class to handle user input for Program4
 * @author Devon Tomblinson
 */
public class Input {
    
    /**
     * ctor for an Input object that holds no variables
     */
    public Input(){
    }

    /**
     * displays instructions, gets user input, and performs desired actions
     */
    public void run(){
        
        //create decider object
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