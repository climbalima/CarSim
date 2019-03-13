package racesim;

import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Random;

public class Venue {
    private Rectangle venueVisual;
    private HashMap<String, HashMap<Integer, Integer>> locationMap;
    private HashMap<Character, Location> locations;
    private ArrayList<Car> cars;
    private static final int NUMCARS = 4;
    private static final int NUMLOCATIONS = 4;
    
    public Venue(HashMap<Character, Location> locations, ArrayList<Car> cars){
        this.locations = locations;
        this.cars = cars;
        Random gen = new Random();
        Location[] paths = new Location[4];
    }
    public Venue(){}

    public Location getLocation(char locationID) {
        return locations.get(locationID);
    }
    
    public Car getCar(int carID){
        return cars.get(carID);
    }
}
