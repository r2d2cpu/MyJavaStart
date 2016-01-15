package mypackage;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Node extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane pane = new StackPane();
        Button okButton = new Button("Ok");
        okButton.setStyle("-fx-border-color: blue; -fx-color: red;");
        okButton.setTextFill(Color.BLACK);
        pane.getChildren().add(okButton);

        pane.setRotate(12);// pošto pane sadrži nodove (button labele itd..) svi nodovi će se takodjer zakrenuti
        pane.setStyle("-fx-border-color: red; -fx-background-color: lightgray;");

        Scene scene = new Scene(pane, 200, 250);
        primaryStage.setTitle("Primary Stage");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
