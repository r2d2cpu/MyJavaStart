package mypackage;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MyFx5 extends Application {
    boolean result;
    @Override
    public void start(Stage primaryStage){

        Button button1 = new Button("Clic kme");
        Button button2 = new Button("No click me instead");
        button1.setOnAction(e -> {
            result = ConfirmBox.display("Confirm window", "Are you sure you want to do that");
            if(result)
                primaryStage.close();
        });
        button2.setOnAction(e -> AlertBox.display("Error", "You should click the other button!"));

        VBox layout = new VBox(20);
        layout.getChildren().addAll(button1, button2);

        Scene scene = new Scene(layout, 500, 500);

        primaryStage.setTitle("Program");
        primaryStage.setScene(scene);
        primaryStage.show();


    }
}
