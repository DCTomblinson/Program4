import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.PriorityQueue;

/**
 * These are Helper methods for Program 04. This is optional. It's just one way
 * to set this up. It's also a place where I can share more P4 Helper code.
 * 
 * @author Prof Bill, Cole P, Dev T, Luis G, Jason E
 * @version 0.1
 */
public class GraphHelper {

    //ctor for a GraphHelper which has no variables
    public GraphHelper(){
    }

    /**
     * Read a directed graph from a file.
     * 
     * The format of the file is from Sedgewick, algs4.cs.princeton.edu/43mst:
     * num-vertices num-edges v1 v2 weight // one line per edge
     * 
     * @param fileName name of graph file
     * @return Returns a new Graph210, or null on error
     * @throws IOException in case of any other error in reading the file
     */
    public Graph210 readGraphFile(String fileName) throws IOException {

        //Create Buffered Reader to read the file
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            
            //read the first 2 lines for the number of vertices and number of edges and construct a graph of them
            int numVerts = Integer.parseInt(br.readLine());
            int numEdges = Integer.parseInt(br.readLine());
            Graph210 graph = new MyGraph(numVerts, numEdges);
        
            //get the next line and while it is an actual line of text, split it into the 2 connected vertices and edge weight, parsing them and adding an edge to the graph
            String temp = br.readLine();
            while (temp != null) {
                String[] temp2 = temp.split(" ");
            
                int v1 = Integer.parseInt(temp2[0]);
                int v2 = Integer.parseInt(temp2[1]);
                Double weight = Double.parseDouble(temp2[2]);
                graph.addEdge(v1, v2, weight);

                temp = br.readLine();
            }
        
            //close the Buffered Reader and return the completed graph
            br.close();
            return graph;
        }
        
        //In case file isn't found
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Writes a graph to a results file starting with the number of vertices, then the number of edges, and finally the edges in the graph
     * @param g the graph to be written to a results file.
     */
    public void writeFile(Graph210 g) {
        
        //get all the edges in the graph
        List<Edge210> e = g.allEdges();
        
        try {
            //create a Print Writer object and print out the number of vertices and the number of edges
            PrintWriter out = new PrintWriter("results.txt");
            out.println(g.numVerts());
            out.println(g.numEdges());
            
            //Print each edge
            for(Edge210 edge : e){
                out.println(edge.getVert1() + " " + edge.getVert2() + " " + edge.getWeight());
            }
            
            //close the Print
            out.close();
        } 
        
        //In case of the file not being found or writable to
        catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * performs Prim's min spanning tree algorithm on a graph and return the optimal graph
     * @param g the graph which the operations will be performed on
     * @param startVert starting vertice for Prim's
     * @return the optimized graph
     */
    public Graph210 doPrims(Graph210 g, int startVert){
        
        //create arrays for the known state of a vertice, cost(distance or edge weight) of the current optimal edge for the vertice, and current optimal parent vertice
        Boolean[] known = new Boolean[g.numVerts()];
        Double[] cost = new Double[g.numVerts()];
        int[] parent = new int[g.numVerts()];

        //set all the values in the arrays to their proper default value for the start of Prim's
        for(int j = 0 ; j < g.numVerts() ; j++){
            known[j] = false;
            cost[j] = Double.MAX_VALUE;
            parent[j] = -1;
        }
        
        //create a priority queue of PrimsData objects that uses a PrimComparator
        PriorityQueue<PrimsData> pq = new PriorityQueue<PrimsData>(g.numVerts(), new PrimComparator());

        //set starting vertice cost to 0 because it has no distance from itself, then create starting PrimsData object to put in the priority queue
        cost[startVert] = 0.0;
        pq.add(new PrimsData(startVert, cost[startVert]));

        //while there is still something in the priority queue take the min weighted PrimsData and get the vertice, 
        //set known for the vertice to true thenget all the edges connected to that vertex
        while(!pq.isEmpty()){
            PrimsData temp = pq.poll();
            int u = temp.getInt();
            known[u] = true;
            List<Edge210> edges = g.edges(u);
            
            //for each edge, get the other vertex than the known vertex and if it isn't known and the weight of the edge is less than the weight currently associated with the vertex,
            //set the weight associated with the vertex to the edge weight, set the parent to the known vertex, 
            //and if there isnt a PrimsData object in the priority queue for the second vertice and lowest cost, add one to the priority queue
            for( Edge210 e : edges){
                int v2 = e.otherVert(u);
                if(!known[v2] && e.getWeight() < cost[v2]){
                    cost[v2] = e.getWeight();
                    parent[v2] = u;
                    PrimsData pTemp = new PrimsData(v2, cost[v2]);
                    if(!pq.contains(pTemp)){
                        pq.add(pTemp);
                    }
                }
            }
        }

        //create a graph with the updated Prim's graph
        Graph210 graph = new MyGraph(g.numVerts(), g.numVerts() - 1);
        for(int i = 0 ; i < graph.numVerts() ; i++){
            graph.addEdge(i, parent[i], cost[i]);
        }

        //return the updated graph
        return graph;
    }
}