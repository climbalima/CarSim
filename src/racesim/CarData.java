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
        super.setWidth(width);
        super.setHeight(height);
        this.allCars = allCars;
        this.locations = locations;
        carInfo = new Text();
        instructions = new Text();
        startData = "";endData="";
        insText="";
        for(Car c: allCars){
            startData+="\nCar ID: " + c.getCarID()
                    + "\nSpeed: " + c.getSpeed() 
                    + "\nPath: " + c.getPath().toString();
        }
        carInfo.setText(startData);
    }
    public CarData(){
        super();
    }
    public void buildFinishCarInfo(){
        for(Car c: allCars){
            if(c.isFinished()){
                endData+="\nCar ID: " + c.getCarID()
                    + "\nSpeed: " + c.getSpeed() 
                    + "\nPath: " + c.getPath().toString()    
                    +"\nFinish time: " + c.finishTime();
            }
        }
        carInfo= new Text();
        carInfo.setText(endData);
    }

    

}

