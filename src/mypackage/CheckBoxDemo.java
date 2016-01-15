package mypackage;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Oliver on 9.1.2016..
 */
public class CheckBoxDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //Stage
        Stage window = primaryStage;

        //CheckBoxes
        CheckBox chkBox1 = new CheckBox("Bacon");
        CheckBox chkBox2 = new CheckBox("Tuna");
        chkBox1.setSelected(true);


        //Button
        Button orderButton = new Button("Order");
        orderButton.setOnAction(e -> handleOptions(chkBox1, chkBox2));

        //Layouut
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(chkBox1, chkBox2, orderButton);


        //Scene
        Scene scene = new Scene(layout, 300, 300);

        //Window
        window.setTitle("CheckboxDemo");
        window.setScene(scene);
        window.show();

    }

    //Handle CheckBoxes Options
    private void handleOptions(CheckBox chkBox1, CheckBox chkBox2) {

        //Order
        String order = "Customer order:\n";

        if (chkBox1.isSelected()) {
            order += " -v" + chkBox1.getText() + "\n";
        }

        if (chkBox2.isSelected()) {
            order += " -v" + chkBox2.getText() + "\n";
        }

        System.out.println(order);

    }
}
