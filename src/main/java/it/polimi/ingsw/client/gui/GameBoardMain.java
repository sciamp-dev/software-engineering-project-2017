package it.polimi.ingsw.client.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameBoardMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/client/gui/gameboard.fxml"));
        primaryStage.setTitle("Lorenzo il Magnifico - Gameboard");
        primaryStage.setScene(new Scene(root, 1254, 630));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
