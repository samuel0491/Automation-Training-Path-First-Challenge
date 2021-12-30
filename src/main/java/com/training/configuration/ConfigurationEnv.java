package com.training.configuration;

import java.io.*;
import java.util.Properties;

public class ConfigurationEnv {

    private Properties properties;
    private InputStream inputStream;

    public ConfigurationEnv(){

        BufferedReader reader;
        try{

            reader = new BufferedReader(new FileReader("src/main/resources/config.properties"));
            properties = new Properties();

                try{
                    properties.load(reader);
                    reader.close();
                }catch(IOException e){
                    e.printStackTrace();
                }

        }catch(FileNotFoundException e){
            e.printStackTrace();
            throw new RuntimeException("Config.properties file not found");
        }
    }

    //TODO: refactor this line
    public String getSpecificProperty(String property){

        String rProperty = properties.getProperty(property);

        if(rProperty == null)
            throw new RuntimeException("path not found in the config.properties file");
        else
            return rProperty;

    }
}
