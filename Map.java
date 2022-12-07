import com.google.common.graph.*;

public class Map{

    Location spaceship = new Location("spaceship");
    Location forest = new Location("forest");
    Location lake = new Location("lake");
    Location mountain = new Location("mountain");
    Location cave = new Location("cave");
    Location field = new Location("field");

    ImmutableGraph<Location> map = GraphBuilder.directed()
    .<Location>immutable()
    .putEdge(spaceship, forest)
    .putEdge(forest, lake)
    .putEdge(forest, mountain)
    .putEdge(mountain, cave)
    .putEdge(spaceship, field)
    .build();

}