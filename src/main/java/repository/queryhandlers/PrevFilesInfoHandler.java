package repository.queryhandlers;

import io.netty.channel.ChannelHandlerContext;
import repository.config.ConfigReader;
import repository.dboperations.PrevFilesHqlSelector;
import repository.passwordhashing.TokenImplementor;
import repository.persistentclasses.FilesPersistentClass;
import repository.queryhandlers.pickers.FileStringPicker;
import java.util.List;

public class PrevFilesInfoHandler implements HandlerInterface {
    public static void exec(ChannelHandlerContext currentCtx, String[] clientQuery) {
        StringBuilder stringBuilder = new StringBuilder();
        String toClientResponse;
        String separator = ConfigReader.getSeparator();
        String currentToken = clientQuery[2];
        if (!TokenImplementor.isTokenValid(currentToken)) {
            toClientResponse = stringBuilder.append(ConfigReader.getStartOfTransmission()).append(separator)
                    .append(ConfigReader.getNextFilesInfoQuery()).append(separator)
                    .append(ConfigReader.getTokenIsInvalid()).append(separator)
                    .append(ConfigReader.getEndOfText())
                    .append(ConfigReader.getEndOfTransmission()).toString();
            currentCtx.writeAndFlush(toClientResponse);
        } else {
            String fromFileName = clientQuery[3];
            int numberOfRowsInt = Integer.parseInt(clientQuery[4]);
            String numberOfRows = Integer.toString(numberOfRowsInt + 1);
            List fileData = PrevFilesHqlSelector.exec(currentCtx, fromFileName, numberOfRows);

            int numberOfFilesInfo = fileData.size();
            String moreFiles;
            int startFileDataIndex = 0;
            if (numberOfFilesInfo > Integer.parseInt(ConfigReader.getNumberOfRowsToSelect())) {
                numberOfFilesInfo--;
                moreFiles = ConfigReader.getHaveMore();
                startFileDataIndex = 1;
            } else {
                moreFiles = ConfigReader.getHaveNotMore();
            }

            int currentFileInfoIndex = 0;
            for (int i = startFileDataIndex; i < fileData.size(); i++, currentFileInfoIndex++) {
                stringBuilder.setLength(0);
                FilesPersistentClass file = (FilesPersistentClass) fileData.get(i);
                toClientResponse = stringBuilder.append(ConfigReader.getStartOfTransmission()).append(separator)
                        .append(ConfigReader.getPrevFilesInfoQuery()).append(separator)
                        .append(ConfigReader.getTokenIsValid()).append(separator)
                        .append(Integer.toString(numberOfFilesInfo)).append(separator)
                        .append(currentFileInfoIndex).append(separator)
                        .append(moreFiles).append(separator)
                        .append(FileStringPicker.get(file))
                        .append(ConfigReader.getEndOfText())
                        .append(ConfigReader.getEndOfTransmission()).toString();
                String finalToClientResponse = toClientResponse;
                currentCtx.writeAndFlush(finalToClientResponse);
            }
        }
    }
}
