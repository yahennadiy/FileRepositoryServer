package repository.queryhandlers;

import io.netty.channel.ChannelHandlerContext;
import repository.config.ConfigReader;
import repository.dboperations.NextFilesHqlSelector;
import repository.passwordhashing.TokenImplementor;
import repository.persistentclasses.FilesPersistentClass;
import repository.queryhandlers.pickers.FileStringPicker;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NextFilesInfoHandler implements HandlerInterface {
    private static final int RESPONSE_DELAY = ConfigReader.getResponseDelay();

    public static void exec(ChannelHandlerContext currentCtx, String[] clientQuery) {
        StringBuilder stringBuilder = new StringBuilder();
        String toClientResponse;
        String separator = ConfigReader.getSeparator();
        String currentToken = clientQuery[2];
        if (!TokenImplementor.isTokenValid(currentToken)) {
            toClientResponse = stringBuilder.append(ConfigReader.getStartOfTransmission()).append(separator)
                    .append(ConfigReader.getNextFilesInfoQuery()).append(separator)
                    .append(ConfigReader.getTokenIsInvalid()).append(separator)
                    .append(ConfigReader.getEndOfTransmission()).toString();
            System.out.println(toClientResponse);
            currentCtx.writeAndFlush(toClientResponse);
        } else {
            String fromFileName = clientQuery[3];
            int numberOfRowsInt = Integer.parseInt(clientQuery[4]);
            String numberOfRows = Integer.toString(numberOfRowsInt + 1);
            List fileData = NextFilesHqlSelector.exec(currentCtx, fromFileName, numberOfRows);
            int numberOfFilesInfo = fileData.size();
            String moreFiles;
            if (numberOfFilesInfo > Integer.parseInt(ConfigReader.getNumberOfRowsToSelect())) {
                numberOfFilesInfo--;
                moreFiles = ConfigReader.getHaveMore();
            } else {
                moreFiles = ConfigReader.getHaveNotMore();
            }

            for (int i = 0; i < numberOfFilesInfo; i++) {
                int currentFileInfoIndex = i;
                stringBuilder.setLength(0);
                FilesPersistentClass file = (FilesPersistentClass) fileData.get(i);
                toClientResponse = stringBuilder.append(ConfigReader.getStartOfTransmission()).append(separator)
                        .append(ConfigReader.getNextFilesInfoQuery()).append(separator)
                        .append(ConfigReader.getTokenIsValid()).append(separator)
                        .append(Integer.toString(numberOfFilesInfo)).append(separator)
                        .append(currentFileInfoIndex).append(separator)
                        .append(moreFiles).append(separator)
                        .append(FileStringPicker.get(file))
                        .append(ConfigReader.getEndOfTransmission()).toString();
                System.out.println(toClientResponse);

                String finalToClientResponse = toClientResponse;
                currentCtx.executor().schedule(() ->
                        currentCtx.writeAndFlush(finalToClientResponse),
                        i * RESPONSE_DELAY, TimeUnit.MILLISECONDS);
            }
        }
    }
}
