package racesim;

import java.util.ArrayList;
import javafx.scene.layout.Pane;

public class Venue extends Pane{
    private ArrayList<Location> locations;
    private ArrayList<Car> cars;
    private double height;private double width;
    private static final int NUMCARS = 4;
    private static final int NUMLOCATIONS = 4;
    
    public Venue(ArrayList<Location> locations, ArrayList<Car> cars,double height,double width){
        this.locations = locations;
        this.cars = cars;
        this.height=height;
        this.width=width;
        super.setHeight(height);
        super.setWidth(width);
        super.setStyle(("-fx-background-color: black;"));
    }
    public Venue(){}
    
    public ArrayList<Location> getLocations() {
        return locations;
    }

    public void setLocations(ArrayList<Location> locations) {
        this.locations = locations;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
    

}
