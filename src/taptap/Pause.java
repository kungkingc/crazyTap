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
import static taptap.Main.scene2;

/**
 *
 * @author Mac
 */
public class Pause {
    public Pane getPause() throws IOException 
    {
        Pane game = new Pane();
        Button restartB = new Button("restart");
        Button resumeB = new Button("resume");
        Button exitB = new Button("exit");
        
        InputStream bgInput = Files.newInputStream(Paths.get("C:\\Users\\Mac\\Documents\\java\\TapTap\\src\\Image\\pauseBG.png"));
        InputStream restart1 = Files.newInputStream(Paths.get("C:\\Users\\Mac\\Documents\\java\\TapTap\\src\\Image\\restart1.png"));
        InputStream restart2 = Files.newInputStream(Paths.get("C:\\Users\\Mac\\Documents\\java\\TapTap\\src\\Image\\restart2.png"));
        InputStream continue1 = Files.newInputStream(Paths.get("C:\\Users\\Mac\\Documents\\java\\TapTap\\src\\Image\\continue1.png"));
        InputStream continue2 = Files.newInputStream(Paths.get("C:\\Users\\Mac\\Documents\\java\\TapTap\\src\\Image\\continue2.png"));
        InputStream library1 = Files.newInputStream(Paths.get("C:\\Users\\Mac\\Documents\\java\\TapTap\\src\\Image\\musicLibrary1.png"));
        InputStream library2 = Files.newInputStream(Paths.get("C:\\Users\\Mac\\Documents\\java\\TapTap\\src\\Image\\musicLibrary2.png"));
        
        Image BgImg = new Image(bgInput);
        Image restart1Img = new Image(restart1);
        Image restart2Img = new Image(restart2);
        Image continue1Img = new Image(continue1);
        Image continue2Img = new Image(continue2);
        Image library1Img = new Image(library1);
        Image library2Img = new Image(library2);
        
        ImageView bg = new ImageView(BgImg);
        ImageView restart = new ImageView(restart1Img);
        ImageView continued = new ImageView(continue1Img);
        ImageView library = new ImageView(library1Img);
        
        restart.setX(300);
        restart.setY(200);
        continued.setX(290);
        continued.setY(260);
        library.setX(230);
        library.setY(320);
        
        
        restart.setOnMouseExited(event-> restart.setImage(restart1Img));
        restart.setOnMouseEntered(event-> restart.setImage(restart2Img));
        restart.setOnMouseClicked(event->{
            try {
                Main.gameScene = new Scene(new Play().gameApp());
                Main.primaryStage.setScene(Main.gameScene);
                Main.primaryStage.show();
            } catch (IOException ex) {
                Logger.getLogger(Pause.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
        continued.setOnMouseExited(event-> continued.setImage(continue1Img));
        continued.setOnMouseEntered(event-> continued.setImage(continue2Img));
        continued.setOnMouseClicked(event->{
            try {
                Main.gameScene = new Scene(new Play().gameApp());
                Main.primaryStage.setScene(Main.gameScene);
                Main.primaryStage.show();
            } catch (IOException ex) {
                Logger.getLogger(Pause.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
        library.setOnMouseExited(event-> library.setImage(library1Img));
        library.setOnMouseEntered(event-> library.setImage(library2Img));
        library.setOnMouseClicked(event->{
            try {
                Main.scene3 = new Scene(new SongLibrary().getSong());
                Main.primaryStage.setScene(Main.scene3);
                Main.primaryStage.show();
            } catch (IOException ex) {
                Logger.getLogger(Pause.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
        
        
        game.getChildren().addAll(bg,restart,continued,library);
        
        return game;
    }
}
