package mypackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MyFx3 extends Application {

    Button button = new Button("OK");

    @Override
    public void start(Stage primaryStage) throws Exception{


        Stage myStage = new Stage();
        StackPane myStackPane = new StackPane();
        Scene myScene = new Scene(myStackPane, 800, 800);

        myStackPane.getChildren().add(button);
        myStage.setScene(myScene);

        myStage.setTitle("Prozor");
        myStage.show();

        //pomocu lambdi

        button.setOnAction(event -> callSomeMethod());
        /*
        stari nacin

        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.print("Ouch! ");
            }
        });

         */



    }

    private void callSomeMethod() {
        System.out.print("Ouch! ");
    }


}
