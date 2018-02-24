package repository.queryhandlers.errorhandlers;

import io.netty.channel.ChannelHandlerContext;
import repository.config.ConfigReader;
import repository.queryhandlers.HandlerInterface;

public class TransmissionErrorHandler implements HandlerInterface {
    public static void exec(ChannelHandlerContext currentCtx) {
        StringBuilder stringBuilder = new StringBuilder();
        String separator = ConfigReader.getSeparator();
        String toClientResponse = stringBuilder.append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getTransmissionError()).append(separator)
                .append(ConfigReader.getEndOfTransmission()).toString();
        currentCtx.writeAndFlush(toClientResponse);
    }
}
