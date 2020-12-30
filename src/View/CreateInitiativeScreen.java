/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CreateInitiativeManager;
import Model.CreateInitiative;
import Model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class CreateInitiativeScreen implements Initializable, Create {
    
    private CreateInitiative model;
    private CreateInitiativeManager controller;
    static Student student;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new CreateInitiativeManager(model);
        this.model = new CreateInitiative();
        fillFields();
    }
    
    public void CreateInitiativeInput(int studentId, String name, String location, String description, int phone, int numberOfVolunteers, String studentName) {
        controller.CreateInitiativeInput(studentId, name, location, description, phone, numberOfVolunteers, studentName);
        try {
            TextFieldStudentId.setText("");
            TextFieldInitiativeName.setText("");
            TextFieldStudentPhone.setText("");
            TextFieldInitiativeAddress.setText("");
            TextFieldaNumbersOfVolunteers.setText("");
            TextAreaIntitativeDescription.setText("");
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("process succeeded");
            alert.setContentText("You can continue now, you will be notified when the DOV respond 😄");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Try again later");
            alert.showAndWait();
        }
    }
    
    public static Student getStudent() {
        return student;
    }
    
    public static void setStudent(Student student) {
        CreateInitiativeScreen.student = student;
    }
    
    public void fillFields() {
        TextFieldStudentId.setText(String.valueOf(student.getId()));
        TextFieldStudentPhone.setText(String.valueOf(student.getPhone()));
    }
    
    @FXML
    private Pane rootpane;
    
    @FXML
    private Button ButtonMainPage;
    
    @FXML
    private Button ButtonApplyVolunteerPage;
    
    @FXML
    private Button ButtonAddInstitutionPage;
    
    @FXML
    private Button ButtonStudentMailBox;
    
    @FXML
    private Button ExitButton;
    
    @FXML
    private TextField TextFieldStudentId;
    
    @FXML
    private TextField TextFieldInitiativeName;
    
    @FXML
    private TextField TextFieldStudentPhone;
    
    @FXML
    private TextField TextFieldInitiativeAddress;
    
    @FXML
    private TextField TextFieldaNumbersOfVolunteers;
    
    @FXML
    private TextArea TextAreaIntitativeDescription;
    
    @FXML
    private Button ButtonSubmit;
    
    @FXML
    @Override
    public void buttonSubmit(ActionEvent event) {
        CreateInitiativeInput(student.getId(), TextFieldInitiativeName.getText(), TextFieldInitiativeAddress.getText(), TextAreaIntitativeDescription.getText(), Integer.parseInt(TextFieldaNumbersOfVolunteers.getText()), Integer.parseInt(TextFieldStudentPhone.getText()), student.getName());
    }
    
    @FXML
    void buttonMainPage(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/StudentGUI/MainPage.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    
    @FXML
    void buttonAddInstitutionPage(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/StudentGUI/AddInstitutionScreen.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    
    @FXML
    void buttonApplyVolunteerPage(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/StudentGUI/InstitutionScreen.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    
    @FXML
    void buttonStudentMailBox(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/StudentGUI/StudentMailBox.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    
    @FXML
    void ButtonExit(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/MainPage/StartPage.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    
}
