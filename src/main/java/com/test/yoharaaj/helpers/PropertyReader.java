package com.test.yoharaaj.helpers;

import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties prop = new Properties();
    private static String DEFAULT_PATH = "/uimap/PageObjects.properties";


    public static String getProperty(String key) {
        try {
            prop.load(PropertyReader.class.getResourceAsStream(DEFAULT_PATH));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return prop.getProperty(key);
    }

}
