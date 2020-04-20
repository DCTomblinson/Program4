import java.util.ArrayList;
import java.util.List;
/**
 * Class for holding a vertex and an arraylist of edges connected to the vertice
 * @author Devon Tomblinson
 */
public class AdjacencyList {
    
    //variables held in the adjacency list
    private int vertex;
    private ArrayList<Edge210> edges;

    /**
     * Ctor for an adjacency list object
     * @param vertex the vertex that the adjacency list is for
     */
    public AdjacencyList(int vertex){
        this.vertex = vertex;
        edges = new ArrayList<Edge210>();
    }

    /**
     * Gets the vertex in the adjacency list
     * @return the vertex held in the adjacency list
     */
    public int getVert(){
        return vertex;
    }

    /**
    * Gets the edges in the adjacency list
    * @return the edges held in the adjacency list
    */
    public List<Edge210> getEdges(){
        return edges;
    }

    /**
     * Adds an edge to the list of edges in the adjacency list
     * @param v1 first vertex in the adjacency list
     * @param v2 second vertex in the adjacency list
     * @param weight weight of the edge
     * @return the edge
     */
    public Edge210 addEdge(int v1, int v2, double weight){
        Edge210 edge = new MyEdge(v1, v2, weight);
        edges.add(edge);
        return edge;
    }
}