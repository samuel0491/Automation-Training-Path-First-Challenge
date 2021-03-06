package com.training.configuration;

import java.io.*;
import java.util.Properties;

public class ConfigurationEnv {

    private final Properties properties;

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

    public String getURLPracticePage(){

        String URLPage = properties.getProperty("URLAutomationPracticeSite");
        if(URLPage == null)
            throw new RuntimeException("URL page value not specified in the config.properties file");
        else
            return URLPage;
    }

    public boolean windowMaximized(){

        String windowMaximized = properties.getProperty("windowMaximized");

        if(windowMaximized == null)
            throw new RuntimeException("Window size value not specified in the config.properties file");
        else
            return Boolean.parseBoolean(windowMaximized);
    }

    public long getImplicitWaitTimeOut(){

        String explicitWait = properties.getProperty("ExplicitWaitTimeOut");
        if(explicitWait == null)
            throw new RuntimeException("Explicit wait time not specified in the config.properties file");
        else
            return Long.parseLong(explicitWait);
    }

    public long getExplicitWaitTimeOut(){

        String explicitWait = properties.getProperty("ExplicitWaitTimeOut");
        if(explicitWait == null)
            throw new RuntimeException("Implicit wait time not specified in the config.properties file");
        else
            return Long.parseLong(explicitWait);
    }

    public String getHomePageTitle(){

        String homePageTitle = properties.getProperty("homepage_tile");
        if(homePageTitle == null)
            throw new RuntimeException("Home page title value not specified in the config.properties file");
        else
            return homePageTitle;
    }

    public String getShopPageTitle(){

        String shopageTitle = properties.getProperty("shopage_title");
        if(shopageTitle == null)
            throw new RuntimeException("Shop page title value not specified in the config.properties file");
        else
            return shopageTitle;
    }
}
