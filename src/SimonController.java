import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Arc;
import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import java.util.ArrayList;

public class SimonController {
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
    	if(event.getSource() == startButton) {
    		
    		
    	}
    	if (event.getSource() == instructionsButton) {
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Simon Game Alert");
    		alert.setHeaderText("How to Play Simon");
    		alert.setContentText("Click the Start Button and a random color will light up. Click the colors in the sequence they light up. The game ends when a wrong color is chosen.");
    		alert.show();
    	}
    }

    @FXML
    private void userAction(MouseEvent event) {
    	if () {
    		
    	}
    }

}
