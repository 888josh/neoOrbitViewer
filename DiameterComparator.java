/**
* @author J. R. N
*    e-mail: joshua.nghe@stonybrook.edu
*    Stony Brook ID: 114908487
**/

public class DiameterComparator implements java.util.Comparator<NearEarthObject>{
    public int compare(NearEarthObject o1, NearEarthObject o2){
        Double firstDiam = o1.getAverageDiameter();
        Double secondDiam = o2.getAverageDiameter();
        return firstDiam.compareTo(secondDiam);
    }
    
}
