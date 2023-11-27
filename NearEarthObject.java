/**
* @author J. R. N
*    e-mail: joshua.nghe@stonybrook.edu
*    Stony Brook ID: 114908487
**/

import java.util.Date;

public class NearEarthObject{
    private int referenceID;

    private String name;

    private double absoluteMagnitude;

    private double averageDiameter;

    private boolean isDangerous;

    private Date closestApproachDate; // (Date)

    private double missDistance;

    private String orbitingBody;

    /**
     * Default Constructor.
     * @param referenceID Unique the ID of the NEO.
     * @param name Unique name of the asteroid or orbital body.
     * @param absoluteMagnitude Absolute brightness of the asteroid or orbital body in the sky.
     * @param minDiameter Estimated minimum diameter of the asteroid or orbital body in kilometers. This parameter should be used in conjunction with the maxDiameter parameter to calculate and initialize the averageDiameter member variable.
     * @param maxDiameter Estimated maximum diameter of the asteroid or orbital body in kilometers. This parameter should be used in conjunction with the minDiameter parameter to calculate and initialize the averageDiameter member variable.
     * @param isDangerous Boolean value indicating whether the astroid or orbital body is a potential impact threat.
     * @param closestDateTimestamp Unix timestamp representing the date of closest approach. Note that this can be used to directly construct the closestApproachDate member variable, as the Date class provides a constructor taking a timestamp as a parameter.
     * @param missDistance Distance in kilometers at which the asteroid or orbital body will pass by the Earth on the date of it's closest approach.
     * @param orbitingBody Planet or other orbital body which this NEO orbits.
     */
    public NearEarthObject(int referenceID, String name, double absoluteMagnitude, double minDiameter, double maxDiameter, boolean isDangerous, long closestDateTimestamp, double missDistance, String orbitingBody){
        this.referenceID = referenceID;
        if(name.length()<26){
            this.name = name;
        }else{
            this.name = name.substring(0,26);
        }
        this.absoluteMagnitude = absoluteMagnitude;
        averageDiameter = (minDiameter + maxDiameter) / 2;
        this.isDangerous = isDangerous;
        this.closestApproachDate = new Date(closestDateTimestamp);
        this.missDistance = missDistance;
        this.orbitingBody = orbitingBody;
    }


    public int getReferenceID(){
        return referenceID;
    }
    public void setReferenceID(int newRef){
        referenceID = newRef;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public double getAbsoluteMagnitude(){
        return absoluteMagnitude;
    }

    public void setAbsoluteMagnitude(double newMagnitude){
        absoluteMagnitude = newMagnitude;
    }

    public double getAverageDiameter(){
        return averageDiameter;
    }

    public void setAverageDiameter(double newDiameter){
        averageDiameter = newDiameter;
    }

    public boolean getDangerous(){
        return isDangerous;
    }

    public void setDangerous(boolean newBool){
        isDangerous = newBool;
    }

    public Date getApproachDate(){
        return closestApproachDate;
    }

    public void setApproachDate(Date newDate){
        closestApproachDate = newDate;
    }

    public double getMissDistance(){
        return missDistance;
    }

    public String getOrbitingBody(){
        return orbitingBody;
    }

    public void setOrbitingBody(String newBody){
        orbitingBody = newBody;
    }

    public String toString(){
        return name;
    }


}