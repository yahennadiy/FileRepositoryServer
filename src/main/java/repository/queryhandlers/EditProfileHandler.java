package repository.queryhandlers;

import io.netty.channel.Channel;
import repository.config.ConfigReader;
import repository.dboperations.UserUpdater;
import repository.persistentclasses.UsersPersistentClass;
import repository.queryhandlers.pickers.UserStringPicker;

public class EditProfileHandler implements HandlerInterface {
    public static void exec(Channel currentChannel, String[] clientQuery) {
        String userName = clientQuery[2];
        String password = clientQuery[3];
        String firstName = clientQuery[4];
        String lastName = clientQuery[5];
        UserUpdater.exec(currentChannel, userName, password, firstName, lastName);
        UsersPersistentClass user = UserUpdater.getUser();
        StringBuilder stringBuilder = new StringBuilder();
        String separator = ConfigReader.getSeparator();
        String toClientResponse = stringBuilder.append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getEditProfileQuery()).append(separator)
                .append(ConfigReader.getProfileStored()).append(separator)
                .append(UserStringPicker.get(user))
                .append(ConfigReader.getEndOfTransmission()).toString();
        currentChannel.writeAndFlush(toClientResponse);
    }
}
