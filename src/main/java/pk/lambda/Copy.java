package pk.lambda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

@FunctionalInterface
public interface Copy {
    void copy(File source, File target);

    Copy useIOStream = (source, target) -> {
        try(FileInputStream is = new FileInputStream(source); FileOutputStream os = new FileOutputStream(target)){
            int readingByte;
            while ((readingByte = is.read()) != -1){
                os.write(readingByte);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    };
}
