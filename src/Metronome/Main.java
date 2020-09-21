package Metronome;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    /*
            need to make it multithreaded
            cause now with every "tick" interface not responding
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        // Load root node from fxml
        Parent root = FXMLLoader.load(getClass().getResource("mainFrame.fxml"));
        primaryStage.setTitle("Simple metronome");

        primaryStage.setScene(new Scene(root, 330, 370));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
