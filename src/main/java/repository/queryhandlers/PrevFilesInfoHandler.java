package repository.queryhandlers;

import io.netty.channel.Channel;
import repository.config.ConfigReader;
import repository.dboperations.PrevFilesHqlSelector;
import repository.persistentclasses.FilesPersistentClass;
import repository.queryhandlers.pickers.FileStringPicker;
import java.util.List;

public class PrevFilesInfoHandler implements HandlerInterface {
    public static void exec(Channel currentChannel, String[] clientQuery) {
        String fromFileName = clientQuery[2];
        int numberOfRowsInt = Integer.parseInt(clientQuery[3]);
        String numberOfRows = Integer.toString(numberOfRowsInt + 1);
        List fileData = PrevFilesHqlSelector.exec(currentChannel, fromFileName, numberOfRows);
        StringBuilder stringBuilder = new StringBuilder();
        String separator = ConfigReader.getSeparator();
        int numberOfFilesInfo = fileData.size();
        String moreFiles;
        int startIndex= 0;
        if (numberOfFilesInfo > Integer.parseInt(ConfigReader.getNumberOfRowsToSelect())) {
            numberOfFilesInfo--;
            moreFiles = ConfigReader.getHaveMore();
            startIndex = 1;
        } else {
            moreFiles = ConfigReader.getHaveNotMore();
        }

        stringBuilder.append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getPrevFilesInfoQuery()).append(separator)
                .append(Integer.toString(numberOfFilesInfo)).append(separator)
                .append(moreFiles).append(separator);
        for (int i = startIndex; i < fileData.size(); i++) {
            FilesPersistentClass file = (FilesPersistentClass) fileData.get(i);
            stringBuilder.append(FileStringPicker.get(file));
        }

        String toClientResponse = stringBuilder.append(ConfigReader.getEndOfTransmission()).toString();
        currentChannel.writeAndFlush(toClientResponse);
    }
}
