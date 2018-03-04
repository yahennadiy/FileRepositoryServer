package repository.queryhandlers;

import io.netty.channel.ChannelHandlerContext;
import repository.config.ConfigReader;
import repository.dboperations.FileRemover;
import repository.passwordhashing.TokenImplementor;

public class DeleteFileInfoHandler implements HandlerInterface {
    public static void exec(ChannelHandlerContext currentCtx, String[] clientQuery) {
        StringBuilder stringBuilder = new StringBuilder();
        String separator = ConfigReader.getSeparator();
        stringBuilder.append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getDeleteFileInfoQuery()).append(separator);
        String currentToken = clientQuery[2];
        if (!TokenImplementor.isTokenValid(currentToken)) {
            stringBuilder.append(ConfigReader.getTokenIsInvalid()).append(separator);
        } else {
            String fileName = clientQuery[3];
            FileRemover.exec(currentCtx, fileName);
            stringBuilder.append(ConfigReader.getFileInfoDeleted()).append(separator);
        }

        String toClientResponse = stringBuilder.append(ConfigReader.getEndOfText())
                .append(ConfigReader.getEndOfTransmission()).toString();
        currentCtx.writeAndFlush(toClientResponse);
    }
}
