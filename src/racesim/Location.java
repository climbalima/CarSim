package racesim;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;


public class Location extends Circle{
    
    private ArrayList<Car> curCars;
    private ArrayList<Car> incomingCars;
    private char LocationID;
    private final int rad=5;
    private double x_coord;
    private double y_coord;

    public Location(char LocationID, double x_coord, double y_coord) {
        super();
        ArrayList<Car> curCars = new ArrayList<Car>();
        ArrayList<Car> incomingCars = new ArrayList<Car>();
        this.LocationID = LocationID;
        this.x_coord = x_coord;
        this.y_coord = y_coord;
        
    }

    public ArrayList<Car> getCurCars() {
        return curCars;
    }
    

    public void setCurCars(ArrayList<Car> curCars) {
        this.curCars = curCars;
    }

    public ArrayList<Car> getIncomingCars() {
        return incomingCars;
    }

    public void setIncomingCars(ArrayList<Car> incomingCars) {
        this.incomingCars = incomingCars;
    }

    public char getLocationID() {
        return LocationID;
    }

    public void setLocationID(char LocationID) {
        this.LocationID = LocationID;
    }

    public double getX_coord() {
        return x_coord;
    }

    public void setX_coord(double x_coord) {
        this.x_coord = x_coord;
    }

    public double getY_coord() {
        return y_coord;
    }

    public void setY_coord(double y_coord) {
        this.y_coord = y_coord;
    }

    public void addCurCar(Car car){
        curCars.add(car);
    }
    
    public void addIncomingCar(Car car){
        incomingCars.add(car);
    }
    
    public void removeIncomingCar(Car car){
        incomingCars.remove(car);
    }
    
    public void removeCurCar(Car car){
        curCars.remove(car);
    }
    
    public double distance(Location l){
        double xDist = x_coord-l.getX_coord();
        double yDist = y_coord-l.getY_coord();
        return Math.sqrt(yDist*yDist + xDist*xDist);
    }
    
    @Override
    public String toString() {
        return "Location{" + "curCars=" + curCars + ", incomingCars=" + incomingCars + ", LocationID=" + LocationID + ", x_coord=" + x_coord + ", y_coord=" + y_coord +'}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.curCars);
        hash = 43 * hash + Objects.hashCode(this.incomingCars);
        hash = 43 * hash + this.LocationID;
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.x_coord) ^ (Double.doubleToLongBits(this.x_coord) >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.y_coord) ^ (Double.doubleToLongBits(this.y_coord) >>> 32));
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
        final Location other = (Location) obj;
        if (this.LocationID != other.LocationID) {
            return false;
        }
        if (Double.doubleToLongBits(this.x_coord) != Double.doubleToLongBits(other.x_coord)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y_coord) != Double.doubleToLongBits(other.y_coord)) {
            return false;
        }
        if (!Objects.equals(this.curCars, other.curCars)) {
            return false;
        }
        if (!Objects.equals(this.incomingCars, other.incomingCars)) {
            return false;
        }
        return true;
    }
    



}
