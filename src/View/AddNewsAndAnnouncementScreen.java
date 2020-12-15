/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AddNewsAndAnnouncementManager;
import Model.AddNewsAndAnnouncement;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
/**
 *
 * @author Mahmoud_Abusaqer
 */
public class AddNewsAndAnnouncementScreen {

    private AddNewsAndAnnouncement model;
    private AddNewsAndAnnouncementManager controller;

    public AddNewsAndAnnouncementScreen(AddNewsAndAnnouncement model) {
        this.model = model;
    }

    public void setController(AddNewsAndAnnouncementManager controller) {
        this.controller = controller;
    }

    public void AddNewsAndAnnouncement(int nOr, String title, String body, Date date) {

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
        private TextField TextFieldNOrA;

        @FXML
        private TextField TextFieldNewsTitle;

        @FXML
        private TextField TextFieldNewsDescription;

        @FXML
        private TextField TextFieldNewsDate;

        @FXML
        private Button ButtonSubmit;

        @FXML
        void ButtonExit(ActionEvent event) {

        }

        @FXML
        void buttonApplyVolunteerPage(ActionEvent event) {

        }

        @FXML
        void buttonMainPage(ActionEvent event) {

        }

        @FXML
        void buttonStudentMailBox(ActionEvent event) {

        }

        @FXML
        void buttonSubmit(ActionEvent event) {

        }

    }

