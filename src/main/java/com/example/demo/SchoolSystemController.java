package com.example.demo;

import Exceptions.SchoolSystemException;
import Model.School;
import Model.Student;
import Model.Teacher;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.demo.SchoolSystemApp.school;

public class SchoolSystemController {
    @FXML
    private PasswordField passwordTextField;

    @FXML
    private TextField loginTextField;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label errorText;

    @FXML
    protected void onLoginButtonClick(ActionEvent event) {
        try {
           User user = school.loginUser(loginTextField.getText(), passwordTextField.getText());
           if(user instanceof Teacher) {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("teacher-view.fxml"));
               root = loader.load();
               TeacherViewController teacherViewController = loader.getController();
               teacherViewController.displayUserName(user);
               stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

               scene = new Scene(root);

               stage.setScene(scene);

               stage.show();
           }
           else if(user instanceof Student)
           {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("student-view.fxml"));
               root = loader.load();
               StudentViewController studentViewController = loader.getController();
               studentViewController.displayUserName(user);
               stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

               scene = new Scene(root);

               stage.setScene(scene);

               stage.show();
           }
        }catch (SchoolSystemException| IOException e)
        {
            errorText.setText(e.getMessage());
        }
    }
}