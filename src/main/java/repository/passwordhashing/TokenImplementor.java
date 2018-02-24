package repository.passwordhashing;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.UnsupportedEncodingException;
import java.util.Date;

public class TokenImplementor {
    private static Algorithm algorithm;

    static {
        try {
            algorithm = Algorithm.HMAC256("VeryTerribleSecret");
        } catch (UnsupportedEncodingException exc) {
            System.out.println("JWT exception in TokenImplementor class : " + exc.getMessage());
            exc.printStackTrace();
        }
    }

    public static String getNewToken(String audience, int expiresIn) {
        String token = JWT.create()
                .withIssuer("repository")
                .withAudience(audience)
                .withExpiresAt(new Date(System.currentTimeMillis() + expiresIn))
                .sign(algorithm);
        return token;
    }

    public static boolean isTokenValid(String token) {
        boolean tokenValid = true;
        try {
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("repository")
                    .build();
            verifier.verify(token);
        } catch (JWTVerificationException exc) {
            tokenValid = false;
        }

        return tokenValid;
    }

    public static void tokenDecoder(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            System.out.println("Issuer: " + jwt.getIssuer());
            System.out.println("Exp time: " + jwt.getExpiresAt());
            System.out.println("Audience: " + jwt.getAudience());
        } catch (JWTDecodeException exception) {
            System.out.println("Token is Invalid");
        }
    }
}
