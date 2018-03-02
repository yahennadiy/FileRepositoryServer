package repository;

import repository.config.ConfigReader;
import repository.fileoperations.FtpServerImplementor;

public class Main {
    static public void main(String args[]) {
        ConfigReader.exec();
        FtpServerImplementor.exec();
        new ServerContainer(ConfigReader.getPort()).start();
    }
}
