package ps.lambda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.StandardCopyOption;
import java.util.function.Function;

public class Copy {

    public static void main(String[] args) {
        String path = "src/main/java/lambda/";
        File source = new File(path + "loremIpsum.txt");
        File streamsTarget = new File(path + "loremStreams.txt");
        File filesTarget = new File(path + "loremFiles.txt");
        File channelsTarget = new File(path + "loremChannels.txt");

        System.out.println("Using streams: ");
        timeThis(CopyInterface.usingStreams, source, streamsTarget);
        System.out.println("Using Files: ");
        timeThis(CopyInterface.usingFiles, source, filesTarget);
        System.out.println("Using Channels: ");
        timeThis(CopyInterface.usingChannels, source, channelsTarget);
    }

    public static void timeThis(CopyInterface copy, File source, File target) {
        long startTime = System.nanoTime();
        try {
            copy.copy(source, target);
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println(duration / 1000000);
    }

    public static void printOne(Integer number) {
        System.out.println("One");
    }
}

@FunctionalInterface
interface CopyInterface {

    void copy(File source, File target) throws IOException;

    CopyInterface usingFiles = (source, target) -> {
        Files.copy(source.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
    };


    CopyInterface usingStreams = (source, target) -> {
        try(FileInputStream in = new FileInputStream(source);
            FileOutputStream out = new FileOutputStream(target)) {
                int readingByte;
                while ((readingByte = in.read()) != -1) {
                    out.write(readingByte);
            }
        }
    };

    CopyInterface usingChannels = (source, target) -> {
        try(FileChannel sourceChannel = new FileInputStream(source).getChannel();
            FileChannel targetChannel = new FileOutputStream(target).getChannel()){
            targetChannel.transferFrom(sourceChannel,0,sourceChannel.size());
        }
    };

}

