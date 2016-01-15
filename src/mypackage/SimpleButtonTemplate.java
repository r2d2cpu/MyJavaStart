package mypackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Oliver on 10.1.2016..
 */
public class SimpleButtonTemplate extends Application {

    Button button;

    @Override
    public void start(Stage window) {

        //Button

        button = new Button("Submit");
        button.setOnAction(e -> handleCick(e));

        //Vbox Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(button);

        //Scene
        Scene scene = new Scene(layout, 300, 300);

        //Window
        window.setTitle("Simple Window");
        window.setScene(scene);
        window.show();


    }

    private void handleCick(ActionEvent e) {
        if (e.getSource() == button){
            System.out.println("e = " + e);
        }
    }
}
