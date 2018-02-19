package repository.queryhandlers.pickers;

import repository.config.ConfigReader;
import repository.persistentclasses.FilesPersistentClass;

public class FileStringPicker {
    public static String get(FilesPersistentClass file) {
        StringBuilder fileStringBuilder = new StringBuilder();
        String separator = ConfigReader.getSeparator();
        fileStringBuilder = fileStringBuilder.append(file.getFileName()).append(separator)
                .append(file.getDescription()).append(separator)
                .append(file.getUrl()).append(separator);
        return fileStringBuilder.toString();
    }
}
