package repository.fileoperations;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.*;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.apache.ftpserver.usermanager.impl.WritePermission;
import repository.Main;
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
        BaseUser baseUser = new BaseUser();
        String keyWord = ConfigReader.getKeyWord();
        baseUser.setName(keyWord);
        baseUser.setPassword(keyWord);
        fileUploadDir = System.getProperty("user.dir").concat("/").concat(ConfigReader.getFileUploadDir());
        File fileUploadDirFile = new File(fileUploadDir);
        if (!fileUploadDirFile.exists()) {
            fileUploadDirFile.mkdir();
        }

        baseUser.setHomeDirectory(fileUploadDir);
        List<Authority> authorities = new ArrayList<Authority>();
        authorities.add(new WritePermission());
        baseUser.setAuthorities(authorities);
        UserManager userManager = userManagerFactory.createUserManager();
        try {
            userManager.save(baseUser);
        } catch (FtpException exc) {
            Main.getLogger().error("FtpException1 in FtpServerImplementor:", exc);
        }

        serverFactory.setUserManager(userManager);
        Map<String, Ftplet> hashMap = new HashMap<String, Ftplet>();
        serverFactory.setFtplets(hashMap);
        FtpServer server = serverFactory.createServer();
        try {
            server.start();
        } catch (FtpException exc) {
            Main.getLogger().error("FtpException2 in FtpServerImplementor:", exc);
        }
    }

    public static String getFileUploadDir() {
        return fileUploadDir;
    }
}
