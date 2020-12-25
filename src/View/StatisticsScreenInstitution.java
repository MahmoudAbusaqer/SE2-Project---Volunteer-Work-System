/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StatisticManagerInstitution;
import Model.StatisticsInstitution;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class StatisticsScreenInstitution implements Initializable {

    private StatisticsInstitution model;
    private StatisticManagerInstitution controller;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new StatisticManagerInstitution(model);
        try {
            showStatistics(model.getInstitutionId()/*Institution id from login*/);
        } catch (SQLException ex) {
            Logger.getLogger(StatisticsScreenInstitution.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public StatisticsScreenInstitution(StatisticsInstitution model) {
//        this.model = model;
//    }
//
//    public void setController(StatisticManagerInstitution controller) {
//        this.controller = controller;
//    }
    public void showStatistics(int institutionId) throws SQLException {
        List<StatisticsInstitution> statisticsInstitutions = new ArrayList<>();
        statisticsInstitutions = controller.showStatistics(institutionId);
        int index = 0;
        while (!statisticsInstitutions.isEmpty()) {//I think this does not need while
            model = statisticsInstitutions.get(index);
            labelFinishedVolunteers.setText(String.valueOf(model.getStudentsFinishedNumbers()));
            labelNumbersOfVolunteers.setText(String.valueOf(model.getNumberOfAllStudents()));
            labelActiveVolunteers.setText(String.valueOf(model.getActiveVolunteers()));
            statisticsInstitutions.remove(index);
            index++;
        }
    }

    @FXML
    private Pane rootpane;

    @FXML
    private Button ButtonNewVolunteers;

    @FXML
    private Button ButtonReportPage;

    @FXML
    private Button ButtonInstitutionMailBox;

    @FXML
    private Button ExitButton;

    @FXML
    private Label labelNumbersOfVolunteers;

    @FXML
    private Label labelFinishedVolunteers;

    @FXML
    private Label labelActiveVolunteers;

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
    void buttonReportPage(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/ReportScreen.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void ButtonExit(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/MainPage/StartPage.fxml"));
        rootpane.getChildren().setAll(pane);
    }

}
