import java.io.File;
import javax.sound.sampled.*;

public class Player {
    Clip clip;
    String path;
    Boolean isPlaying = false;

    Player(String path){
        this.path = path;
    }


    public void play(String recordName) {

        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(new File(path + "/" + recordName));
            clip = AudioSystem.getClip();


            clip.open(ais);
            clip.start();
            isPlaying = true;
            System.out.println("Воспроизвожу");
            Thread.sleep(clip.getMicrosecondLength()/1000);
            System.out.println("Воспроизведение завершилось");
            isPlaying = false;
            clip.stop();
            clip.close();
            clip = null;

        }catch(Exception ex){
            //ex.printStackTrace();
            System.out.println("Не удалось воспроизвести, неверное название файла или тип(");
        }
    }

    public void stop() {
        if (isPlaying && clip != null) {
            clip.stop();
            clip.close();
        }
    }


}
