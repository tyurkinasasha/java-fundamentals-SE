package homework.Unit4.Task3;

import java.io.*;
import java.nio.file.Files;

import static homework.Unit4.ParseTools.getFile;

public class Main {
    private static File textFile = getFile("textUTF8.txt", Main.class);
    private static File encodedText = new File("java\\homework\\Unit4\\Task3\\textUTF16.txt");

    public static void main(String[] args) throws IOException {
        if (encodedText.createNewFile()) System.out.println("File created");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(encodedText), "UTF-16"));
        bw.write(getText(textFile));
        bw.close();
    }

    private static String getText(File file) throws IOException {
        return new String(Files.readAllBytes(file.toPath()), "UTF-8");
    }
}
