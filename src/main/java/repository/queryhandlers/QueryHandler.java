package repository.queryhandlers;

import io.netty.channel.Channel;
import repository.config.ConfigReader;
import repository.queryhandlers.errorhandlers.DataIntegrityErrorHandler;
import repository.queryhandlers.errorhandlers.TransmissionErrorHandler;
import repository.queryhandlers.errorhandlers.UnknownQueryErrorHandler;

public class QueryHandler {
    private static final String START_OF_TRANSMISSION = ConfigReader.getStartOfTransmission();
    private static final String END_OF_TRANSMISSION = ConfigReader.getEndOfTransmission();
    private static final String MORE_FILES_INFO_QUERY = ConfigReader.getNextFilesInfoQuery();
    private static final String LESS_FILES_INFO_QUERY = ConfigReader.getPrevFilesInfoQuery();
    private static final String LOG_IN_QUERY = ConfigReader.getLogInQuery();
    private static final String REGISTRATION_QUERY = ConfigReader.getRegistrationQuery();
    private static final String EDIT_PROFILE_QUERY = ConfigReader.getEditProfileQuery();
    private static final String DELETE_ACCOUNT_QUERY = ConfigReader.getDeleteAccountQuery();

    public static void exec(Channel currentChannel, String[] clientQuery) {
        for (String item : clientQuery) {
            if (item.equals("")) {
                DataIntegrityErrorHandler.exec(currentChannel);
            }
        }

        String startOfTransmission = clientQuery[0];
        String queryType = clientQuery[1];
        String endOfTransmission = clientQuery[clientQuery.length - 1];
        if (startOfTransmission.equals(START_OF_TRANSMISSION)
                && endOfTransmission.equals(END_OF_TRANSMISSION)) {
            if (queryType.equals(MORE_FILES_INFO_QUERY)) {
                NextFilesInfoHandler.exec(currentChannel, clientQuery);
            } else if (queryType.equals(LESS_FILES_INFO_QUERY)) {
                PrevFilesInfoHandler.exec(currentChannel, clientQuery);
            } else if (queryType.equals(LOG_IN_QUERY)) {
                LogInHandler.exec(currentChannel, clientQuery);
            } else if (queryType.equals(REGISTRATION_QUERY)) {
                RegistrationHandler.exec(currentChannel, clientQuery);
            } else if (queryType.equals(EDIT_PROFILE_QUERY)) {
                EditProfileHandler.exec(currentChannel, clientQuery);
            } else if (queryType.equals(DELETE_ACCOUNT_QUERY)) {
                DeleteAccountHandler.exec(currentChannel, clientQuery);
            } else {
                UnknownQueryErrorHandler.exec(currentChannel);
            }
        } else {
            TransmissionErrorHandler.exec(currentChannel);
        }
    }
}
