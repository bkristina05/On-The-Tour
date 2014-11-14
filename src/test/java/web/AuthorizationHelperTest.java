package web;

import junit.framework.Assert;
import org.junit.Test;

public class AuthorizationHelperTest {
    @Test
    public void testIsEmailValid() throws Exception {
        boolean emailValid = AuthorizationHelper.isEmailValid("missis.Bobiakowa@yandex.ru");
        Assert.assertEquals(true,emailValid);
    }
}