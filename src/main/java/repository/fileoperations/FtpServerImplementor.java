package repository.fileoperations;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.*;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;
import repository.config.ConfigReader;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FtpServerImplementor {
    private static String fileUploadDir;
    public static void exec() {
        FtpServerFactory serverFactory = new FtpServerFactory();
        ListenerFactory factory = new ListenerFactory();
        factory.setPort(ConfigReader.getFtpPort());
        serverFactory.addListener("default", factory.createListener());
        PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
        BaseUser user = new BaseUser();
        String keyWord = ConfigReader.getKeyWord();
        user.setName(keyWord);
        user.setPassword(keyWord);
        fileUploadDir = RootPathCreator.getRootDirPath().concat(ConfigReader.getFileUploadDir());
        File fileUploadDirFile = new File(fileUploadDir);
        if (!fileUploadDirFile.exists()) {
            fileUploadDirFile.mkdir();
        }
        System.out.println(fileUploadDir);
        user.setHomeDirectory(fileUploadDir);
        List<Authority> authorities = new ArrayList<Authority>();
        authorities.add(new WritePermission());
        user.setAuthorities(authorities);
        UserManager userManager = userManagerFactory.createUserManager();
        try {
            userManager.save(user);
        } catch (FtpException ftpExc) {
            System.out.println("FtpException1 in FtpServerImplementor: " + ftpExc);
        }

        serverFactory.setUserManager(userManager);
        Map<String, Ftplet> hashMap = new HashMap<String, Ftplet>();
        serverFactory.setFtplets(hashMap);
        FtpServer server = serverFactory.createServer();
        try {
            server.start();
        } catch (FtpException ftpExc) {
            System.out.println("FtpException2 in FtpServerImplementor: " + ftpExc);
        }
    }

    public static String getFileUploadDir() {
        return fileUploadDir;
    }
}
