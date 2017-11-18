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
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import static taptap.Main.currentPath;

/**
 *
 * @author Mac
 */
public class Ball {

    int lifeTime = 150;
    Path ball;
    InputStream b;
    Image Img;
    ImageView iv;

    TranslateTransition tt;

    public Ball(String color) throws IOException {
        if (color.equals("blue")) {
            ball = Paths.get(currentPath.toString(), "Image", "blueball.png");
            b = Files.newInputStream(Paths.get(ball.toString()));
            Img = new Image(b);
            iv = new ImageView(Img);
            iv.setX(195);
            iv.setY(0);
        } else if (color.equals("green")) {
            ball = Paths.get(currentPath.toString(), "Image", "greenball.png");
            b = Files.newInputStream(Paths.get(ball.toString()));
            Img = new Image(b);
            iv = new ImageView(Img);
            iv.setX(304);
            iv.setY(0);
        } else if (color.equals("pink")) {
            ball = Paths.get(currentPath.toString(), "Image", "pinkball.png");
            b = Files.newInputStream(Paths.get(ball.toString()));
            Img = new Image(b);
            iv = new ImageView(Img);
            iv.setX(411.5);
            iv.setY(0);
        } else if (color.equals("purple")) {
            ball = Paths.get(currentPath.toString(), "Image", "purpleball.png");
            b = Files.newInputStream(Paths.get(ball.toString()));
            Img = new Image(b);
            iv = new ImageView(Img);
            iv.setX(516.5);
            iv.setY(0);
        }

        tt = new TranslateTransition(Duration.millis(2000), iv);
        tt.setByY(600);
        tt.setNode(iv);
        //tt.setToY(750);

    }

    public void fall() {
        tt.play();
    }

    public ImageView getBall() {
        return iv;
    }
}
