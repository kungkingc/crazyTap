package taptap;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import static taptap.Main.gameScene;

public class HowToPlay{

    public Pane getPane2(){
        Pane p2 = new Pane();
        Button b2 = new Button("Play TapTap");
        
        
        p2.getChildren().add(b2);
        
        return p2;
    }
}
