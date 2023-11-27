/**
* @author J. R. N
*    e-mail: joshua.nghe@stonybrook.edu
*    Stony Brook ID: 114908487
**/

public class MissDistanceComparator  implements java.util.Comparator<NearEarthObject>{

    public int compare(NearEarthObject o1, NearEarthObject o2){
        Double firstDist = o1.getMissDistance();
        Double secondDist = o2.getMissDistance();
        return firstDist.compareTo(secondDist);

    }
    
}
