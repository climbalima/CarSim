/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racesim;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

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
    private StackPane carData;
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
    //for the text objects
    private String startData,endData,insText;
    private Text carInfo;
    private Text endInfo;
    private Text instructions;
    
    
//constructor
    public RaceSim(){
        cars = new ArrayList<Car>();
        locations = new ArrayList<Location>();
        //initializing the size of the carData pane
        carData=new StackPane();
        carData.setMinWidth(200);
        carData.setMinHeight(500);
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
        carInfo = new Text();
        endInfo= new Text();
        instructions = new Text();
        startData = "";endData="";
        insText="";
        instructions.setText(insText);

    }

    @Override
    public void start(Stage stage) {
        //bottom is for the buttons
        bottom.setAlignment(Pos.TOP_CENTER);
        bottom.setHgap(50);
        bottom.getChildren().addAll(start,reset);
        //use of a border pane to stagger the different panes
        BorderPane root = new BorderPane();
        root.setBottom(bottom);
        root.setLeft(venue);
        root.setRight(carData);
        //calling the other methods
        buildLocations();
        buildCars();
        buildCarData();
        //the start button animates the cars
        start.setOnAction((ActionEvent e) -> {
            animateCars();
        });
        //the reset button resets the game
        reset.setOnAction((ActionEvent e) -> {
            reset();
        });
        
        Scene scene = new Scene(root, 1000, 800);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        
    }
    //adds the locations and their ID for easy identification
    //written by Eliza
    public void buildLocations() {
        locations.add(new Location('A',142.5,117.5,locColor,locRad));
        locations.add(new Location('B',142.5,325,locColor,locRad));
        locations.add(new Location('C',570,117.5,locColor,locRad));
        locations.add(new Location('D',570,325,locColor,locRad));
        for(int i=0;i<locations.size();i++){
            venue.getChildren().add(locations.get(i));
            venue.getChildren().add(locations.get(i).Id());
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
    
    public void buildCars(){
        //car images courtesy of iconspalace.com 
        cars.add(new Car("Flo",generatePath(),new Image("http://aux.iconspalace.com/uploads/16277796191148912584.png")));
        cars.add(new Car("Lighting McQueen",generatePath(),new Image("http://aux.iconspalace.com/uploads/15211618611594226778.png")));
        cars.add(new Car("Mater",generatePath(),new Image("http://aux.iconspalace.com/uploads/12939079871163965781.png")));
        cars.add(new Car("Ramone",generatePath(),new Image("http://aux.iconspalace.com/uploads/11489030631764325402.png")));
        venue.addCars(cars);
    }
    //calls the cars' animation methods in a loop
    public void animateCars(){
        for(Car c:cars){
            c.drive();
        }
    }
    //Written by Miguel
    public void buildCarData(){
        //the min is used to calculate the lowest finish time of the cars
        double win=cars.get(0).finishTime();
        //adding the instructions 
        insText+="\nThe cars' information is shown below."
                + "\nClick start to begin the race!"
                + "\nClick the reset button if you'd"
                + "\nlike to begin a new game!";
        //adding the cars' data to the pane
        for(Car c: cars){
            startData+="\nCar ID: " + c.getCarID()
                    + "\nSpeed: " + c.getSpeed() 
                    + "\nPath: " + Arrays.deepToString(c.pathNames());
            }
        for(int i=0;i<cars.size();i++){
            if(cars.get(i).finishTime()<win){
                win=cars.get(i).finishTime();
            }
        }
        for(Car c:cars){
            if(c.finishTime()==win){
                endData+="\nCar " +c.getCarID() +" wins!";
            }
        }
        carInfo.setText(startData);
        endInfo.setText(endData);
        instructions.setText(insText);
        carData.getChildren().addAll(instructions,carInfo,endInfo);
        carData.setAlignment(instructions,Pos.TOP_CENTER);
        carData.setAlignment(carInfo,Pos.CENTER);
        carData.setAlignment(endInfo,Pos.BOTTOM_CENTER);
    }
    public boolean isRaceOver(){
        for(Car c:cars){
            if(c.isFinished()){
                return true;
            }
        }
        return false;
    }
    
    public void reset(){
        venue.removeCars(cars);
        venue.getChildren().remove(locations);
        carData.getChildren().removeAll(carInfo,instructions,endInfo);
        instructions = new Text();
        insText="";
        endData="";
        startData="";
        carInfo = new Text();
        endInfo= new Text();
        cars=new ArrayList<Car>();
        locations=new ArrayList<Location>();
        buildLocations();
        buildCars();
        buildCarData();
        
    }
    
    public static void main(String[]args){
        launch(args);
    }
    
}
