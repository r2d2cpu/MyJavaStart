package mypackage;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Oliver on 10.1.2016..
 */
public class ListViewDemo extends Application {

    Button button;
    Scene scene;
    ListView<String> listView = new ListView<>();

    @Override
    public void start(Stage window) {

         //listview
        listView.getItems().addAll("Iron Man", "Titanic", "Contact", "Surrogates");
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        //Button
        button = new Button("Submit");
        button.setOnAction(e -> printSelectedMovies());

        //Vbox
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(listView, button);

        //Set scene
        scene = new Scene(layout, 300, 300);

        //Set window
        window.setScene(scene);
        window.setTitle("List view");
        window.show();
    }

    //Print out the selected movies
    private void printSelectedMovies() {
        String message = "";
        ObservableList<String> movies = listView.getSelectionModel().getSelectedItems();

        for (String movie : movies) {
            message += movie + ", ";
        }

        System.out.println("Selected movies = " +  message);
    }
}
