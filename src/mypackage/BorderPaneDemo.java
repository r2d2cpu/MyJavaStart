package mypackage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class BorderPaneDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        BorderPane borderPane = new BorderPane();

        HBox topMenu = new HBox();
        Button button1 = new Button("File");
        Button button2 = new Button("Edit");
        Button button3 = new Button("View");

        VBox leftMenu = new VBox();
        Button button4 = new Button("Button");
        Button button5 = new Button("Button");
        Button button6 = new Button("Button");

        topMenu.getChildren().addAll(button1, button2, button3);
        leftMenu.getChildren().addAll(button4, button5, button6);

        borderPane.setTop(topMenu);
        borderPane.setLeft(leftMenu);

        Scene scene = new Scene(borderPane, 300, 300);
        window.setScene(scene);
        window.setTitle("Border Pane demo");
        window.show();
    }
}
