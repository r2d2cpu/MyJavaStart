package mypackage;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by Oliver on 30.12.2015..
 */
public class MyFxtest1 extends Application{
    Stage window;
    @Override
    public void start(Stage window){
        this.window = window;
        StackPane pane = new StackPane();
        Scene scene = new Scene(pane,600,300);
        Button button = new Button("Close");
        window.setOnCloseRequest(e -> {
            e.consume();
            saveGameAndExit();
        });
        button.setOnAction(e -> saveGameAndExit());
        pane.getChildren().add(button);

        window.setScene(scene);
        window.setTitle("Window");
        window.show();
    }

    private void saveGameAndExit() {
        if(ConfirmBox.display("Title","Save before exit?")){
            System.out.print("Game Saved!");
            //window.close();
            Platform.exit();// platform i system u potpunosti zatvaraju cijelu aplikaciju a ne samo prozor.
            System.exit(0);
        }
    }


}
