package ch.fhnw.oop2.tasky.part4.ui;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Tasky_GUI extends Application {

    public static final double width =  900;
    public static final double height = 600;


    @Override public void init() {}


    @Override public void start(Stage primaryStage) {
        Parent rootPanel = new ApplicationUI();

        Scene scene = new Scene(rootPanel);
        primaryStage.setScene(scene);
        primaryStage.setTitle("OOP2: Tasky GUI ");
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
        primaryStage.centerOnScreen();
        primaryStage.show();

    }

    @Override public void stop() {}

    public static void main(String[] args) {
        Application.launch(args);
    }

}
