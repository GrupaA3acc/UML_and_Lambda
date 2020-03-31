package nk.lambda;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ZadanieCopyFile {
    public static void main(String[] args) throws IOException {
        File zrodlo = new File("plikDoCwiczen.txt");
        File cel = new File("plikDoCwiczenSkopiowany.txt");
        double czasKopiowania = czasKopiowaniaPliku(zrodlo, cel);
        System.out.printf("Czas kopiowania pliku to: %s%n", czasKopiowania);
    }

    public static double czasKopiowaniaPliku(File zrodlo, File cel) throws IOException {
        long czasStart = System.currentTimeMillis();

        try (FileInputStream in = new FileInputStream(zrodlo);
             FileOutputStream out = new FileOutputStream(cel)) {
            int innyByte;
            while (((innyByte = in.read()) != -1)) out.write(innyByte);
        }
        long czasStop = System.currentTimeMillis();
        return czasStop - czasStart;
    }

}
