package mypackage;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer = false;


    public static boolean display(String title, String messageText) {

        Stage window = new Stage();

        Button yesButton = new Button("Yes");
        Button noButton = new Button("Cancel");

        Label message = new Label(messageText);

        VBox layout = new VBox(10);
        layout.getChildren().addAll(message, yesButton, noButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);

        yesButton.setOnAction(e -> {
            answer = true;
            window.close();
        });

        noButton.setOnAction(e -> {
            answer = false;
            window.close();
        });

        window.initModality(Modality.APPLICATION_MODAL);
        window.setScene(scene);
        window.setTitle(title);
        window.setMinWidth(250);
        window.setMinHeight(100);
        window.showAndWait();

        return answer;
    }
}

