package repository.queryhandlers;

import io.netty.channel.ChannelHandlerContext;
import repository.config.ConfigReader;
import repository.queryhandlers.errorhandlers.DataIntegrityErrorHandler;
import repository.queryhandlers.errorhandlers.TransmissionErrorHandler;
import repository.queryhandlers.errorhandlers.UnknownQueryErrorHandler;

public class QueryHandler {
    private static final String START_OF_TRANSMISSION = ConfigReader.getStartOfTransmission();
    private static final String END_OF_TRANSMISSION = ConfigReader.getEndOfTransmission();
    private static final String NEXT_FILES_INFO_QUERY = ConfigReader.getNextFilesInfoQuery();
    private static final String PREV_FILES_INFO_QUERY = ConfigReader.getPrevFilesInfoQuery();
    private static final String LOG_IN_QUERY = ConfigReader.getLogInQuery();
    private static final String REGISTRATION_QUERY = ConfigReader.getRegistrationQuery();
    private static final String EDIT_PROFILE_QUERY = ConfigReader.getEditProfileQuery();
    private static final String CHANGE_PASSWORD_QUERY = ConfigReader.getChangePasswordQuery();
    private static final String DELETE_ACCOUNT_QUERY = ConfigReader.getDeleteAccountQuery();

    public static void exec(ChannelHandlerContext currentCtx, String[] clientQuery) {
        for (String item : clientQuery) {
            if (item.equals("")) {
                DataIntegrityErrorHandler.exec(currentCtx);
            }
        }

        String startOfTransmission = clientQuery[0];
        String queryType = clientQuery[1];
        String endOfTransmission = clientQuery[clientQuery.length - 1];
        if (startOfTransmission.equals(START_OF_TRANSMISSION)
                && endOfTransmission.equals(END_OF_TRANSMISSION)) {
            if (queryType.equals(NEXT_FILES_INFO_QUERY)) {
                NextFilesInfoHandler.exec(currentCtx, clientQuery);
            } else if (queryType.equals(PREV_FILES_INFO_QUERY)) {
                PrevFilesInfoHandler.exec(currentCtx, clientQuery);
            } else if (queryType.equals(LOG_IN_QUERY)) {
                LogInHandler.exec(currentCtx, clientQuery);
            } else if (queryType.equals(REGISTRATION_QUERY)) {
                RegistrationHandler.exec(currentCtx, clientQuery);
            } else if (queryType.equals(EDIT_PROFILE_QUERY)) {
                EditProfileHandler.exec(currentCtx, clientQuery);
            } else if (queryType.equals(CHANGE_PASSWORD_QUERY)) {
                ChangePasswordHandler.exec(currentCtx, clientQuery);
            } else if (queryType.equals(DELETE_ACCOUNT_QUERY)) {
                DeleteAccountHandler.exec(currentCtx, clientQuery);
            } else {
                UnknownQueryErrorHandler.exec(currentCtx);
            }
        } else {
            TransmissionErrorHandler.exec(currentCtx);
        }
    }
}
