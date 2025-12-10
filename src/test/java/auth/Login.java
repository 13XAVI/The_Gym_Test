package auth;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class Login extends BaseTest {

    @Test
    public void loginTest() {
        var account = homePage.clickLogin();
        String email = "dovagopaulau-8584@yopmail.com";
        account.emailInputs(email)
                .passwordInputs("Hello@1")
                .AccountLoggIn();

        String actualMessage = account.getErrorMessage();


        String expectedMessage = "The password/email address combo is incorrect.";

        assertTrue(actualMessage.contains(expectedMessage),
                "Expected error message not displayed. Actual: " + actualMessage);
    }
}
