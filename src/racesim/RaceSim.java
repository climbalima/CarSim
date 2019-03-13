/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package racesim;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

/**
 *
 * @author max
 */
public class RaceSim extends Application {
    private ArrayList<Color> colors;
    @Override
    public void start(Stage primaryStage) {
        BorderPane layout = new BorderPane();
        HBox buttons = new HBox();
        VBox data = new VBox();
        Venue course = new Venue();
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        BorderPane root = new BorderPane();
        root.setBottom(buttons);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void buildCar(int i){
        //create the cars
        //randomize the speed variable
        //create car's path randomized
        //call in for loop in start method
        //set line color in switch statement
    }
    public void buildVenue(){
        
    }
    public void buildLocations(){
        
    }
    public void carVisuals(){
        ArrayList<Image> carPics = new ArrayList<>();
        carPics.add(new Image("Cars-Lightning-McQueen-128.PNG"));
        carPics.add(new Image("Cars-Flo-128.PNG"));
        carPics.add(new Image("Cars-Mater-128.PNG"));
        carPics.add(new Image("Cars-Ramone-128.PNG"));
    }
    public void checkOver(){
        
    }
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
