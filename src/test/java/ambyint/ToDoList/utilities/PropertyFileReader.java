package ambyint.ToDoList.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyFileReader {
    static Map<Object, Object> allProps = new HashMap<Object, Object>();

    static {
        readPropertyFile();
    }

    public static void readPropertyFile() {
        File file = new File("config.properties");

        try {
            FileInputStream fis = new FileInputStream(file);
            Properties p = new Properties(); //From Java.util > {Key:Value}
            p.load(fis);
            allProps.putAll(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getPropertyValue(String PropertyName) {
        return allProps.get(PropertyName).toString();
    }

}
