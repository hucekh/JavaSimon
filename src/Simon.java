import java.util.ArrayList;
import javafx.application.Application;
	import javafx.fxml.FXMLLoader;
	import javafx.scene.Parent;
	import javafx.scene.Scene;
	import javafx.stage.Stage;

	public class Simon extends Application {
	   @Override
	   public void start(Stage stage) throws Exception {
	      Parent root = 
	         FXMLLoader.load(getClass().getResource("SimonGUI.fxml"));

	      Scene scene = new Scene(root); // attach scene graph to scene
	      stage.setTitle("Simon"); // displayed in window's title bar
	      stage.setScene(scene); // attach scene to stage
	      stage.show(); // display the stage
	   }

	   public static void main(String[] args) {
	      launch(args);	// call start method
	   }
	   
	   private ArrayList<String> colorSequence;
	   
	   public Simon() {	// create Simon object
		   
	   }

	   public void setSequence(ArrayList<String> colorSequence) {
		   this.colorSequence = colorSequence;
	   }
	   
	   public ArrayList<String> getSequence() {
		return colorSequence;
	}
	}
