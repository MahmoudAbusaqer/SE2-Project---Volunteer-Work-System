/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AddInstitutionsManager;
import Model.AddInstitutions;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class AddInstitutionsScreen {

    private AddInstitutions model;
    private AddInstitutionsManager controller;

    public AddInstitutionsScreen(AddInstitutions model) {
        this.model = model;
    }

    public void setController(AddInstitutionsManager controller) {
        this.controller = controller;
    }

    public void AddInstitutionInput(String name, String email, String distict, int phone, int district) {

    }

        @FXML
        private Pane rootpane;

        @FXML
        private Button ButtonMainPage;

        @FXML
        private Button ButtonApplyVolunteerPage;

        @FXML
        private Button ButtonCreateIntitivePage;

        @FXML
        private Button ButtonStudentMailBox;

        @FXML
        private Button ExitButton;

        @FXML
        private TextField TextFieldInstitutionName;

        @FXML
        private TextField TextFieldInstitutionMail;

        @FXML
        private TextField TextFieldInstitutionDistrict;

        @FXML
        private TextField TextFieldInstitutionAddress;

        @FXML
        private TextField TextFieldInstitutionPhone;

        @FXML
        private Button ButtonSubmit;

        @FXML
        void ButtonExit(ActionEvent event) {

        }

        @FXML
        void buttonApplyVolunteerPage(ActionEvent event) {

        }

        @FXML
        void buttonCreateIntitivePage(ActionEvent event) {

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


