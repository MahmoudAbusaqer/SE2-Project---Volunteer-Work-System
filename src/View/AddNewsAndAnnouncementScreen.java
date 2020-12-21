/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.AddNewsAndAnnouncementManager;
import Model.AddNewsAndAnnouncement;
import Model.InstitutionMailbox;
import Model.StudentMailbox;

import java.io.IOException;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class AddNewsAndAnnouncementScreen {

    private AddNewsAndAnnouncement addNewsAndAnnouncementModel;
    private StudentMailbox studentMailboxModel;
    private InstitutionMailbox institutionMailboxModel;
    private AddNewsAndAnnouncementManager controller;

    public AddNewsAndAnnouncementScreen(AddNewsAndAnnouncement model) {
        this.addNewsAndAnnouncementModel = model;
    }

    public void setController(AddNewsAndAnnouncementManager controller) {
        this.controller = controller;
    }

    public void AddNewsAndAnnouncement(int nOr, String title, String body, Date date) {
        controller.AddNewsAndAnnouncement(nOr, title, body, date);
        studentMailboxModel.setSenderId(nOr/*need to be the dov id or I can let it be a number like 123*/);
        studentMailboxModel.setSenderName("DOV");
        studentMailboxModel.setTitle(title);
        studentMailboxModel.setBody(body);
        studentMailboxModel.setDate(date);
        studentMailboxModel.setApproveOrDeny(true);
        controller.add(studentMailboxModel);
        institutionMailboxModel.setSenderId(nOr/*need to be the dov id or I can let it be a number like 123*/);
        institutionMailboxModel.setSenderName("DOV");
        institutionMailboxModel.setTitle(title);
        institutionMailboxModel.setBody(body);
        institutionMailboxModel.setDate(date);
        institutionMailboxModel.setApproveOrDeny(true);
        controller.add(institutionMailboxModel);

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
    private TextField TextFieldNewsTitle;

    @FXML
    private DatePicker DatePickerDate;

    @FXML
    private TextArea TextAreaDescription;

    @FXML
    private ChoiceBox<?> ChoiceBoxNOrA;

    @FXML
    private Button ButtonSubmit;

    @FXML
    void buttonSubmit(ActionEvent event) {

    }

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
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/DOVGUI/MailBoxTest.fxml"));
        rootpane.getChildren().setAll(pane);
    }


    @FXML
    void ButtonExit(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/MainPage/StartPage.fxml"));
        rootpane.getChildren().setAll(pane);
    }

}
