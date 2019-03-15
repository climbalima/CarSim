/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racesim;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

/**
 *This class builds a stage for a venue with locations and cars to race on
 * the locations are placed randomly within bounds on the venue pane
 * the paths for the cars are generated with the use of a hashmap 
 * buttons for beginning the game
 * @author Max,Eliza,Miguel 
 */
public class RaceSim extends Application {
    //attributes
    private ArrayList<Color> colors;
    private ArrayList<Car> cars;
    private ArrayList<Location> locations;
    private CarData carData;
    private Venue venue;
    private Color locColor;
    private double locRad;
    private double btHeight,btWidth;
    private double btnHght;
    private FlowPane bottom;
    private Button start;
    private Button reset;
    //written by Eliza
    public RaceSim(){
        colors = new ArrayList<Color>();
        cars = new ArrayList<Car>();
        locations = new ArrayList<Location>();
        carData=new CarData(cars,locations,200,650);
        venue = new Venue(locations,cars,800,650);
        btHeight=200;btWidth=1000;
        bottom= new FlowPane();
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
    //written by Eliza
    public void start(Stage primaryStage) {
        bottom.setAlignment(Pos.TOP_CENTER);
        bottom.setHgap(50);
        bottom.getChildren().addAll(start,reset);
        BorderPane root = new BorderPane();
        root.setBottom(bottom);
        root.setLeft(venue);
        root.setRight(carData);
        buildLocations();
        Scene scene = new Scene(root, 1000, 800);
        
        primaryStage.setTitle("Car Racing Project: Eliza Doering, Miguel Oyler-Castrillo, Max Hernandez");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    //written by Max
    public Car buildCar(int carID, String color, Image carVisual){
        //create the cars
        //randomize the speed variable
        //call in for loop in buildVenue
        //set line color in switch statement
        int speed = (int)Math.random()*10;
        Car newCar = new Car(speed, carID, color, carVisual);
        return newCar;
    }
    public void startButton(){
        
    }
    public void buildVenue(){
        
    }
    //written by Eliza
    public void buildLocations(){
        double xUpper= 590;double yUpper=490;
        double loc1x = Math.random()*xUpper;
        double loc1y = Math.random()*yUpper;
        locations.add(0, new Location('A',loc1x,loc1y,locRad,locColor));
        
        double loc2x = Math.random()*xUpper;
        double loc2y = Math.random()*yUpper;
        if(loc2y==loc1y||loc2x==loc1x){
            loc2x = Math.random()*xUpper;
            loc2y = Math.random()*yUpper;
        }
        locations.add(1,new Location('B',loc2x,loc2y,locRad,locColor));
        
        double loc3x = Math.random()*xUpper;
        double loc3y = Math.random()*yUpper;
        if(loc3y==loc2y||loc3y==loc1y||loc3x==loc2x||loc3x==loc1x){
            loc3x = Math.random()*xUpper;
            loc3y = Math.random()*yUpper;
        }
        locations.add(2,new Location('C',loc3x,loc3y,locRad,locColor));
        
        double loc4x = Math.random()*xUpper;
        double loc4y = Math.random()*yUpper;
        if(loc4y==loc3y||loc4y==loc2y||loc4y==loc1y||loc4x==loc3x||loc4x==loc2x||loc4x==loc1x){
            loc4y = Math.random()*xUpper;
            loc4x = Math.random()*yUpper;
        }
        locations.add(3,new Location('D',loc4x,loc4y,locRad,locColor));
        for(int i=0;i<locations.size();i++){
            venue.getChildren().add(locations.get(i));
        }
    }
    //written by Miguel
    
    public void generatePaths(ArrayList<Car> Cars, HashMap<Character, Location> locationMap){
        Random gen = new Random();
        String paths = "abcd";

        for (int i = 0; i < 4; i++) {
            char[] path = new char[4];
            path[0] = paths.charAt(i);
            while(true) {
                int randInt = gen.nextInt(4);
                if (pathGenHelper(paths.charAt(i), paths.charAt(randInt))) {
                    path[3] = paths.charAt(randInt);
                }

            }
            pathGenHelper2(path);
            Location[] locationArr = charToLocationArray(path, locationMap);
            Cars.get(i).setPath(locationArr);
        }
    }
    //written by Miguel
    public Location[] charToLocationArray(char[] paths, HashMap<Character, Location> locationMap) {
        Location[] locationArr = new Location[4];
        for (int i = 0; i < 4; i++) {
            locationArr[i] = locationMap.get(paths[i]);
        }
        return locationArr;
    }
    //written by Miguel
    public boolean pathGenHelper(char src, char dest) {
        return src != dest;
    }
    //written by Miguel
    public void pathGenHelper2(char[] path) {
        String paths = "abcd";
        String newPath = paths.substring(0, paths.charAt(path[0])) + 
        paths.substring(paths.charAt(path[0]) + 1);
        String finalPath = paths.substring(0, paths.charAt(path[3])) + 
        paths.substring(paths.charAt(path[3]) + 1);
        path[1] = finalPath.charAt(0);
        path[2] = finalPath.charAt(1);
        
    }
    //written by Max
    public ArrayList<Image> carVisuals(){
        ArrayList<Image> carPics = new ArrayList<>();
        carPics.add(new Image("Cars-Lightning-McQueen-128.PNG"));
        carPics.add(new Image("Cars-Flo-128.PNG"));
        carPics.add(new Image("Cars-Mater-128.PNG"));
        carPics.add(new Image("Cars-Ramone-128.PNG"));
        return carPics;
    }
    public boolean checkOver(ArrayList<Car> cars){
        for(Car c: cars){
            if(!c.checkWin()){
                return false;
            }     
        }
        return true;
    }
    public void reset(){
       
    }

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
