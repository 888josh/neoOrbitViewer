/**
* @author J. R. N
*    e-mail: joshua.nghe@stonybrook.edu
*    Stony Brook ID: 114908487
**/

import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;

import big.data.*;

public class NeoDatabase {

    /*
     * API Key specific to this application used to perform queries to the NASA NeoW API
     */

    public static final String API_KEY = "pHedVaLQ2vP9CLROnLuVOtMYJVkkdNtXwmZ5eGnE";

    /*
     * URL of the REST API used to conduct queries. The query parameters will be appended to the end of this string, which will indicate the page number requested by the user along with the program's uniqe API_KEY described above (see buildQueryURL() below for further information).
     */
    public static final String API_ROOT = "https://api.nasa.gov/neo/rest/v1/neo/browse?";

    private static ArrayList<NearEarthObject> storageBase = new ArrayList<NearEarthObject>();
    private static ArrayList<Integer> addedPages = new ArrayList<Integer>();
    
    /*
     * Default constructor
     * preconditions: The database has been constructed and is empty
     */
    public NeoDatabase(){

    }

    /**
     * Builds a query URL given a page number. 
     * @param pageNumber Integer ranging from 0 to 715 indicating the page the user wishes to load.
     * @return The generated URL.
     * @throws IllegalArgumentException If pageNumber is not in the valid range.
     */

    public static String buildQueryURL(int pageNumber) throws IllegalArgumentException{
        if((pageNumber < 0 || pageNumber > 715)){
            throw new IllegalArgumentException();
        }

        addedPages.add(pageNumber);

        return (API_ROOT + "page=" + pageNumber + "&api_key=" + API_KEY);

    }

    /**
     * Opens a connection to the data source indicated by queryURL and adds all NearEarthObjects found in the dataset.
     * @param queryURLString containing the URL requesting a dataset from the NASA NeoW service (should be generated by buildQueryURL())
     * Preconditions: queryURL is a non-null string representing a valid API request to the NASA NeoW service.
     * Postconditions: All NearEarthObject records returned have been added to the database, or else a IllegalArgumentException has been thrown.
     * @throws IllegalArgumentException If queryURL is null or cound not be resolved by the server.
     */
    public static void addAll(String queryURL) throws IllegalArgumentException{

        DataSource nasaInfo = DataSource.connectJSON(queryURL).load();
        NearEarthObject[] toAdd = nasaInfo.fetchArray("NearEarthObject", "near_earth_objects/id", "near_earth_objects/name", "near_earth_objects/absolute_magnitude_h", "near_earth_objects/estimated_diameter/kilometers/estimated_diameter_min","near_earth_objects/estimated_diameter/kilometers/estimated_diameter_max", "near_earth_objects/is_potentially_hazardous_asteroid", "near_earth_objects/close_approach_data/epoch_date_close_approach", "near_earth_objects/close_approach_data/miss_distance/kilometers", "near_earth_objects/close_approach_data/orbiting_body");

        for(int i = 0; i<toAdd.length; i++){
            storageBase.add(toAdd[i]);
        }
    }

    /**
     * Sorts the database using the specified Comparator of NearEarthObjects.
     * @param comp Comparator of NearEarthObjects which will be used to sort the database. This parameter can be any of the required Comparator classes listed above.
     * Preconditions: comp is not null.
     * Postconditions: The database has been sorted based on the order specified by the inidcated Comparator of NearEarthObjects.
     * @throws IllegalArgumentException If comp is null.
     */

    public void sort(Comparator<NearEarthObject> comp) throws IllegalArgumentException{

        if(comp == null){
            throw new IllegalArgumentException();
        }
        Collections.sort(storageBase, comp);
    }

    /**
     * Displays the database in a neat, tabular form, listing all member variables for each NearEarthObject. Note the table should be printed in the order specified by the last sort() call.
     * Preconditions: This NeoDatabase is initialized and not null.
     * Postconditions: The table has been printed to the console but remains unchanged.
     */

    public static void printData(){
        System.out.println("     ID    |            Name            | Mag. | Diameter | Danger | Close Date | Miss Dist | Orbits");
        System.out.println("=====================================================================================================");
        for(int i = 0; i<storageBase.size(); i++){
            String convert = storageBase.get(i).getApproachDate().toInstant().toString();
            String dateConverted = convert.substring(5,7) + "-" + convert.substring(8,10) + "-" + convert.substring(0,4);
            System.out.printf("%-14d%10s%10.1f%10.3f%10b%15s%13.0f%13s", storageBase.get(i).getReferenceID(), storageBase.get(i).getName(), storageBase.get(i).getAbsoluteMagnitude(), storageBase.get(i).getAverageDiameter(), storageBase.get(i).getDangerous(), dateConverted, storageBase.get(i).getMissDistance(), storageBase.get(i).getOrbitingBody() + "\n");
        }
    }


    
}
