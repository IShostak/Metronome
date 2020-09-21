package Metronome;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import java.io.File;


public class ClickLogic implements Runnable{
    public boolean isPlaying = false;
    public ClickLogic() {
        currentValue = 100;
    }
    private Media sound = new Media(
            new File("src\\Metronome\\Sound\\1.wav")
            .toURI().toString());
    private MediaPlayer mediaPlayer = new MediaPlayer(sound);

    static final int MIN_VALUE = 40;
    static final int MAX_VALUE = 220;
    private final int oneMinute = 60*1000;
    static int currentValue = 100;
    private final int worktime = 117; //need to assign right value(what time program need to play sound once )

    public static int getCurrentValue() {
        return currentValue;
    }

    public static void setCurrentValue(int currentValue) {
        ClickLogic.currentValue = currentValue;
    }

    @Override
    public void run() {
            mediaPlayer.setOnEndOfMedia(new Runnable() {  //infinite play for audio file
                @Override
                public void run() {
                    try {
                        Thread.sleep(oneMinute / currentValue - worktime);
                        // simple formula beats per minute
                        // Need to consider how long program need to one start+stop+play audio im ml
                        // and assign this value to worktime to have right metronome
                        // now it's ~0.01 sec wrong
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mediaPlayer.seek(Duration.ZERO);   //change audio position to start
                    mediaPlayer.play();                //play again
                    if (isPlaying) mediaPlayer.stop(); //in case some1 have pressed stop button
                }
            });
            mediaPlayer.play();
        }
}
