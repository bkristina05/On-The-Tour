package web;

import junit.framework.Assert;
import org.junit.Test;

public class AuthorizationHelperTest {
    @Test
    public void testIsEmailValid() throws Exception {
        boolean emailValid = AuthorizationHelper.isEmailValid("missis.Bobiakowa@yandex.ru");
        Assert.assertEquals(true,emailValid);
    }

    @Test
    public void testIsEmailValid2() throws Exception {
        boolean emailValid = AuthorizationHelper.isEmailValid("Bobiakowayandex.ru");
        Assert.assertEquals(false,emailValid);
    }

    @Test
    public void testIsPhoneValid1() throws Exception {
        boolean phoneValid = AuthorizationHelper.isPhoneValid("89219276120");
        Assert.assertEquals(true,phoneValid);
    }

    @Test
    public void testIsPhoneValid2() throws Exception {
        boolean phoneValid = AuthorizationHelper.isPhoneValid("9219276120");
        Assert.assertEquals(true,phoneValid);
    }

    @Test
    public void testIsPhoneValid3() throws Exception {
        boolean phoneValid = AuthorizationHelper.isPhoneValid("(921)927-61-20");
        Assert.assertEquals(false,phoneValid);
    }

    @Test
    public void testIsLoginValid1() throws Exception {
        boolean loginValid = AuthorizationHelper.isLoginValid("dasha");
        Assert.assertEquals(true,loginValid);
    }

    @Test
    public void testIsLoginValid2() throws Exception {
        boolean loginValid = AuthorizationHelper.isLoginValid("Dasha.B93");
        Assert.assertEquals(false,loginValid);
    }


    @Test
    public void testIsAgeValid() throws Exception {
        boolean ageValid = AuthorizationHelper.isAgeValid("25");
        Assert.assertEquals(true,ageValid);
    }

    @Test
    public void testIsAgeValid2() throws Exception {
        boolean ageValid = AuthorizationHelper.isAgeValid("ddd");
        Assert.assertEquals(false,ageValid);
    }


}