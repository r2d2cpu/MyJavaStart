package mypackage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Oliver on 9.1.2016..
 */
public class DropDownMenu extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Stage
        Stage window = primaryStage;

        //ChoiceBox - slican arraylisti
        ChoiceBox<String> dropDownChoice = new ChoiceBox<>();

        //prvi nacin dodavanja
        dropDownChoice.getItems().add("Apples");
        dropDownChoice.getItems().add("Bananas");
        //drugi nacin dodavanja
        dropDownChoice.getItems().addAll("Piers", "Pineapples", "WaterMellon");
        //Set Default Value
        dropDownChoice.setValue("Apples");

        //Ako zelimo dodati onchange Funkcionalnost
            //moze se koristiti i dropDownChoice.setOnAction(event -> System.out.println("Bla"));
        dropDownChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> handleOnChange(oldValue, newValue));

        //Button
        Button orderButton = new Button("Order");
        orderButton.setOnAction(e -> handleDropDownMenuOnButtonClick(dropDownChoice));

        //Layouut
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(dropDownChoice, orderButton);

        //Scene
        Scene scene = new Scene(layout, 300, 300);

        //Window
        window.setTitle("CheckboxDemo");
        window.setScene(scene);
        window.show();

    }

    private void handleOnChange(String oldValue, String newValue) {
        System.out.println("Stara vijednost: " + oldValue);
        System.out.println("Nova vrijednost: " + newValue);
    }

    private void handleDropDownMenuOnButtonClick(ChoiceBox<String> dropDownChoice) {
        String food = dropDownChoice.getValue();
        System.out.println("Selected food: " + food);
    }

}