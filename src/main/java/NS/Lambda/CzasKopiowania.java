package NS.Lambda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.util.logging.ConsoleHandler;

public class CzasKopiowania {

    public static void main(String[] args) throws IOException {
        File source = new File("source.txt");
        File target = new File("target.txt");
        System.out.println("Stream: " + fileCopyTime(FileCopy.usingStream, source, target));
        System.out.println("Channel: " + fileCopyTime(FileCopy.usingChanel, source, target));
        System.out.println("Files: " + fileCopyTime(FileCopy.usingFiles, source, target));

    }

    public static double fileCopyTime(FileCopy fileCopy, File src, File trgt) throws IOException {
        long start = System.nanoTime();

        //zlap czas poczatkowy

        //przekopiuj
        fileCopy.copy(src,trgt);

        //zlap czas po zakonczeniu
        long end = System.nanoTime();

        //zwroc wartosc
        return end-start;
    }
}
interface FileCopy {

    void copy(File src, File trgt) throws IOException;

    FileCopy usingChanel = (src, trgt) -> {
        FileChannel sourceChannel = null;
        FileChannel destChannel = null;
        sourceChannel = new FileInputStream(src).getChannel();
        destChannel = new FileOutputStream(trgt).getChannel();
        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
        destChannel.close();
        sourceChannel.close();

    };

    FileCopy usingStream = (src, trgt) -> {
        try (FileInputStream in = new FileInputStream(src);
             FileOutputStream out = new FileOutputStream(trgt)) {
            int anotherByte;

            while (((anotherByte = in.read()) != -1)) {
                out.write(anotherByte);
            }
        }
    };

    FileCopy usingFiles = (src, trgt) -> Files.copy(src.toPath(), src.toPath());

}
