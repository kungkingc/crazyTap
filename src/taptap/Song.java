/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taptap;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import static taptap.Main.currentPath;

/**
 *
 * @author macintoshhd
 */
public class Song {

    
    Path musicFile;
    InputStream m;
    Media sound;
    MediaPlayer player;

    public Song(String music) throws IOException {
      if(music.equals("Closer")) {
        musicFile = Paths.get(currentPath.toString(), "Songs", "Closer.mp3");
      } 
      else if(music.equals("Summer")) {
        musicFile = Paths.get(currentPath.toString(), "Songs", "Summer.mp3");
      } 
      else if(music.equals("This is")) {
        musicFile = Paths.get(currentPath.toString(), "Songs", "This is.mp3");
      } 
      else if(music.equals("Roses")) {
        musicFile = Paths.get(currentPath.toString(), "Songs", "Roses.mp3");
      } 
      m = Files.newInputStream(Paths.get(musicFile.toString()));
      sound = new Media(m.toString());
      player = new MediaPlayer(sound);
    }

    public MediaPlayer getPlayer() {
        return player;
    }
   
}
