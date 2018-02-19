package repository.passwordhashing;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

public class PasswordImplementor {
    private static Argon2 argon2 = Argon2Factory.create();

    public static String getNewHash(String password) {
        char[] passwordCharArr = password.toCharArray();
        String hash;
        try {
            hash = argon2.hash(2, 65536, 1, passwordCharArr);
        } finally {
            argon2.wipeArray(passwordCharArr);
        }

        return hash;
    }

    public static boolean verifyPassword(String password, String hash) {
        char[] passwordCharArr = password.toCharArray();
        boolean result = false;
        try {
            if (argon2.verify(hash, passwordCharArr)) {
                result = true;
            }
        } finally {
            argon2.wipeArray(passwordCharArr);
        }

        return result;
    }
}
