/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StudentMailboxManager;
import Model.Student;
import Model.StudentMailbox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class StudentMailboxScreen implements Initializable, Shows {

    private StudentMailbox model;
    private StudentMailboxManager controller;
    static Student student;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new StudentMailboxManager(model);
        this.model = new StudentMailbox();
        MailboxPane.getStylesheets().add("View/SceneBuilder/StudentGUI/mailstyle.css");
        try {
            showMailbox(student.getId());
        } catch (SQLException ex) {
            Logger.getLogger(StudentMailboxScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void showMailbox(int id) throws SQLException {
        List<StudentMailbox> studentMailboxs = new ArrayList<>();
        studentMailboxs = controller.showMailbox(id);
        for (int i = 0; i < studentMailboxs.size(); i++) {
            StudentMailbox mailbox = new StudentMailbox();
            mailbox = studentMailboxs.get(i);
            final String body = mailbox.getBody();
            Button mailButton = new Button(mailbox.getTitle());
            MailboxPane.getStylesheets().add("View/SceneBuilder/StudentGUI/mailstyle.css");
            mailButton.setStyle("-fx-background-color: #2A4166;");
            mailButton.setOnAction((e) -> {
                mailboxTextArea.setText(body);
            });
            MailboxPane.getChildren().add(mailButton);
        }
    }

    public static Student getStudent() {
        return student;
    }

    public static void setStudent(Student student) {
        StudentMailboxScreen.student = student;
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

    @Override
    public void showNewVolunteers(int institutionId) throws SQLException {
    }
}
