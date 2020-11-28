package com.georgeangelov;

import com.georgeangelov.datamodel.InviteListData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("UI/mainWindow.fxml"));
        primaryStage.setTitle("Invite List");
        primaryStage.setScene(new Scene(root, 700, 380));
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void stop() throws Exception {
        try {
            InviteListData.getInstance().saveInviteListItems();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void init(){
        InviteListData.getInstance().loadInviteListItems();
    }
}
