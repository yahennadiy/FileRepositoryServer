package repository.queryhandlers;

import io.netty.channel.ChannelHandlerContext;
import repository.config.ConfigReader;
import repository.dboperations.UserHqlSelector;
import repository.passwordhashing.HashPasswordImplementor;
import repository.passwordhashing.TokenImplementor;
import repository.persistentclasses.UsersPersistentClass;
import repository.queryhandlers.pickers.UserStringPicker;
import java.util.List;

public class LogInHandler implements HandlerInterface {
    public static void exec(ChannelHandlerContext currentCtx, String[] clientQuery) {
        String userName = clientQuery[2];
        String password = clientQuery[3];
        List userData = UserHqlSelector.exec(currentCtx, userName);
        String separator = ConfigReader.getSeparator();
        StringBuilder stringBuilder = new StringBuilder()
                .append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getLogInQuery()).append(separator);
        if (!userData.isEmpty()) {
            UsersPersistentClass user = (UsersPersistentClass) userData.get(0);
            if (user.getUserName().equals(userName)
                    && HashPasswordImplementor.verifyPassword(password, user.getHashPassword())) {
                String newToken = TokenImplementor.getNewToken(user.getAccess(), ConfigReader.getExpiresIn());
                stringBuilder.append(ConfigReader.getUserOK()).append(separator)
                        .append(newToken).append(separator)
                        .append(UserStringPicker.get(user));
            } else {
                stringBuilder.append(ConfigReader.getUserNameOrPasswordIsIncorrect()).append(separator);
            }
        } else {
            stringBuilder.append(ConfigReader.getUserNameOrPasswordIsIncorrect()).append(separator);
        }

        String toClientResponse = stringBuilder.append(ConfigReader.getEndOfText())
                .append(ConfigReader.getEndOfTransmission()).toString();
        currentCtx.writeAndFlush(toClientResponse);
    }
}
