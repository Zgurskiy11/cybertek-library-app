package com.cybertek.library.utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties props=new Properties();//creating PropertieS object. Using Encapsulation

    static {    //static block. It will run before everything else, and Sout will work too

        //Load the file into FileInputStream
        try {   //adding try catch. If something goes wrong with loading data from file, program still will run.
            FileInputStream fileX=new FileInputStream("configuration.properties");// FileInputStream was underlined red till we surrounded with try catch
            //load property object with the fileX, still inside of try catch
            props.load(fileX);

            //close the file
            fileX.close();//Gc will collect. we dont need it no more in Java memory
        } catch (IOException e) {
            System.out.println("file not found in Configuration properties");;
        }
    }

    //use above logic to create reusable static method
    public static String getProperty(String keyWord){
        return props.getProperty(keyWord);
    }
}
