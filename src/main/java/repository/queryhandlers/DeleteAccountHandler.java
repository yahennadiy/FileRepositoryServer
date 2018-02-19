package repository.queryhandlers;

import io.netty.channel.Channel;
import repository.config.ConfigReader;
import repository.dboperations.UserRemover;

public class DeleteAccountHandler implements HandlerInterface {
    public static void exec(Channel currentChannel, String[] clientQuery) {
        String userName = clientQuery[2];
        UserRemover.exec(currentChannel, userName);
        StringBuilder stringBuilder = new StringBuilder();
        String separator = ConfigReader.getSeparator();
        String toClientResponse = stringBuilder.append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getDeleteAccountQuery()).append(separator)
                .append(ConfigReader.getAccountDeleted()).append(separator)
                .append(ConfigReader.getEndOfTransmission()).toString();
        currentChannel.writeAndFlush(toClientResponse);
    }
}
