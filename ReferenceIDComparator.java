/**
* @author J. R. N
*    e-mail: joshua.nghe@stonybrook.edu
*    Stony Brook ID: 114908487
**/

public class ReferenceIDComparator implements java.util.Comparator<NearEarthObject>{

    public int compare(NearEarthObject o1, NearEarthObject o2){
        Integer firstID = o1.getReferenceID();
        Integer secondID = o2.getReferenceID();

        return firstID.compareTo(secondID);
    }
    
}
