import java.util.ArrayList;
import java.lang.Math;
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
	   private boolean gameOn; 
	   private int currentIndex;
	   private final int turns = 1;
	   private final String[] colors = {"g", "r", "y", "b", "p", "o"};
	   
	   public Simon() {	// constructor to create Simon object, creates arraylist for sequence
		   currentIndex = 0;
		   colorSequence = new ArrayList<String>();
		   setGameOn(false); 
	   }
	   
	   public void start() {	// starts game
		   colorSequence.clear();
		   generateSequence();
		   setGameOn(true);
		   currentIndex = 0;
	   }
	   
	   public void generateSequence() {	// generates random sequence of colors by adding random colors to arraylist
		   for(int i = 0; i < turns; i++){
			   colorSequence.add(randomColor()); 
		   }
	   }
	   
	   public boolean checkInput(String color) {	// checks if user selected the correct color
		   if((colorSequence.get(currentIndex)).equals(color)){
			   if(currentIndex == (colorSequence.size()-1)){
				   addColor();
				   currentIndex = 0;
				   return true;
			   }
			   currentIndex++;
			   return true; 
		   }
		   else {
			   endGame();
			   return false; 
			}
	   }
	   
	   public void endGame() {	// ends game
		   currentIndex = 0;
		   colorSequence.clear();
		   setGameOn(false); 
	   }
	   
	   public void addColor() {	// adds random color to sequence
		   colorSequence.add(randomColor());
	   }
	   
	   private String randomColor() {	// returns random color
		   return colors[(int) (Math.random()*6)];
	   }
	   
	   public int getIndex() {	// returns the current index
		   return currentIndex;
	   }
	   
	   public void setIndex() {	// setter method for current index
		   this.currentIndex = currentIndex;
	   }
	   
	   public ArrayList<String> getSequence() {	// getter method for arraylist
		return colorSequence;
	   }
	   
	   public void setSequence(ArrayList<String> colorSequence) {	// sets sequence to an array of colors
		   this.colorSequence = colorSequence;
	   }
	   
	   public boolean isGameOn() {	// returns value of gameOn
		   return gameOn;
	   }
	   
	   public void setGameOn(boolean gameOn) {	// sets gameOn variable to boolean value
		   this.gameOn = gameOn;
	   }
	}
