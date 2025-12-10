package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private  static WebDriver driver;
    private By email = By.cssSelector("input[data-aid='MEMBERSHIP_SSO_LOGIN_EMAIL']");
    private By password = By.cssSelector("input[data-aid='MEMBERSHIP_SSO_LOGIN_PASSWORD']");
    private  By signin = By.cssSelector("button[data-aid='MEMBERSHIP_SSO_SUBMIT']");
    private  By message =  By.cssSelector("p[data-aid='MEMBERSHIP_SSO_ERR_REND']");

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public LoginPage emailInputs(String email_user){
        driver.findElement(email).sendKeys(email_user);
        return this;
    }
    public LoginPage passwordInputs(String password_user){
        driver.findElement(password).sendKeys(password_user);
        return this;
    }


    public void AccountLoggIn(){
        driver.findElement(signin).click();
    }

    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(message)).getText();
    }


}
