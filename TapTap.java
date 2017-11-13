/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taptap;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;


public class TapTap extends Application {

    Button button1;
    public static void main(String[] args) {
       launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Crazy Tap");
        button1 = new Button();
        button1.setText("Start");
        
        StackPane layout = new StackPane();
        layout.getChildren().add(button1);
        
        Scene scene = new Scene(layout, 600,500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
