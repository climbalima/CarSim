package racesim;

import java.util.Arrays;
import java.util.Objects;
import javafx.scene.image.Image;
import javafx.scene.shape.Line;
public class Car {

    private int speed;
    private int carID;
    private Location[] path;
    private Location startLocation;
    private Location prevLocation;
    private Location currLocation;
    private Location currDestination;
    private Location destination;
    private int startTime;
    private int finishTime;
    private Image carVisual;
    private String carColor;

    public Car(int speed, int carID, Location[] path, int startTime, String carColor, Image carVisual) {
        this.speed = speed;
        this.carID = carID;
        this.path = path;
        this.startTime = startTime;
        this.carColor = carColor;
        this.carVisual = carVisual;
        this.startLocation = path[0];
        this.destination = path[path.length-1];
        this.currLocation = startLocation;
        this.currDestination = path[1];
    }

    public boolean checkWin(){
        return currLocation == path[path.length-1]; 
    }
    
    public void drawPath(Location a, Location b){
        Line segment = new Line();
        segment.setStartX(prevLocation.getX_coord());
        segment.setStartY(prevLocation.getY_coord());
        segment.setEndX(currLocation.getX_coord());
        segment.setEndY(currLocation.getY_coord());
    }
    
    public int getSpeed() {
        return speed;
    }

    public int getCarID() {
        return carID;
    }

    public Location[] getPath() {
        return path;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public Location getPrevLocation() {
        return prevLocation;
    }

    public Location getCurrLocation() {
        return currLocation;
    }

    public Location getCurrDestination() {
        return currDestination;
    }

    public Location getDestination() {
        return destination;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getFinishTime() {
        return finishTime;
    }

    public String getCarColor() {
        return carColor;
    }

    public Image getCarVisual() {
        return carVisual;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public void setPath(Location[] path) {
        this.path = path;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public void setPrevLocation(Location prevLocation) {
        this.prevLocation = prevLocation;
    }

    public void setCurrLocation(Location currLocation) {
        this.currLocation = currLocation;
    }

    public void setCurrDestination(Location currDestination) {
        this.currDestination = currDestination;
    }

    public void setDestination(Location destination) {
        this.destination = destination;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setFinishTime(int finishTime) {
        this.finishTime = finishTime;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public void setCarVisual(Image carVisual) {
        this.carVisual = carVisual;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.speed;
        hash = 89 * hash + this.carID;
        hash = 89 * hash + Arrays.deepHashCode(this.path);
        hash = 89 * hash + Objects.hashCode(this.startLocation);
        hash = 89 * hash + Objects.hashCode(this.prevLocation);
        hash = 89 * hash + Objects.hashCode(this.currLocation);
        hash = 89 * hash + Objects.hashCode(this.currDestination);
        hash = 89 * hash + Objects.hashCode(this.destination);
        hash = 89 * hash + this.startTime;
        hash = 89 * hash + this.finishTime;
        hash = 89 * hash + Objects.hashCode(this.carVisual);
        hash = 89 * hash + Objects.hashCode(this.carColor);
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
        final Car other = (Car) obj;
        if (this.speed != other.speed) {
            return false;
        }
        if (this.carID != other.carID) {
            return false;
        }
        if (this.startTime != other.startTime) {
            return false;
        }
        if (this.finishTime != other.finishTime) {
            return false;
        }
        if (!Objects.equals(this.carColor, other.carColor)) {
            return false;
        }
        if (!Arrays.deepEquals(this.path, other.path)) {
            return false;
        }
        if (!Objects.equals(this.startLocation, other.startLocation)) {
            return false;
        }
        if (!Objects.equals(this.prevLocation, other.prevLocation)) {
            return false;
        }
        if (!Objects.equals(this.currLocation, other.currLocation)) {
            return false;
        }
        if (!Objects.equals(this.currDestination, other.currDestination)) {
            return false;
        }
        if (!Objects.equals(this.destination, other.destination)) {
            return false;
        }
        if (!Objects.equals(this.carVisual, other.carVisual)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Car{" + "speed=" + speed + ", carID=" + carID + ", path=" + path + ", startLocation=" + startLocation + ", prevLocation=" + prevLocation + ", currLocation=" + currLocation + ", currDestination=" + currDestination + ", destination=" + destination + ", startTime=" + startTime + ", finishTime=" + finishTime  + ", carVisual=" + carVisual + ", carColor=" + carColor + '}';
    }
    
}
