package racesim;

import java.util.ArrayList;
import javafx.scene.layout.Pane;
/**
 * 
 * @author Eliza Doering
 */
public class Venue extends Pane{
    private ArrayList<Location> locations;
    private ArrayList<Car> cars;
    private double height;private double width;
    
    public Venue(ArrayList<Location> locations, ArrayList<Car> cars,double height,double width){
        super();
        super.setHeight(height);
        super.setWidth(width);
        this.locations = locations;
        this.cars = cars;
    }
    
    public Venue(){
        super();
    }
    
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
    
    public void addCars(ArrayList<Car> cars){
        for(int i=0;i<cars.size();i++){
            getChildren().add(cars.get(i).getCarImage());
        }
    }
    public void removeCars(ArrayList<Car> cars){
        for(int i=0;i<cars.size();i++){
            getChildren().remove(cars.get(i).getCarImage());
        }
    }
}