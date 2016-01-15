package mypackage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Oliver on 9.1.2016..
 */
public class DropDownMenu2 extends Application {

    //declared Combobox
    ComboBox<String> comboBox;


    @Override
    public void start(Stage primaryStage) throws Exception {

        //Stage
        Stage window = primaryStage;

        //ComboBox
        comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Good will Hunting", "St. Vincent", "Terminator", "Rambo");
        comboBox.setPromptText("What's your favorite movie?");// gets overriden by next line

        //ComboBox Editable
        //comboBox.setEditable(true);// Editable overrides setPromptText
        //set onChangeAction
        comboBox.setOnAction(event -> printSelection(comboBox.getValue()));

        //Button
        Button printMovieButton = new Button("Order");
        printMovieButton.setOnAction(e -> printMovie());

        //Layouut
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(comboBox, printMovieButton);

        //Scene
        Scene scene = new Scene(layout, 300, 300);

        //Window
        window.setTitle("CheckboxDemo");
        window.setScene(scene);
        window.show();

    }

    private void printSelection(String value) {
        System.out.println("User selected movie: " + value);
    }

    private void printMovie() {

        System.out.println(comboBox.getValue() + " ordered!");
    }

}



