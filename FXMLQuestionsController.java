package quickquizfx;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mosiur Rahman Sweet
 */
public class FXMLQuestionsController implements Initializable {

    @FXML
    private Label lblWelcome;
    @FXML
    private RadioButton rbOption1;
    @FXML
    private RadioButton rbOption2;
    @FXML
    private RadioButton rbOption3;
    @FXML
    private RadioButton rbOption4;
    @FXML
    private Button btnSubmit;
    @FXML
    private Label lblQuestion;

    Questions[] q = new Questions[5];

    public static int num = 0;
    @FXML
    private ToggleGroup options;
    User u = new User();

    private void setQuestions() {
        lblWelcome.setText("Welcome " + u.getName() + " To Quick Quiz");
        lblQuestion.setText("Q" + (num + 1) + " : " + q[num].question);
        rbOption1.setText(q[num].option1);
        rbOption2.setText(q[num].option2);
        rbOption3.setText(q[num].option3);
        rbOption4.setText(q[num].option4);
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        q[0] = new Questions("What is Java ?", "Programming Language", "Tea", "Juice", "Operating System", "Programming Language");
        q[1] = new Questions("Sob Meyei josh, except....?", "Beder Meye", "Meena", "Amar Classmates", "Gal Gadot", "Beder Meye");
        q[2] = new Questions("Dim Agey na Murgi?", "Dim", "Murgi", "Object", "Main Function", "Dim");
        q[3] = new Questions("I have got an Aladdin News! Here Aladdin means...", "Positive", "Negative", "Both", "None", "Both");
        q[4] = new Questions("haat e ki bolo dekhi ?", "Chocolate", "Misty", "Dudh", "Candy", "Candy");
        setQuestions();
    }

    @FXML
    private void handleSubmitBtn(ActionEvent event) {
        if (num == 3) {
            btnSubmit.setText("Finish");
        }

        if (options.getSelectedToggle() != null) {

            RadioButton usrChoice = (RadioButton) options.getSelectedToggle();
            String usrAnswer = usrChoice.getText();
            if (usrAnswer == q[num].answer) {
                u.score += 1;
            } else {
                u.score -= 0.25;
            }
            System.out.println(u.score);
        }

        if (num == 4) {
            try {
                num=0;
                Parent question = FXMLLoader.load(getClass().getResource("FXMLResult.fxml"));
                Scene scene = new Scene(question);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } else {
            num++;
            options.selectToggle(null);
            setQuestions();
        }
    }
}
