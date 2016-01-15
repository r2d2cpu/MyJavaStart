package mypackage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class MyFx7 extends Application {
    Stage window;
    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;

        Button button = new Button("Save and close");
        button.setOnAction(e -> closeProgram());

        StackPane pane = new StackPane();
        pane.getChildren().add(button);

        Scene scene = new Scene(pane, 400, 400);

        window.setOnCloseRequest(e -> {
            e.consume();// sprjecava automatsko zatvaranje programa nakon što odradi closeProgram
            closeProgram();
        });
        window.setScene(scene);
        window.setTitle("Close application");
        window.show();

    }

    private void closeProgram() {
        if(ConfirmBox.display("Title","Save before exit?")){
            System.out.print("Game Saved!");
            window.close();
           // Platform.exit(); platform i system u potpunosti zatvaraju cijelu aplikaciju a ne samo prozor.
           // System.exit(0);
        }
    }
}
