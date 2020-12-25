/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ReportManager;
import Model.Report;
import Model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class ReportScreen implements Initializable {

    private Report reportModel;
    private Student studentModel;
    private ReportManager controller;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new ReportManager(reportModel);
        this.reportModel = new Report();
        this.studentModel = new Student();
        TableColStudentId.setCellValueFactory(new PropertyValueFactory("id"));
        TableColStudentAddress.setCellValueFactory(new PropertyValueFactory("address"));
        TableColStudentEmail.setCellValueFactory(new PropertyValueFactory("email"));
        TableColStudentPhone.setCellValueFactory(new PropertyValueFactory("phone"));
        TableColStudentName.setCellValueFactory(new PropertyValueFactory("name"));
        tableView.getSelectionModel().selectedItemProperty().addListener(listener -> selectStudent());
        try {
            showStudent(1/*institutionId*/);
        } catch (SQLException ex) {
            Logger.getLogger(ReportScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public ReportScreen(Report reportModel) {
//        this.reportModel = reportModel;
//        this.studentModel = new Student();
//    }
//    public void setController(ReportManager controller) {
//        this.controller = controller;
//    }
    public void reportInput(int studentId, String studentName, String institutionName, String report) {
        controller.reportInput(studentId, studentName, institutionName, report);
    }

    public void showStudent(int institutionId) throws SQLException {
        List<Student> students = new ArrayList<>();
        students = controller.showStudent(institutionId);
        tableView.getItems().setAll(students);
//        int index = 0;
//        while (!students.isEmpty()) {
//            students.get(index);
//            tableView.getItems().setAll(students);
//            students.remove(index);
//            index++;
//        }
    }

    public void selectStudent() {
        Student student = tableView.getSelectionModel().getSelectedItem();
        TextFieldStudentId.setText(String.valueOf(student.getId()));
        TextFieldStudentName.setText(student.getName());
    }

    @FXML
    private TableView<Student> tableView;

    @FXML
    private TableColumn<Student, Integer> TableColStudentPhone;

    @FXML
    private TableColumn<Student, String> TableColStudentEmail;

    @FXML
    private TableColumn<Student, String> TableColStudentAddress;

    @FXML
    private TableColumn<Student, String> TableColStudentName;

    @FXML
    private TableColumn<Student, Integer> TableColStudentId;

    @FXML
    private Pane rootpane;

    @FXML
    private Button ButtonStatisticsInstitution;

    @FXML
    private Button ButtonNewVolunteers;

    @FXML
    private Button ButtonInstitutionMailBox;

    @FXML
    private Button ExitButton;

    @FXML
    private TextField TextFieldStudentName;

    @FXML
    private TextArea TextFieldReport;

    @FXML
    private TextField TextFieldInstitutionName;

    @FXML
    private TextField TextFieldStudentId;

    @FXML
    private Button ButtonSubmit;

    @FXML
    void buttonSubmit(ActionEvent event) {
        reportInput(Integer.parseInt(TextFieldStudentId.getText()), TextFieldStudentName.getText(), TextFieldInstitutionName.getText(), TextFieldReport.getText());
    }

    @FXML
    void buttonInstitutionMailBox(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/InstitutionMailBox.fxml"));
        rootpane.getChildren().setAll(pane);

    }

    @FXML
    void buttonNewVolunteers(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/ViewNewVolunteers.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void buttonStatisticsInstitution(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/StatisticsScreenInstitution.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void ButtonExit(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/MainPage/StartPage.fxml"));
        rootpane.getChildren().setAll(pane);
    }

}
