/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class testMainClass extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
//        Pane paneStudentTableView = FXMLLoader.load(getClass().getResource("SceneBuilder/DOVGUI/NewsAndAnnouncmentScreen.fxml"));
//        Pane paneStudentTableView = FXMLLoader.load(getClass().getResource("SceneBuilder/DOVGUI/StatisticsScreen.fxml"));
//        Pane paneStudentTableView = FXMLLoader.load(getClass().getResource("SceneBuilder/DOVGUI/DOVMailBox.fxml"));
//        Pane paneStudentTableView = FXMLLoader.load(getClass().getResource("SceneBuilder/StudentGUI/MainPage.fxml"));
//        Pane paneStudentTableView = FXMLLoader.load(getClass().getResource("SceneBuilder/StudentGUI/StudentMailBox.fxml"));
//        Pane paneStudentTableView = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/InstitutionMailBox.fxml"));
//        Pane paneStudentTableView = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/ReportScreen.fxml"));
//        Pane paneStudentTableView = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/ViewsNewVolunteers.fxml"));
//        Pane paneStudentTableView = FXMLLoader.load(getClass().getResource("SceneBuilder/InstitutionGUI/StatisticsScreenInstitution.fxml"));
//        Pane paneStudentTableView = FXMLLoader.load(getClass().getResource("SceneBuilder/MainPage/LoginPage.fxml"));
        Pane paneStudentTableView = FXMLLoader.load(getClass().getResource("SceneBuilder/MainPage/StartPage.fxml"));
//        Pane paneStudentTableView = FXMLLoader.load(getClass().getResource("SceneBuilder/StudentGUI/InstitutionScreen.fxml"));
        Scene scene = new Scene(paneStudentTableView);
        primaryStage.setTitle("test");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
