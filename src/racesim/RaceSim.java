/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racesim;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import javafx.animation.PathTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;

/**
 *
 * @author Max,Eliza,Miguel 
 */
public class RaceSim extends Application {
//attributes
    //the cars racing
    private ArrayList<Car> cars;
    //the locations the cars will travel around
    private ArrayList<Location> locations;
    //a pane for storing the car's data
    private CarData carData;
    //the pane where the race takes place
    private Venue venue;
    //the color for the locations
    private Color locColor;
    //the locations' radius
    private double locRad;
    //for calculating the dimensions of the bottom pane
    private double btHeight,btWidth;
    private double btnHght;
    //pane for storing the buttons
    private FlowPane bottom;
    //a start button
    private Button start;
    //a reset button
    private Button reset;
//constructor
    public RaceSim(){
        cars = new ArrayList<Car>();
        locations = new ArrayList<Location>();
        //initializing the size of the carData pane
        carData=new CarData(cars,locations,200,650);
        //initializing the size of the venue pane
        venue = new Venue(locations,cars,800,650);
        //initiazling the bottom pane's dimensions 
        btHeight=200;btWidth=1000;
        bottom= new FlowPane();
        //setting the bottom pane's dimensions
        bottom.setMinHeight(btHeight);
        bottom.setMinWidth(btWidth);
        locColor=Color.BLACK;
        locRad=5;
        start=new Button("Start");
        start.setMinHeight(btnHght);
        reset=new Button("Reset");
        reset.setMinHeight(btnHght);

    }

    @Override
    public void start(Stage stage) {
        bottom.setAlignment(Pos.TOP_CENTER);
        bottom.setHgap(50);
        bottom.getChildren().addAll(start,reset);
        BorderPane root = new BorderPane();
        root.setBottom(bottom);
        root.setLeft(venue);
        root.setRight(carData);
        buildLocations();
        buildCars();
        start.setOnAction((ActionEvent e) -> {
            animateCars();
        });
        reset.setOnAction((ActionEvent e) -> {
            reset();
        });
        
        Scene scene = new Scene(root, 1000, 800);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
    }
    //randomizes the locations
    //written by Eliza
    public void buildLocations() {
        locations.add(new Location('A',142.5,117.5,locColor,locRad));
        locations.add(new Location('B',142.5,325,locColor,locRad));
        locations.add(new Location('C',570,117.5,locColor,locRad));
        locations.add(new Location('D',570,325,locColor,locRad));
        for(int i=0;i<locations.size();i++){
            venue.getChildren().add(locations.get(i));
        }
    }

    public ArrayList generatePath(){
        return pathPermutations(locations);
    }
    private ArrayList pathPermutations(ArrayList<Location> list){
        if(list.get(0).isStart()){
            Collections.shuffle(list);  
                return list;
            }
        return list;
    }
    
    public Location[] stringToLocationArray(String path, HashMap<Character, Location> locationMap) {
        Location[] locationArr = new Location[4];
        for (int i = 0; i < 4; i++) {
            locationArr[i] = locationMap.get(path.charAt(i));
        }
        return locationArr;
    }
    public void buildCars(){
        cars.add(new Car(1,generatePath(),new Image("http://aux.iconspalace.com/uploads/16277796191148912584.png")));
        cars.add(new Car(2,generatePath(),new Image("http://aux.iconspalace.com/uploads/15211618611594226778.png")));
        cars.add(new Car(3,generatePath(),new Image("http://aux.iconspalace.com/uploads/12939079871163965781.png")));
        cars.add(new Car(4,generatePath(),new Image("http://aux.iconspalace.com/uploads/11489030631764325402.png")));
        venue.addCars(cars);
    }
    public void animateCars(){
        for(Car c:cars){
            c.drive();
        }
    }
    public void reset(){
        venue.removeCars(cars);
        venue.getChildren().removeAll(locations);
        cars=new ArrayList<Car>();
        locations=new ArrayList<Location>();
        buildLocations();
        buildCars();
        
    }
    
    public static void main(String[]args){
        launch(args);
    }
    
}
