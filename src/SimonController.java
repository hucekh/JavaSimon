/**
 * Class Name: SimonController
 * Class Description: This class handles all actions from GUI, linking them with Simon class.
 * @author Hope H, Sam W, Declan R
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import javafx.scene.Node;


public class SimonController implements Initializable {
	private Simon simon = new Simon();	// create new Simon object

	private ArrayList<String> colorSequence = simon.getSequence();
	
	
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	


	@FXML
	private Pane background;
	
	@FXML
    private Button startMenuButton;

	@FXML
	private Button normalButton;
	    
    @FXML
    private Arc yellowButton;

    @FXML
    private Arc purpleButton;

    @FXML
    private Arc redButton;

    @FXML
    private Arc greenButton;

    @FXML
    private Arc blueButton;

    @FXML
    private Arc orangeButton;

    @FXML
    private Button startButton;

    @FXML
    private Label currentRound;
    
    @FXML
    private Label mode;

    @FXML
    private Button instructionsButton;
    
    @FXML
    private Label highScore;
    
    @FXML
    private Slider difficultySlider;
    
    DataSingleton data = DataSingleton.getInstance();
	
    public void difficultySelector() throws IOException {//called when the user locks in their difficulty
    	data.setDifficulty((int) difficultySlider.getValue());
    	startMenuButton.setOpacity(1);//allows start button to be pressed once difficulty is saved in the dataSingleton
    	startMenuButton.setDisable(false);
    }
    
    


	public void switchToMainScreen(ActionEvent event) throws IOException {//Switches from main menu to the game screen when start is pressed
    	  Parent root = FXMLLoader.load(getClass().getResource("SimonGUI.fxml"));
    	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();  
     	  scene = new Scene(root);
    	  stage.setScene(scene);
    	  stage.show();
    	  
    	 }


    @FXML
    private void buttonAction(ActionEvent event) {	// actions for "instructions" and "start" buttons
    	if (event.getSource() == startButton) {

    		simon.start();
    		displaySequence(simon.getSequence());

    	}
    	if (event.getSource() == instructionsButton) {

    		
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Alert");
    		alert.setHeaderText("How to Play Simon");
    		alert.setContentText("Click the Start Button and a random color will light up. Click the colors in the sequence they light up. The game ends when a wrong color is chosen.");
    		alert.show();
    	}
    	
    }
    
    @FXML
    private void userAction(MouseEvent event) {	// checks if colors clicked match the sequence of colors generated
    	if (simon.isGameOn()) {
    		if (event.getSource() == greenButton){
    			if (!simon.checkInput("g")){
    				gameOver();
    			}
    		}
    		if (event.getSource() == redButton){
	    		if(!simon.checkInput("r")){
	    			gameOver();
	    		}
	    	}
    		if (event.getSource( )== yellowButton){
    			if(!simon.checkInput("y")){
    				gameOver();
    			}
    		}
    		if (event.getSource() == blueButton){
    			if(!simon.checkInput("b")){
    				gameOver();
    			}
    		}
    		if (event.getSource() == purpleButton){
    			if(!simon.checkInput("p")){
    				gameOver();
    			}
    		}
    		if (event.getSource() == orangeButton){
    			if(!simon.checkInput("o")){
    				gameOver();
    			}
    		}
    		
    		if (simon.getIndex() == 0){
    			displaySequence(simon.getSequence());
    		}
    	}
    	else {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Alert");
    		alert.setHeaderText("Click the Start Button");
    		alert.setContentText("Please click on the button labeled Start to begin the game.");
    		alert.show();

    	}
    }
    
    private void gameOver() {	// alerts user that game is over
    	Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Alert");
		alert.setHeaderText("Game Over");
		alert.setContentText("Please click on the button labeled Start to begin another game.");
		alert.show();	
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }
    
    
    public void displaySequence(ArrayList<String> colorSequence) {	// displays sequence of colors as flashes and changes score counters
 
    	int duration = data.getDifficulty();
   
    	SequentialTransition st = new SequentialTransition();
    	st.setCycleCount(1);
    	st.setAutoReverse(false);
    	for(int i = 0; i < colorSequence.size(); i++){
    		switch(colorSequence.get(i)){
    			case "g":
    				FadeTransition greenft = new FadeTransition(Duration.millis(duration), greenButton);
    				greenft.setAutoReverse(true);
    				greenft.setFromValue(1.0);
    				greenft.setToValue(0.1);
    				greenft.setCycleCount(2);
    				st.getChildren().add(greenft);
    				break;
    			case "r":
    				FadeTransition redft = new FadeTransition(Duration.millis(duration), redButton);
    				redft.setAutoReverse(true);
    				redft.setFromValue(1.0);
    				redft.setToValue(0.1);
    				redft.setCycleCount(2);
    				st.getChildren().add(redft);
    				break;
    			case "y":
    				FadeTransition yellowft = new FadeTransition(Duration.millis(duration), yellowButton);
    				yellowft.setAutoReverse(true);
    				yellowft.setFromValue(1.0);
    				yellowft.setToValue(0.1);
    				yellowft.setCycleCount(2);
    				st.getChildren().add(yellowft);
    				break;
    			case "b":
    				FadeTransition blueft = new FadeTransition(Duration.millis(duration), blueButton);
    				blueft.setAutoReverse(true);
    				blueft.setFromValue(1.0);
    				blueft.setToValue(0.1);
    				blueft.setCycleCount(2);
    				st.getChildren().add(blueft);
    				break;
    			case "p":
    				FadeTransition purpleft = new FadeTransition(Duration.millis(duration), purpleButton);
    				purpleft.setAutoReverse(true);
    				purpleft.setFromValue(1.0);
    				purpleft.setToValue(0.1);
    				purpleft.setCycleCount(2);
    				st.getChildren().add(purpleft);
    				break;
    			case "o":
    				FadeTransition orangeft = new FadeTransition(Duration.millis(duration), orangeButton);
    				orangeft.setAutoReverse(true);
    				orangeft.setFromValue(1.0);
    				orangeft.setToValue(0.1);
    				orangeft.setCycleCount(2);
    				st.getChildren().add(orangeft);
    				break;
    		}
    		int cRound = (i+1);
    		if (cRound>=simon.getHighScore()) {// determines if the current score is the highest score in the current playthrough
    			simon.setHighScore(cRound);
    			highscore();
    		}
    		currentRound.setText(cRound + "");	// sets and displays the current round
    		
    		
    	}
    	st.play();
    }
    
    public void highscore() {// changes the highscore to a string and prints it on the game
    	String highScoreToString = simon.getHighScore() + "";
    	highScore.setText(highScoreToString);
    }

   
}
