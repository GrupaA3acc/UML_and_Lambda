package pk.lambda;

import java.io.File;
import java.io.IOException;

public class CopyTimer {
    public static void main(String[] args) {
        File source = new File("source.txt");
        File targetIOStream = new File("targetIOStream.txt");
        File targetChanel = new File("targetChanel.txt");
        File targetFiles = new File("targetFiles.txt");

        long copyTimeIOStream = fileCopyTime(Copy.useIOStream, source, targetIOStream);
        long copyTimeChannel = fileCopyTime(Copy.useChannel, source, targetChanel);
        long copyTimeFiles = fileCopyTime(Copy.useFiles, source, targetFiles);
        System.out.println("IOStream: " + copyTimeIOStream);
        System.out.println("Channel: " + copyTimeChannel);
        System.out.println("Files: " + copyTimeFiles);
    }

    public static long fileCopyTime(Copy copyType, File source, File target){
        long start = System.currentTimeMillis();
        try {
            copyType.copy(source, target);
        }catch (IOException e){
            e.printStackTrace();
        }
        return System.currentTimeMillis() - start;
    }
}
