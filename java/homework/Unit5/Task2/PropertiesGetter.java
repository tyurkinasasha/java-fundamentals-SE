package homework.Unit5.Task2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesGetter {
    private Properties properties;

    public PropertiesGetter(String filePath) {
        this.properties = getProperties(filePath);
    }

    private Properties getProperties(String filePath) {
        Properties pr = new Properties();
        try {
            pr.load(new FileInputStream(filePath));
        } catch (FileNotFoundException e1) {
            System.out.println("File Not Found");
        } catch (IOException e1) {
            System.out.println("Problem reading file");
        }
        return pr;
    }

    public String getPropertyValue(String key) throws KeyNotFoundException {
        //этот метод не бросает исключений, поэтому я "обработала"
        //ситуацию key not found следующим путем
        String value = properties.getProperty(key);
        if (value == null) {
            throw new KeyNotFoundException();
        } else {
            return value;
        }
    }

    public class KeyNotFoundException extends Exception{
        public KeyNotFoundException() {
            System.out.println("Key not found");
        }
    }
}
