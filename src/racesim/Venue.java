package racesim;

import java.util.ArrayList;
import java.util.Objects;
import javafx.scene.layout.Pane;
/**
 * 
 * @author Eliza Doering
 */
public class Venue extends Pane{
    private ArrayList<Location> locations;
    private ArrayList<Car> cars;
    private double height;private double width;
    private static final int NUMCARS = 4;
    private static final int NUMLOCATIONS = 4;
    
    public Venue(ArrayList<Location> locations, ArrayList<Car> cars,double height,double width){
        super();
        this.locations = locations;
        this.cars = cars;
        this.height=height;
        this.width=width;
        super.setHeight(height);
        super.setWidth(width);
        //super.setStyle(("-fx-background-color: black;"));
        for(int i=0;i<cars.size();i++){
            super.getChildren().add(cars.get(i).getCarVisual());
        }
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

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "Venue{" + "locations=" + locations + ", cars=" + cars + ", height=" + height + ", width=" + width + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 73 * hash + Objects.hashCode(this.locations);
        hash = 73 * hash + Objects.hashCode(this.cars);
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.height) ^ (Double.doubleToLongBits(this.height) >>> 32));
        hash = 73 * hash + (int) (Double.doubleToLongBits(this.width) ^ (Double.doubleToLongBits(this.width) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venue other = (Venue) obj;
        if (Double.doubleToLongBits(this.height) != Double.doubleToLongBits(other.height)) {
            return false;
        }
        if (Double.doubleToLongBits(this.width) != Double.doubleToLongBits(other.width)) {
            return false;
        }
        if (!Objects.equals(this.locations, other.locations)) {
            return false;
        }
        if (!Objects.equals(this.cars, other.cars)) {
            return false;
        }
        return true;
    }
    
    
    

}
