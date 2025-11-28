package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.HomePage;
import pages.PopupModal;

public class BaseTest {

    private WebDriver driver;
    protected HomePage homePage;
    protected PopupModal popupModal;

    @BeforeClass
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver-win64/chromedriver.exe");
        driver = new ChromeDriver();
        gotoHomePage();
        homePage =  new HomePage(driver);
        popupModal = new PopupModal(driver);
        popupModal.closeModalVisible();


    }

    public void gotoHomePage(){
        driver.get("https://candymapper.com/");
    }



    @AfterClass
    public void tearDown()
    {
        driver.quit();
    }

}
