package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class StartPage implements Initializable {

    @FXML
    private Pane loginPagePane;
    @FXML
    private Pane grad1;
    @FXML
    private Button buttonLogin;
    @FXML
    private PasswordField TextFieldPass;
    @FXML
    private TextField TextFieldID;
    @FXML
    private Pane startPagePane;
    @FXML
    private Pane grad;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private Button InstitutionButton;

    @FXML
    private Button DOVButton;

    @FXML
    private Button StudentButton;

    @FXML
    void DOVButton(ActionEvent event) {

    }

    @FXML
    void InstitutionButton(ActionEvent event) {

    }

    @FXML
    void StudentButton(ActionEvent event) {

    }

    @FXML
    private void buttonLoginHandle(ActionEvent event) {
    }

}
