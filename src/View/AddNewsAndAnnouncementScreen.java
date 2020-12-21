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
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class AddNewsAndAnnouncementScreen {

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
    private ChoiceBox<String> ChoiceBoxNOrA;

    @FXML
    private Button ButtonSubmit;
    
    private AddNewsAndAnnouncement addNewsAndAnnouncementModel;
//    private StudentMailbox studentMailboxModel;
//    private InstitutionMailbox institutionMailboxModel;
    private AddNewsAndAnnouncementManager controller;
    ObservableList<String> ChoiceBoxItems = FXCollections.observableArrayList("News", "Announcements");
    
    @FXML 
    private void initialize(){
        ChoiceBoxNOrA.setItems(ChoiceBoxItems);
    }
    
    public AddNewsAndAnnouncementScreen(AddNewsAndAnnouncement model) {
        this.addNewsAndAnnouncementModel = model;
//        this.studentMailboxModel = new StudentMailbox();
//        this.institutionMailboxModel = new InstitutionMailbox();
        this.controller = new AddNewsAndAnnouncementManager(model);
    }

    public void setController(AddNewsAndAnnouncementManager controller) {
        this.controller = controller;
    }

    public void AddNewsAndAnnouncement(int nOr, String title, String body, Date date) {
        controller.AddNewsAndAnnouncement(nOr, title, body, date);
//        studentMailboxModel.setSenderId(nOr/*need to be the dov id or I can let it be a number like 123*/);
//        studentMailboxModel.setSenderName("DOV");
//        studentMailboxModel.setTitle(title);
//        studentMailboxModel.setBody(body);
//        studentMailboxModel.setDate(date);
//        studentMailboxModel.setApproveOrDeny(true);
//        controller.add(studentMailboxModel);
//        institutionMailboxModel.setSenderId(nOr/*need to be the dov id or I can let it be a number like 123*/);
//        institutionMailboxModel.setSenderName("DOV");
//        institutionMailboxModel.setTitle(title);
//        institutionMailboxModel.setBody(body);
//        institutionMailboxModel.setDate(date);
//        institutionMailboxModel.setApproveOrDeny(true);
//        controller.add(institutionMailboxModel);

    }

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
        AddNewsAndAnnouncement(Integer.parseInt(ChoiceBoxNOrA.getValue()), TextFieldNewsTitle.getText(), TextAreaDescription.getText(), new java.sql.Timestamp(System.currentTimeMillis()));
    }

}
