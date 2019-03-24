package racesim;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;

/**
 *This class creates a car object to be used in a race
 * It uses an ImageView object to make it visible and 
 * uses animation to make its path viewable 
 * @author Eliza Doering and Max Hernandez
 */
public class Car {
//attributes
    //for the car's speed
    private int speed;
    //an ID set as a number
    private int carID;
    //the car's path in the race
    private ArrayList<Location> path;
    //for storing the car's start and end locations
    private Location startLocation,endLocation;
    //boolean to indicate if the car has finished its race
    private boolean finished;
    //the size of the path
    private int pathSize;
    //the distance of the path
    private double pathDist;
    //a double array of all of the x,y coordinates at the locations in the path
    private Double[] points;
    //an image from a url
    private Image carVisual;
    //an ImageView to be used as a node created from the image
    private ImageView carImage;

    //constructors
    //takes the car's ID, an arraylist of locations for the race path, and a String url for the car's image
    public Car(int carID,ArrayList<Location> path, Image carVisual) {
        super();
        this.carID = carID;
        this.path = path;
        this.carVisual = carVisual;
        carImage = new ImageView();
        //the ImageView is assigned the image from the URL
        carImage.setImage(carVisual);
        //the car is initialized as not being finished with its race
        finished = false;
        //calculate the path's size
        pathSize=path.size();
        //initialize the car's distance to be calculated later
        pathDist=0;
        //start location is the path's initial index
        startLocation = path.get(0);
        //start location noted as being a start location
        startLocation.setIsStart(true);
        //end location is the path's final index
        endLocation = path.get(pathSize-1);
        //end location is noted as being an end location
        endLocation.setIsEnd(true);
        //the Double array for storing points is initialized as twice the size of the path for x,y coordinates 
        points = new Double[pathSize*2];
        //temporary arrays for storing x and y coordinates 
        Double[] x_Points = new Double[points.length];
        Double[] y_Points = new Double[points.length];
        //the x coordinates are saved in even indices in one temp array 
        for(int i=0;i<pathSize;i++){
            x_Points[2*i]=path.get(i).getCenterX();
        }
        //the y coordinates are saved in odd indices in one temp array
        for(int i=0;i<=pathSize;i++){
            //to ensure index one is filled
            if(i==0){
                y_Points[1]=path.get(i).getCenterY();
            }else if(i<pathSize){
                y_Points[(2*i)-1]=path.get(i).getCenterY();
            }else{
             //to ensure that the final index is filled   
                y_Points[(2*i)-1]=path.get(pathSize-1).getCenterY();
            }
        }
        //the temp arrays are copied into the points array index to index 
        for(int i=0;i<points.length;i++){
            if(i%2==0){
                points[i]=x_Points[i];
            }else{
                points[i]=y_Points[i];
            }
        }
        //the speed is randomized as a number between 1 and 10 to enable a different race time than other cars
        speed = (int)Math.random()*10+1;
        //the carImage, being used as a node, is given x and y coordinates to make it a viewable object 
        carImage.setX(startLocation.getCenterX());
        carImage.setY(startLocation.getCenterY());
        
    }
    //no arg constructor
    public Car(){}
//methods
    //getters and setters for speed,carID,path,finished,startLocation,endLocation,carVisual, and both images
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getCarID() {
        return carID;
    }

    public void setCarID(int carID) {
        this.carID = carID;
    }

    public boolean isFinished() {
        return finished;
    }

    public ArrayList<Location> getPath() {
        return path;
    }

    public void setPath(ArrayList<Location> path) {
        this.path = path;
    }

    public Location getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }

    public Location getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }
    //uses a manipulated version of distance formula and car's distance method to calculate the finish time of the car
    public double finishTime(){
        return calculateDistance()/speed;
    }

    public Image getCarVisual() {
        return carVisual;
    }

    public void setCarVisual(Image carVisual) {
        this.carVisual = carVisual;
    }
    
    public int getPathSize() {
        return pathSize;
    }

    public void setPathSize(int pathSize) {
        this.pathSize = pathSize;
    }

    public ImageView getCarImage() {
        return carImage;
    }

    public void setCarImage(ImageView carImage) {
        this.carImage = carImage;
    }

    public Double[] getPoints() {
        return points;
    }
    //sets finished as true if the carImage is at the same coordinates as the end location
    public void setFinished(){
        if(carImage.getX()==endLocation.getCenterX()&&carImage.getY()==endLocation.getCenterY()){
            finished=true;
        }
    }
    //Utilizes a method in the Location class to calculate the total distance in the car's given path
    //Written by Max
    public double calculateDistance(){
        for(int i=0;i<pathSize-1;i++){
            pathDist+=path.get(i).distance(path.get(i++));
        }
        return pathDist;
    }
    //Animates the cars driving throughout their path utilizing a Polyline and PathTransition
    //Written by Eliza and Max
    public void drive(){
        Polyline polyLine = new Polyline();
        //the Double array used to store the points for the polyLine
        polyLine.getPoints().addAll(points);
        //The duration is calculated using the car's finish time to make each car's finsih time unique 
        Duration duration = new Duration(finishTime()*10);
        PathTransition pt = new PathTransition();
        //the carImage being an ImageView also makes it possible to animate 
        pt.setDuration(duration);
        pt.setNode(carImage);
        pt.setPath(polyLine);
        pt.playFromStart();
        setFinished();
    }
    //hashCode,equals and toString methods
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.speed;
        hash = 13 * hash + this.carID;
        hash = 13 * hash + Objects.hashCode(this.path);
        hash = 13 * hash + Objects.hashCode(this.startLocation);
        hash = 13 * hash + Objects.hashCode(this.endLocation);
        hash = 13 * hash + (this.finished ? 1 : 0);
        hash = 13 * hash + this.pathSize;
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.pathDist) ^ (Double.doubleToLongBits(this.pathDist) >>> 32));
        hash = 13 * hash + Arrays.deepHashCode(this.points);
        hash = 13 * hash + Objects.hashCode(this.carVisual);
        hash = 13 * hash + Objects.hashCode(this.carImage);
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
        if (this.finished != other.finished) {
            return false;
        }
        if (this.pathSize != other.pathSize) {
            return false;
        }
        if (Double.doubleToLongBits(this.pathDist) != Double.doubleToLongBits(other.pathDist)) {
            return false;
        }
        if (!Objects.equals(this.path, other.path)) {
            return false;
        }
        if (!Objects.equals(this.startLocation, other.startLocation)) {
            return false;
        }
        if (!Objects.equals(this.endLocation, other.endLocation)) {
            return false;
        }
        if (!Arrays.deepEquals(this.points, other.points)) {
            return false;
        }
        if (!Objects.equals(this.carVisual, other.carVisual)) {
            return false;
        }
        if (!Objects.equals(this.carImage, other.carImage)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Car{" + "speed=" + speed + ", carID=" + carID + ", path=" + path + ", startLocation=" + startLocation + ", endLocation=" + endLocation + ", finished=" + finished + ", pathSize=" + pathSize + ", pathDist=" + pathDist + ", points=" + points + ", carVisual=" + carVisual + ", carImage=" + carImage + '}';
    }
    

    
}