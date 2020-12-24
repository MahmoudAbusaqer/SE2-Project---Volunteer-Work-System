/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StatisticManagerDoV;
import Model.StatisticsDoV;
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
public class StatisticsScreenDoV implements Initializable {

    private StatisticsDoV model;
    private StatisticManagerDoV controller;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.model = new StatisticsDoV();
        try {
            showStatistics();
        } catch (SQLException ex) {
            Logger.getLogger(StatisticsScreenDoV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public StatisticsScreenDoV(StatisticsDoV model) {
//        this.model = model;
//    }
    public void setController(StatisticManagerDoV controller) {
        this.controller = controller;
    }

    public void showStatistics() throws SQLException {
        List<StatisticsDoV> statisticsDoVs = new ArrayList<>();
        statisticsDoVs = controller.showStatistics();
        int index = 0;
        while (!statisticsDoVs.isEmpty()) {//I think this does not need while
            model = statisticsDoVs.get(index);
            labelActiveInitiatives.setText(String.valueOf(model.getActiveInitiatives()));
            labelActiveVolunteers.setText(String.valueOf(model.getActiveVolunteers()));
            labelFinishedVolunteers.setText(String.valueOf(model.getFinishedVolunteersNumbers()));
            labelInitiativesNumber.setText(String.valueOf(model.getInitiatives()));
            labelInstitutionsNumbers.setText(String.valueOf(model.getInstitutionsNumbers()));
            labelNumbersOfVolunteers.setText(String.valueOf(model.getVolunteersNumbers()));
            statisticsDoVs.remove(index);
            index++;
        }
    }

    @FXML
    private Pane rootpane;

    @FXML
    private Button ButtonMainPage;

    @FXML
    private Button ButtonAddNewsPage;

    @FXML
    private Button ButtonDOVMailBox;

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
    void buttonMainPage(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/DOVGUI/StatisticsScreen.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void buttonAddNewsPage(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/DOVGUI/NewsAndAnnouncmentScreen.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void buttonDOVMailBox(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/DOVGUI/DOVMailBox.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void ButtonExit(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/MainPage/StartPage.fxml"));
        rootpane.getChildren().setAll(pane);
    }

}
