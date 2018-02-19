package repository.queryhandlers;

import io.netty.channel.Channel;
import repository.config.ConfigReader;
import repository.dboperations.NextFilesHqlSelector;
import repository.persistentclasses.FilesPersistentClass;
import repository.queryhandlers.pickers.FileStringPicker;

import java.util.List;

public class NextFilesInfoHandler implements HandlerInterface {
    public static void exec(Channel currentChannel, String[] clientQuery) {
        String fromFileName = clientQuery[2];
        int numberOfRowsInt = Integer.parseInt(clientQuery[3]);
        String numberOfRows = Integer.toString(numberOfRowsInt + 1);
        List fileData = NextFilesHqlSelector.exec(currentChannel, fromFileName, numberOfRows);
        StringBuilder stringBuilder = new StringBuilder();
        String separator = ConfigReader.getSeparator();
        int numberOfFilesInfo = fileData.size();
        String moreFiles;
        if (numberOfFilesInfo > Integer.parseInt(ConfigReader.getNumberOfRowsToSelect())) {
            numberOfFilesInfo--;
            moreFiles = ConfigReader.getHaveMore();
        } else {
            moreFiles = ConfigReader.getHaveNotMore();
        }

        stringBuilder.append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getNextFilesInfoQuery()).append(separator)
                .append(Integer.toString(numberOfFilesInfo)).append(separator)
                .append(moreFiles).append(separator);
        for (int i = 0; i < numberOfFilesInfo; i++) {
            FilesPersistentClass file = (FilesPersistentClass) fileData.get(i);
            stringBuilder.append(FileStringPicker.get(file));
        }

        String toClientResponse = stringBuilder.append(ConfigReader.getEndOfTransmission()).toString();
        System.out.println(toClientResponse);
        currentChannel.writeAndFlush(toClientResponse);
    }
}
