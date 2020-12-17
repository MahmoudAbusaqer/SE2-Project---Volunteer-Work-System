/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StatisticManagerDoV;
import Model.StatisticsDoV;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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

    public void showStatistics() {
        controller.showStatistics();
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
    private TableView<?> tableView;

    @FXML
    private TableColumn<?, ?> tableColActiveInitiatives;

    @FXML
    private TableColumn<?, ?> tableColActiveVolunteers;

    @FXML
    private TableColumn<?, ?> tableColInitiatives;

    @FXML
    private TableColumn<?, ?> tableColFinishedVolunteersNumbers;

    @FXML
    private TableColumn<?, ?> tableColInstitutionsNumbers;

    @FXML
    private TableColumn<?, ?> tableColVolunteersNumbers;

    @FXML
    void ButtonExit(ActionEvent event) {

    }

    @FXML
    void buttonAddNewsPage(ActionEvent event) {

    }

    @FXML
    void buttonDOVMailBox(ActionEvent event) {

    }

    @FXML
    void buttonMainPage(ActionEvent event) {

    }

}
