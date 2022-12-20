import java.util.ArrayList;

public class Player {

    //Name of player
    public String name;
    //Location of player
    public Location location;
    //Player's inventory
    public ArrayList<String> inventory;

    /* Constructor for player object
     * @param l is location of player
     */
    public Player(Location l){
        name = "";
        this.location = l;
        inventory = new ArrayList<String>();
        inventory.add("Lighter");
        inventory.add("Oxygen");
        inventory.add("Knife");
        inventory.add("Water filter");
    }

    /*Mutator for name variable
     * @param String n name to be set to
     */
    public void setName(String n){
        this.name = n;
    }

    /* Mutator for location variable
     * @param Location l is location to set to
     */
    public void setLocation(Location l){
        this.location = l;
    }

    /* Accessor for location variable
     * @return Location of player
     */
    public Location getLocation(){
        return this.location;
    }

    /* Accessor for name of player
     * @return String name of player
     */
    public String getName(){
        return name;
    }

    /* Adds item to inventory
     * @param item to add to the inventory
     */
    public void pickUp(String i){
        inventory.add(i);
    }

    /* Print method for inventory
     * @return String of ArrayList inventory
     */
    public String printInventory(){
        return "Inventory: " + inventory;
    }
}
