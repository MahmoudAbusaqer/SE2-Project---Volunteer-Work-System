/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StatisticManagerDoV;
import Model.StatisticsDoV;
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
public class StatisticsScreenDoV {

    private StatisticsDoV model;
    private StatisticManagerDoV controller;

    public StatisticsScreenDoV(StatisticsDoV model) {
        this.model = model;
    }

    public void setController(StatisticManagerDoV controller) {
        this.controller = controller;
    }

    public void showStatistics() throws SQLException {
        List<StatisticsDoV> statisticsDoVs = new ArrayList<>();
        statisticsDoVs = controller.showStatistics();
        int index = 0;
        while (!statisticsDoVs.isEmpty()) {
            model = statisticsDoVs.get(index);
            //here need to match every GUI field with the model.get
            statisticsDoVs.remove(index);
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
    private Label labelInitiativesNumber;

    @FXML
    private Label labelActiveInitiatives;

    @FXML
    private Label labelInstitutionsNumbers;

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
