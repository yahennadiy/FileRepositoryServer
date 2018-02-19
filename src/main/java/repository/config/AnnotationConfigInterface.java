package repository.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @ interface AnnotationConfigInterface {
    int port = 5555;
    String numberOfRowsToSelect = "4";
    String startOfTransmission = "\001";
    String endOfTransmission = "\004";
    String haveMore = "+";
    String haveNotMore = "-";
    String separator = "\031";
    String logInQuery = "00";
    String registrationQuery = "01";
    String editProfileQuery = "02";
    String deleteAccountQuery = "03";
    String nextFilesInfoQuery = "04";
    String prevFilesInfoQuery = "05";
    String userExist = "10";
    String userNotExist = "11";
    String passwordNotCorrect = "12";
    String profileStored = "13";
    String accountDeleted = "14";
    String dataBaseOperationError = "20";
    String dataIntegrityError = "21";
    String transmissionError = "22";
    String unknownQueryError = "23";
}