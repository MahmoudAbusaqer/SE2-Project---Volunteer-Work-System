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

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class CreateInitiativeScreen implements Initializable {

    private CreateInitiative model;
    private CreateInitiativeManager controller;
    static Student student;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new CreateInitiativeManager(model);
        this.model = new CreateInitiative();
        fillFields();
    }
//    public CreateInitiativeScreen(CreateInitiative model) {
//        this.model = model;
//    }

//    public void setController(CreateInitiativeManager controller) {
//        this.controller = controller;
//    }
    public void CreateInitiativeInput(int studentId, String name, String location, String description, int phone, int numberOfVolunteers) {
        controller.CreateInitiativeInput(studentId, name, location, description, phone, numberOfVolunteers);
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        CreateInitiativeScreen.student = student;
    }

    public void fillFields() {
        TextFieldStudentId.setText(String.valueOf(student.getId()));
        TextFieldStudentName.setText(student.getName());
        TextFieldStudentPhone.setText(String.valueOf(student.getPhone()));
//        System.out.println(Integer.parseInt(TextFieldStudentId.getText()));
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
    private TextField TextFieldStudentName;

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
    void buttonSubmit(ActionEvent event) {
        CreateInitiativeInput(student.getId(), student.getName(), TextFieldInitiativeAddress.getText(), TextAreaIntitativeDescription.getText(), Integer.parseInt(TextFieldaNumbersOfVolunteers.getText()), Integer.parseInt(TextFieldStudentPhone.getText()));
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
