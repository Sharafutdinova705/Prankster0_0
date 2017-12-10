import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;


public class Recorder extends Thread  {
    private TargetDataLine mike;
    private AudioFileFormat.Type formatType;
    private AudioInputStream audioInputStream;
    private File outputFile;

    public Recorder(TargetDataLine mike, AudioFileFormat.Type formatType, File outputFile) {
        this.mike = mike;
        this.formatType = formatType;
        this.audioInputStream = new AudioInputStream(mike);
        this.outputFile = outputFile;
    }

    public void startRecording() {
        mike.start();
        super.start();
        System.out.println("Запись началась");
    }

    public void stopRecording() {
        mike.stop();
        mike.close();
        System.out.println("Запись завершилась");
    }


    public void run() {
        try {
            AudioSystem.write(audioInputStream, formatType, outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}