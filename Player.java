import java.util.ArrayList;
import com.google.common.graph.*;

public class Player {
    public String name;
    public Location loc;
    public ArrayList<String> inventory;

    public Player(){
        name = "";
        loc = new Location("spaceship");
        inventory = new ArrayList<String>();
    }

    public void setName(String n){
        this.name = n;
    }

    public void setLocation(Location l){
        if(map.hasEdgeConnecting(this.loc, l)){

        }
    }

    public String getName(){
        return name;
    }

    public String getLocation(){
        return loc.getName();
    }

    public void pickUp(String i){
    }
}
