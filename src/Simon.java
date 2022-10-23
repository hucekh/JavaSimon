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
	   
	   public Simon() {	// constructor to create Simon object, creates arraylist for sequence
		   
	   }
	   
	   public void start() {	// starts game
		   
	   }
	   
	   public void generateSequence() {	// generates random sequence of colors by adding random colors to arraylist
		   
	   }
	   
	   public boolean checkInput() {	// checks if user selected the correct color
		   
	   }
	   
	   public void endGame() {	// ends game
		   
	   }
	   
	   public void addColorToSequence() {	// ads random color to sequence
		   
	   }
	   
	   public void randomColor() {	// returns random color
		   
	   }
	   
	   public int getIndex() {	// returns the current index
		   
	   }
	   
	   public void setIndex() {	// setter method for current index
		   
	   }
	   
	   public ArrayList<String> getSequence() {	// getter method for arraylist
		return colorSequence;
	   }
	   
	   public void setSequence(ArrayList<String> colorSequence) {	// sets sequence to an array of colors
		   this.colorSequence = colorSequence;
	   }
	   
	   public isGameOn() {	// returns value of gameOn
		   
	   }
	   
	   public void setGameOn() {	// sets gameOn variable to boolean value
		   
	   }
	}
