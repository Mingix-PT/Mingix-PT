package hust.soict.hedspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) throws IOException {
        String filename = "hust/soict/hedspi/garbage/garbage.txt";
        byte[] inputBytes = {0};
        long startTime, endTime;
        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b: inputBytes) {
            outputStringBuilder.append((char) b);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time elapsed: " + (endTime - startTime) + "ms");
    }
}
