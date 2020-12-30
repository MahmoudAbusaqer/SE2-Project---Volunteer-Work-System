package View;

import Controller.LoginPageManager;
import Model.DOV;
import Model.Institutions;
import Model.Student;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class StartPagePanes implements Initializable {

    private DOV dov = null;
    private Student student = null;
    private Institutions institutions = null;
    private LoginPageManager controller;

    @FXML
    private Button buttonLogin;

    @FXML
    private PasswordField TextFieldPass;

    @FXML
    private TextField TextFieldID;

    @FXML
    private Button InstitutionButton;

    @FXML
    private Button DOVButton;

    @FXML
    private Button StudentButton;

    @FXML
    private Pane loginPagePane;

    @FXML
    private Pane startPagePane;
    @FXML
    private AnchorPane rootpane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        startPagePane.toFront();
        startPagePane.setVisible(true);
        loginPagePane.setVisible(false);
        this.controller = new LoginPageManager();
    }

    @FXML
    void DOVButton(ActionEvent event) throws SQLException, IOException {
        loginPagePane.toFront();
        startPagePane.setVisible(false);
        loginPagePane.setVisible(true);
        dov = new DOV();
        buttonLoginHandle(event);
    }

    @FXML
    void InstitutionButton(ActionEvent event) throws SQLException, IOException {
        loginPagePane.toFront();
        startPagePane.setVisible(false);
        loginPagePane.setVisible(true);
        institutions = new Institutions();
        buttonLoginHandle(event);
    }

    @FXML
    void StudentButton(ActionEvent event) throws SQLException, IOException {
        loginPagePane.toFront();
        startPagePane.setVisible(false);
        loginPagePane.setVisible(true);
        student = new Student();
        buttonLoginHandle(event);
    }

    @FXML
    void buttonLoginHandle(ActionEvent event) throws SQLException, IOException {
        try {
            if (!TextFieldID.getText().equals("") && !TextFieldPass.getText().equals("")) {
                if (student != null) {
                    student = controller.checkStudent(Integer.parseInt(TextFieldID.getText()), TextFieldPass.getText());
                    if (student != null) {
                        RequestScreen.setStudent(student);
                        CreateInitiativeScreen.setStudent(student);
                        AddInstitutionsScreen.setStudent(student);
                        StudentMailboxScreen.setStudent(student);
                        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/StudentGUI/MainPage.fxml"));
                        rootpane.getChildren().setAll(pane);
                    }
                } else if (institutions != null) {
                    institutions = controller.checkInstitution(Integer.parseInt(TextFieldID.getText()), TextFieldPass.getText());
                    if (institutions != null) {
                        StatisticsScreenInstitution.setInstitutions(institutions);
                        ReportScreen.setInstitutions(institutions);
                        ViewNewVolunteersScreen.setInstitutions(institutions);
                        InstitutionMailboxScreen.setInstitutions(institutions);
                        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/StatisticsScreenInstitution.fxml"));
                        rootpane.getChildren().setAll(pane);
                    }
                } else if (dov != null) {
                    dov = controller.checkDOV(Integer.parseInt(TextFieldID.getText()), TextFieldPass.getText());
                    if (dov != null) {
                        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/DOVGUI/StatisticsScreen.fxml"));
                        rootpane.getChildren().setAll(pane);
                    }
                }
            }
        } catch (NullPointerException e) {

        }
    }

    public void checkStudent(int studentId, String password) throws SQLException {
        controller.checkStudent(studentId, password);
    }

}
