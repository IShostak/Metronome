package Metronome;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class Controller {
    ClickLogic cl = new ClickLogic(); //instance of ClickLogic to run
    int count = 1;    //variable to track and operate set button

    @FXML
    private TextField tittel;

    @FXML
    private Button button;

    @FXML
    private Label mainPBM ;

    @FXML
    private void handlePlus(ActionEvent event) {
        int temp = ClickLogic.getCurrentValue()+1;
        if(temp > ClickLogic.MAX_VALUE) temp = ClickLogic.MAX_VALUE;
        ClickLogic.setCurrentValue(temp);
        mainPBM.setText(temp+"");
    }
    @FXML
    private void handleMinus(ActionEvent event) {
        int temp = ClickLogic.getCurrentValue()-1;
        if(temp < ClickLogic.MIN_VALUE) temp = ClickLogic.MIN_VALUE;
        ClickLogic.setCurrentValue(temp);
        mainPBM.setText(temp+"");
    }

    @FXML
    private void handleSet(ActionEvent event) {
        String textField = tittel.getText();  //receive text from tittel textfield
        tittel.setText("");
        int temp = 0 ;
        int currentVal = ClickLogic.getCurrentValue(); //store current value
        try {
            temp = Integer.parseInt(textField);
        } catch (NumberFormatException e) {  //if input was not number and parsing failed
           temp = currentVal;                //return previous value
        }
        //minvalue check, in case failed check assign min
        if(temp < ClickLogic.MIN_VALUE) {
            temp = ClickLogic.MIN_VALUE;
        }
        //maxvalue check, in case failed check assign max
        if (temp > ClickLogic.MAX_VALUE) temp = ClickLogic.MAX_VALUE;
        ClickLogic.setCurrentValue(temp);
        mainPBM.setText(temp+"");
    }

    @FXML
    //change button text and stop/start audio on press
    private void handleStart(ActionEvent event) {
        cl.run();  //run clicker
        count++;
        if (count == 3) {
            button.setText("Start");
            cl.isPlaying = true;
            count = 1;
        } else if (count == 2) {
            cl.isPlaying = false;  //this needed after first start to resume audio
            button.setText("Stop");
        }
    }
}
