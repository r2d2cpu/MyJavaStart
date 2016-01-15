package mypackage;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;



public class MyFx2 extends Application implements EventHandler<ActionEvent>{
    Button button = new Button("Hi there!");

    @Override
    public void start(Stage primaryStage) throws Exception  {

        StackPane pane = new StackPane();
        Scene scene = new Scene(pane, 500, 400);
       // button.setOnAction(e -> System.out.print("Ouch!"));
        button.setOnAction(event -> handle(event));

        pane.getChildren().add(button);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Prozor");
        primaryStage.show();
    }

    public static void main(String ...args){
        launch();
    }



    @Override
    public void handle(ActionEvent event) {
        if(event.getSource() == button){
            System.out.println("Ouch!!");
        }
    }
}
