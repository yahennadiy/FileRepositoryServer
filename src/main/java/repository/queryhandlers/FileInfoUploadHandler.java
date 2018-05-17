package repository.queryhandlers;

import io.netty.channel.ChannelHandlerContext;
import repository.fileoperations.FtpServerImplementor;
import repository.config.ConfigReader;
import repository.dboperations.FileHqlSelector;
import repository.dboperations.FileSaver;
import repository.passwordhashing.TokenImplementor;
import repository.persistentclasses.FilesPersistentClass;
import repository.queryhandlers.pickers.FileStringPicker;

import java.util.List;

public class FileInfoUploadHandler implements HandlerInterface {
    public static void exec(ChannelHandlerContext currentCtx, String[] clientQuery) {
        StringBuilder stringBuilder = new StringBuilder();
        String toClientResponse;
        String separator = ConfigReader.getSeparator();
        stringBuilder.append(ConfigReader.getStartOfTransmission()).append(separator)
                .append(ConfigReader.getFileInfoUploadQuery()).append(separator);
        String currentToken = clientQuery[2];
        if (!TokenImplementor.isTokenValid(currentToken)) {
            stringBuilder.append(ConfigReader.getTokenIsInvalid()).append(separator);
        } else {
            String fileName = clientQuery[3];
            List fileData = FileHqlSelector.exec(currentCtx, fileName);
            if (fileData.isEmpty()) {
                int fileOwner = Integer.parseInt(clientQuery[4]);
                String fileDescription = clientQuery[5];

                String fileUrl = ConfigReader.getHeadUrl().concat(FtpServerImplementor.getFileUploadDir())
                        .concat(fileName);
                System.out.println(fileUrl);
                FileSaver.exec(currentCtx, fileName, fileOwner, fileDescription, fileUrl);
                FilesPersistentClass file = FileSaver.getFile();
                stringBuilder.append(ConfigReader.getFileInfoStored()).append(separator)
                        .append(FileStringPicker.get(file));
            } else {
                stringBuilder.append(ConfigReader.getFileNameAlreadyExist()).append(separator);
            }
        }

        toClientResponse = stringBuilder.append(ConfigReader.getEndOfText())
                .append(ConfigReader.getEndOfTransmission()).toString();
        currentCtx.writeAndFlush(toClientResponse);
    }
}
