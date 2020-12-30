/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.InstitutionMailboxManager;
import Model.InstitutionMailbox;
import Model.Institutions;
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
public class InstitutionMailboxScreen implements Initializable {

    private InstitutionMailbox model;
    private InstitutionMailboxManager controller;
    static Institutions institutions;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new InstitutionMailboxManager(model);
        this.model = new InstitutionMailbox();
        try {
            showMailbox(institutions.getId());
        } catch (SQLException ex) {
            Logger.getLogger(InstitutionMailboxScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void showMailbox(int id) throws SQLException {
        List<InstitutionMailbox> institutionMailboxs = new ArrayList<>();
        institutionMailboxs = controller.showMailbox(id);
        for (int i = 0; i < institutionMailboxs.size(); i++) {
            InstitutionMailbox mailbox = new InstitutionMailbox();
            mailbox = institutionMailboxs.get(i);
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

    public static Institutions getInstitutions() {
        return institutions;
    }

    public static void setInstitutions(Institutions institutions) {
        InstitutionMailboxScreen.institutions = institutions;
    }

    @FXML
    private Pane rootpane;

    @FXML
    private Button ButtonMainPage;

    @FXML
    private Button ButtonNewVolunteersPage;

    @FXML
    private Button ButtonSendReportsPage;

    @FXML
    private Button ExitButton;

    @FXML
    private VBox MailboxPane;

    @FXML
    private TextArea mailboxTextArea;

    @FXML
    void buttonMainPage(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/StatisticsScreenInstitution.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void buttonNewVolunteersPage(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/ViewsNewVolunteers.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void buttonSendReportsPage(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/ReportScreen.fxml"));
        rootpane.getChildren().setAll(pane);
    }

    @FXML
    void ButtonExit(ActionEvent event) throws IOException {
        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/MainPage/StartPage.fxml"));
        rootpane.getChildren().setAll(pane);
    }

}
