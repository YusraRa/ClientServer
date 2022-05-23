/**
 * Sample Skeleton for 'cata.fxml' Controller Class
 */

package org.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import org.example.App;
import org.example.entities.Message;

import java.io.IOException;

public class catacontrol {

    @FXML // fx:id="ShowButton"
    private Button ShowButton; // Value injected by FXMLLoader

    @FXML // fx:id="welcomeText"
    private Label welcomeText; // Value injected by FXMLLoader

    @FXML // fx:id="signInButton"
    private Button signInButton; // Value injected by FXMLLoader

    @FXML // fx:id="usernameTF"
    private TextField usernameTF; // Value injected by FXMLLoader

    @FXML // fx:id="passwordTF"
    private TextField passwordTF; // Value injected by FXMLLoader

    @FXML // fx:id="signIpButton"
    private Button signIpButton; // Value injected by FXMLLoader
    @FXML // fx:id="instructions"
    private Label instructions; // Value injected by FXMLLoader

    @FXML
    void ShowCatalogue(ActionEvent event) {
        try {
            Message msg=new Message(Message.getAllItems);
            Client.getClient().sendToServer(msg);
            System.out.println("message sent to server to get all products ");

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @FXML
    void signIn(ActionEvent event) {
        if (usernameTF.getText().equals("") || passwordTF.getText().equals("") || usernameTF.getText().equals("Name:") || passwordTF.getText().equals("Password")) {
            instructions.setTextFill(Color.color(0.7, 0, 0));
            instructions.setText("A field or two are empty! please enter your credentials again.");
        } else {
            try {
                Message msg = new Message(Message.getAllItems);
                Client.getClient().sendToServer(msg);
                System.out.println("message sent to server to get all products ");

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

        @FXML
    void signUp(ActionEvent event) {
            try {
                App.setRoot("signUpPage");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }

}
