package ru.levlup.at.homework4.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropReader {

    private static final Properties properties = new Properties();
    private static final InputStream path;

    static {
        try {
            path = new FileInputStream("src/test/resources/resources.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getLogin() throws IOException {
        properties.load(path);
        return properties.getProperty("login");
    }

    public static String getPassword() throws IOException {
        properties.load(path);
        return properties.getProperty("password");
    }

    public static String getAddress() throws IOException {
        properties.load(path);
        return properties.getProperty("address");
    }

    public static String getLoginName() throws IOException {
        properties.load(path);
        return properties.getProperty("loginName1") + " " + properties.getProperty("loginName2");
    }


}
