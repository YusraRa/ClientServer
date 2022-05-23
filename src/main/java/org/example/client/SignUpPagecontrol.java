package org.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import org.example.App;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SignUpPagecontrol {

    @FXML
    private Label phoneTF;

    @FXML
    private Label passwordTF;

    @FXML
    private TextField nameTF;

    @FXML
    private TextField idTF;

    @FXML
    private Button signUpButton;

    @FXML
    private Label instructions;

    @FXML
    void signUp(ActionEvent event) throws InterruptedException {
            if (nameTF.getText().equals("") || passwordTF.getText().equals("") || idTF.getText().equals("") || phoneTF.getText().equals("")) {
                instructions.setTextFill(Color.color(0.7, 0, 0));
                instructions.setText("there is an empty field please, fill out all required information.");
            }
            else {
                try {
                    App.setRoot("cata");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
    }
}

