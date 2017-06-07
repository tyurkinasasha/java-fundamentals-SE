package homework.Unit3.Task2;

import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by Tyurkina Alexandra on 5/29/2017.
 */
public class Sample {
    static ResourceBundle rb;
    static Locale enLocale = new Locale("EN", "US");
    static Locale ruLocale = new Locale("RU", "RU");

    public static void main(String[] args) throws UnsupportedEncodingException {
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            try {
                System.out.println("Choose the language:");
                System.out.println("1. English\n2. Русский\n3. Exit");
                input = sc.nextLine();
                if (input.equals("1")) {
                    rb = ResourceBundle.getBundle("homework.Unit3.Task2.ques", enLocale);
                }
                if (input.equals("2")) {
                    rb = ResourceBundle.getBundle("homework.Unit3.Task2.ques", ruLocale);
                }
                if (input.equals("3")) {
                    break;
                }
                List<String> keyList = Collections.list(rb.getKeys());
                Collections.sort(keyList);//sorting cause didn't display in order (probably cause stored in hashmap)

                for (String st : keyList) {
                    System.out.println(encodeUTF(rb.getString(st)));
                }
                input = sc.nextLine();
                rb = ResourceBundle.getBundle("homework.Unit3.Task2.answ", rb.getLocale());
                System.out.println(encodeUTF(rb.getString("ans" + input)));
                System.out.println(encodeUTF(rb.getString("tryAgain")));
                input = sc.nextLine();
                if (input.equals("y")) continue;
                if (input.equals("n")) break;
                throw new Exception();
            } catch (Exception e) {
                System.out.println("Learn to press right buttons please!");
                break;
            }
        }
    }

    private static String encodeUTF(String st) {
        try {
            return new String(st.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

}

