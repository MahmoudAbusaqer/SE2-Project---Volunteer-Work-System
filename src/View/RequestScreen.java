/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.RequestManager;
import Model.Institutions;
import Model.RequestVolunteer;
import Model.Student;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
;
import javafx.scene.input.KeyEvent;
;
import javafx.scene.layout.Pane;

/**
 *
 * @author Mahmoud_Abusaqer
 */


public class RequestScreen implements Initializable, Create {

    private RequestVolunteer requestVolunteerModel;
    private RequestManager controller;
    private StartPagePanes startPagePanes = new StartPagePanes();
    static Student student;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new RequestManager(requestVolunteerModel);
        this.requestVolunteerModel = new RequestVolunteer();
        TableColInstitutionId.setCellValueFactory(new PropertyValueFactory("id"));
        TableColName.setCellValueFactory(new PropertyValueFactory("name"));
        TableColAddress.setCellValueFactory(new PropertyValueFactory("address"));
        TableColEmail.setCellValueFactory(new PropertyValueFactory("email"));
        TableColPhone.setCellValueFactory(new PropertyValueFactory("phone"));
        TableColDistrict.setCellValueFactory(new PropertyValueFactory("district"));
        TableView.getSelectionModel().selectedItemProperty().addListener(listener -> selectInstitution());
        try {
            showDistrict();
            fillFields();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public void showDistrict() throws SQLException {
        List<String> districtsNames = new ArrayList<>();
        districtsNames = controller.showDistrict();
        ObservableList<String> observableList = FXCollections.observableArrayList(districtsNames);
        ChoiceBoxDistrict.setItems(observableList);
    }

    public void showInstitutions(String district) throws SQLException {
        List<Institutions> institutionses = new ArrayList<>();
        institutionses = controller.showInstitutions(district);
        TableView.getItems().setAll(institutionses);
    }

    public static Student getStudent() {
        return student;
    }

    public static void setStudent(Student student) {
        RequestScreen.student = student;
    }

    public void fillFields() {
        TextFieldStudentId.setText(String.valueOf(student.getId()));
        TextFieldStudentName.setText(student.getName());
    }

    public void requestVlounteer(int studentId, String studentName, int institutionId, String institutionName, String district, String address) {
        controller.requestVlounteer(studentId, studentName, institutionId, institutionName, district, address);
        try {
            TextFieldInstitutionName.setText("");
            TextFieldStudentId.setText("");
            TextFieldInstitutionId.setText("");
            TextFieldInstitutionName.setText("");
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

    public void selectInstitution() {
        Institutions institution = TableView.getSelectionModel().getSelectedItem();
        TextFieldInstitutionId.setText(String.valueOf(institution.getId()));
        TextFieldInstitutionName.setText(institution.getName());
    }

    @FXML
    private Pane rootpane;

    @FXML
    private Button ButtonMainPage;

    @FXML
    private Button ButtonAddInstitutionPage;

    @FXML
    private Button ButtonCreateIntitivePage;

    @FXML
    private Button ButtonStudentMailBox;

    @FXML
    private Button ExitButton;

    @FXML
    private TextField TextFieldStudentId;

    @FXML
    private TextField TextFieldStudentName;

    @FXML
    private TextField TextFieldInstitutionId;

    @FXML
    private TextField TextFieldInstitutionName;

    @FXML
    private Button ButtonSubmit;

    @FXML
    private TableView<Institutions> TableView;

    @FXML
    private TableColumn<Institutions, Integer> TableColInstitutionId;

    @FXML
    private TableColumn<Institutions, String> TableColName;

    @FXML
    private TableColumn<Institutions, String> TableColAddress;

    @FXML
    private TableColumn<Institutions, String> TableColEmail;

    @FXML
    private TableColumn<Institutions, Integer> TableColPhone;

    @FXML
    private TableColumn<Institutions, String> TableColDistrict;

    @FXML
    private ChoiceBox<String> ChoiceBoxDistrict;

    @FXML
    @Override
    public void buttonSubmit(ActionEvent event) {
        requestVlounteer(student.getId(), student.getName(),
                Integer.parseInt(TextFieldInstitutionId.getText()), TextFieldInstitutionName.getText(),
                ChoiceBoxDistrict.getValue(), student.getAddress());
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
    void buttonCreateIntitivePage(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/StudentGUI/AddInitiative.fxml"));
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

    @FXML
    private void ChoiceBoxHandle(KeyEvent event) throws SQLException {
        showInstitutions(ChoiceBoxDistrict.getValue());
    }

}
