package repository.config;

import java.lang.reflect.Method;

public class ConfigReader {
    private static AnnotationConfigInterface configParameters;

    public static void exec() {
        try {
            AnnotationConfigClass configParametersObject = new AnnotationConfigClass();
            Method configParametersMethod = configParametersObject.getClass().getMethod(
                    "configParametersMethod");
            configParameters = configParametersMethod.getAnnotation(AnnotationConfigInterface.class);
        } catch (Exception e) {
            System.out.println("Annotation Error: " + e);
        }
    }

    public static int getPort() {
        return configParameters.port;
    }

    public static int getExpiresIn() {
        return configParameters.expiresIn;
    }

    public static int getResponseDelay() {
        return configParameters.responseDelay;
    }

    public static String getNumberOfRowsToSelect() {
        return configParameters.numberOfRowsToSelect;
    }

    public static String getStartOfTransmission() {
        return configParameters.startOfTransmission;
    }

    public static String getEndOfTransmission() {
        return configParameters.endOfTransmission;
    }

    public static String getHaveMore() {
        return configParameters.haveMore;
    }

    public static String getHaveNotMore() {
        return configParameters.haveNotMore;
    }

    public static String getSeparator() {
        return configParameters.separator;
    }

    public static String getLogInQuery() {
        return configParameters.logInQuery;
    }

    public static String getRegistrationQuery() {
        return configParameters.registrationQuery;
    }

    public static String getNextFilesInfoQuery() {
        return configParameters.nextFilesInfoQuery;
    }

    public static String getPrevFilesInfoQuery() {
        return configParameters.prevFilesInfoQuery;
    }

    public static String getEditProfileQuery() {
        return configParameters.editProfileQuery;
    }

    public static String getChangePasswordQuery() {
        return configParameters.changePasswordQuery;
    }

    public static String getDeleteAccountQuery() {
        return configParameters.deleteAccountQuery;
    }

    public static String getTokenIsValid() {
        return configParameters.tokenIsValid;
    }

    public static String getTokenIsInvalid() {
        return configParameters.tokenIsInvalid;
    }

    public static String getUserOK() {
        return configParameters.userOK;
    }

    public static String getUserAlreadyExist() {
        return configParameters.userAlreadyExist;
    }

    public static String getUserNameOrPasswordIsIncorrect() {
        return configParameters.userNameOrPasswordIsIncorrect;
    }

    public static String getProfileStored() {
        return configParameters.profileStored;
    }

    public static String getPasswordChanged() {
        return configParameters.passwordChanged;
    }

    public static String getAccountDeleted() {
        return configParameters.accountDeleted;
    }

    public static String getDataBaseOperationError() {
        return configParameters.dataBaseOperationError;
    }

    public static String getDataIntegrityError() {
        return configParameters.dataIntegrityError;
    }

    public static String getTransmissionError() {
        return configParameters.transmissionError;
    }

    public static String getUnknownQueryError() {
        return configParameters.unknownQueryError;
    }
}
