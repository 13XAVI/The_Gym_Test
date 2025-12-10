package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CreateAccount {

    private  static WebDriver driver;
    private By fName = By.cssSelector("input[data-aid='CREATE_ACCOUNT_NAME_FIRST']");
    private By lName = By.cssSelector("input[data-aid='CREATE_ACCOUNT_NAME_LAST']");
    private By email = By.cssSelector("input[data-aid='CREATE_ACCOUNT_EMAIL']");
    private By phone = By.cssSelector("input[data-aid='CREATE_ACCOUNT_PHONE']");
    private  By accBtn = By.cssSelector("button[data-ux='ButtonPrimary']");
    private By confirmHeading = By.cssSelector("h4[data-ux='Heading']");



    public CreateAccount(WebDriver driver) {
        this.driver = driver;
    }

    public CreateAccount firstNameInputs(String firstName){
        driver.findElement(fName).sendKeys(firstName);
        return this;
    }
    public CreateAccount lastNameInputs(String lastName){
        driver.findElement(lName).sendKeys(lastName);
        return this;
    }
    public CreateAccount emailInputs(String email_user){
        driver.findElement(email).sendKeys(email_user);
        return this;
    }
    public CreateAccount phoneInputs(String phone_user){
        driver.findElement(phone).sendKeys(phone_user);
        return this;
    }

    public CreateAccount clickCreateAccountBtn(){
        driver.findElement(accBtn).click();
        return this;
    }
    public String getConfirmationMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(confirmHeading)
        ).getText();
    }


}
