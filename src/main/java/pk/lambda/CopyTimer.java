package pk.lambda;

import java.io.File;

public class CopyTimer {
    public static void main(String[] args) {
        File source = new File("source.txt");
        File target = new File("target.txt");

        long copyTime = fileCopyTime(Copy.useIOStream, source, target);
        System.out.println(copyTime);
    }

    public static long fileCopyTime(Copy copyType, File source, File target){
        long start = System.currentTimeMillis();
        copyType.copy(source, target);
        return System.currentTimeMillis() - start;
    }
}
