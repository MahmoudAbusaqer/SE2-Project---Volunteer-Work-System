/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.dovMailboxManager;
import Model.DOVMailbox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class DoVMailbox implements Initializable {

    private DOVMailbox model;
    private dovMailboxManager controller;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new dovMailboxManager(model);
        this.model = new DOVMailbox();
        try {
            showMailbox();
        } catch (SQLException ex) {
            Logger.getLogger(DoVMailbox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showMailbox() throws SQLException {
        List<DOVMailbox> dOVMailboxs = new ArrayList<>();
        try {
            dOVMailboxs = controller.showMailbox();
            for (int i = 0; i < dOVMailboxs.size(); i++) {
                DOVMailbox mailbox = new DOVMailbox();
                mailbox = dOVMailboxs.get(i);
                final int sendfor = mailbox.getSendFor();
                final int mailId = mailbox.getId();
                final String body = mailbox.getBody();
                final String typeOfMail = mailbox.getTypeOfMail();
                Button mailButton = new Button(mailbox.getTitle());
                MailboxPane.getStylesheets().add("View/SceneBuilder/StudentGUI/mailstyle.css");
                mailButton.setStyle("-fx-background-color: #2A4166;");
                mailButton.setOnAction((e) -> {
                    mailboxTextArea.setText(body);
                    MailboxPane2.getChildren().clear();
                    Button approve = new Button("Approve");
                    Button deny = new Button("Deny");
                    approve.setOnAction(((event) -> {
                        mailResponse(sendfor, 111, "DOV", "Respond to your email", body, new java.sql.Timestamp(System.currentTimeMillis()), true, typeOfMail, mailId);
                    }));
                    deny.setOnAction(((event) -> {
                        mailResponse(sendfor, 111, "DOV", "Respond to your email", body, new java.sql.Timestamp(System.currentTimeMillis()), false, typeOfMail, mailId);
                    }));
                    MailboxPane2.getChildren().addAll(approve, deny);
                });
                MailboxPane.getChildren().add(mailButton);
            }

        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

    public void mailResponse(int sendfor, int senderId, String senderName, String title, String body, Date date, boolean approveOrDeny, String dovmailbox, int mailId) {
        controller.mailResponse(sendfor, senderId, senderName, title, body, new java.sql.Timestamp(System.currentTimeMillis()), approveOrDeny, dovmailbox, mailId);
        try {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("process succeeded");
            alert.setContentText("You can continue now 😄");
            alert.showAndWait();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setContentText("Try again later");
            alert.showAndWait();
        }
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
    private VBox MailboxPane;

    @FXML
    private VBox MailboxPane2;

    @FXML
    private TextArea mailboxTextArea;

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
