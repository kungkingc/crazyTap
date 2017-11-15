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


public class Play {
    public Pane gameApp() throws IOException 
    {
        Pane game = new Pane();
        
        InputStream input = Files.newInputStream(Paths.get("Image\\basicBg.png"));
        InputStream pause1 = Files.newInputStream(Paths.get("Image\\pause1.png"));
        InputStream pause2 = Files.newInputStream(Paths.get("Image\\pause2.png"));
        InputStream lifeline = Files.newInputStream(Paths.get("Image\\LifeLine.png"));
        InputStream green1 = Files.newInputStream(Paths.get("Image\\greenBtn1.png"));
        InputStream blue1 = Files.newInputStream(Paths.get("Image\\blueBtn1.png"));
        InputStream pink1 = Files.newInputStream(Paths.get("Image\\pinkBtn1.png"));
        InputStream purple1 = Files.newInputStream(Paths.get("Image\\purpleBtn1.png"));
        InputStream green2 = Files.newInputStream(Paths.get("Image\\greenBtn2.png"));
        InputStream blue2 = Files.newInputStream(Paths.get("Image\\blueBtn2.png"));
        InputStream pink2 = Files.newInputStream(Paths.get("Image\\pinkBtn2.png"));
        InputStream purple2 = Files.newInputStream(Paths.get("Image\\purpleBtn2.png"));
        
        
        Image BgImg = new Image(input);
        Image pause1Img = new Image(pause1);
        Image pause2Img = new Image(pause2);
        Image LifeLineImg = new Image(lifeline);
        Image green1Img = new Image(green1);
        Image blue1Img = new Image(blue1);
        Image pink1Img = new Image(pink1);
        Image purple1Img = new Image(purple1);
        Image green2Img = new Image(green2);
        Image blue2Img = new Image(blue2);
        Image pink2Img = new Image(pink2);
        Image purple2Img = new Image(purple2);
        
        ImageView bg = new ImageView(BgImg);
        ImageView pause = new ImageView(pause1Img);
        ImageView LifeLine = new ImageView(LifeLineImg);
        ImageView green = new ImageView(green1Img);
        ImageView blue = new ImageView(blue1Img);
        ImageView pink = new ImageView(pink1Img);
        ImageView purple = new ImageView(purple1Img);
        
        blue.setX(178);
        blue.setY(500);
        green.setX(283);
        pink.setX(391);
        purple.setX(495);
        
        
        LifeLine.setX(53);
        LifeLine.setY(320);
        
        pause.setX(680);
        pause.setY(30);
        
        blue.setOnKeyReleased(event->blue.setImage(blue1Img));
        blue.setOnKeyPressed(event->blue.setImage(blue2Img));
        
        pause.setOnMouseExited(event-> pause.setImage(pause1Img));
        pause.setOnMouseEntered(event-> pause.setImage(pause2Img));
        pause.setOnMouseClicked(event-> {
            try {
                Main.scene5 = new Scene(new Pause().getPause());
                Main.primaryStage.setScene(Main.scene5);
                Main.primaryStage.show();
            } catch (IOException ex) {
                Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        });
        
        
        game.getChildren().addAll(bg,pause,LifeLine,blue,green,pink,purple);
        
        return game;
    }
}
