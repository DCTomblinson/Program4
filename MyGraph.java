import java.util.ArrayList;
import java.util.List;

public class MyGraph implements Graph210 {
    
    //variables held in the graph
    private int numVerts;
    private int numEdges;
    private ArrayList<Edge210> allEdges;
    private ArrayList<AdjacencyList> adjacencyList;

    
    /**
     * ctor for a MyGraph object
     * @param numVerts number of vertices in the graph
     * @param numEdges number of edges in the graph
     */
    public MyGraph(int numVerts, int numEdges){
        this.numVerts = numVerts;
        this.numEdges = numEdges;
        this.allEdges = new ArrayList<Edge210>();
        this.adjacencyList = new ArrayList<AdjacencyList>();
        
        //creates adjacency lists for every vertex in the graph
        int count = 0;
        while(count < numVerts){
            adjacencyList.add(new AdjacencyList(count));
            count++;
        }
    }
    
    /**
     * Returns the number of vertices in the graph; verts are numbered 0 to V-1.
     * @return Returns the number of vertices in the graph
     */
    public int numVerts(){
        return numVerts;
    }

    /**
     * Returns the number of edges in the graph; edges are numbered 0 to E-1.
     * @return Returns the number of edges in the graph
     */
    public int numEdges(){
        return numEdges;
    }

    /**
     * Adds an edge to the graph.
     * @param v1 is vert1, from vert
     * @param v2 is vert2, to vert
     * @param weight Edge weight
     * @return Returns the edge just added; on error, null is returned
     */
    public Edge210 addEdge(int v1, int v2, double weight){
        
        //check if the weight is valid (non-negative)
        if(weight >= 0){
            
            //check if the first vertice is valid
            if(v1 >= 0 && v1 < numVerts){
                
                //check if the second vertice is valid. If it is, add the edge to the graph and return it
                if(v2 >= 0 && v2 < numVerts){
                    Edge210 edge = new MyEdge(v1, v2, weight);
                    allEdges.add(edge);

                    //check to see if the vertices are different and add to adjacency lists for each vertex if they are not
                    if(v1 != v2){
                    adjacencyList.get(v1).addEdge(v1, v2, weight);
                    adjacencyList.get(v2).addEdge(v1, v2, weight);
                    return edge;
                    }

                    //add to only one adjacency list if the vertices are the same
                    else{
                        adjacencyList.get(v1).addEdge(v1, v2, weight);
                        return edge;
                    }
                }

                //In case of error
                else{
                    return null;
                }
            }

            //In case of error
            else{
                return null;
            }

        }

        //In case of error
        else{
            return null;
        }
    }

    /**
     * Returns a list of edges connected to the vertex.
     * @param v The vertex
     * @return Returns a list of edges connected to the vertex
     */
    public List<Edge210> edges(int v){
        
        //iterates through each adjacency list
        for(AdjacencyList adjL : adjacencyList){
            
            //if it is the adjacency list for the specified vertex, return the list of edges.
            if(v == adjL.getVert()){
                return adjL.getEdges();
            }

            //do nothing
            else{
                ;
            }
        }

        //return null if not found
        return null;
    }

    /**
     * Returns a list of all edges in the graph.
     * @return Returns a list of all edges; never null
     */
    public List<Edge210> allEdges(){
        return allEdges;
    }

    /**
     * Two steps: 1) Normalize each edge in the graph
     * We do this so that we can (easily) compare two normalized graphs.
     */
    public void normalizeEdges(){
        for(Edge210 e : allEdges){
            e.normalize();
        }
    }
}