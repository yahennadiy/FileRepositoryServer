package repository;

import org.apache.log4j.Logger;
import repository.config.ConfigReader;
import repository.fileoperations.FtpServerImplementor;

public class Main {
    private static Logger logger;
    static public void main(String args[]) {
        logger = Logger.getRootLogger();
        ConfigReader.exec();
        FtpServerImplementor.exec();
        new ServerContainer(ConfigReader.getPort()).start();
    }

    public static Logger getLogger() {
        return logger;
    }
}
