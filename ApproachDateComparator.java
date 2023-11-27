/**
* @author J. R. N
*    e-mail: joshua.nghe@stonybrook.edu
*    Stony Brook ID: 114908487
**/
import java.util.Date;

public class ApproachDateComparator implements java.util.Comparator<NearEarthObject>{
    public int compare(NearEarthObject o1, NearEarthObject o2) {
        Date firstDate = o1.getApproachDate();
        Date secondDate = o2.getApproachDate();
        return firstDate.compareTo(secondDate);
    }
}
