package com.example.demo;

import Exceptions.SchoolSystemException;
import Model.Grade;
import Model.Student;
import Model.Teacher;
import Model.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.demo.SchoolSystemApp.school;

/**
 * @author Julia Merta
 * @version %I%, %G%
 */
public class StudentViewController {
    @FXML
    private Button logOutButton;

    @FXML
    private Label userNameText;

    @FXML
    private Label userSurnameText;
    @FXML
    private Label userLoginText;
    @FXML
    private PasswordField oldPasswordField;
    @FXML
    private PasswordField newPasswordField;
    @FXML
    private PasswordField newPasswordField2;
    @FXML
    private Button changePasswordButton;
    @FXML
    private Label errorLabel;

    @FXML
    private TableView tableView;
    @FXML
    private TableColumn gradeColumn;
    @FXML
    private TableColumn subjectColumn;
    @FXML
    private TableColumn teacherColumn;

    @FXML
    private Label classText;

    private Student student;
    private ObservableList<Grade> grades;

    private Stage stage;
    private Scene scene;
    private Parent root;

    public StudentViewController() {
    }

    @FXML
    protected void displayUserName(User user)
    {
        this.userNameText.setText(user.getName());
        this.userSurnameText.setText(user.getSurname());
        this.userLoginText.setText(user.getLogin());
        this.student=(Student) user;
        try {
            this.classText.setText(school.getStudentsClass(student));
        }catch (SchoolSystemException e)
        {
            errorLabel.setText("Nie odnaleziono studenta!");
        }
        grades= FXCollections.observableArrayList(student.getGrades());
        subjectColumn.setCellValueFactory(
                new PropertyValueFactory<Grade,String>("subject")
        );

        gradeColumn.setCellValueFactory(
                new PropertyValueFactory<Grade,String>("value")
        );
        teacherColumn.setCellValueFactory(
                new PropertyValueFactory<Grade,String>("teacher")
        );

        tableView.setItems(grades);
    }



    @FXML
    protected void onLogOutButtonClick(ActionEvent event)
    {try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("system-view.fxml"));
        root = loader.load();
        SchoolSystemController controller = loader.getController();
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();

        scene = new Scene(root);

        stage.setScene(scene);

        stage.show();
    }catch (IOException e){}
    }



    @FXML
    protected void onChangePasswordButtonClick()
    {
        if(student.getPassword().equals(this.oldPasswordField.getText()))
        {
            if(this.newPasswordField.getText().equals(this.newPasswordField2.getText()))
            {
                if(newPasswordField.getText().equals(oldPasswordField.getText()))
                {
                    this.errorLabel.setText("Stare i nowe hasło są identyczne!");
                }else{
                    try {
                        this.student.setPassword(newPasswordField.getText());
                        this.errorLabel.setText("Hasło zostało zmienione");
                    }catch (SchoolSystemException e){
                        this.errorLabel.setText(e.getMessage());
                    }}
            }
            else{
                this.errorLabel.setText("Hasła są różne!");
            }
        }
        else {
            this.errorLabel.setText("Hasło nie jest poprawne!");
        }
    }
}
