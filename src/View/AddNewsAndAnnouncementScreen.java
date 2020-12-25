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
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class AddNewsAndAnnouncementScreen implements Initializable {

    private AddNewsAndAnnouncement addNewsAndAnnouncementModel;
    private AddNewsAndAnnouncementManager controller;
    ObservableList<String> ChoiceBoxItems = FXCollections.observableArrayList("News", "Announcements");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new AddNewsAndAnnouncementManager(addNewsAndAnnouncementModel);
        this.addNewsAndAnnouncementModel = new AddNewsAndAnnouncement();
        ChoiceBoxNOrA.setItems(ChoiceBoxItems);
    }

//    public AddNewsAndAnnouncementScreen(AddNewsAndAnnouncement model) {
//        this.addNewsAndAnnouncementModel = model;
//        this.controller = new AddNewsAndAnnouncementManager(model);
//    }
//    public void setController(AddNewsAndAnnouncementManager controller) {
//        this.controller = controller;
//    }
    public void AddNewsAndAnnouncement(int nOr, String title, String body, Date date) {
        controller.AddNewsAndAnnouncement(nOr, title, body, date);

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
    private ChoiceBox<String> ChoiceBoxNOrA;

    @FXML
    private Button ButtonSubmit;

    @FXML
    void buttonSubmit(ActionEvent event) {
        AddNewsAndAnnouncement(Integer.parseInt(ChoiceBoxNOrA.getValue()), TextFieldNewsTitle.getText(), TextAreaDescription.getText(), new java.sql.Timestamp(System.currentTimeMillis()));
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
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/DOVGUI/DOVMailBox.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void ButtonExit(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/MainPage/StartPage.fxml"));
        rootpane.getChildren().setAll(pane);
    }

}
