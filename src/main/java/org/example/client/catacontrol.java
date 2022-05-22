/**
 * Sample Skeleton for 'cata.fxml' Controller Class
 */

package org.example.client;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.entities.Message;

import java.io.IOException;

public class catacontrol {

    @FXML // fx:id="welcomeText"
    private Label welcomeText; // Value injected by FXMLLoader

    @FXML // fx:id="ShowButton"
    private Button ShowButton; // Value injected by FXMLLoader

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

}
