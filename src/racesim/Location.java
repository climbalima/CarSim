package racesim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Location {
    
    private String name;
    private int time;
    private double[][] location;

    public Location(String name, int time, double[][] location) {
        this.name = name;
        this.time = time;
        this.location = location;
    }

    public Location() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double[][] getLocation() {
        return location;
    }

    public void setLocation(double[][] location) {
        this.location = location;
    }
    
    public void addedTime(){
        
    }
    
    public void addCar(){
        
    }
    
    public ArrayList currentCars(){
        
    }

    @Override
    public String toString() {
        return "Location{" + "name=" + name + ", time=" + time + ", location=" + location + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + this.time;
        hash = 59 * hash + Arrays.deepHashCode(this.location);
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
        return true;
    }

}
