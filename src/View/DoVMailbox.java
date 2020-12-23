/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.dovMailboxManager;
import Model.DOVMailbox;

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
public class DoVMailbox {

    private DOVMailbox model;
    private dovMailboxManager controller;

    public DoVMailbox(DOVMailbox model) {
        this.model = model;
    }

    public void setController(dovMailboxManager controller) {
        this.controller = controller;
    }

    public void showMailbox() throws SQLException {
        List<DOVMailbox> dOVMailboxs = new ArrayList<>();
        dOVMailboxs = controller.showMailbox();
        int index = 0;
        while (!dOVMailboxs.isEmpty()) {
            model = dOVMailboxs.get(index);
            //here need to match every GUI field with the model.get
            dOVMailboxs.remove(index);
            index++;
        }
    }

    public void mailResponse(int senderId, String senderName, String title, String body, Date date, boolean approveOrDeny, String dovmailbox) {
        controller.mailResponse(senderId/*need to be the dov id or I can let it be a number like 123*/, "DOV", "Respond to your email", body, new java.sql.Timestamp(System.currentTimeMillis()), approveOrDeny, dovmailbox);//need to be edit
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


