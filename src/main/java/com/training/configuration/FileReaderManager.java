package com.training.configuration;

public class FileReaderManager {

    private static FileReaderManager fileReaderManager = new FileReaderManager();
    private static ConfigurationEnv configurationEnv;

    private FileReaderManager(){}

    public static FileReaderManager getInstance(){
        return fileReaderManager;
    }

    public ConfigurationEnv getConfigurationEnvReader(){

        if(configurationEnv == null)
            return new ConfigurationEnv();
        else
            return configurationEnv;
    }

}
