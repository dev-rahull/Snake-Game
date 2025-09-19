package snakegame;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class Sound {
    public static void play(String soundFile) {
        try {
            URL url = Sound.class.getResource("/snakegame/audio/" + soundFile);
            if (url == null) {
                System.out.println("Sound file not found: " + soundFile);
                return;
            }
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(url);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println("Sound error: " + e.getMessage());
        }
    }
}
