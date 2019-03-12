package racesim;

import javafx.scene.shape.Rectangle;
import java.util.HashMap;
import java.util.ArrayList;

public class Venue {
    private Rectangle venueVisual;
    private HashMap<String, HashMap<Integer, Integer>> cords;
    private ArrayList<Car> cars;

    public Venue(Rectangle venueVisual, HashMap<String, HashMap<Integer, Integer>> cords, ArrayList<Car> cars) {
        this.venueVisual = venueVisual;
        this.cords = cords;
        this.cars = cars;
    }
    
    public Venue(){
        
    }

    public Rectangle getVenueVisual() {
        return venueVisual;
    }

    public HashMap<String, HashMap<Integer, Integer>> getCords() {
        return cords;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setVenueVisual(Rectangle venueVisual) {
        this.venueVisual = venueVisual;
    }

    public void setCords(HashMap<String, HashMap<Integer, Integer>> cords) {
        this.cords = cords;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }
    
    
    
    
}
