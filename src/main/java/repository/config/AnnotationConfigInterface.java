package repository.config;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @ interface AnnotationConfigInterface {
    String keyWord = "repository";
    String host = "localhost";
    int port = 5555;
    int ftpPort = 6666;
    String headUrl = "file://localhost/";
    String fileUploadDir = "FileUpload/";
    int expiresIn = 86400000;
    String numberOfRowsToSelect = "20";
    String startOfTransmission = "\001";
    String endOfText = "\003";
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
    String fileInfoUploadQuery = "07";
    String tokenIsValid = "20";
    String tokenIsInvalid = "21";
    String userOK = "22";
    String userAlreadyExist = "23";
    String userNameOrPasswordIsIncorrect = "24";
    String profileStored = "25";
    String passwordChanged = "26";
    String accountDeleted = "27";
    String fileInfoStored = "28";
    String fileNameAlreadyExist = "29";
    String dataBaseOperationError = "40";
    String dataIntegrityError = "41";
    String transmissionError = "42";
    String unknownQueryError = "43";
}