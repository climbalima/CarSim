package racesim;

import java.util.ArrayList;
import javafx.scene.layout.Pane;
/**
 * 
 * @author Miguel Oyler and Eliza Doering
 */
public class Venue extends Pane{
    //for the locations added to the venue
    private ArrayList<Location> locations;
    //for the cars added to the venue
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
    //adding the cars to the venue
    //written by Eliza
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