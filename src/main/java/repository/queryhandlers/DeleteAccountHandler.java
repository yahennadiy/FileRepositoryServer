package repository.queryhandlers;

import io.netty.channel.ChannelHandlerContext;
import repository.config.ConfigReader;
import repository.dboperations.UserHqlSelector;
import repository.dboperations.UserRemover;
import repository.passwordhashing.HashPasswordImplementor;
import repository.passwordhashing.TokenImplementor;
import repository.persistentclasses.UsersPersistentClass;
import java.util.List;

public class DeleteAccountHandler implements HandlerInterface {
    public static void exec(ChannelHandlerContext currentCtx, String[] clientQuery) {
        StringBuilder stringBuilder = new StringBuilder();
        String separator = ConfigReader.getSeparator();
        stringBuilder.append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getDeleteAccountQuery()).append(separator);
        String currentToken = clientQuery[2];
        if (!TokenImplementor.isTokenValid(currentToken)) {
            stringBuilder.append(ConfigReader.getTokenIsInvalid()).append(separator);
        } else {
            String userName = clientQuery[3];
            String password = clientQuery[4];
            List userData = UserHqlSelector.exec(currentCtx, userName);
            UsersPersistentClass user = (UsersPersistentClass) userData.get(0);
            if (HashPasswordImplementor.verifyPassword(password, user.getHashPassword())) {
                UserRemover.exec(currentCtx, userName);
                stringBuilder.append(ConfigReader.getAccountDeleted()).append(separator);
            } else {
                stringBuilder.append(ConfigReader.getUserNameOrPasswordIsIncorrect()).append(separator);
            }
        }

        String toClientResponse = stringBuilder.append(ConfigReader.getEndOfText())
                .append(ConfigReader.getEndOfTransmission()).toString();
        currentCtx.writeAndFlush(toClientResponse);
    }
}
