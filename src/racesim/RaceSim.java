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
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import java.util.HashMap;

/**
 *
 * @author max
 */
public class RaceSim extends Application {
    private ArrayList<Color> colors;
    private ArrayList<Car> cars;
    private HashMap<Character, Location> locations;
    private CarData carData;
    private Venue venue;
    private int length,width;
    private Button start;
    private Button reset;
    
    public RaceSim(){
        colors = new ArrayList<Color>();
        cars = new ArrayList<Car>();
        locations = new HashMap<Character, Location>();
        carData=new CarData(cars,locations,700,200);
        venue = new Venue(locations ,cars,700,800);
        start=new Button("Start");
        reset=new Button("Reset");
    }
    @Override
    public void start(Stage primaryStage) {
        
        
        BorderPane root = new BorderPane();
        
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
    public void startButton(){
        
    }
    public void buildVenue(){
        
    }
    public void buildLocations(){
        double xUpper= 690;double yUpper=590;
        double loc1x = Math.random()*xUpper;
        double loc1y = Math.random()*yUpper;
        locations.put('a', new Location('a',loc1x,loc1y));
        double loc2x = Math.random()*xUpper;
        double loc2y = Math.random()*yUpper;
        if(loc2y==loc1y||loc2x==loc1x){
            loc2x = Math.random()*xUpper;
            loc2y = Math.random()*yUpper;
        }
        locations.put('b',new Location('b',loc2x,loc2y));
        double loc3x = Math.random()*xUpper;
        double loc3y = Math.random()*yUpper;
        if(loc3y==loc2y||loc3y==loc1y||loc3x==loc2x||loc3x==loc1x){
            loc3x = Math.random()*xUpper;
            loc3y = Math.random()*yUpper;
        }
        locations.put('c',new Location('c',loc3x,loc3y));
        double loc4x = Math.random()*xUpper;
        double loc4y = Math.random()*yUpper;
        if(loc4y==loc3y||loc4y==loc2y||loc4y==loc1y||loc4x==loc3x||loc4x==loc2x||loc4x==loc1x){
            loc4y = Math.random()*xUpper;
            loc4x = Math.random()*yUpper;
        } 
        locations.put('d',new Location('d',loc4x,loc4y));
    }

    public void generatePaths(ArrayList<Car> Cars, HashMap<Character, Location> locationMap){
        String[] ad = new String[2];
        String[] cb = new String[2];
        String[] da = new String[2];
        String[] bc = new String[2];
        ad[0] = "abcd";
        ad[1] = "acbd";
        bc[0] = "badc";
        bc[1] = "bdac";
        cb[0] = "cadb";
        cb[1] = "cdab";
        da[0] = "dbca";
        da[1] = "dcba";
        Random gen = new Random();
        String path = "";
        
        for (int i = 0; i < 4; i++) {
            int randInt = gen.nextInt(2);
            switch(i){
                case 0:
                    path = ad[randInt];
                    break;
                case 1:
                    path = bc[randInt];
                    break;
                case 2:
                    path = cb[randInt];
                    break;
                case 3:
                    path = da[randInt];
                    break;
            }
            Location[] locationArr = stringToLocationArray(path, locationMap);
            Cars.get(i).setPath(locationArr);
        }
    }
    
    public Location[] stringToLocationArray(String path, HashMap<Character, Location> locationMap) {
        Location[] locationArr = new Location[4];
        for (int i = 0; i < 4; i++) {
            locationArr[i] = locationMap.get(path.charAt(i));
        }
        return locationArr;
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
    public void reset(){
        
    }

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
