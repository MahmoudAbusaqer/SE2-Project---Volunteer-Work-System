/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ViewNewVolunteersManager;
import Model.ViewNewVolunteers;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class ViewNewVolunteersScreen {

    private ViewNewVolunteers model;
    private ViewNewVolunteersManager controller;

    @FXML
    private void initialize() throws SQLException {
        TableColAddress.setCellValueFactory(new PropertyValueFactory("address"));
        TableColFaculty.setCellValueFactory(new PropertyValueFactory("faculty"));
        TableColMail.setCellValueFactory(new PropertyValueFactory("email"));
        TableColPhone.setCellValueFactory(new PropertyValueFactory("phone"));
        TableColStudent.setCellValueFactory(new PropertyValueFactory("name"));
        showNewVolunteers(model.getInstitutionId()/*Institution id from login*/);
    }

    public ViewNewVolunteersScreen(ViewNewVolunteers model) {
        this.model = model;
    }

    public void setController(ViewNewVolunteersManager controller) {
        this.controller = controller;
    }

    public void showNewVolunteers(int institutionId) throws SQLException {
        List<ViewNewVolunteers> newVolunteerses = new ArrayList<>();
        newVolunteerses = controller.showNewVolunteers(institutionId);
        int index = 0;
        while (!newVolunteerses.isEmpty()) {
            model = newVolunteerses.get(index);
            TableView.getItems().setAll(newVolunteerses);
            newVolunteerses.remove(index);
            index++;
        }
    }

    @FXML
    private Pane rootpane;

    @FXML
    private Button ButtonStatisticsInstitution;

    @FXML
    private Button ButtonAddReportPage;

    @FXML
    private Button ButtonInstitutionMailBox;

    @FXML
    private Button ExitButton;

    @FXML
    private TableView<ViewNewVolunteers> TableView;

    @FXML
    private TableColumn<ViewNewVolunteers, Integer> TableColPhone;

    @FXML
    private TableColumn<ViewNewVolunteers, String> TableColMail;

    @FXML
    private TableColumn<ViewNewVolunteers, String> TableColAddress;

    @FXML
    private TableColumn<ViewNewVolunteers, String> TableColFaculty;

    @FXML
    private TableColumn<ViewNewVolunteers, String> TableColStudent;

    @FXML
    void buttonAddReportPage(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/ReportScreen.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void buttonInstitutionMailBox(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/InstitutionMailBox.fxml"));
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
