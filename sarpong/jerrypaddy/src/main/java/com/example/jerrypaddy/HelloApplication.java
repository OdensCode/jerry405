package com.example.jerrypaddy;

/* Jerry Paddy
    10922405
 */
import com.example.jerrypaddy.Database.DatabaseConnection;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    Stage window;
    ActionEvent event;




    @Override
    public void start(Stage stage) throws IOException {
        this.window = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1360, 695);
        window.setTitle("Inventory Goat");
        window.setResizable(false);
        window.setScene(scene);
        window.show();



    }

    public static void main(String[] args) {
        launch();


    }

}