package repository.queryhandlers;

import io.netty.channel.Channel;
import repository.config.ConfigReader;
import repository.dboperations.UserHqlSelector;
import repository.dboperations.UserSaver;
import repository.persistentclasses.UsersPersistentClass;
import repository.queryhandlers.pickers.UserStringPicker;

import java.util.List;

public class RegistrationHandler implements HandlerInterface {
    public static void exec(Channel currentChannel, String[] clientQuery) {
        String userName = clientQuery[2];
        String password = clientQuery[3];
        String firstName = clientQuery[4];
        String lastName = clientQuery[5];
        List userData = UserHqlSelector.exec(currentChannel, userName);
        String separator = ConfigReader.getSeparator();
        StringBuilder stringBuilder = new StringBuilder()
                .append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getRegistrationQuery()).append(separator);
        if (userData.isEmpty()) {
            UserSaver.exec(currentChannel, userName, password, firstName, lastName);
            UsersPersistentClass user = UserSaver.getUser();
            stringBuilder.append(ConfigReader.getProfileStored()).append(separator)
                    .append(UserStringPicker.get(user));
        } else {
            stringBuilder.append(ConfigReader.getUserExist()).append(separator);
        }

        String toClientResponse = stringBuilder.append(ConfigReader.getEndOfTransmission()).toString();
        currentChannel.writeAndFlush(toClientResponse);
    }
}
