package repository.queryhandlers.pickers;

import repository.config.ConfigReader;
import repository.persistentclasses.UsersPersistentClass;

public class UserStringPicker {
    public static String get(UsersPersistentClass user) {
        StringBuilder userStringBuilder = new StringBuilder();
        String separator = ConfigReader.getSeparator();
        userStringBuilder.append(Integer.toString(user.getUserId())).append(separator)
                .append(user.getUserName()).append(separator)
                .append(user.getFirstName()).append(separator)
                .append(user.getLastName()).append(separator);
        return userStringBuilder.toString();
    }
}
