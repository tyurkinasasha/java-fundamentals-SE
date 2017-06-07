package homework.Unit4.Task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tyurkina Alexandra on 6/6/2017.
 */

public class Main {
    private static byte[] distBytes = new byte[10];
    static Map<String, Integer> keywordsStat = new HashMap<>();
    static File javaCode = getFile("Sample.java");
    static File keyWords = getFile("JavaKeyWords.txt");
    static File resultFile = new File("java\\homework\\Unit4\\Task1\\result.txt");
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        resultFile.createNewFile();

        String codeTMP = getString(new FileInputStream(javaCode), (int) javaCode.length());
        String kwTMP = getString(new FileInputStream(keyWords), (int) keyWords.length());

        //Parsing code
        String[] sampleCodeArray = parseCode(codeTMP);

        String[] kwArray = kwTMP.split("\\s+");

        Pattern keyWordsPattern = Pattern.compile(createRegex(kwArray));
        for (String str : sampleCodeArray) {
            Matcher kwMatcher = keyWordsPattern.matcher(str);
            if (kwMatcher.matches()) {
                if (keywordsStat.containsKey(str)) {
                    int i = keywordsStat.get(str);
                    keywordsStat.replace(str, ++i);
                } else keywordsStat.put(str, 1);
            }
        }

        for (Map.Entry entry : keywordsStat.entrySet()) {
            result.append(entry.getKey() + "=")
                    .append(entry.getValue() + "\n");
        }
        FileOutputStream fileOutputStream = new FileOutputStream(resultFile);
        fileOutputStream.write(result.toString().getBytes());
        fileOutputStream.close();
    }

    private static String[] parseCode(String codeTMP) {
        return codeTMP.replaceAll("/(.*\n )*.*\\*/", "")//deleting doc&multi-line comments
                .replaceAll("//.*", "")//deleting one-line comments
                .replaceAll("\\p{Punct}|\\n", " ")//deleting punctuation and newline chars
                .replaceAll("\\s{2,}", " ")//deleting excess spaces
                .split(" ");
    }

    private static String getString(FileInputStream fs, int size) throws IOException {
        byte[] bytes = new byte[size];
        fs.read(bytes);
        return new String(bytes);
    }

    private static File getFile(String s) {
        try {
            return Paths.get(Main.class.getResource(s).toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static String createRegex(String[] s) {
        StringBuilder regex = new StringBuilder();
        for (String str : s) {
            regex.append(str + "|");
        }
        regex.deleteCharAt(regex.length() - 1);//removing last [ | ]
        return regex.toString();
    }
}