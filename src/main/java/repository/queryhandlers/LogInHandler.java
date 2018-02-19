package repository.queryhandlers;

import io.netty.channel.Channel;
import repository.config.ConfigReader;
import repository.dboperations.UserHqlSelector;
import repository.persistentclasses.UsersPersistentClass;
import repository.queryhandlers.pickers.UserStringPicker;
import java.util.List;

public class LogInHandler implements HandlerInterface {
    public static void exec(Channel currentChannel, String[] clientQuery) {
        String userName = clientQuery[2];
        String password = clientQuery[3];
        List userData = UserHqlSelector.exec(currentChannel, userName);
        String separator = ConfigReader.getSeparator();
        StringBuilder stringBuilder = new StringBuilder()
                .append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getLogInQuery()).append(separator);
        if (!userData.isEmpty()) {
            UsersPersistentClass user = (UsersPersistentClass) userData.get(0);
            System.out.println(user.getUserName() + "," + user.getPassword() + "," + user.getFirstName() + "," + user.getLastName());
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                stringBuilder = stringBuilder.append(ConfigReader.getUserExist()).append(separator)
                        .append(UserStringPicker.get(user));
            } else {
                stringBuilder = stringBuilder.append(ConfigReader.getPasswordNotCorrect()).append(separator);
            }
        } else {
            stringBuilder = stringBuilder.append(ConfigReader.getUserNotExist()).append(separator);
        }

        String toClientResponse = stringBuilder.append(ConfigReader.getEndOfTransmission()).toString();
        currentChannel.writeAndFlush(toClientResponse);
    }
}
