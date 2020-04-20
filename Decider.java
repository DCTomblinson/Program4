import java.io.IOException;

/**
 * class to handle input from the user in Program4
 * 
 * @author Devon Tomblinson
 */
public class Decider {

    // the starting vertice
    private int START_VERT;

    /**
     * ctor for a decider object with constant starting vertice 0
     */
    public Decider() {
        this.START_VERT = 0;
    }

    /**
     * prints instructions for using Program4
     */
    public void directions(){
        System.out.println();
        System.out.println("Please enter the number corresponding to the graph file you want to use. Exit to quit.");
        System.out.println("1.) tinyEWG.txt");
        System.out.println("2.) mediumEWG.txt");
        System.out.println("3.) 1000EWG.txt");
        System.out.println("4.) 10000EWG.txt");
    }
    
    /**
     * reads in a graph file of choice, performs Prim's min spanning tree algorithm
     * on the graph, then writes the resulting graph to results.txt
     * 
     * @param choice the number or word corresponing to the user's choice
     */
    public void execute(String choice) {

        // using tinyEWG.txt
        if (choice.equals("1")) {
            GraphHelper gh = new GraphHelper();
            Graph210 g;
            try {
                g = gh.readGraphFile("data/tinyEWG.txt");
                Graph210 primGraph = gh.doPrims(g, START_VERT);
                gh.writeFile(primGraph);
                
                //print message to user
                System.out.println("results.txt created using tinyEWG.txt");
            }
            
            //if file is not found
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        //using mediumEWG.txt
        else if (choice.equals("2")) {
            GraphHelper gh = new GraphHelper();
            Graph210 g;
            try {
                g = gh.readGraphFile("data/mediumEWG.txt");
                Graph210 primGraph = gh.doPrims(g, START_VERT);
                gh.writeFile(primGraph);
                
                //print message to user
                System.out.println("results.txt created using mediumEWG.txt");
            }
            
            //if file is not found
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        //using 1000EWG.txt
        else if (choice.equals("3")) {
            GraphHelper gh = new GraphHelper();
            Graph210 g;
            try {
                g = gh.readGraphFile("data/1000EWG.txt");
                Graph210 primGraph = gh.doPrims(g, START_VERT);
                gh.writeFile(primGraph);
                
                //print message to user
                System.out.println("results.txt created using 1000EWG.txt");
            }
            
            //if file is not found
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        //using 10000EWG.txt
        if (choice.equals("4")) {
            GraphHelper gh = new GraphHelper();
            Graph210 g;
            try {
                g = gh.readGraphFile("data/10000EWG.txt");
                Graph210 primGraph = gh.doPrims(g, START_VERT);
                gh.writeFile(primGraph);
                
                //print message to user
                System.out.println("results.txt created using 10000EWG.txt");
            }
            
            //if file is not found
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        //exiting the program with a farewell message
        else if(choice.equals("Exit")){
            System.out.println("Goodbye and thank you for using this program!");
        }
    }
}