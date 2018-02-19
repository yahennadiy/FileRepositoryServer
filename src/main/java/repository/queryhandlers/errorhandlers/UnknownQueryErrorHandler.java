package repository.queryhandlers.errorhandlers;

import io.netty.channel.Channel;
import repository.config.ConfigReader;
import repository.queryhandlers.HandlerInterface;

public class UnknownQueryErrorHandler implements HandlerInterface {
    public static void exec(Channel currentChannel) {
        StringBuilder stringBuilder = new StringBuilder();
        String separator = ConfigReader.getSeparator();
        String toClientResponse = stringBuilder.append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getUnknownQueryError()).append(separator)
                .append(ConfigReader.getEndOfTransmission()).toString();
        currentChannel.writeAndFlush(toClientResponse);
    }
}
