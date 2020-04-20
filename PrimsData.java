/**
 * class to hold the int and assosiated cost for use in a Priority Queue
 * @author Devon Tomblinson
 */
public class PrimsData {

    //the int and double stored
    private int i;
    private Double cost;

    /**
     * ctor for a PrimsData object
     * @param i the integer stored. Represents a vertice
     * @param cost the double stored. Rerresents the min edge weight at the time
     */
    public PrimsData(int i, Double cost){
        this.i = i;
        this.cost = cost;
    }

    /**
     * gets the cost
     * @return the edge weight double
     */
    public Double getCost(){
        return cost;
    }

    /**
     * gets the number
     * @return the vertice number
     */
    public int getInt(){
        return i;
    }
}