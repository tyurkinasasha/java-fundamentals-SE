package homework.Unit6;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

public class Task2 {
    private static Map<String, String> properties = new HashMap<>();

    public static void main(String[] args) {
        System.out.println("Enter .properties file path: ");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        Properties pr = new Properties();
        try {
            pr.load(new FileInputStream(path));
        } catch (IOException e) {
            System.out.println("Wrong path");
        }
        for (String key : pr.stringPropertyNames()) {
            properties.put(key, pr.getProperty(key));
        }
        System.out.println(properties);
    }
}
