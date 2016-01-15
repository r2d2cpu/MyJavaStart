package mypackage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Created by Oliver on 9.1.2016..
 */
public class ExtractAndValidate extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        //TextField
        TextField textField = new TextField();
        textField.setPromptText("Enter your age");
        textField.setStyle( "-fx-prompt-text-fill: derive(-fx-control-inner-background,-30%);");

        //Button
        Button logINButton = new Button("Log In");
        logINButton.setOnAction(e -> validateInput(textField));

        //Vbox Layout
        VBox layout = new VBox(10);// 10 - razmak izmedju vertikalnih redova
        layout.setPadding(new Insets(20, 20, 20, 20));// 20 razmak od rubova prozora
        layout.getChildren().addAll(textField, logINButton);

        //Scene
        Scene scene = new Scene(layout, 300, 300);

        //Set Stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Get Value Demo");
        primaryStage.show();
    }

    private boolean validateInput(TextField textField){
        try {
            int userAge = Integer.parseInt(textField.getText());
            System.out.println("User age: " + userAge);
            return true;

        }catch (NumberFormatException e){

            //Message
            String errorMessage = "User age must be an Integer value!";

            //Alert the user
            textField.setText(errorMessage);
            textField.setStyle("-fx-text-fill: RED;");

            //Output to Console
            System.out.println(errorMessage);

            return false;

        }
    }
}
