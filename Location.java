import java.util.ArrayList;

public class Location {
    
    public String name;
    public ArrayList<String> items;

    public Location(String n){
        name = n;
        items = new ArrayList<String>();
    }

    public void addItem(String i){
        this.items.add(i);
    }

    public String getName(){
        return this.name;
    }
}
