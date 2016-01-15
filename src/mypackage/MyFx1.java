package mypackage;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MyFx1 extends Application {

    Button button1 = new Button();
    Button button2 = new Button("NOK");
    Button button3 = new Button("Hi!");

    StackPane layout = new StackPane();
    Scene scene1 = new Scene(layout, 600, 600);


    Stage secondStage = new Stage();
    StackPane stackPane2 = new StackPane();
    Scene scene2 = new Scene(stackPane2, 800, 700);

    @Override
    public void start(Stage primaryStage) throws Exception {

        stackPane2.getChildren().add(button3);

        secondStage.setTitle("Drugi prozor");
        secondStage.setScene(scene2);
        secondStage.show();


        primaryStage.setTitle("MyFx");

        button1.layoutXProperty().setValue(33);

        layout.getChildren().add( button1);
        layout.getChildren().add( button2);



        primaryStage.setScene(scene1);
        primaryStage.show();

    }

    public static void main(String[] args){
        Application.launch();
        // ili samo launch();
    }
}
