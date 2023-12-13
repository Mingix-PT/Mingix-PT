package hust.soict.hedspi.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Painter extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("Painter.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("Painter");
            primaryStage.setScene(scene);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
