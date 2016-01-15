package mypackage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Created by Oliver on 9.1.2016..
 */
public class GridPaneDemo extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage window = primaryStage;
        window.setTitle("Grid Pane Demo");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);
        Button button = new Button("dddd");
        button.setAlignment(Pos.CENTER_LEFT);

        //Name label
        Label nameLabel = new Label("Username: ");
        GridPane.setConstraints(nameLabel, 0, 0);

        //Name input
        TextField nameInput = new TextField();
        GridPane.setConstraints(nameInput, 1, 0);

        //Password label
        Label passwordLabel = new Label("Password: ");
        GridPane.setConstraints(passwordLabel, 0, 1);

        //Password input
        TextField passwordInput = new TextField();
        passwordInput.setPromptText("password");
        GridPane.setConstraints(passwordInput, 1, 1);

        //Login Button
        Button loginButton = new Button("Log In");
        GridPane.setConstraints(loginButton, 1, 3);

        grid.getChildren().addAll(nameLabel, nameInput, passwordLabel, passwordInput, loginButton);

        Scene scene = new Scene(grid, 300, 200);

        window.setScene(scene);
        window.show();


    }
}