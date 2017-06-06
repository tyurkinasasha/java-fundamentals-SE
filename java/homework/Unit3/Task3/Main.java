package homework.Unit3.Task3;


import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Tyurkina Alexandra on 5/29/2017.
 */
/*
Работает криво, ищет, скорее всего, не все, зато опыт с регулярками успешно получен)
 */
public class Main {
    static int prevNum = 0;
    static List<String> sentences = new ArrayList<>();

    public static void main(String[] args) throws IOException, URISyntaxException {

        String path = "Java.SE.03.Information handling_task_attachment.html";
        String page = new String(Files.readAllBytes(getPath(path)), "windows-1251");

        Pattern picPattern = Pattern.compile("\\(\\s?[Рр]ис\\.?\\s?\\d+\\)");
        Pattern digitPattern = Pattern.compile("\\d+");

        String cleanPage = getString(page); //(not really clean)

        //getting sentences
        BreakIterator iterator = BreakIterator.getSentenceInstance(Locale.forLanguageTag("ru"));
        iterator.setText(cleanPage);
        int start = iterator.first();
        for (int end = iterator.next();
             end != BreakIterator.DONE;
             start = end, end = iterator.next()) {
            String sentence = cleanPage.substring(start, end);
            Matcher matcher = picPattern.matcher(sentence);
            if (matcher.find()) {
                sentences.add(sentence + "\n"); //adding sentence, that contains pic reference to the list
                String result = matcher.group();
                Matcher digitMatcher = digitPattern.matcher(result);
//                System.out.println(result);
                if (digitMatcher.find()) {
                    int num = Integer.parseInt(digitMatcher.group());
                    if (num >= prevNum) System.out.println("Последовательно");
                    else System.out.println("Непоследовательно");
                    prevNum = num;
                }
            }
        }
        System.out.println(sentences);
    }

    /*
    partially removing html-syntax and useless stuff for easier and faster parsing
    (not sure if it helps parsing, but good for practicing regexes)
     */
    private static String getString(String s) {
        return s.replaceAll("[^а-яА-Я\\d \\p{Punct}]", "")
                .replaceAll("\\d{3,}", "")
                .replaceAll("[\\p{Punct}]{3,}", "")
                .replaceAll("(\\p{Punct}\\s+){2,}", "")
                .replaceAll("\\s{2,}", "")
                .replaceAll("([^а-я]\\s+[^а-я]){2,}", "")
                .replaceAll("[\\p{Punct}]{3,}", "")
                .replaceAll("\\d{3,}", "")
                .replaceAll("\\s{2,}", "")
                .replaceAll("\\p{Punct}{2,}\\s\\p{Punct}{2,}}", "");
    }

    private static Path getPath(String s) throws URISyntaxException {
        return Paths.get(Main.class.getResource(s).toURI());
    }
}
