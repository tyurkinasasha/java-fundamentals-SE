package homework.Unit4.Task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import static homework.Unit4.ParseTools.*;

public class Main {
    private static File javaCode = getFile("Sample.java", Main.class);
    private static File keyWords = getFile("JavaKeyWords.txt",Main.class);
    //creating result file locally because output directory is in .gitignore
    private static File resultFile = new File("java\\homework\\Unit4\\Task1\\result.txt");

    public static void main(String[] args) throws IOException {
        if(resultFile.createNewFile()) System.out.println("File created");

        String codeTMP = getString(new FileInputStream(javaCode), (int) javaCode.length());
        String kwTMP = getString(new FileInputStream(keyWords), (int) keyWords.length());

        //Parsing code
        String[] sampleCodeArray = parseCode(codeTMP);

        String[] kwArray = kwTMP.split("\\s+");

        String result=keywordFinder(sampleCodeArray, kwArray);

        FileOutputStream fileOutputStream = new FileOutputStream(resultFile);
        fileOutputStream.write(result.getBytes());
        fileOutputStream.close();
    }

    private static String getString(FileInputStream fs, int size) throws IOException {
        byte[] bytes = new byte[size];
        fs.read(bytes);
        fs.close();
        return new String(bytes);
    }
}