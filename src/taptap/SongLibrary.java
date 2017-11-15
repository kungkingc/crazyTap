/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taptap;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


/**
 *
 * @author Mac
 */
public class SongLibrary {
    public Pane getSong() throws IOException 
    {
        Pane game = new Pane();
        Button b = new Button("go back");
        
        //this is for test 
        InputStream Closer = Files.newInputStream(Paths.get("Image\\Closer.jpg"));
        InputStream Roses = Files.newInputStream(Paths.get("Image\\Roses.jpg"));
        InputStream Summer = Files.newInputStream(Paths.get("Image\\Summer.jpg"));
        InputStream ThisIs = Files.newInputStream(Paths.get("Image\\ThisIsWhatYouCameFor.jpg"));
        InputStream left1 = Files.newInputStream(Paths.get("Image\\left2.png"));
        InputStream left2 = Files.newInputStream(Paths.get("Image\\left1.png"));
        InputStream right1 = Files.newInputStream(Paths.get("Image\\right2.png"));
        InputStream right2 = Files.newInputStream(Paths.get("Image\\right1.png"));
        InputStream select1 = Files.newInputStream(Paths.get("Image\\select1.png"));
        InputStream select2 = Files.newInputStream(Paths.get("Image\\select2.png"));
        InputStream mainmenu1 = Files.newInputStream(Paths.get("Image\\mainmenu1.png"));
        InputStream mainmenu2 = Files.newInputStream(Paths.get("Image\\mainmenu2.png"));
        
        
        Image ImgCloser = new Image(Closer);
        Image ImgRoses = new Image(Roses);
        Image ImgSummer = new Image(Summer);
        Image ImgThisIs = new Image(ThisIs);
        Image ImgLeft1 = new Image(left1);
        Image ImgLeft2 = new Image(left2);
        Image ImgRight1 = new Image(right1);
        Image ImgRight2 = new Image(right2);
        Image ImgSelect1 = new Image(select1);
        Image ImgSelect2 = new Image(select2);
        Image Imgmain1 = new Image(mainmenu1);
        Image Imgmain2 = new Image(mainmenu2);
        
        
        ImageView bg = new ImageView(ImgCloser);
        ImageView left = new ImageView(ImgLeft1);
        ImageView right = new ImageView(ImgRight1);
        ImageView select = new ImageView(ImgSelect1);
        ImageView mainmenu = new ImageView(Imgmain1);
        
        
        
        left.setX(50);
        left.setY(345);
        right.setX(650);
        right.setY(345);
        select.setX(300);
        select.setY(340);
        mainmenu.setX(250);
        mainmenu.setY(480);
        
        left.setOnMouseExited(event->left.setImage(ImgLeft1));
        left.setOnMouseEntered(event->left.setImage(ImgLeft2));
        left.setOnMouseClicked(event->{
            if(bg.getImage().equals(ImgCloser)) bg.setImage(ImgThisIs);
            else if(bg.getImage().equals(ImgRoses)) bg.setImage(ImgCloser);
            else if(bg.getImage().equals(ImgSummer)) bg.setImage(ImgRoses);
            else if(bg.getImage().equals(ImgThisIs)) bg.setImage(ImgSummer);
        });
        right.setOnMouseExited(event->right.setImage(ImgRight1));
        right.setOnMouseEntered(event->right.setImage(ImgRight2));
        right.setOnMouseClicked(event->{
            if(bg.getImage().equals(ImgCloser)) bg.setImage(ImgRoses);
            else if(bg.getImage().equals(ImgRoses)) bg.setImage(ImgSummer);
            else if(bg.getImage().equals(ImgSummer)) bg.setImage(ImgThisIs);
            else if(bg.getImage().equals(ImgThisIs)) bg.setImage(ImgCloser);
        });
        select.setOnMouseExited(event->select.setImage(ImgSelect1));
        select.setOnMouseEntered(event->select.setImage(ImgSelect2));
        select.setOnMouseClicked(event->{
            Pane pane2;
            try {
                Main.scene4 = new Scene(new Mode().selectMode());
                Main.primaryStage.setScene(Main.scene4);
                Main.primaryStage.show();
            } catch (IOException ex) {
                Logger.getLogger(SongLibrary.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        mainmenu.setOnMouseExited(event->mainmenu.setImage(Imgmain1));
        mainmenu.setOnMouseEntered(event->mainmenu.setImage(Imgmain2));
        mainmenu.setOnMouseClicked(event->{
            try {
                Main.scene1 = new Scene(new Main().createContent());
                Main.primaryStage.setScene(Main.scene1);
                Main.primaryStage.show();
            } catch (IOException ex) {
                Logger.getLogger(SongLibrary.class.getName()).log(Level.SEVERE, null, ex);
            }
                
        });
        
        
        game.getChildren().addAll(b,bg,left,right,select,mainmenu);
        
        return game;
    }
}
