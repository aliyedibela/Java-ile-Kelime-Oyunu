package com.kelime.oyunu;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class KelimeOyunu extends Application {

    private static BorderPane root = new BorderPane();
    
    @Override
    public void start(Stage stage) throws Exception { 
        
        Parent page = FXMLLoader.load(KelimeOyunu.class.getResource("GirisEkran.fxml"));
        root.setCenter(page);
        Scene scene = new Scene(root);
        stage.setMaximized(true);
        stage.setFullScreenExitHint("");
        stage.setFullScreen(true);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Kelime Oyunu");
    }   

    public static void changePage(String fxml) throws IOException{
        try {
            Parent parent = FXMLLoader.load(KelimeOyunu.class.getResource(fxml));
            root.setCenter(parent);  
        } catch (IOException e) {
            System.out.println(e);
        }
    }



    

    public static void main(String[] args) {
        launch(args);
    }
    
}
