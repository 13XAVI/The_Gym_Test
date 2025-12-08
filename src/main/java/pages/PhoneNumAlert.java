package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PhoneNumAlert {
    private WebDriver driver;
    private By  alert =  By.id("alert");
    public PhoneNumAlert(WebDriver driver) {
        this.driver = driver;
    }

}
