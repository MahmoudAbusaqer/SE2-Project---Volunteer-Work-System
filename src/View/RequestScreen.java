/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.RequestManager;
import Model.District;
import Model.Institutions;
import Model.RequestVolunteer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 *
 * @author Mahmoud_Abusaqer
 */
public class RequestScreen {

    private District districtModel;
    private Institutions institutionsModel;
    private RequestVolunteer requestVolunteerModel;
    private RequestManager controller;

    public RequestScreen(RequestVolunteer requestVolunteerModel) {
        this.requestVolunteerModel = requestVolunteerModel;
        this.districtModel = new District();
        this.institutionsModel = new Institutions();
    }

    public void setController(RequestManager controller) {
        this.controller = controller;
    }

    public void showDistrict() throws SQLException {
        List<District> districts = new ArrayList<>();
        List<String> districtsNames = new ArrayList<>();
        districts = controller.showDistrict();
        int index = 0;
        while (!districts.isEmpty()) {
            districtModel = districts.get(index);
            districtsNames.add(districtModel.getName());
            districts.remove(index);
            index++;
        }
        ChoiceBoxDistrict.setItems((ObservableList<String>) districtsNames);
    }

    public void showInstitutions() throws SQLException {
        List<Institutions> institutionses = new ArrayList<>();
        institutionses = controller.showInstitutions(ChoiceBoxDistrict.getValue());
        int index = 0;
        while (!institutionses.isEmpty()) {
            institutionsModel = institutionses.get(index);
            //here need to match every GUI field with the model.get
            institutionses.remove(index);
            index++;
        }
    }

    public void requestVlounteer(int studentId, String studentName, int institutionId, String institutionName) {
        controller.requestVlounteer(studentId, studentName, institutionId, institutionName);
    }

    @FXML
    private Pane rootpane;

    @FXML
    private Button ButtonMainPage;

    @FXML
    private Button ButtonAddInstitutionPage;

    @FXML
    private Button ButtonCreateIntitivePage;

    @FXML
    private Button ButtonStudentMailBox;

    @FXML
    private Button ExitButton;

    @FXML
    private TextField TextFieldStudentId;

    @FXML
    private TextField TextFieldStudentName;

    @FXML
    private TextField TextFieldInstitutionId;

    @FXML
    private TextField TextFieldInstitutionName;

    @FXML
    private Button ButtonSubmit;

    @FXML
    private TableView<?> TableView;

    @FXML
    private TableColumn<?, ?> TableColPhone;

    @FXML
    private TableColumn<?, ?> TableColAddress;

    @FXML
    private TableColumn<?, ?> TableColDistrict;

    @FXML
    private TableColumn<?, ?> TableColEmail;

    @FXML
    private TableColumn<?, ?> TableColName;

    @FXML
    private ChoiceBox<String> ChoiceBoxDistrict;

    @FXML
    void ButtonExit(ActionEvent event) {

    }

    @FXML
    void buttonAddInstitutionPage(ActionEvent event) {

    }

    @FXML
    void buttonCreateIntitivePage(ActionEvent event) {

    }

    @FXML
    void buttonMainPage(ActionEvent event) {

    }

    @FXML
    void buttonStudentMailBox(ActionEvent event) {

    }

    @FXML
    void buttonSubmit(ActionEvent event) {
        requestVlounteer(Integer.parseInt(TextFieldStudentId.getText()), TextFieldStudentName.getText(), Integer.parseInt(TextFieldInstitutionId.getText()), TextFieldInstitutionName.getText());
    }

}
