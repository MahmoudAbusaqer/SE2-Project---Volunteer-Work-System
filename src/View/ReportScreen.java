/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ReportManager;
import Model.Institutions;
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
public class ReportScreen implements Initializable, Create {

    private Report reportModel;
    private ReportManager controller;
    static Institutions institutions;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new ReportManager(reportModel);
        this.reportModel = new Report();
        TableColStudentId.setCellValueFactory(new PropertyValueFactory("id"));
        TableColStudentAddress.setCellValueFactory(new PropertyValueFactory("address"));
        TableColStudentEmail.setCellValueFactory(new PropertyValueFactory("email"));
        TableColStudentPhone.setCellValueFactory(new PropertyValueFactory("phone"));
        TableColStudentName.setCellValueFactory(new PropertyValueFactory("name"));
        fillFields();
        tableView.getSelectionModel().selectedItemProperty().addListener(listener -> selectStudent());
        try {
            showStudent(institutions.getId());
        } catch (SQLException ex) {
            Logger.getLogger(ReportScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void reportInput(int studentId, String studentName, int institutionId, String report) {
        controller.reportInput(studentId, studentName, institutionId, report);
        try {
            TextFieldInstitutionName.setText("");
            TextFieldReport.setText("");
            TextFieldInstitutionName.setText("");
            TextFieldStudentId.setText("");
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

    public void showStudent(int institutionId) throws SQLException {
        List<Student> students = new ArrayList<>();
        students = controller.showStudent(institutionId);
        tableView.getItems().setAll(students);
    }

    public void selectStudent() {
        Student student = tableView.getSelectionModel().getSelectedItem();
        TextFieldStudentId.setText(String.valueOf(student.getId()));
        TextFieldStudentName.setText(student.getName());
    }

    public static Institutions getInstitutions() {
        return institutions;
    }

    public static void setInstitutions(Institutions institutions) {
        ReportScreen.institutions = institutions;
    }

    public void fillFields() {
        TextFieldInstitutionName.setText(String.valueOf(institutions.getId()));

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
    @Override
    public void buttonSubmit(ActionEvent event) {
        reportInput(Integer.parseInt(TextFieldStudentId.getText()), TextFieldStudentName.getText(), Integer.parseInt(TextFieldInstitutionName.getText()), TextFieldReport.getText());
    }

    @FXML
    void buttonInstitutionMailBox(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/InstitutionMailBox.fxml"));
        rootpane.getChildren().setAll(pane);

    }

    @FXML
    void buttonNewVolunteers(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/ViewsNewVolunteers.fxml"));
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
