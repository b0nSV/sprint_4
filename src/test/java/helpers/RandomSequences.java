package helpers;

import java.util.Random;

public class RandomSequences {

    public static String createRandomAccountNameAllowedString(int length) {
        var allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"; //!@#$%&0123456789
        var random = new Random();
        var stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
        }
        return stringBuilder.toString();
    }
}
