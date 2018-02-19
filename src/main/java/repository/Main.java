package repository;

import repository.config.ConfigReader;

public class Main {
    static public void main(String args[]) {
        ConfigReader.exec();
        new ServerContainer(ConfigReader.getPort()).start();
    }
}
