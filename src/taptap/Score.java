/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taptap;

/**
 *
 * @author Mac
 */
public class Score {
    int score;

    public Score(int score) {
        this.score = score;
    }
    
    public void addScore(int score){
        this.score+=score;
    }
    
    public void setScore(int score){
        this.score= score;
    }
    
}
