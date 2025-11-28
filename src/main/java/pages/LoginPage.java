package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private  static WebDriver driver;
    private By email = By.cssSelector("input[data-aid='CREATE_ACCOUNT_EMAIL']");
    private By password = By.cssSelector("input[data-aid='MEMBERSHIP_SSO_LOGIN_PASSWORD']");
    private  By signin = By.cssSelector("button[data-aid='MEMBERSHIP_SSO_SUBMIT']");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public LoginPage emailInputs(String email_user){
        driver.findElement(email).sendKeys(email_user);
        return new LoginPage(driver);
    }
    public LoginPage passwordInputs(String password_user){
        driver.findElement(password).sendKeys(password_user);
        return new LoginPage(driver);
    }


    public void AccountLoggIn(){
        driver.findElement(signin).click();
    }

}
