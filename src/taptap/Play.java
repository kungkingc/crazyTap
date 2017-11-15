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
        
        InputStream input = Files.newInputStream(Paths.get("C:\\Users\\Mac\\Documents\\java\\TapTap\\src\\Image\\gameScreen.jpg"));
        InputStream pause1 = Files.newInputStream(Paths.get("C:\\Users\\Mac\\Documents\\java\\TapTap\\src\\Image\\pause1.png"));
        InputStream pause2 = Files.newInputStream(Paths.get("C:\\Users\\Mac\\Documents\\java\\TapTap\\src\\Image\\pause2.png"));
        InputStream lifeline = Files.newInputStream(Paths.get("C:\\Users\\Mac\\Documents\\java\\TapTap\\src\\Image\\LifeLine.png"));
        
        Image BgImg = new Image(input);
        Image pause1Img = new Image(pause1);
        Image pause2Img = new Image(pause2);
        Image LifeLineImg = new Image(lifeline);
        
        ImageView bg = new ImageView(BgImg);
        ImageView pause = new ImageView(pause1Img);
        ImageView LifeLine = new ImageView(LifeLineImg);
        
        LifeLine.setX(53);
        LifeLine.setY(320);
        
        pause.setX(680);
        pause.setY(30);
        
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
        
        
        game.getChildren().addAll(bg,pause,LifeLine);
        
        return game;
    }
}
