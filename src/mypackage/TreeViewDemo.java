package mypackage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TreeView;

/**
 * Created by Oliver on 10.1.2016..
 */
public class TreeViewDemo extends Application {


    Button button;
    TreeView<String> tree;

    @Override
    public void start(Stage window) {

        //TreeView
        TreeItem<String> root, stalloneMovies, arnoldMovies;

        //Root
        root = new TreeItem<>();
        root.setExpanded(true);

        //Branch1
        stalloneMovies = makeBranch("Stallone Movies", root);
        makeBranch("Rambo", stalloneMovies);
        makeBranch("Rocky 1", stalloneMovies);
        makeBranch("Rocky 2", stalloneMovies);

        //Branch2
        arnoldMovies = makeBranch("Arnold Movies", root);
        makeBranch("Terminator", arnoldMovies);
        makeBranch("Expendables ", arnoldMovies);
        makeBranch("Terminator 2", arnoldMovies);

        //ili ovako
        stalloneMovies.getChildren().add(new TreeItem<>("Rambo 6"));

        //Create tree
        tree = new TreeView<>(root);
        tree.setShowRoot(false);
        tree.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null)
                System.out.println("Selected movie = " + newValue.getValue());
        });

// Moje drvo Start

        //Create tree items
        TreeItem<String> deblo      = new TreeItem<>("Moj Tree View");
        //First branch
        TreeItem<String> prvaGrana  = new TreeItem<>("BLA");
                         prvaGrana.getChildren().add(new TreeItem<>("Bl222a bla"));
                         prvaGrana.getChildren().add(new TreeItem<>("Bl222a bwwwla"));
                         prvaGrana.getChildren().add(new TreeItem<>("Bla bla"));
                         prvaGrana.getChildren().add(new TreeItem<>("Bla blaw"));
                         prvaGrana.setExpanded(false);
        //Second branch
        TreeItem<String> drugaGrana = new TreeItem<>("BLA 2");
                         drugaGrana.getChildren().add(new TreeItem<>("Bl222a bla"));
                         drugaGrana.getChildren().add(new TreeItem<>("Bl222a bwwwla"));
                         drugaGrana.getChildren().add(new TreeItem<>("Bla bla"));
                         drugaGrana.getChildren().add(new TreeItem<>("Bla blaw"));
                         drugaGrana.setExpanded(true);
        //Add branches to the main root
        deblo.getChildren().addAll(prvaGrana, drugaGrana);
        //Create tree
        TreeView<String> drvo = new TreeView<>(deblo);
        drvo.setShowRoot(true);

// Moje drvo end

        //Vbox Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(tree, drvo);

        //Scene
        Scene scene = new Scene(layout, 500, 600);

        //Window
        window.setTitle("Simple Window");
        window.setScene(scene);
        window.show();


    }

    private TreeItem<String> makeBranch(String title, TreeItem<String> parent) {
        TreeItem<String> item = new TreeItem<>(title);
        item.setExpanded(true);
        parent.getChildren().add(item);
        return item;

    }

}
