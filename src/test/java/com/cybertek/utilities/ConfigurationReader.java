package com.cybertek.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/*
We will create a re-usable method that will be reading from configuration.reader file
 */
public class ConfigurationReader {

    //1# Create properties object
    private static final Properties properties = new Properties();

    static {
        try {
            //#2 Load the file into FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");

            //#3 Load properties object with the file(configuration.properties)
            properties.load(file);

            //@4 Close the file
            file.close();

        } catch (IOException e) {
            System.out.println("File not found in Configuration properties.");
        }

    }

    //Use the above created Logic to create a reusable static object
    public static String getProperty(String keyWord) {
        return properties.getProperty(keyWord);
    }

}
