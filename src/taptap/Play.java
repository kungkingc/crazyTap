package taptap;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Box;
import javafx.util.Duration;
import static taptap.Main.scene2;
import static taptap.Main.currentPath;

public class Play implements EventHandler<KeyEvent> {

    Image Imgblue1;
    Image Imgblue2;
    Image Imggreen1;
    Image Imggreen2;
    Image Imgpink1;
    Image Imgpink2;
    Image Imgpurple1;
    Image Imgpurple2;

    ImageView bg;
    ImageView pause;
    ImageView LifeLine;
    ImageView ivblue;
    ImageView ivgreen;
    ImageView ivpink;
    ImageView ivpurple;
    
    ImageView blueball;
    ImageView greenball;
    ImageView pinkball;
    ImageView purpleball;
    
    
    public Pane gameApp() throws IOException {
        Pane game = new Pane();
        Path gameScreenPath = Paths.get(currentPath.toString(), "Image", "basicBg.png");
        Path pause1Path = Paths.get(currentPath.toString(), "Image", "pause1.png");
        Path pause2Path = Paths.get(currentPath.toString(), "Image", "pause2.png");
        Path lifelinePath = Paths.get(currentPath.toString(), "Image", "LifeLine.png");
        Path blue1Path = Paths.get(currentPath.toString(), "Image", "blue1.png");
        Path blue2Path = Paths.get(currentPath.toString(), "Image", "blue2.png");
        Path green1Path = Paths.get(currentPath.toString(), "Image", "green1.png");
        Path green2Path = Paths.get(currentPath.toString(), "Image", "green2.png");
        Path pink1Path = Paths.get(currentPath.toString(), "Image", "pink1.png");
        Path pink2Path = Paths.get(currentPath.toString(), "Image", "pink2.png");
        Path purple1Path = Paths.get(currentPath.toString(), "Image", "purple1.png");
        Path purple2Path = Paths.get(currentPath.toString(), "Image", "purple2.png");
        
        InputStream input = Files.newInputStream(Paths.get(gameScreenPath.toString()));
        InputStream pause1 = Files.newInputStream(Paths.get(pause1Path.toString()));
        InputStream pause2 = Files.newInputStream(Paths.get(pause2Path.toString()));
        InputStream lifeline = Files.newInputStream(Paths.get(lifelinePath.toString()));
        InputStream blue1 = Files.newInputStream(Paths.get(blue1Path.toString()));
        InputStream blue2 = Files.newInputStream(Paths.get(blue2Path.toString()));
        InputStream green1 = Files.newInputStream(Paths.get(green1Path.toString()));
        InputStream green2 = Files.newInputStream(Paths.get(green2Path.toString()));
        InputStream pink1 = Files.newInputStream(Paths.get(pink1Path.toString()));
        InputStream pink2 = Files.newInputStream(Paths.get(pink2Path.toString()));
        InputStream purple1 = Files.newInputStream(Paths.get(purple1Path.toString()));
        InputStream purple2 = Files.newInputStream(Paths.get(purple2Path.toString()));
        
        
        Image BgImg = new Image(input);
        Image pause1Img = new Image(pause1);
        Image pause2Img = new Image(pause2);
        Image LifeLineImg = new Image(lifeline);
        
        
        
        Imgblue1 = new Image(blue1);
        Imgblue2 = new Image(blue2);
        Imggreen1 = new Image(green1);
        Imggreen2 = new Image(green2);
        Imgpink1 = new Image(pink1);
        Imgpink2 = new Image(pink2);
        Imgpurple1 = new Image(purple1);
        Imgpurple2 = new Image(purple2);
       
        
        bg = new ImageView(BgImg);
        pause = new ImageView(pause1Img);
        LifeLine = new ImageView(LifeLineImg);
        ivblue = new ImageView(Imgblue1);
        ivgreen = new ImageView(Imggreen1);
        ivpink = new ImageView(Imgpink1);
        ivpurple = new ImageView(Imgpurple1);
        
        
        LifeLine.setX(53);
        LifeLine.setY(320);

        pause.setX(680);
        pause.setY(30);

        ivblue.setX(181.5);
        ivgreen.setX(286.5);
        ivpink.setX(395);
        ivpurple.setX(501);
        ivblue.setY(490);
        ivgreen.setY(490);
        ivpink.setY(490);
        ivpurple.setY(490);
        

        

        pause.setOnMouseExited(event -> pause.setImage(pause1Img));
        pause.setOnMouseEntered(event -> pause.setImage(pause2Img));
        pause.setOnMouseClicked(event -> {
            try {
                Main.scene5 = new Scene(new Pause().getPause());
                Main.primaryStage.setScene(Main.scene5);
                Main.primaryStage.show();
            } catch (IOException ex) {
                Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
            }

        });

        final TextField textBox = new TextField();
        textBox.setPromptText("Write here");

        textBox.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if(ke.getText().equals("d")) ivblue.setImage(Imgblue2);
                else if(ke.getText().equals("f")) ivgreen.setImage(Imggreen2);
                else if(ke.getText().equals("j")) ivpink.setImage(Imgpink2);
                else if(ke.getText().equals("k")) ivpurple.setImage(Imgpurple2);
                
                //System.out.println("Key Pressed: " + ke.getText());
                
            }
        });

        textBox.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {
                if(ke.getText().equals("d")) ivblue.setImage(Imgblue1);
                else if(ke.getText().equals("f")) ivgreen.setImage(Imggreen1);
                else if(ke.getText().equals("j")) ivpink.setImage(Imgpink1);
                else if(ke.getText().equals("k")) ivpurple.setImage(Imgpurple1);
                //System.out.println("Key Released: " + ke.getText());
                
            }
        });

        
        TranslateTransition tt = new TranslateTransition(Duration.millis(2000), ivbb);
     tt.setByY(700);
     tt.setCycleCount(4);
     tt.setAutoReverse(true);
 
     tt.play();
     
     
        //Main.gameScene.setOnKeyPressed(event -> System.out.println("ahhhhh"));
//        Main.gameScene.addEventFilter(KeyEvent.KEY_PRESSED,
//                event -> System.out.println("Pressed: " + event.getCode()));
        game.getChildren().addAll(textBox,bg, pause, LifeLine, ivblue, ivgreen, ivpink, ivpurple,ivbb);
        return game;
    }

    public void handle(KeyEvent arg0) {
        if (arg0.getCode() == KeyCode.SPACE) {
            //ivblue.setImage(Imgblue2);

        }
    }
}
