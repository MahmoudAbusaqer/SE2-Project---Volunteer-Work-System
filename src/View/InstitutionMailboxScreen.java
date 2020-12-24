/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.InstitutionMailboxManager;
import Model.InstitutionMailbox;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class InstitutionMailboxScreen {

    private InstitutionMailbox model;
    private InstitutionMailboxManager controller;

    public InstitutionMailboxScreen(InstitutionMailbox model) {
        this.model = model;
    }

    public void setController(InstitutionMailboxManager controller) {
        this.controller = controller;
    }

    public void showMailbox() throws SQLException {
        List<InstitutionMailbox> institutionMailboxs = new ArrayList<>();
        institutionMailboxs = controller.showMailbox();
        int index = 0;
        while (!institutionMailboxs.isEmpty()) {
            model = institutionMailboxs.get(index);
            //here need to match every GUI field with the model.get
            institutionMailboxs.remove(index);
            index++;
        }
    }



        @FXML
        private Pane rootpane;

        @FXML
        private Button ButtonMainPage;

        @FXML
        private Button ButtonNewVolunteersPage;

        @FXML
        private Button ButtonSendReportsPage;

        @FXML
        private Button ExitButton;

        @FXML
        void buttonMainPage(ActionEvent event) throws IOException {
            Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/StatisticsScreenInstitution.fxml"));
            rootpane.getChildren().setAll(pane);
        }

        @FXML
        void buttonNewVolunteersPage(ActionEvent event) throws IOException {
            Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/ViewNewVolunteers.fxml"));
            rootpane.getChildren().setAll(pane);
        }

        @FXML
        void buttonSendReportsPage(ActionEvent event) throws IOException {
            Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/ReportScreen.fxml"));
            rootpane.getChildren().setAll(pane);
        }

        @FXML
        void ButtonExit(ActionEvent event) throws IOException {
            Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/MainPage/StartPage.fxml"));
            rootpane.getChildren().setAll(pane);
        }

    }

