package repository.queryhandlers;

import io.netty.channel.ChannelHandlerContext;
import repository.config.ConfigReader;
import repository.dboperations.UserUpdater;
import repository.passwordhashing.TokenImplementor;
import repository.persistentclasses.UsersPersistentClass;
import repository.queryhandlers.pickers.UserStringPicker;

public class EditProfileHandler implements HandlerInterface {
    public static void exec(ChannelHandlerContext currentCtx, String[] clientQuery) {
        StringBuilder stringBuilder = new StringBuilder();
        String separator = ConfigReader.getSeparator();
        stringBuilder.append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getEditProfileQuery()).append(separator);
        String currentToken = clientQuery[2];
        if (!TokenImplementor.isTokenValid(currentToken)) {
            stringBuilder.append(ConfigReader.getTokenIsInvalid()).append(separator);
        } else {
            String userName = clientQuery[3];
            String firstName = clientQuery[4];
            String lastName = clientQuery[5];
            UserUpdater.exec(currentCtx, userName, firstName, lastName);
            UsersPersistentClass user = UserUpdater.getUser();
            stringBuilder.append(ConfigReader.getProfileStored()).append(separator)
                    .append(UserStringPicker.get(user));
        }

        String toClientResponse = stringBuilder.append(ConfigReader.getEndOfTransmission()).toString();
        currentCtx.writeAndFlush(toClientResponse);
    }
}
