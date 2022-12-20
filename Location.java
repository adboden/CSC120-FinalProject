import java.util.ArrayList;

public class Location {
    
    public String name;
    public ArrayList<String> items;
    public Location location;

    /*
     * Constructor for Location object
     * @param n name of location
     */
    public Location(String n){
        name = n;
        items = new ArrayList<String>();
    }

    /* Mutator for location
     * @param l location to be set
     */
    public void setLocation(Location l){
        this.location = l;
    }

    /* Accessor for name of location
     * @return name of location object
     */
    public String getLocationName(){
        return this.name;
    }
    
}
