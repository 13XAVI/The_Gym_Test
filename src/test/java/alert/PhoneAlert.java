package alert;

import base.BaseTest;
import org.testng.annotations.Test;

public class PhoneAlert extends BaseTest {
    @Test
    public void testPhoneAlert(){
        homePage.clickPhoneNumberAlert();
    }
}
