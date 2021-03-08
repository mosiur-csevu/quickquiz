/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickquizfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mosiur Rahman Sweet
 */
public class FXMLResultController implements Initializable {

    @FXML
    private Label lblName;
    @FXML
    private Label lblScore;
    @FXML
    private Button btnPlayAgain;

    User u = new User();

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        lblName.setText("Name: " + u.getName());
        lblScore.setText("Score: " + u.score);
        u.score = 0;
    }

    @FXML
    private void handlePlayAgainBtn(ActionEvent event) {
        try {
            Parent question = FXMLLoader.load(getClass().getResource("FXMLQuestions.fxml"));
            Scene scene = new Scene(question);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
