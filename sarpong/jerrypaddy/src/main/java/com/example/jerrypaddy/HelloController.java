package com.example.jerrypaddy;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {


    @FXML
    public void switchScene(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(Trrrr.class.getResource("trrrr.fxml"));
            Node node = (Node) event.getSource();
            Scene scene = new Scene(loader.load(), 1360, 695);
            Stage oldStage = (Stage) node.getScene().getWindow();
            oldStage.setScene(scene);
            oldStage.setResizable(false);
            oldStage.show();






    }


}