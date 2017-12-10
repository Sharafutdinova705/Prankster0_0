import javax.sound.sampled.*;
import java.io.File;

public class DictaphoneManager {

    Recorder recorder;
    Player player;
    String path;

    public DictaphoneManager(String path) {
        this.path = path;

        File directory = new File(path);
        if (! directory.exists()){
            directory.mkdir();
        }

    }

    public void startRecord(String recordName) {


        File outputFile = new File(path + "/" + recordName + ".wav");

        AudioFormat audioFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,44100, 16,  2, 4, 44100, false);

        //получаем доступ к микрофону
        DataLine.Info info = new DataLine.Info(TargetDataLine.class, audioFormat);

        try {
            TargetDataLine targetDataLine = (TargetDataLine) AudioSystem.getLine(info);
            targetDataLine.open(audioFormat);

            //начинается запись
            recorder = new Recorder(targetDataLine, AudioFileFormat.Type.WAVE, outputFile);
            recorder.startRecording();

        } catch (LineUnavailableException e) {
            System.out.println("unable to get a recording line");
        }


    }

    public void stopRecord() {
        if (recorder != null) {
            System.out.println("stopRecord");
            recorder.stopRecording();
        }
    }

    public void showList() {
        System.out.println("Список файлов:");
        File[] files = new File(path).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }
    }


    public void startPlay(String recordName) {
        player = new Player(path);
        player.play(recordName);
    }


    public void stopPlay() {
        if (player != null) {
            player.stop();
        }
    }


    public void deleteRecord(String recordName) {
        File file = new File(path + "/" + recordName);
        if(file.delete()){
            System.out.println(recordName + " удален");
        } else {
            System.out.println("Файл " + recordName  + " не обнаружен");
        }
    }


    public String commands() {
        return "1. Начать запись\n2. Закончить запись\n3. Показать список\n4. Воспроизвести\n5. Остановить воспроизведение \n6. Удалить запись\n0. Выйти";

    }
}
