/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.StudentMailboxManager;
import Model.StudentMailbox;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class StudentMailboxScreen {

    private StudentMailbox model;
    private StudentMailboxManager controller;

    public StudentMailboxScreen(StudentMailbox model) {
        this.model = model;
    }

    public void setController(StudentMailboxManager controller) {
        this.controller = controller;
    }

    public void showMailbox() throws SQLException {
        List<StudentMailbox> studentMailboxs = new ArrayList<>();
        studentMailboxs = controller.showMailbox();
        int index = 0;
        while (!studentMailboxs.isEmpty()) {
            model = studentMailboxs.get(index);
            //here need to match every GUI field with the model.get
            studentMailboxs.remove(index);
            index++;
        }
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
    private Button ButtonStudentMailBox;

    @FXML
    private Button ExitButton;

    @FXML
    void ButtonExit(ActionEvent event) {

    }

    @FXML
    void buttonAddInstitutionPage(ActionEvent event) {

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

}
