package taptap;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    static Pane root;
    static Scene scene1, scene2,scene3,scene4,scene5, gameScene;  
    //scene1 = main,scene2 = howto,scene3 = songLibrary, scene4 = mode , scene5 = pause
    static Stage primaryStage;

    public Parent createContent() throws IOException {
        root = new Pane();
        root.setPrefSize(800, 600);

        InputStream input = Files.newInputStream(Paths.get("C:\\Users\\Mac\\Documents\\java\\TapTap\\src\\taptap\\welcomePageElement.jpg"));
        InputStream play1 = Files.newInputStream(Paths.get("C:\\Users\\Mac\\Documents\\java\\TapTap\\src\\taptap\\play1.png"));
        InputStream play2 = Files.newInputStream(Paths.get("C:\\Users\\Mac\\Documents\\java\\TapTap\\src\\taptap\\play2.png"));
        InputStream howto1 = Files.newInputStream(Paths.get("C:\\Users\\Mac\\Documents\\java\\TapTap\\src\\taptap\\howtoplay1.png"));
        InputStream howto2 = Files.newInputStream(Paths.get("C:\\Users\\Mac\\Documents\\java\\TapTap\\src\\taptap\\howtoplay2.png"));
        InputStream exit1 = Files.newInputStream(Paths.get("C:\\Users\\Mac\\Documents\\java\\TapTap\\src\\taptap\\exit1.png"));
        InputStream exit2 = Files.newInputStream(Paths.get("C:\\Users\\Mac\\Documents\\java\\TapTap\\src\\taptap\\exit2.png"));

        Image ImgInput1 = new Image(input);
        Image ImgPlay1 = new Image(play1);
        Image ImgPlay2 = new Image(play2);
        Image ImgHowto1 = new Image(howto1);
        Image ImgHowto2 = new Image(howto2);
        Image ImgExit1 = new Image(exit1);
        Image ImgExit2 = new Image(exit2);

        ImageView iv1 = new ImageView(ImgInput1);
        ImageView ivPlay = new ImageView(ImgPlay1);
        ImageView ivHowto = new ImageView(ImgHowto1);
        ImageView ivExit = new ImageView(ImgExit1);

        ivPlay.setX(320);
        ivPlay.setY(390);

        ivHowto.setX(200);
        ivHowto.setY(450);

        ivExit.setX(320);
        ivExit.setY(510);

        ivPlay.setOnMouseExited(event -> ivPlay.setImage(ImgPlay1));
        ivPlay.setOnMouseEntered(event -> ivPlay.setImage(ImgPlay2));
        ivPlay.setOnMouseClicked(event -> {
            Pane pane3;
            try {
                pane3 = new SongLibrary().getSong();
                scene3 = new Scene(pane3);
                primaryStage.setScene(scene3);
                primaryStage.show();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
//            Pane pane3 = new Play().gameApp();
//            gameScene = new Scene(pane3);
//            primaryStage.setScene(gameScene);
//            primaryStage.show();
        });
        
        ivHowto.setOnMouseExited(event -> ivHowto.setImage(ImgHowto1));
        ivHowto.setOnMouseEntered(event -> ivHowto.setImage(ImgHowto2));
        ivHowto.setOnMouseClicked(event -> {
            Pane pane2 = new HowToPlay().getPane2();
            scene2 = new Scene(pane2);
            primaryStage.setScene(scene2);
            primaryStage.show();
        });
        
        
        ivExit.setOnMouseExited(event -> ivExit.setImage(ImgExit1));
        ivExit.setOnMouseEntered(event -> ivExit.setImage(ImgExit2));
        ivExit.setOnMouseClicked(event -> System.exit(0));
        

        root.getChildren().addAll(iv1, ivPlay, ivHowto, ivExit);
        return root;
    }

    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        scene1 = new Scene(createContent());
        primaryStage.setTitle("Tap Tap");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
