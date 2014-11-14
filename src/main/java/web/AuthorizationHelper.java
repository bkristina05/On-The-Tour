package web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Daria on 14.11.2014.
 */
public class AuthorizationHelper {
    public static boolean isEmailValid(String email) {
        final Pattern pattern = Pattern.compile("^[A-Za-z0-9.%+\\-]+@[A-Za-z0-9.\\-]+\\.[A-Za-z]{2,4}");
        final Matcher matcher = pattern.matcher(email);
        if (matcher.find()) {
            System.out.println("Email подходит");
            return true;

        } else {
            System.out.println("Email имеет неверный формат");
            return false;
        }
    }


}
