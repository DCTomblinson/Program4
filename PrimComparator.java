import java.util.Comparator;
/**
 * Comparator for PrimsData objects
 * @author Devon Tomblinson
 */
public class PrimComparator implements Comparator<PrimsData> {

    /**
     * compare override for use in Priority Queue comparison of PrimsData objects by their edge weights, represented as cost in the form of doubles
     */
    public int compare(PrimsData p1, PrimsData p2){
            
        //if first item is greater return positive number
        if(p1.getCost() > p2.getCost()){
            return 1;
        }

        //if first item is lesser reurn negative number
        else if(p1.getCost() < p2.getCost()){
            return -1;
        }

        //if items are equal return 0
        else{
            return 0;
        }
    }
}