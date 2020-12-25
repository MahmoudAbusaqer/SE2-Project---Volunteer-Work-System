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
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class AddInstitutionsScreen implements Initializable {

    private AddInstitutions model;
    private AddInstitutionsManager controller;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new AddInstitutionsManager(model);
        this.model = new AddInstitutions();
    }

//    public AddInstitutionsScreen(AddInstitutions model) {
//        this.model = model;
//    }
//    public void setController(AddInstitutionsManager controller) {
//        this.controller = controller;
//    }
    public void AddInstitutionInput(String name, String email, String address, int phone, String district) {
        controller.AddInstitutionInput(name, address, email, phone, district);
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
    void buttonSubmit(ActionEvent event) {
        AddInstitutionInput(TextFieldInstitutionName.getText(), TextFieldInstitutionMail.getText(), TextFieldInstitutionAddress.getText(), Integer.parseInt(TextFieldInstitutionPhone.getText()), TextFieldInstitutionDistrict.getText());
    }

    @FXML
    void buttonMainPage(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/StudentGUI/MainPage.fxml"));
        rootpane.getChildren().setAll(pane);

    }

    @FXML
    void buttonApplyVolunteerPage(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/StudentGUI/InstitutionScreen.fxml"));
        rootpane.getChildren().setAll(pane);

    }

    @FXML
    void buttonCreateIntitivePage(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/StudentGUI/AddInitiative.fxml"));
        rootpane.getChildren().setAll(pane);

    }

    @FXML
    void buttonStudentMailBox(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/StudentGUI/StudentMailBox.fxml"));
        rootpane.getChildren().setAll(pane);

    }

    @FXML
    void ButtonExit(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/MainPage/StartPage.fxml"));
        rootpane.getChildren().setAll(pane);

    }

}
