package nk.lambda;

import java.io.*;

public class ZadanieCopyFile2 {
    public static void main(String[] args) throws IOException {
        File source = new File("plikDoCwiczen.txt");
        File destination = new File("plikDoCwiczenSkopiowany2.txt");

        //kopiowanie pliku za pomocą STREAM
        long start = System.nanoTime();
        kopiujPlik(source, destination);
        long czasKopiowania = System.nanoTime() - start;
        System.out.format("Czas skopiowania pliku metodą Stream to = %s%n", czasKopiowania);
    }

    private static void kopiujPlik(File source, File destination) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(destination);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }


}
