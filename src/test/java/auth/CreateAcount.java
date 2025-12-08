package auth;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateAcount extends BaseTest {

    @Test
    public void createAcount(){
        var account = homePage.clickCreateAccount();
        String email = "dovagopaulau-8584@yopmail.com";

        account.firstNameInputs("tresor")
                .lastNameInputs("Xavier")
                .emailInputs(email)
                .phoneInputs("078111111111")
                .clickCreateAccountBtn();

        String actualMessage = account.getConfirmationMessage();
        System.out.println(actualMessage);
        assertTrue(actualMessage.contains("Check your email"));

    }

}
