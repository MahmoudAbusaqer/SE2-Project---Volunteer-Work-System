package View;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class LoginPage implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
    @FXML
    private Pane grad;

    @FXML
    private Button buttonLogin;

    @FXML
    private PasswordField TextFieldPass;

    @FXML
    private TextField TextFieldUsername;

}
