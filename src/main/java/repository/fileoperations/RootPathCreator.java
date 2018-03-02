package repository.fileoperations;

public class RootPathCreator {
    private static String rootDirPath;

    public static String getRootDirPath() {
        StringBuilder stringBuilder = new StringBuilder();
        if (isUnix()) {
            rootDirPath = stringBuilder.append("/home/").append(System.getProperty("user.name")).append("/")
                    .toString();
        } else if (isMac()) {
            rootDirPath = stringBuilder.append("/Users/").append(System.getProperty("user.name")).append("/")
                    .toString();
        } else if (isWindows()) {
            rootDirPath = stringBuilder.append("c:/").toString();
        }

        return rootDirPath;
    }

    private static boolean isUnix() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("nix") || os.contains("nux"));
    }

    private static boolean isMac() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("mac"));
    }

    private static boolean isWindows() {
        String os = System.getProperty("os.name").toLowerCase();
        return (os.contains("win"));
    }
}
