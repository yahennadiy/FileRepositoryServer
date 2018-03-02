package repository.queryhandlers.pickers;

import repository.config.ConfigReader;
import repository.persistentclasses.FilesPersistentClass;

public class FileStringPicker {
    public static String get(FilesPersistentClass file) {
        StringBuilder fileStringBuilder = new StringBuilder();
        String separator = ConfigReader.getSeparator();
        fileStringBuilder.append(Integer.toString(file.getFileId())).append(separator)
                .append(file.getFileName()).append(separator)
                .append(file.getFileOwner()).append(separator)
                .append(file.getDescription()).append(separator)
                .append(file.getUrl()).append(separator);
        return fileStringBuilder.toString();
    }
}
