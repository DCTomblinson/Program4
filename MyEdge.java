/**
 * class for an edge data structure holding 2 vertices and a weight between them
 * implements Edge210 interface
 * @author Devon Tomblinson
 */
public class MyEdge implements Edge210{
    
    //vertices and weight for the edge
    private int vert1;
    private int vert2;
    private double weight;
    
    /**
     * ctor for a MyEdge object
     * @param vert1 the first vertice
     * @param vert2 the second vertice
     * @param weight the edge weight
     */
    public MyEdge(int vert1, int vert2, double weight){
        this.vert1 = vert1;
        this.vert2 = vert2;
        this.weight = weight;
    }

    /**
     * Returns the first "from" vert on the edge.
     * @return Returns the first vert
     */
    public int getVert1(){
        return vert1;
    }

    /**
     * Returns the second "to" vert on the edge.
     * @return Returns the second vert
     */
    public int getVert2(){
        return vert2;
    }

    /**
     * Returns the edge weight, a positive number (greater than 0)
     * @return Returns the edge weight
     */
    public double getWeight(){
        return weight;
    }

    /**
     * Returns the "other" vertex in the edge
     * @param v This vert
     * @return Returns the other vert; if v is not on the edge, then vert1 is returned
     */
    public int otherVert( int v){
        if(v == vert1){
            return vert2;
        }

        else if(v == vert2){
            return vert1;
        }

        else{
            return vert1;
        }
    }

    /**
     * Returns true if vert is part of the edge.
     * @param v The vert to check
     * @return Returns true if part of edge
     */
    public boolean hasVert( int v){
        if(v == vert1 || v == vert2){
            return true;
        }

        else{
            return false;
        }
    }

    /**
     * Normalize the edge by ordering its verts, smallest first.
     * Warning: Only use for UNDIRECTED graphs!
     */
    public void normalize(){
        if(vert1 > vert2){
            int tempVert = vert1;
            vert1 = vert2;
            vert2 = tempVert;
        }

        else{
            return;
        }
    }
}