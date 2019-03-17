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
import java.util.HashMap;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *This class builds a stage for a venue with locations and cars to race on
 * the locations are placed randomly within bounds on the venue pane
 * the paths for the cars are generated with the use of a Hashmap 
 * buttons for beginning the game
 * @author Max,Eliza,Miguel 
 */
public class RaceSim extends Application {
    //attributes
    private ArrayList<Color> colors;
    private ArrayList<Car> cars;
    private ArrayList<Location> locations;
    private HashMap<Character, Location> locHash;
    private ArrayList<Image> carPics;
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
        carPics = new ArrayList<>();
        locHash = new HashMap<Character, Location>();
        carData=new CarData(cars,locHash,700,200);
        venue = new Venue(locHash ,cars,700,800);
        start=new Button("Start");
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
        
            BorderPane root = new BorderPane();
            bottom.setAlignment(Pos.TOP_CENTER);
            bottom.setHgap(50);
            bottom.getChildren().addAll(start,reset);
            root.setBottom(bottom);
            root.setLeft(venue);
            root.setRight(carData);
            try {
                carVisuals();
            buildLocations();
            buildVenue();
            generatePaths(cars, locHash);
            Scene scene = new Scene(root, 1000, 800);
            
            primaryStage.setTitle("Car Racing Project: Eliza Doering, Miguel Oyler-Castrillo, Max Hernandez");
            primaryStage.setResizable(false);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception ex) {
            Logger.getLogger(RaceSim.class.getName()).log(Level.SEVERE, null, ex);
        }
        start.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                for(Car c: cars){
                    while(!c.checkWin()){
                        c.drive();
                    }
                }
            }
        });
    }
    //written by Max
    public Car buildCar(int carID, Color color, Image carVisual){
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
        for(int n = 0; n<4; n++){
            cars.add(buildCar(n, colors.get(n), carPics.get(n)));
        }
    }
    //written by Eliza
    public void buildLocations(){
        double xUpper= 590;double yUpper=490;
        double loc1x = Math.random()*xUpper;
        double loc1y = Math.random()*yUpper;
        locations.add(0, new Location('A',loc1x,loc1y,locRad,locColor));
        locHash.put('a',locations.get(0));
        
        double loc2x = Math.random()*xUpper;
        double loc2y = Math.random()*yUpper;
        if(loc2y==loc1y||loc2x==loc1x){
            loc2x = Math.random()*xUpper;
            loc2y = Math.random()*yUpper;
        }
        locations.add(1,new Location('B',loc2x,loc2y,locRad,locColor));
        locHash.put('b',locations.get(1));
        
        double loc3x = Math.random()*xUpper;
        double loc3y = Math.random()*yUpper;
        if(loc3y==loc2y||loc3y==loc1y||loc3x==loc2x||loc3x==loc1x){
            loc3x = Math.random()*xUpper;
            loc3y = Math.random()*yUpper;
        }
        locations.add(2,new Location('C',loc3x,loc3y,locRad,locColor));
        locHash.put('c',locations.get(2));
        
        double loc4x = Math.random()*xUpper;
        double loc4y = Math.random()*yUpper;
        if(loc4y==loc3y||loc4y==loc2y||loc4y==loc1y||loc4x==loc3x||loc4x==loc2x||loc4x==loc1x){
            loc4y = Math.random()*xUpper;
            loc4x = Math.random()*yUpper;
        }
        locations.add(3,new Location('D',loc4x,loc4y,locRad,locColor));
        locHash.put('d',locations.get(3));
        for(int i=0;i<locHash.size();i++){
            venue.getChildren().add(locations.get(i));
        }
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
            Cars.get(i).initPath();
        }
    }
    
    public Location[] stringToLocationArray(String path, HashMap<Character, Location> locationMap) {
        Location[] locationArr = new Location[4];
        for (int i = 0; i < 4; i++) {
            locationArr[i] = locationMap.get(path.charAt(i));
        }
        return locationArr;
    }

    public void carVisuals() throws Exception{
        FileInputStream file1 = new FileInputStream("src/racesim/Cars-Lightning-McQueen-128.png");
        FileInputStream file2 = new FileInputStream("src/racesim/Cars-Flo-128.png");
        FileInputStream file3 = new FileInputStream("src/racesim/Cars-Mater-128.png");
        FileInputStream file4 = new FileInputStream("src/racesim/Cars-Ramone-128.png");
        carPics.add(new Image(file1));
        carPics.add(new Image(file2));
        carPics.add(new Image(file3));
        carPics.add(new Image(file4));
        colors.add(Color.DEEPSKYBLUE);
        colors.add(Color.CRIMSON);
        colors.add(Color.LIMEGREEN);
        colors.add(Color.GOLD);
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
