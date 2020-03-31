package nk.lambda;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ZadanieCopyFile3 {
    public static void main(String[] args) throws IOException {
        File source = new File("plikDoCwiczen.txt");
        File destination = new File("plikDoCwiczenSkopiowany3.txt");

        //kopiowanie pliku za pomocą FILE CLASS
        long start = System.nanoTime();
        kopiujPlik(source, destination);
        long czasKopiowania = System.nanoTime()-start;
                System.out.format("Czas kopiowania pliku za pomocą klasy File = %s%n", czasKopiowania);
    }
    private static void kopiujPlik(File source, File destination) throws IOException {
        Files.copy(source.toPath(), destination.toPath());
    }
}


