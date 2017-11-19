package taptap;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
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
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Box;
import javafx.util.Duration;
import static taptap.Main.scene2;
import static taptap.Main.currentPath;
import java.sql.*;
import java.util.ArrayList;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.util.Duration;
import java.text.DecimalFormat;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class Play {

    Duration time = Duration.millis(0);

    //Score score = new Score();
    int score = 0;

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
    ImageView ivblue;
    ImageView ivgreen;
    ImageView ivpink;
    ImageView ivpurple;

    ArrayList<Integer> arrayPos1 = new ArrayList<Integer>();
    ArrayList<Integer> arrayPos2 = new ArrayList<Integer>();
    ArrayList<Integer> arrayPos3 = new ArrayList<Integer>();
    ArrayList<Integer> arrayPos4 = new ArrayList<Integer>();
    ArrayList<Integer> tryTime = new ArrayList<Integer>();
    private Connection connect1;
    private Statement stat1;
    private ResultSet rs;

    //ArrayList<Ball> ballList;
    ArrayList<Ball> blueList;
    ArrayList<Ball> greenList;
    ArrayList<Ball> pinkList;
    ArrayList<Ball> purpleList;

    ArrayList<TranslateTransition> transList;
    //private int time;
    //private int songDuration;
    //MyTime time = new MyTime();
    int comp;
    Label scoreLabel = new Label("0");
    Label highLabel = new Label("");
    int highScore;
    String songname;
    String mode;

    public Pane gameApp(String songname, String mode) throws IOException, SQLException, ClassNotFoundException {
        //boolean state = false;
        highScore hScore = new highScore();
        this.songname = songname;
        this.mode = mode;

        Pane game = new Pane();
        Path gameScreenPath = Paths.get(currentPath.toString(), "Image", "basicBg.png");
        Path pause1Path = Paths.get(currentPath.toString(), "Image", "pause1.png");
        Path pause2Path = Paths.get(currentPath.toString(), "Image", "pause2.png");
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

        scoreLabel.setTranslateX(85);
        scoreLabel.setTranslateY(100);
        scoreLabel.setScaleX(3);
        scoreLabel.setScaleY(3);
        scoreLabel.setTextFill(Color.web("#FFD4F4"));

        highLabel.setTranslateX(85);
        highLabel.setTranslateY(450);
        highLabel.setScaleX(3);
        highLabel.setScaleY(3);
        highLabel.setTextFill(Color.web("#FFD4F4"));

        //ballList = new ArrayList<Ball>();
        blueList = new ArrayList<Ball>();
        greenList = new ArrayList<Ball>();
        pinkList = new ArrayList<Ball>();
        purpleList = new ArrayList<Ball>();
        transList = new ArrayList<TranslateTransition>();

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
        ivblue = new ImageView(Imgblue1);
        ivgreen = new ImageView(Imggreen1);
        ivpink = new ImageView(Imgpink1);
        ivpurple = new ImageView(Imgpurple1);

        pause.setX(680);
        pause.setY(30);

        //button pos 
        ivblue.setX(181.5);
        ivgreen.setX(286.5);
        ivpink.setX(395);
        ivpurple.setX(501);
        ivblue.setY(490);
        ivgreen.setY(490);
        ivpink.setY(490);
        ivpurple.setY(490);

        // get location positions
        //nat's path
        //connect1 = DriverManager.getConnection("jdbc:ucanaccess:///Users/macintoshhd/Desktop/crazyTap/tapNodes.accdb");
        //fon's path
        //connect1 = DriverManager.getConnection("jdbc:ucanaccess://C://Users//Mac//Desktop//crazyTap//tapNodes.accdb");
        //kk's path
        connect1 = DriverManager.getConnection("jdbc:ucanaccess://C://Users//Macbook Pro//Documents//GitHub//crazyTap//tapNodes.accdb");
        stat1 = connect1.createStatement();
        String selectcloserE = "select time, col1, col2, col3,col4 from closer1";
        String selectcloserM = "select time, col1, col2, col3,col4 from closer2";
        //String selecteasycloser = "select "
        if (songname.equals("Closer")) {
            if (mode.equals("easy")) {
                rs = stat1.executeQuery(selectcloserE);
                highScore = hScore.getCloser1();
                highLabel.setText("" + highScore);
            } else if (mode.equals("medium")) {
                rs = stat1.executeQuery(selectcloserE);
                highScore = hScore.getCloser2();
                highLabel.setText("" + highScore);
            } else {
                rs = stat1.executeQuery(selectcloserE);
                highScore = hScore.getCloser3();
                highLabel.setText("" + highScore);
            }
        } else if (songname.equals("Roses")) {
            if (mode.equals("easy")) {
                rs = stat1.executeQuery(selectcloserE);
                highScore = hScore.getRoses1();
                highLabel.setText("" + highScore);
            } else if (mode.equals("medium")) {
                rs = stat1.executeQuery(selectcloserE);
                highScore = hScore.getRoses2();
                highLabel.setText("" + highScore);
            } else {
                rs = stat1.executeQuery(selectcloserE);
                highScore = hScore.getRoses3();
                highLabel.setText("" + highScore);
            }
        } else if (songname.equals("Summer")) {
            if (mode.equals("easy")) {
                rs = stat1.executeQuery(selectcloserE);
                highScore = hScore.getSummer1();
                highLabel.setText("" + highScore);
            } else if (mode.equals("medium")) {
                rs = stat1.executeQuery(selectcloserE);
                highScore = hScore.getSummer2();
                highLabel.setText("" + highScore);
            } else {
                rs = stat1.executeQuery(selectcloserE);
                highScore = hScore.getSummer3();
                highLabel.setText("" + highScore);
            }
        } else if (songname.equals("This is")) {
            if (mode.equals("easy")) {
                rs = stat1.executeQuery(selectcloserE);
                highScore = hScore.getThisIs1();
                highLabel.setText("" + highScore);
            } else if (mode.equals("medium")) {
                rs = stat1.executeQuery(selectcloserE);
                highScore = hScore.getThisIs2();
                highLabel.setText("" + highScore);
            } else {
                rs = stat1.executeQuery(selectcloserE);
                highScore = hScore.getThisIs3();
                highLabel.setText("" + highScore);
            }
        }

        while (rs.next()) {
            int timey = rs.getInt(1);
            int pos1 = rs.getInt(2);
            int pos2 = rs.getInt(3);
            int pos3 = rs.getInt(4);
            int pos4 = rs.getInt(5);
            tryTime.add(timey);
            arrayPos1.add(pos1);
            arrayPos2.add(pos2);
            arrayPos3.add(pos3);
            arrayPos4.add(pos4);

            //System.out.println(timey + " " + pos1+ " " + pos2+ " " +pos3+ " " +pos4);
        }

        //MediaPlayer closer = new Song("Closer").getPlayer();
        //closer.play();
        MediaPlayer summer = new Song(songname).getPlayer();

        final TextField textBox = new TextField();
        textBox.setPromptText("Write here");

        Duration summerTime = Duration.millis(5720);

        int comp = tryTime.get(0);
        System.out.println("comp = " + comp);
        int index = 0;

        summer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                for (Ball ball : blueList) {
                    ball.setUpdatedY(ball.iv.getTranslateY());
                }
                for (Ball ball : greenList) {
                    ball.setUpdatedY(ball.iv.getTranslateY());
                }
                for (Ball ball : pinkList) {
                    ball.setUpdatedY(ball.iv.getTranslateY());
                }
                for (Ball ball : purpleList) {
                    ball.setUpdatedY(ball.iv.getTranslateY());
                }
                if ((int) newValue.toMillis() == (int) summer.getMedia().getDuration().toMillis()) {
                    Pane pane3;
                    try {
                        hScore.rewrite(highScore, songname, mode);
                        pane3 = new ShowScore().showScore(score, highScore);
                        Main.scene6 = new Scene(pane3,800,600);
                        Main.primaryStage.setScene(Main.scene6);
                        Main.primaryStage.show();
                    } catch (IOException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });

        //System.out.println("Summer du ="+(int)summer.getTotalDuration().toSeconds());
        while (summerTime.greaterThan(time)) {
            if ((int) time.toMillis() == comp) {
                if (arrayPos1.get(index) == 1) {

                    Ball temp = new Ball("blue");
                    ImageView iv = temp.getBall();
                    TranslateTransition tt = new TranslateTransition(Duration.millis(1500), iv);
                    tt.setToY(700);
                    tt.setDelay(Duration.millis((int) time.toMillis()));
                    tt.play();

                    transList.add(tt);
                    blueList.add(temp);

                    System.out.println("1");
                }
                if (arrayPos2.get((int) time.toSeconds()) == 1) {
                    Ball temp = new Ball("green");
                    ImageView iv = temp.getBall();
                    TranslateTransition tt = new TranslateTransition(Duration.millis(1500), iv);
                    tt.setToY(700);
                    tt.setDelay(Duration.millis((int) time.toMillis()));
                    tt.play();

                    transList.add(tt);
                    greenList.add(temp);
                    System.out.println("2");
                }
                if (arrayPos3.get((int) time.toSeconds()) == 1) {
                    Ball temp = new Ball("pink");
                    ImageView iv = temp.getBall();
                    TranslateTransition tt = new TranslateTransition(Duration.millis(1500), iv);
                    tt.setToY(700);
                    tt.setDelay(Duration.millis((int) time.toMillis()));
                    tt.play();

                    transList.add(tt);
                    pinkList.add(temp);
                    System.out.println("3");
                }
                if (arrayPos4.get((int) time.toSeconds()) == 1) {
                    Ball temp = new Ball("purple");
                    ImageView iv = temp.getBall();
                    TranslateTransition tt = new TranslateTransition(Duration.millis(1500), iv);
                    tt.setToY(700);
                    tt.setDelay(Duration.millis((int) time.toMillis()));
                    tt.play();

                    transList.add(tt);
                    purpleList.add(temp);
                    System.out.println("4");
                }
                index++;
                comp = tryTime.get(index);
            }

            textBox.setOnKeyPressed(new TextBoxHandler());

            textBox.setOnKeyReleased(new EventHandler<KeyEvent>() {
                @Override
                public void handle(KeyEvent ke) {

                    if (ke.getText().equals("s")) {
                        ivblue.setImage(Imgblue1);
                    } else if (ke.getText().equals("d")) {
                        ivgreen.setImage(Imggreen1);
                    } else if (ke.getText().equals("j")) {
                        ivpink.setImage(Imgpink1);
                    } else if (ke.getText().equals("k")) {
                        ivpurple.setImage(Imgpurple1);
                    }

                }

            });

            time = time.add(Duration.millis(1));
            //System.out.println("time : " + (int) time.toMillis());
        }

        pause.setOnMouseExited(event
                -> pause.setImage(pause1Img));
        pause.setOnMouseEntered(event
                -> pause.setImage(pause2Img));
        pause.setOnMouseClicked(event
                -> {
            try {
                summer.pause();
                Main.scene5 = new Scene(new Pause().getPause(songname, mode));
                Main.primaryStage.setScene(Main.scene5);
                Main.primaryStage.show();
            } catch (IOException ex) {
                Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
        new Thread(new Runnable() {

            public void run() {
                try {
                    Thread.sleep(820);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Play.class.getName()).log(Level.SEVERE, null, ex);
                }

                //do something.........
                System.out.println("all things done");
            }
        }).run();
        summer.play();
        System.out.println("Score = " + score);
        game.getChildren().addAll(textBox, bg, pause);
        for (int i = 0; i < blueList.size(); i++) {
            game.getChildren().add(blueList.get(i).getBall());
            System.out.println("getbb");

        }
        for (int i = 0; i < greenList.size(); i++) {
            game.getChildren().add(greenList.get(i).getBall());
            System.out.println("getgb");
        }
        for (int i = 0; i < pinkList.size(); i++) {
            game.getChildren().add(pinkList.get(i).getBall());
            System.out.println("getpb");
        }
        for (int i = 0; i < purpleList.size(); i++) {
            game.getChildren().add(purpleList.get(i).getBall());
            System.out.println("getppb");
        }

        game.getChildren().addAll(ivblue, ivgreen, ivpink, ivpurple, scoreLabel, highLabel);
        return game;
    }

    private class TextBoxHandler implements EventHandler<KeyEvent> {

        public void handle(KeyEvent ke) {
            if (ke.getText().equals("s")) {
                ivblue.setImage(Imgblue2);
                for (Ball ball : blueList) {
                    System.out.println(ball.getY());
                    if (ball.getY() >= 490 && ball.getY() < 599) {
                        score += 5;
                        System.out.println("blue hit " + score);
                    }
                }

            } else if (ke.getText().equals("d")) {
                ivgreen.setImage(Imggreen2);
                for (Ball ball : greenList) {
                    System.out.println(ball.getY());
                    if (ball.getY() >= 490 && ball.getY() < 599) {
                        score += 5;
                        System.out.println("green hit " + score);
                    }
                }
            } else if (ke.getText().equals("j")) {
                ivpink.setImage(Imgpink2);
                for (Ball ball : pinkList) {
                    System.out.println(ball.getY());
                    if (ball.getY() >= 490 && ball.getY() < 599) {
                        score += 5;
                        System.out.println("pink hit " + score);
                    }
                }
            } else if (ke.getText().equals("k")) {
                ivpurple.setImage(Imgpurple2);
                for (Ball ball : purpleList) {
                    System.out.println(ball.getY());
                    if (ball.getY() >= 490 && ball.getY() < 599) {
                        score += 5;
                        System.out.println("purple hit " + score);
                    }
                }
            }
            scoreLabel.setText(score + "");
            if (highScore < score) {
                highScore = score;
                highLabel.setText("" + highScore);
            }
            //System.out.println("Key Pressed: " + ke.getText());
        }
    }

}
