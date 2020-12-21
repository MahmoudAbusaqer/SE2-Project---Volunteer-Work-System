/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ReportManager;
import Model.Report;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class ReportScreen {

    private Report model;
    private ReportManager controller;

    public ReportScreen(Report model) {
        this.model = model;
    }

    public void setController(ReportManager controller) {
        this.controller = controller;
    }

    public void reportInput(int studentId, String studentName, String institutionName, String report) {
        controller.reportInput(studentId, studentName, institutionName, report);//need edit
    }

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

    }


        @FXML
        void buttonInstitutionMailBox(ActionEvent event) throws IOException {
            Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/MailBoxTest.fxml"));
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
