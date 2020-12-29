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

public class StartPagePanes implements Initializable {

//    private int studentId;
//    private int dovId;
//    private int institutionId;
    private DOV dov = null;
    private Student student = null;
    private Institutions institutions = null;
    private LoginPageManager controller;
    private RequestScreen requestScreen;
    private CreateInitiativeScreen initiativeScreen;
    private StatisticsScreenInstitution statisticsScreenInstitution;
    private ReportScreen reportScreen;
    private ViewNewVolunteersScreen volunteersScreen;

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
        requestScreen = new RequestScreen();
        initiativeScreen = new CreateInitiativeScreen();
        statisticsScreenInstitution = new StatisticsScreenInstitution();
        reportScreen = new ReportScreen();
        volunteersScreen = new ViewNewVolunteersScreen();
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
                        requestScreen.setStudent(student);
                        initiativeScreen.setStudent(student);
//                        requestScreen.showStudent(student);
                        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/StudentGUI/MainPage.fxml"));
                        rootpane.getChildren().setAll(pane);
                    }
                } else if (institutions != null) {
                    institutions = controller.checkInstitution(Integer.parseInt(TextFieldID.getText()), TextFieldPass.getText());
                    if (institutions != null) {
//                        setInstitutions(institutions);
                        statisticsScreenInstitution.setInstitutions(institutions);
                        reportScreen.setInstitutions(institutions);
                        volunteersScreen.setInstitutions(institutions);
                        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/StatisticsScreenInstitution.fxml"));
                        rootpane.getChildren().setAll(pane);
//                        System.out.println("worked");
//                        System.out.println(controller.checkInstitution(Integer.parseInt(TextFieldID.getText()), TextFieldPass.getText()).toString());
//            checkStudent(Integer.parseInt(TextFieldID.getText()), TextFieldPass.getText());
                    }
                } else if (dov != null) {
                    dov = controller.checkDOV(Integer.parseInt(TextFieldID.getText()), TextFieldPass.getText());
                    if (dov != null) {
//                        setDov(dov);
                        Pane pane = FXMLLoader.load(getClass().getResource("SceneBuilder/DOVGUI/StatisticsScreen.fxml"));
                        rootpane.getChildren().setAll(pane);
//                        System.out.println(controller.checkDOV(Integer.parseInt(TextFieldID.getText()), TextFieldPass.getText()));
//                        System.out.println("worked");
//                        System.out.println(controller.checkStudent(Integer.parseInt(TextFieldID.getText()), TextFieldPass.getText()).toString());
//            checkStudent(Integer.parseInt(TextFieldID.getText()), TextFieldPass.getText());
                    }
                }
            }

//        setStudentId(Integer.parseInt(TextFieldID.getText()));
        } catch (NullPointerException e) {
            System.out.println("wrong infromation");
        }
    }

    public void checkStudent(int studentId, String password) throws SQLException {
        controller.checkStudent(studentId, password);
    }

//    public DOV getDov() {
//        return dov;
//    }
//
//    public void setDov(DOV dov) {
//        this.dov = dov;
//    }
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//
//    public Institutions getInstitutions() {
//        return institutions;
//    }
//
//    public void setInstitutions(Institutions institutions) {
//        this.institutions = institutions;
//    }
//
//    public int getStudentId() {
//        return studentId;
//    }
//
//    public void setStudentId(int studentId) {
//        this.studentId = studentId;
//    }
//
//    public int getDovId() {
//        return dovId;
//    }
//
//    public void setDovId(int dovId) {
//        this.dovId = dovId;
//    }
//
//    public int getInstitutionId() {
//        return institutionId;
//    }
//
//    public void setInstitutionId(int institutionId) {
//        this.institutionId = institutionId;
//    }
}
