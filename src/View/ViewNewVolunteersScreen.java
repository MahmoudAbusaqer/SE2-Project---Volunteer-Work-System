/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ViewNewVolunteersManager;
import Model.ViewNewVolunteers;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.Pane;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class ViewNewVolunteersScreen {

    private ViewNewVolunteers model;
    private ViewNewVolunteersManager controller;

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
            //here need to match every GUI field with the model.get
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
        private TableColumn<?, ?> TableColPhone;

        @FXML
        private TableColumn<?, ?> TableColMail;

        @FXML
        private TableColumn<?, ?> TableColAddress;

        @FXML
        private TableColumn<?, ?> TableColFaculty;

        @FXML
        private TableColumn<?, ?> TableColStudent;

        @FXML
        void ButtonExit(ActionEvent event) {

        }

        @FXML
        void buttonAddReportPage(ActionEvent event) {

        }

        @FXML
        void buttonInstitutionMailBox(ActionEvent event) {

        }

        @FXML
        void buttonStatisticsInstitution(ActionEvent event) {

        }

    }

