/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.RequestManager;
import Model.District;
import Model.Institutions;
import Model.RequestVolunteer;
import Model.Student;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.Pane;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class RequestScreen implements Initializable {

    private District districtModel;
    private Institutions institutionsModel;
    private RequestVolunteer requestVolunteerModel;
    private RequestManager controller;
    private StartPagePanes startPagePanes = new StartPagePanes();
//    private int studentId;
    static Student student;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new RequestManager(requestVolunteerModel);
        this.requestVolunteerModel = new RequestVolunteer();
        this.districtModel = new District();
        this.institutionsModel = new Institutions();
//        student =;
//        studentId = startPagePanes.getStudentId();
//        System.out.println(student.getName());
//        student = startPagePanes.getStudent();
//        System.out.println(student.getName());
        TableColName.setCellValueFactory(new PropertyValueFactory("name"));
        TableColAddress.setCellValueFactory(new PropertyValueFactory("address"));
        TableColEmail.setCellValueFactory(new PropertyValueFactory("email"));
        TableColPhone.setCellValueFactory(new PropertyValueFactory("phone"));
        TableColDistrict.setCellValueFactory(new PropertyValueFactory("district"));
        TableView.getSelectionModel().selectedItemProperty().addListener(listener -> selectInstitution());
        try {
            showDistrict();
//            showStudent(student);
            fillFields();
//            System.out.println(ChoiceBoxDistrict.getValue());
//            showInstitutions(ChoiceBoxDistrict.getValue());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

//    public RequestScreen(Student student) {
//        this.student = student;
//    }
//    public RequestScreen(RequestVolunteer requestVolunteerModel) {
//        this.requestVolunteerModel = requestVolunteerModel;
//        this.districtModel = new District();
//        this.institutionsModel = new Institutions();
//    }
//    public void setController(RequestManager controller) {
//        this.controller = controller;
//    }
    public void showDistrict() throws SQLException {
//        List<District> districts = new ArrayList<>();
        List<String> districtsNames = new ArrayList<>();
//        System.out.println(districts = controller.showDistrict());
        districtsNames = controller.showDistrict();
//        ChoiceBoxDistrict.setItems(districtsNames);
//        for (int i = 0; i < districtsNames.size(); i++) {
//            District districtObject = new District();
//            districtObject = districts.get(i);
//            districtsNames.add(districtObject.getName());
//            ChoiceBoxDistrict.setItems(districtObject.getName());
//            districts.remove(i);
//        }
//        int index = districts.size();
//        while (!districts.isEmpty() || index > districts.size()) {
//            districtModel = districts.get(index);
//            districtsNames.add(districtModel.getName());
//            districts.remove(index);
//            index--;
//        }
        ObservableList<String> observableList = FXCollections.observableArrayList(districtsNames);
//        ChoiceBoxDistrict.setItems((ObservableList<String>) districtsNames);
        ChoiceBoxDistrict.setItems(observableList);
    }

    public void showInstitutions(String district) throws SQLException {
        List<Institutions> institutionses = new ArrayList<>();
        institutionses = controller.showInstitutions(district);
        System.out.println(institutionses.size());
//        for (int i = 0; i < institutionses.size(); i++) {
//            System.out.println(institutionses.get(i) + " i: " + i);
//            Institutions institutions = new Institutions();
//            institutions = institutionses.get(i);
        TableView.getItems().setAll(institutionses);
//        }
//        int index = 0;
//        while (!institutionses.isEmpty()) {
//            institutionsModel = institutionses.get(index);
//            TableView.getItems().setAll(institutionses);
////            institutionses.remove(index);
//            index++;
//        }
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        RequestScreen.student = student;
    }

//    public void showStudent(Student newstudent) {
////        newstudent = getStudent();
//        setStudent(newstudent);
//        System.out.println(newstudent.getName());
//    }

    public void fillFields() {
        TextFieldStudentId.setText(String.valueOf(student.getId()));
        TextFieldStudentName.setText(student.getName());
        System.out.println(Integer.parseInt(TextFieldStudentId.getText()));
    }

    public void requestVlounteer(int studentId, String studentName, int institutionId, String institutionName, String district, String address) {
        controller.requestVlounteer(studentId, studentName, institutionId, institutionName, district, address);
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
    void buttonSubmit(ActionEvent event) {
        requestVlounteer(student.getId(), student.getName(),
                Integer.parseInt(TextFieldInstitutionId.getText()), TextFieldInstitutionName.getText(),
                ChoiceBoxDistrict.getValue(), /*student address from student id*/ student.getAddress());//need edit
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
//        System.out.println(ChoiceBoxDistrict.getValue());
        showInstitutions(ChoiceBoxDistrict.getValue());
    }

}
