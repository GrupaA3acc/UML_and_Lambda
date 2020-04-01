package pk.lambda;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;

@FunctionalInterface
public interface Copy {
    void copy(File source, File target) throws IOException;

    Copy useIOStream = (source, target) -> {
        try(FileInputStream is = new FileInputStream(source); FileOutputStream os = new FileOutputStream(target)){
            int readingByte;
            while ((readingByte = is.read()) != -1){
                os.write(readingByte);
            }
        }
    };

    Copy useChannel = (source, target) -> {
        try(FileChannel sourceChannel = new FileInputStream(source).getChannel();
            FileChannel targetChannel = new FileOutputStream(target).getChannel()){
            targetChannel.transferFrom(sourceChannel,0,sourceChannel.size());
        }
    };

    Copy useFiles = (source, target) -> {
        if(!Files.exists(target.toPath()))
          Files.copy(source.toPath(), target.toPath());
    };
}
