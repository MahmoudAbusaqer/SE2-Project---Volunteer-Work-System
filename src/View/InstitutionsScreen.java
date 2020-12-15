/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.RequestManager;
import Model.RequestVolunteer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class InstitutionsScreen {

    private RequestVolunteer model;
    private RequestManager controller;

    public InstitutionsScreen(RequestVolunteer model) {
        this.model = model;
    }

    public void setController(RequestManager controller) {
        this.controller = controller;
    }

    public void showInstitutions(String name, String email, String address, int phone) {

    }

    public void requestVlounteer(int studentId, String studentName, int institutionId, String institutionName) {

    }

        @FXML
        private Pane rootpane;

        @FXML
        private Button ButtonMainPage;

        @FXML
        private Button ButtonAddInstitutionPage;

        @FXML
        private Button ButtonCreateIntitivePage;

        @FXML
        private Button ButtonStudentMailBox;

        @FXML
        private Button ExitButton;

        @FXML
        private TextField TextFieldStudentId;

        @FXML
        private TextField TextFieldStudentName;

        @FXML
        private TextField TextFieldInstitutionId;

        @FXML
        private TextField TextFieldInstitutionName;

        @FXML
        private Button ButtonSubmit;

        @FXML
        private TableView<?> TableView;

        @FXML
        private TableColumn<?, ?> TableColPhone;

        @FXML
        private TableColumn<?, ?> TableColAddress;

        @FXML
        private TableColumn<?, ?> TableColDistrict;

        @FXML
        private TableColumn<?, ?> TableColEmail;

        @FXML
        private TableColumn<?, ?> TableColName;

        @FXML
        private ChoiceBox<?> ChoiceBoxDistrict;

        @FXML
        void ButtonExit(ActionEvent event) {

        }

        @FXML
        void buttonAddInstitutionPage(ActionEvent event) {

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


