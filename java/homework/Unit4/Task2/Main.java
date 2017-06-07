package homework.Unit4.Task2;

import java.io.*;

import static homework.Unit4.ParseTools.*;

public class Main {
    private static File codeFile = getFile("Sample2.java", Main.class);
    private static File kwFile = getFile("JavaKeyWords.txt", Main.class);
    private static File resultFile = new File("java\\homework\\Unit4\\Task2\\result.txt");

    public static void main(String[] args) throws IOException {

        String[] codeString = parseCode(readFile(codeFile));

        String[] keywords = readFile(kwFile).split("\\s+");

        String result = keywordFinder(codeString, keywords);

        if (resultFile.createNewFile()) System.out.println("File created");

        writeTextToFile(result, resultFile);
    }

    private static String readFile(File file) throws IOException {
        StringBuilder codeBuilder = new StringBuilder();
        BufferedReader br = new BufferedReader(new FileReader(file));
        while (br.ready()) {
            codeBuilder.append(br.readLine()).append(" ");
        }
        br.close();
        return codeBuilder.toString();
    }

    private static void writeTextToFile(String s, File file) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(s);
        bw.close();
    }
}
