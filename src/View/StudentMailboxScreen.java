/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StudentMailboxManager;
import Model.StudentMailbox;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class StudentMailboxScreen implements Initializable {

    private StudentMailbox model;
    private StudentMailboxManager controller;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new StudentMailboxManager(model);
        this.model = new StudentMailbox();
        MailboxPane.getStylesheets().add("View/SceneBuilder/StudentGUI/mailstyle.css");
      //MailboxPane.setStyle("View/SceneBuilder/StudentGUI/mailstyle.css");
        try {
            showMailbox();
        } catch (SQLException ex) {
            Logger.getLogger(StudentMailboxScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public StudentMailboxScreen(StudentMailbox model) {
//        this.model = model;
//    }
//    public void setController(StudentMailboxManager controller) {
//        this.controller = controller;
//    }
    public void showMailbox() throws SQLException {
        List<StudentMailbox> studentMailboxs = new ArrayList<>();
        studentMailboxs = controller.showMailbox();
        for (int i = 0; i < studentMailboxs.size(); i++) {
            StudentMailbox mailbox = new StudentMailbox();
            mailbox = studentMailboxs.get(i);
            final String body = mailbox.getBody();
            Button mailButton = new Button(mailbox.getTitle());
            MailboxPane.getStylesheets().add("View/SceneBuilder/StudentGUI/mailstyle.css");
    //        mailButton.setStyle("View/SceneBuilder/StudentGUI/mailstyle.css");
            mailButton.setStyle("-fx-background-color: #2A4166;");
            mailButton.setOnAction((e) -> {
                mailboxTextArea.setText(body);
            });
            MailboxPane.getChildren().add(mailButton);
        }
//        int index = studentMailboxs.size();
//        while (!studentMailboxs.isEmpty()) {
//            StudentMailbox mailbox = new StudentMailbox();
//            mailbox = studentMailboxs.get(index);
//            Button mailButton = new Button(mailbox.getTitle());
//            mailButton.setStyle("-fx-background-color: #2A4166;");
//            mailboxTextArea.setText(mailbox.getBody());
//            MailboxPane.getChildren().add(mailButton);
//            //here need to match every GUI field with the model.get
//            studentMailboxs.remove(index);
//            index--;
//        }
    }

    @FXML
    private Pane rootpane;

    @FXML
    private Button ButtonMainPage;

    @FXML
    private Button ButtonApplyVolunteerPage;

    @FXML
    private Button ButtonAddInstitutionPage;

    @FXML
    private Button ButtonCreateIntitivePage;

    @FXML
    private VBox MailboxPane;

    @FXML
    private Button ExitButton;

    @FXML
    private TextArea mailboxTextArea;

    @FXML
    void buttonMainPage(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/StudentGUI/MainPage.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void buttonAddInstitutionPage(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/StudentGUI/AddInstitutionScreen.fxml"));
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
    void ButtonExit(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/MainPage/StartPage.fxml"));
        rootpane.getChildren().setAll(pane);
    }

}
