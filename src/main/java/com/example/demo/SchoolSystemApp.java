package com.example.demo;

import Model.School;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SchoolSystemApp extends Application {

    public static School school;

    @Override
    public void start(Stage stage) throws IOException {
        stage.getIcons().add(new Image("C:\\Users\\julia\\OneDrive\\Desktop\\Java\\Julia\\demo\\src\\main\\resources\\Images\\fav2.png"));
        FXMLLoader fxmlLoader = new FXMLLoader(SchoolSystemApp.class.getResource("system-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 873, 662);
        stage.setTitle("Dziennik elektroniczny");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        school= new School();
        school.createSampleSchool();
        launch();
    }
}