package auth;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class Login  extends BaseTest {
    @Test
    public void loginTest(){
        var account = homePage.clickLogin();
        String email = "tresor@gmail.com";
        account.emailInputs(email).passwordInputs("Hello@1");

        account.AccountLoggIn();



    }
}
