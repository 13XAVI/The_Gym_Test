package auth;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class CreateAcount extends BaseTest {
    @Test
    public void createAcount(){
        var account = homePage.clickCreateAccount();
        String email = "tresor@gmail.com";
        account.firstNameInputs("tresor").lastNameInputs("Xavier")
                .emailInputs(email).phoneInputs("078111111111");
        account.clicCreateAccountBtn();
        account.getConfirmationMessage();
        assertEquals(account.getConfirmationMessage(), "You're almost there! We sent an email to "+email+ " with a link to activate your account. Please check your email and click the activation link.");
    }
}
