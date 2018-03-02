package repository.queryhandlers;

import io.netty.channel.ChannelHandlerContext;
import repository.config.ConfigReader;
import repository.dboperations.UserHqlSelector;
import repository.dboperations.UserSaver;
import repository.passwordhashing.HashPasswordImplementor;
import repository.passwordhashing.TokenImplementor;
import repository.persistentclasses.UsersPersistentClass;
import repository.queryhandlers.pickers.UserStringPicker;
import java.util.List;

public class RegistrationHandler implements HandlerInterface {
    public static void exec(ChannelHandlerContext currentCtx, String[] clientQuery) {
        String userName = clientQuery[2];
        String password = clientQuery[3];
        String firstName = clientQuery[4];
        String lastName = clientQuery[5];
        List userData = UserHqlSelector.exec(currentCtx, userName);
        String separator = ConfigReader.getSeparator();
        StringBuilder stringBuilder = new StringBuilder()
                .append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getRegistrationQuery()).append(separator);
        if (userData.isEmpty()) {
            String hashPassword = HashPasswordImplementor.getNewHash(password);
            UserSaver.exec(currentCtx, userName, hashPassword, firstName, lastName);
            UsersPersistentClass user = UserSaver.getUser();
            String newToken = TokenImplementor.getNewToken(user.getAccess(), ConfigReader.getExpiresIn());
            stringBuilder.append(ConfigReader.getProfileStored()).append(separator)
                    .append(newToken).append(separator)
                    .append(UserStringPicker.get(user));
        } else {
            stringBuilder.append(ConfigReader.getUserAlreadyExist()).append(separator);
        }

        String toClientResponse = stringBuilder.append(ConfigReader.getEndOfText())
                .append(ConfigReader.getEndOfTransmission()).toString();
        currentCtx.writeAndFlush(toClientResponse);
    }
}
