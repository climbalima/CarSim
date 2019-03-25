package racesim;

import java.util.Arrays;
import java.util.Objects;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

/**
 *This class creates a location 
 * It extends javafx's Circle class
 * The circle objects are viewable 
 * @author Miguel and Max
 */
public class Location extends Circle {
//attributes
    //for identifying the specific location
    private char ID;
    //a color for its viewing purposes
    private Color color;
    //radius
    private double rad;
    //coordinates
    private double x,y;
    //used to determine if it is already being used as a starting point
    private boolean isStart;
    //used to determine if it is already being used as an end point
    private boolean isEnd;
    //to make the id visible on the screen
    private Text id;
//constructors 
    public Location(char ID, double x, double y,Color color,double rad) {
        super(x,y,rad,color);
        this.ID = ID;
        //initially locations are neither start nor end points
        isStart=false;
        isEnd=false;
        id=new Text();
        String IDstr = ID+"";
        id.setText(IDstr);
        //the +5 offsets the id to make it visible
        id.setX(x+5);
        id.setY(y+5);
    }
    public Location(){
        super();
    }
//methods
    //getters and setters for ID, isStart and isEnd
    public char getID() {
        return ID;
    }

    public void setID(char ID) {
        this.ID = ID;
    }

    public boolean isStart() {
        return isStart;
    }

    public void setIsStart(boolean isStart) {
        this.isStart = isStart;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setIsEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }

    public Text Id() {
        return id;
    }

    public void setId(Text id) {
        this.id = id;
    }
    //written by Max
    //uses a call to super and the distance formula to calculate the distance between the calling and original location
    public double distance(Location l) {
        double xDist = super.getCenterX() - l.getCenterX();
        double yDist = super.getCenterY() - l.getCenterX();
        //the distance formula 
        return Math.sqrt(yDist * yDist + xDist * xDist);
    }

    @Override
    public String toString() {
        return "Location{" + "ID=" + ID + ", color=" + color + ", rad=" + rad + ", x=" + x + ", y=" + y + ", isStart=" + isStart + ", isEnd=" + isEnd + ", id=" + id + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.ID;
        hash = 89 * hash + Objects.hashCode(this.color);
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.rad) ^ (Double.doubleToLongBits(this.rad) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.x) ^ (Double.doubleToLongBits(this.x) >>> 32));
        hash = 89 * hash + (int) (Double.doubleToLongBits(this.y) ^ (Double.doubleToLongBits(this.y) >>> 32));
        hash = 89 * hash + (this.isStart ? 1 : 0);
        hash = 89 * hash + (this.isEnd ? 1 : 0);
        hash = 89 * hash + Objects.hashCode(this.id);
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
        if (this.ID != other.ID) {
            return false;
        }
        if (Double.doubleToLongBits(this.rad) != Double.doubleToLongBits(other.rad)) {
            return false;
        }
        if (Double.doubleToLongBits(this.x) != Double.doubleToLongBits(other.x)) {
            return false;
        }
        if (Double.doubleToLongBits(this.y) != Double.doubleToLongBits(other.y)) {
            return false;
        }
        if (this.isStart != other.isStart) {
            return false;
        }
        if (this.isEnd != other.isEnd) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
            
}
