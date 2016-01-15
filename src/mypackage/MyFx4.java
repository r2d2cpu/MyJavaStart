package mypackage;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyFx4 extends Application {

    Stage window;
    Scene scene1,scene2;

    @Override
    public void start(Stage primaryStage){
        window = primaryStage;
        Label label1 = new Label("Welcome to scene1");
        Label label2 = new Label("Medjedje");
        //Button 1
        Button button1 = new Button("Go to Scene2");
        button1.setOnAction(e -> window.setScene(scene2));
        //Button 2
        Button button2 = new Button("Go to Scene1");
        button2.setOnAction(e -> window.setScene(scene1));

        // Layout 1 children are laid in one vertical column
        VBox layout1 = new VBox(20); // 20 je spacing izmedju elemenata
        layout1.getChildren().addAll(label1, button1);
        layout1.setStyle("-fx-border-colo: red; -fx-background-color: gray");
        scene1 = new Scene(layout1, 300, 300);



        //Layout 2

        StackPane layout2 = new StackPane();
        layout2.getChildren().addAll(button2, label2);
        layout2.setRotate(22);
        layout2.setStyle("-fx-border-colo: red; -fx-background-color: lightgray");
        scene2 = new Scene(layout2, 600, 300);

        window.setTitle("Switch Scenes demo");
        window.setScene(scene1);
        window.show();
    }
}
