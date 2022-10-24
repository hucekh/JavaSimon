import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Arc;
import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;

public class SimonController implements Initializable{
	private Simon simon = new Simon();	// create new Simon object
	private ArrayList<String> colorSequence = simon.getSequence();
	
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
    private Button instructionsButton;

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
    private void userAction(MouseEvent event) {	// checks if colors clicked match the sequence of colors
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
    
    public void displaySequence(ArrayList<String> colorSequence) {	// displays sequence of colors as flashes of white
    	SequentialTransition st = new SequentialTransition();
    	st.setCycleCount(1);
    	st.setAutoReverse(false);
    	for(int i = 0; i < colorSequence.size(); i++){
    		switch(colorSequence.get(i)){
    			case "g":
    				FadeTransition greenft = new FadeTransition(Duration.millis(300), greenButton);
    				greenft.setAutoReverse(true);
    				greenft.setFromValue(1.0);
    				greenft.setToValue(0.1);
    				greenft.setCycleCount(2);
    				st.getChildren().add(greenft);
    				break;
    			case "r":
    				FadeTransition redft = new FadeTransition(Duration.millis(300), redButton);
    				redft.setAutoReverse(true);
    				redft.setFromValue(1.0);
    				redft.setToValue(0.1);
    				redft.setCycleCount(2);
    				st.getChildren().add(redft);
    				break;
    			case "y":
    				FadeTransition yellowft = new FadeTransition(Duration.millis(300), yellowButton);
    				yellowft.setAutoReverse(true);
    				yellowft.setFromValue(1.0);
    				yellowft.setToValue(0.1);
    				yellowft.setCycleCount(2);
    				st.getChildren().add(yellowft);
    				break;
    			case "b":
    				FadeTransition blueft = new FadeTransition(Duration.millis(300), blueButton);
    				blueft.setAutoReverse(true);
    				blueft.setFromValue(1.0);
    				blueft.setToValue(0.1);
    				blueft.setCycleCount(2);
    				st.getChildren().add(blueft);
    				break;
    			case "p":
    				FadeTransition purpleft = new FadeTransition(Duration.millis(300), purpleButton);
    				purpleft.setAutoReverse(true);
    				purpleft.setFromValue(1.0);
    				purpleft.setToValue(0.1);
    				purpleft.setCycleCount(2);
    				st.getChildren().add(purpleft);
    				break;
    			case "o":
    				FadeTransition orangeft = new FadeTransition(Duration.millis(300), orangeButton);
    				orangeft.setAutoReverse(true);
    				orangeft.setFromValue(1.0);
    				orangeft.setToValue(0.1);
    				orangeft.setCycleCount(2);
    				st.getChildren().add(orangeft);
    				break;
    		}
		//set the current round
		currentRound.setText(i+"");
    	}
    	st.play();
    }

    @Override
	public void initialize(URL location, ResourceBundle resources) {	// initializes FXML attributes
	}
}
