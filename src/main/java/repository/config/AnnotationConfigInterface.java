package repository.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @ interface AnnotationConfigInterface {
    int port = 5555;
    int expiresIn = 86400000;
    int responseDelay = 25;
    String numberOfRowsToSelect = "20";
    String startOfTransmission = "\001";
    String endOfTransmission = "\004";
    String haveMore = "+";
    String haveNotMore = "-";
    String separator = "\031";
    String logInQuery = "00";
    String registrationQuery = "01";
    String editProfileQuery = "02";
    String changePasswordQuery = "03";
    String deleteAccountQuery = "04";
    String nextFilesInfoQuery = "05";
    String prevFilesInfoQuery = "06";
    String tokenIsValid = "10";
    String tokenIsInvalid = "11";
    String userOK = "12";
    String userAlreadyExist = "13";
    String userNameOrPasswordIsIncorrect = "14";
    String profileStored = "15";
    String passwordChanged = "16";
    String accountDeleted = "17";
    String dataBaseOperationError = "20";
    String dataIntegrityError = "21";
    String transmissionError = "22";
    String unknownQueryError = "23";
}