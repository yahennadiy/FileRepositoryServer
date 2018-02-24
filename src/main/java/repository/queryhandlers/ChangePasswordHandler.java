package repository.queryhandlers;

import io.netty.channel.ChannelHandlerContext;
import repository.config.ConfigReader;
import repository.dboperations.PasswordChanger;
import repository.dboperations.UserHqlSelector;
import repository.passwordhashing.HashPasswordImplementor;
import repository.passwordhashing.TokenImplementor;
import repository.persistentclasses.UsersPersistentClass;
import java.util.List;

public class ChangePasswordHandler implements HandlerInterface {
    public static void exec(ChannelHandlerContext currentCtx, String[] clientQuery) {
        StringBuilder stringBuilder = new StringBuilder();
        String separator = ConfigReader.getSeparator();
        stringBuilder.append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getChangePasswordQuery()).append(separator);
        String currentToken = clientQuery[2];
        if (!TokenImplementor.isTokenValid(currentToken)) {
            stringBuilder.append(ConfigReader.getTokenIsInvalid()).append(separator);
        } else {
            String userName = clientQuery[3];
            String password = clientQuery[4];
            String newPassword = clientQuery[5];
            String newHashPassword = HashPasswordImplementor.getNewHash(newPassword);
            List userData = UserHqlSelector.exec(currentCtx, userName);
            UsersPersistentClass user = (UsersPersistentClass) userData.get(0);

            if (HashPasswordImplementor.verifyPassword(password, user.getHashPassword())) {
                PasswordChanger.exec(currentCtx, userName, newHashPassword);
                stringBuilder.append(ConfigReader.getPasswordChanged()).append(separator);
            } else {
                stringBuilder.append(ConfigReader.getUserNameOrPasswordIsIncorrect()).append(separator);
            }
        }

        String toClientResponse = stringBuilder.append(ConfigReader.getEndOfTransmission()).toString();
        currentCtx.writeAndFlush(toClientResponse);
    }
}
