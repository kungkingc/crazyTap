/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package taptap;

import java.awt.Color;
import java.awt.Rectangle;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Mac
 */


public class TapTap extends Application {
    Stage window;
    Scene scene1,scene2,scene3;
    @Override
    public void start(Stage primaryStage) throws Exception{
        window = primaryStage;
        
        Label label1 = new Label("Welcome to TapTap!");
        Button btn = new Button("Go to Scene 2");

        //layout 1
        StackPane layout1 = new StackPane();
        layout1.getChildren().addAll( label1,btn);
        layout1.setAlignment(label1,Pos.TOP_CENTER);
        layout1.setAlignment(btn,Pos.CENTER);
        
        scene1 = new Scene(layout1,800,600);
        
        //layout 2

        Button btn2 = new Button("Go to Scene 1");
        Button btn3 = new Button("eiei");
        Pane layout2 = new Pane();
        layout2.getChildren().add(btn2);
        btn2.setTranslateX(100);
        btn2.setTranslateY(100);
        
        scene2 = new Scene(layout2,800,600);
        
        
        Pane eiei = new Main().getPane();
        scene3 = new Scene(eiei);
        eiei.getChildren().add(btn3);
        
        //Action
        btn.setOnAction(e -> window.setScene(scene2));
        btn2.setOnAction(e -> window.setScene(scene3)); 
        btn3.setOnAction(e -> window.setScene(scene1));
        
        window.setScene(scene1);
        
        window.setTitle("Hello World!");
        window.setScene(scene1);
        window.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
