package mypackage;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Created by Oliver on 14.1.2016..
 */
public class FileMenuDemo extends Application {

    @Override
    public void start(Stage window) throws Exception {
        //Layout
        BorderPane borderPane = new BorderPane();

        //File Menu
        Menu fileMenu = new Menu("File");

        //File Menu items
        //item with click
        MenuItem newext = new MenuItem("New Text");
        newext.setOnAction(e -> System.out.println("New text button clicked"));
        fileMenu.getItems().add(newext);
        //disabled item
        MenuItem newMOdule = new MenuItem("New Module...");
        newMOdule.setDisable(true);
        fileMenu.getItems().add(newMOdule);
        //regular items
        fileMenu.getItems().add(new MenuItem("New Projecto..."));
        //separator
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Import Project..."));
        fileMenu.getItems().add(new SeparatorMenuItem());
        fileMenu.getItems().add(new MenuItem("Export Project"));

        //Edit menu
        Menu editMenu = new Menu("_Edit");
        //Edit menu Items
        editMenu.getItems().addAll(new MenuItem("Cut.."), new MenuItem("Copy"), new MenuItem("Paste"));

        //SubMenu
        Menu submenu = new Menu("_Copy to...");
        //Sub menu items
        submenu.getItems().addAll(new MenuItem("Bla bla"), new MenuItem("Bla bla 2"), new MenuItem("Bla bla3"));

        //View Menu
        Menu viewMenu = new Menu("View");
        MenuItem[] viewMenuItems = {new MenuItem("Find"), submenu, new MenuItem("Replace")};
        //View Menu Items
        viewMenu.getItems().addAll(viewMenuItems);

        //Radio Menu
        Menu dificulty = new Menu("Dificulty");

        ToggleGroup dificultyToggle = new ToggleGroup();

        RadioMenuItem hard = new RadioMenuItem("Hard");
        RadioMenuItem easy = new RadioMenuItem("Easy");
        RadioMenuItem midd = new RadioMenuItem("Midd");

        easy.setToggleGroup(dificultyToggle);
        midd.setToggleGroup(dificultyToggle);
        hard.setToggleGroup(dificultyToggle);

        midd.setSelected(true);


        dificulty.getItems().addAll(easy,midd,hard);

        //Help menu
        Menu helpMenu = new Menu("Help");
        //CheckMenu...like checkbox
        CheckMenuItem lineNumbers = new CheckMenuItem("Show Line Numbers");
        lineNumbers.setOnAction(event -> {
            if (lineNumbers.isSelected()) {
                System.out.println("Show line numbers");
            } else {
                System.out.println("Do not show line numbers");
            }
        });
        CheckMenuItem autoSave = new CheckMenuItem("Enable Auto Save");
        autoSave.setSelected(true);
        //add menu items to help menu
        helpMenu.getItems().addAll(lineNumbers, autoSave);

        //Assign Menu to Menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu, editMenu, viewMenu, dificulty, helpMenu);

        //Assign menu to border pane
        borderPane.setTop(menuBar);

        //Create Scene
        Scene scene = new Scene(borderPane, 500, 300);

        //Assign scene to window and show
        window.setTitle("Menu Demo");
        window.setScene(scene);
        window.show();


    }
}
