/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ViewNewVolunteersManager;
import Model.Institutions;
import Model.ViewNewVolunteers;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class ViewNewVolunteersScreen implements Initializable {

    private ViewNewVolunteers model;
    private ViewNewVolunteersManager controller;
    private StartPagePanes startPagePanes;
    static Institutions institutions;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new ViewNewVolunteersManager(model);
//        institutions = startPagePanes.getInstitutions();
        TableColAddress.setCellValueFactory(new PropertyValueFactory("address"));
        TableColFaculty.setCellValueFactory(new PropertyValueFactory("faculty"));
        TableColMail.setCellValueFactory(new PropertyValueFactory("email"));
        TableColPhone.setCellValueFactory(new PropertyValueFactory("phone"));
        TableColStudent.setCellValueFactory(new PropertyValueFactory("name"));
        try {
            showNewVolunteers(institutions.getId());
        } catch (SQLException ex) {
            Logger.getLogger(ViewNewVolunteersScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public ViewNewVolunteersScreen(ViewNewVolunteers model) {
//        this.model = model;
//    }
//
//    public void setController(ViewNewVolunteersManager controller) {
//        this.controller = controller;
//    }
    public void showNewVolunteers(int institutionId) throws SQLException {
        List<ViewNewVolunteers> newVolunteerses = new ArrayList<>();
        newVolunteerses = controller.showNewVolunteers(institutionId);
        TableView.getItems().setAll(newVolunteerses);
//        int index = 0;
//        while (!newVolunteerses.isEmpty()) {
//            model = newVolunteerses.get(index);
//            TableView.getItems().setAll(newVolunteerses);
//            newVolunteerses.remove(index);
//            index++;
//        }
    }

    public static Institutions getInstitutions() {
        return institutions;
    }

    public static void setInstitutions(Institutions institutions) {
        ViewNewVolunteersScreen.institutions = institutions;
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
