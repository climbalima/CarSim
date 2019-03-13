package racesim;


import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage; 
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import java.util.Random;

public class CarData extends StackPane {
    private ArrayList<Car> allCars;
    private ArrayList<Location> locations;
    private Rectangle carDataVisual;
    private static final int NUMCARS = 4;
    
    public CarData(ArrayList<Car> allCars, ArrayList<Location> locations) {
        this.allCars = allCars;
        this.locations = locations;
        Rectangle carDataVisual = new Rectangle(500,500);
        String startData = new String();
        for (Car car: allCars) {
            startData += "Car " + car.getCarID() + " data: \n";
            startData += "speed: " + car.getSpeed() + "\n";
            startData += "start location: " + car.getStartLocation() + "\n";
            startData += "next location: " + car.getCurrDestination() + "\n";
        }
        
        Text startText = new Text(startData);
        
        setAlignment(Pos.CENTER_RIGHT);
        getChildren().addAll(carDataVisual, startText);
    }
    
    
    public void updateData() {
        String newData = new String();
        int i = 0;
        for (Car car: allCars) {
            newData += "Car " + i + " data: \n";
            newData += "speed: " + car.getSpeed() + "\n";
            newData += "previous location: " + car.getPrevLocation() + "\n";
            newData += "next location: " + car.getCurrDestination() + "\n";
        }
        
        Text newText = new Text(newData);
        getChildren().addAll(carDataVisual, newText);
    }

}

