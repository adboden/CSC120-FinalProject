import com.google.common.graph.*;

public class Map{

    //Location objects to create and test map
    Location spaceship = new Location("Spaceship");
    Location forest = new Location("Forest");
    Location lake = new Location("Lake");
    Location mountain = new Location("Mountain");
    Location cave = new Location("Cave");
    Location field = new Location("Field");

    public ImmutableGraph<Location> map;

    /* Constructor for map data structure
     * @param l1, l2, l3, l4, l5, l6 locations that create the map
     */
    public Map(Location l1, Location l2, Location l3, Location l4, Location l5, Location l6){

    map = GraphBuilder.directed()
    .<Location>immutable()
    .putEdge(l1, l2)
    .putEdge(l2, l1)
    .putEdge(l2, l3)
    .putEdge(l3, l2)
    .putEdge(l2, l4)
    .putEdge(l4, l2)
    .putEdge(l4, l5)
    .putEdge(l5, l4)
    .putEdge(l1, l6)
    .putEdge(l6, l1)
    .build();

    }

    /* Method to print map */
    public void printMap(){
        System.out.println(map);
    }

    /* Method for determining if player can access a location based on their current location
     * @param Location l is current location
     * @param Location l2 is desired location
     * @return boolean t/f if player can access the desired location
     */
    public boolean canMove(Location l, Location l2){
        return this.map.hasEdgeConnecting(l, l2);
    }

    //Testing map
    public static void main(String[] args){
        Location spaceship = new Location("Spaceship");
        Location forest = new Location("Forest");
        Location lake = new Location("Lake");
        Location mountain = new Location("Mountain");
        Location cave = new Location("Cave");
        Location field = new Location("Field");
        Map map = new Map(spaceship, forest, lake, mountain, cave, field);

        if(map.canMove(spaceship, forest)){
            System.out.println("yay");
        }
        else{
            System.out.println("boo");
        }
    }

}