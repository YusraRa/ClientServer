package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.client.Client;

import java.io.IOException;

public class App extends Application {
    public static Client client;
    private static Scene scene;
    public static Stage appStage;


    @Override
    public void start(Stage stage) throws IOException {
        client = Client.getClient();
        try{
            client.openConnection();
            System.out.println("Hi, i'm Connected");
        }catch (IOException e) {
            // todo handle catch
            e.printStackTrace();
        }

        scene = new Scene(loadFXML("cata"), 640, 480);
        stage.setScene(scene);
        stage.setTitle("Welcome Screen");
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }


//    public static void requestAllItems(){
//        Message message = new Message(Message.getAllItems);
//        client.sendMessageToServer(message);
//    }

//    public static void ShowAllItems(List<Item> items){
//        HBox mainHbox = new HBox(40);
//
//        Button updateBtn = new Button("Update");
//        updateBtn.setOnAction(e -> {
//            requestAllItems();
//        });
//        mainHbox.getChildren().add(updateBtn);
//
//        for (Item item : items) {
//            VBox vbox = new VBox(10);
//
//            Label name = new Label(item.name);
//            Label kind = new Label(item.kind);
//            Label price = new Label(Double.toString(item.price));
//            Button editBTN = new Button("Edit");
//            editBTN.setOnAction(e -> {
//                editItem(item);
//            });
//
//            vbox.getChildren().addAll(name, kind, price, editBTN);
//
//            mainHbox.getChildren().add(vbox);
//
//        }
//
//        Scene newScene = new Scene(mainHbox, 800, 800);
//        appStage.setScene(newScene);
//        appStage.show();
//    }
//
//    public static void editItem(Item item) {
//        VBox vbox = new VBox(10);
//
//        Label name = new Label(item.name);
//        Label kind = new Label(item.kind);
//        TextField price = new TextField(Double.toString(item.price));
//        Button saveBtn = new Button("Save");
//
//        vbox.getChildren().addAll(name, kind, price, saveBtn);
//
//        Scene newScene = new Scene(vbox, 200, 200);
//        Stage newStage = new Stage();
//        newStage.setScene(newScene);
//        newStage.show();
//        saveBtn.setOnAction(e -> {
//            item.price = Double.parseDouble(price.getText());
//            Message message1 = new Message(Message.updateItem, item);
//            client.sendMessageToServer(message1);
//            newStage.close();
//        });
//    }
}
