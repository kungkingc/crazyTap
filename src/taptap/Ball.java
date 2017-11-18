/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taptap;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static taptap.Main.currentPath;

/**
 *
 * @author Mac
 */
public class Ball {
    
    Path ball;
    InputStream b;
    Image Img;
    ImageView iv;
    public Ball(String color) throws IOException {
        if(color.equals("blue"))
            ball = Paths.get(currentPath.toString(), "Image", "blueball.png");
        else if(color.equals("green"))
            ball = Paths.get(currentPath.toString(), "Image", "greenball.png");
        else if(color.equals("pink"))
            ball = Paths.get(currentPath.toString(), "Image", "pinkball.png");
        else if(color.equals("purple"))
            ball = Paths.get(currentPath.toString(), "Image", "purpleball.png");
        
        b = Files.newInputStream(Paths.get(ball.toString()));
        Img = new Image(b);
        iv = new ImageView(Img);
    }
    public ImageView getBall(){
        return iv;
    }
}
