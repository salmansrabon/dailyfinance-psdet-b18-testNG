package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static final ConfigReader instance;

    static {
        try {
            instance = new ConfigReader();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    Properties prop;
    public ConfigReader() throws IOException {
        prop=new Properties();
        FileInputStream fs=new FileInputStream("./src/test/resources/config.properties");
        prop.load(fs);
    }
    public static ConfigReader getInstance(){
        return instance;
    }
    public String get(String key){
        return prop.getProperty(key);
    }
}
