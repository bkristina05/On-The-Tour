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

    public static boolean isPhoneValid(String phone){
        final Pattern pattern = Pattern.compile("\\d{5,10}");
        final Matcher matcher = pattern.matcher(phone);
        if (matcher.find()) {
            System.out.println("Phone подходит");
            return true;

        } else {
            System.out.println("Phone имеет неверный формат");
            return false;
        }
    }

    public static boolean isLoginValid(String login) {
        final Pattern pattern = Pattern.compile("^[a-zA-Z0-9]+$");
        final Matcher matcher = pattern.matcher(login);
        if (matcher.find()) {
            System.out.println("Логин подходит");
            return true;

        } else {
            System.out.println("Логин имеет неверный формат");
            return false;
        }
    }

    public static boolean isAgeValid(String age){
        Integer ageInt;
        try {
            ageInt = Integer.valueOf(age);
        } catch (NumberFormatException e) {
            return false;
        }

        if (ageInt < 90 && ageInt > 15) {
            return true;
        } else {
            return false;
        }
    }

    public static String md5(String password) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(password.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

}
