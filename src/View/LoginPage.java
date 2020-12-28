package View;

import Controller.LoginPageManager;
import Model.DOV;
import Model.Institutions;
import Model.Student;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class LoginPage implements Initializable {

    private int studentId;
    private int dovId;
    private int institutionId;
    private DOV dov;
    private Student student;
    private Institutions institutions;
    private LoginPageManager controller;

    @FXML
    private Pane grad;

    @FXML
    private Button buttonLogin;

    @FXML
    private PasswordField TextFieldPass;

    @FXML
    private TextField TextFieldID;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.controller = new LoginPageManager();
    }

    @FXML
    private void buttonLoginHandle(ActionEvent event) throws SQLException {
        try {
            if (controller.checkStudent(Integer.parseInt(TextFieldID.getText()), TextFieldPass.getText()) != null) {
                System.out.println("worked");
//            checkStudent(Integer.parseInt(TextFieldID.getText()), TextFieldPass.getText());
            }
//        setStudentId(Integer.parseInt(TextFieldID.getText()));
        } catch (NullPointerException e) {
            System.out.println("wrong infromation");
        }

    }

    public void checkStudent(int studentId, String password) throws SQLException {
        controller.checkStudent(studentId, password);
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getDovId() {
        return dovId;
    }

    public void setDovId(int dovId) {
        this.dovId = dovId;
    }

    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    public DOV getDov() {
        return dov;
    }

    public void setDov(DOV dov) {
        this.dov = dov;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Institutions getInstitutions() {
        return institutions;
    }

    public void setInstitutions(Institutions institutions) {
        this.institutions = institutions;
    }

}
