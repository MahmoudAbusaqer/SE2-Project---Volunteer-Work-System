/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StatisticManagerInstitution;
import Model.StatisticsInstitution;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class StatisticsScreenInstitution {

    private StatisticsInstitution model;
    private StatisticManagerInstitution controller;

    public StatisticsScreenInstitution(StatisticsInstitution model) {
        this.model = model;
    }

    public void setController(StatisticManagerInstitution controller) {
        this.controller = controller;
    }

    public void showStatistics(int institutionId) throws SQLException {
        List<StatisticsInstitution> statisticsInstitutions = new ArrayList<>();
        statisticsInstitutions = controller.showStatistics(institutionId);
        int index = 0;
        while (!statisticsInstitutions.isEmpty()) {//I think this does not need while
            model = statisticsInstitutions.get(index);
            //here need to match every GUI field with the model.get
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
    void ButtonExit(ActionEvent event) {

    }

    @FXML
    void buttonInstitutionMailBox(ActionEvent event) {

    }

    @FXML
    void buttonNewVolunteers(ActionEvent event) {

    }

    @FXML
    void buttonReportPage(ActionEvent event) {

    }

}
