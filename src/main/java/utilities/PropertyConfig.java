package utilities;

import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyConfig {

    private final static Logger LOGGER = Logger.getLogger(PropertyConfig.class);

    public static String getProperty(String key, String path) {

        Properties configs = new Properties();
        FileInputStream file = null;
        try {
            file = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            configs.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configs.getProperty(key);
    }

}
