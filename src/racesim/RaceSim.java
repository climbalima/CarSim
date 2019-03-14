/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racesim;

import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

/**
 *
 * @author max
 */
public class RaceSim extends Application {
    private ArrayList<Color> colors;
    private ArrayList<Car> cars;
    private ArrayList<Location> locations;
    private CarData carData;
    private int length,width;
    private BorderPane bp;
    private Button start;
    private Button reset;
    
    public RaceSim(){
        colors = new ArrayList<Color>();
        cars = new ArrayList<Car>();
        locations = new ArrayList<Location>();
        carData=new CarData(cars,locations);
        bp=new BorderPane();
        start=new Button("Start");
        reset=new Button("Reset");
    }
    @Override
    public void start(Stage primaryStage) {
        
        Pane root = new Pane();
        
        Scene scene = new Scene(root, 1000, 800);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public Car buildCar(int i, int carID, String color, Image carVisual){
        //create the cars
        //randomize the speed variable
        //call in for loop in buildVenue
        //set line color in switch statement
        int speed = (int)Math.random()*10;
        Car newCar = new Car(speed, carID, color, carVisual);
        return newCar;
    }
    public void buildVenue(){
        
    }
    public void buildLocations(){
        double xUpper= 690;double yUpper=590;
        double loc1x = Math.random()*xUpper;
        double loc1y = Math.random()*yUpper;
        locations.set(0, new Location('A',loc1x,loc1y));
        double loc2x = Math.random()*xUpper;
        double loc2y = Math.random()*yUpper;
        if(loc2y==loc1y||loc2x==loc1x){
            loc2x = Math.random()*xUpper;
            loc2y = Math.random()*yUpper;
        }
        locations.set(1,new Location('B',loc2x,loc2y));
        double loc3x = Math.random()*xUpper;
        double loc3y = Math.random()*yUpper;
        if(loc3y==loc2y||loc3y==loc1y||loc3x==loc2x||loc3x==loc1x){
            loc3x = Math.random()*xUpper;
            loc3y = Math.random()*yUpper;
        }
        locations.set(2,new Location('C',loc3x,loc3y));
        double loc4x = Math.random()*xUpper;
        double loc4y = Math.random()*yUpper;
        if(loc4y==loc3y||loc4y==loc2y||loc4y==loc1y||loc4x==loc3x||loc4x==loc2x||loc4x==loc1x){
            loc4y = Math.random()*xUpper;
            loc4x = Math.random()*yUpper;
        }
        locations.set(3,new Location('D',loc4x,loc4y));
    }
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
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
