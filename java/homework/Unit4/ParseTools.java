package homework.Unit4;

import java.io.File;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tyurkina Alexandra on 6/7/2017.
 */
public class ParseTools {
    public static File getFile(String s,Class cls) {
        try {
            return Paths.get(cls.getResource(s).toURI()).toFile();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String[] parseCode(String codeTMP) {
        return codeTMP.replaceAll("/(.*\n )*.*\\*/", "")//deleting doc&multi-line comments
                .replaceAll("//.*", "")//deleting one-line comments
                .replaceAll("\\p{Punct}|\\n", " ")//deleting punctuation and newline chars
                .replaceAll("\\s{2,}", " ")//deleting excess spaces
                .split(" ");
    }
    public static String createRegex(String[] s) {
        StringBuilder regex = new StringBuilder();
        for (String str : s) {
            regex.append(str).append("|");
        }
        regex.deleteCharAt(regex.length() - 1);//removing last [ | ]
        return regex.toString();
    }

    public static String keywordFinder(String[] sampleCodeArray, String[] kwArray) {
        Map<String, Integer> keywordsStat = new HashMap<>();
        StringBuilder result=new StringBuilder();
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
            result.append(entry.getKey()).append("=").append(entry.getValue()).append("\n");
        }
        return result.toString();
    }
}
