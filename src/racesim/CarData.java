package racesim;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
/**
 * 
 * @author Miguel Oyler-Castrillo
 */
public class CarData extends StackPane {
    private ArrayList<Car> allCars;
    private ArrayList<Location> locations;
    private String startData,endData,insText;
    private Text carInfo;
    private Text instructions;
    
    public CarData(ArrayList<Car> allCars, ArrayList<Location> locations,int height,int width) {
        super();
        super.setMinWidth(width);
        super.setMinHeight(height);
        this.allCars = allCars;
        this.locations = locations;
        carInfo = new Text();
        instructions = new Text();
        startData = "";endData="";
        insText="\nThe cars all all currrently"
                + "\nin their start positions."
                + "\nTheir information is shown below."
                + "\nClick start to begin the race!"
                + "\nClick the reset button if you'd"
                + "\nlike to begin a new game!";
        for(Car c: cars){
            startData+="\nCar ID: " + c.getCarID()
                    + "\nSpeed: " + c.getSpeed() 
                    + "\nPath: " + c.getPath().toString();
        }
        carInfo.setText(startData);
        super.getChildren().addAll(instructions,carInfo);
    }
    public CarData(){
        super();
    }
    public void buildInitialCarInfo(){
        
    }
    public void buildFinishCarInfo(){
        double win=Double.MAX_VALUE;
        for(Car c: allCars){
            if(c.isFinished()){
                endData+="\nCar ID: " + c.getCarID()
                    + "\nSpeed: " + c.getSpeed() 
                    + "\nPath: " + c.getPath().toString()    
                    +"\nFinish time: " + c.finishTime();
            }
            win=c.finishTime();
            if(c.finishTime()<win){
                win = Math.min(win, c.finishTime());
            }
        carInfo.setText(endData);
    }


    }

}

