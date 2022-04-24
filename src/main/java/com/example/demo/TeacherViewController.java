package com.example.demo;
import Exceptions.SchoolSystemException;
import Model.*;
import Model.Class;
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
import java.util.Objects;

import static com.example.demo.SchoolSystemApp.school;
/**
 * @author Julia Merta
 * @version %I%, %G%
 */

public class TeacherViewController {
    @FXML
    private Button logoutButton;
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
    private TableColumn classColumn;
    @FXML
    private TableColumn studentColumn;
    @FXML
    private Button gradeButton;
    @FXML
    private ComboBox gradeCombobox;
    @FXML
    private ComboBox subjectCombobox;
    @FXML
    private ComboBox studentCombobox;
    @FXML
    private ComboBox classCombobox;

    private Stage stage;
    private Scene scene;
    private Parent root;
    private Teacher teacher;
    private ObservableList<Grade> grades;
    private ObservableList<Subject> subjects;
    private ObservableList<Class> classes;
    private ObservableList<Student>students;


@FXML
private Label errorLabel2;

    @FXML
    protected void onSubjectChosen()
    {
        this.classCombobox.setDisable(false);
        classes=FXCollections.observableArrayList(school.getClasses());
        this.classCombobox.setItems(classes);


    }

    @FXML
    protected void onClassChosen()
    {
        if(this.classCombobox.getValue()!=null)
        {
            Class a = (Class) classCombobox.getValue();
            this.studentCombobox.setDisable(false);
            students = FXCollections.observableArrayList(a.getStudents());
            this.studentCombobox.setItems(students);
        }

    }

    @FXML
    protected void onGradeButtonClick()
    {
        try {
            Grade newGrade = new Grade((Integer) gradeCombobox.getValue(), (Subject) subjectCombobox.getValue(), teacher, (Student) studentCombobox.getValue(), (Class)classCombobox.getValue());
            school.addGrade(newGrade, (Class) classCombobox.getValue());
            this.errorLabel2.setText("Ocena została dodana!");
            grades.add(newGrade);

            school.returnGradesByTeacher(teacher);

            grades=FXCollections.observableArrayList( school.returnGradesByTeacher(teacher));

            tableView.setItems(grades);
            gradeColumn.setCellValueFactory(
                    new PropertyValueFactory<Grade,String>("value")
            );
            subjectColumn.setCellValueFactory(
                    new PropertyValueFactory<Grade,String>("subject")
            );
            studentColumn.setCellValueFactory(
                    new PropertyValueFactory<Grade,String>("student")
            );
            classColumn.setCellValueFactory(
                    new PropertyValueFactory<Grade,String>("class_")
            );




        }catch (NullPointerException e)
        {
            this.errorLabel2.setText("Proszę wypełnić wszystkie pola!");
        }
    }

    @FXML
    protected void displayUserName(User user)
    {
        this.userNameText.setText(user.getName());
        this.userSurnameText.setText(user.getSurname());
        this.userLoginText.setText(user.getLogin());
        this.teacher=(Teacher) user;
        subjects= FXCollections.observableArrayList(teacher.getSubjects());
        this.subjectCombobox.setItems(subjects);
        this.gradeCombobox.getItems().addAll(1,2,3,4,5,6);
        this.gradeCombobox.setDisable(false);

        school.returnGradesByTeacher(teacher);


        grades=FXCollections.observableArrayList( school.returnGradesByTeacher(teacher));

        tableView.setItems(grades);
        gradeColumn.setCellValueFactory(
                new PropertyValueFactory<Grade,String>("value")
        );
        subjectColumn.setCellValueFactory(
                new PropertyValueFactory<Grade,String>("subject")
        );
        studentColumn.setCellValueFactory(
                new PropertyValueFactory<Grade,String>("student")
        );
        classColumn.setCellValueFactory(
                new PropertyValueFactory<Grade,String>("class_")
        );
    }

    @FXML
    protected void onLogOutButtonClick(ActionEvent event)
    {
        try {
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
        if(teacher.getPassword().equals(this.oldPasswordField.getText()))
        {
            if(this.newPasswordField.getText().equals(this.newPasswordField2.getText()))
            {
                if(newPasswordField.getText().equals(oldPasswordField.getText()))
                {
                    this.errorLabel.setText("Stare i nowe hasło są identyczne!");
                }else{
                try {
                    this.teacher.setPassword(newPasswordField.getText());
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
