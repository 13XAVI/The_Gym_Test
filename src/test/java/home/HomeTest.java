package home;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.HomePage;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomeTest extends BaseTest {


    @Test
    public void verifyNavBarHomePage(){
        assertTrue(homePage.getNavItemsCount()==4,"HomePage Should Be 4");
    }




}
