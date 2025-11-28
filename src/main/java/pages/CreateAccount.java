package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateAccount {

    private  static WebDriver driver;
    private By fName = By.cssSelector("input[data-aid='CREATE_ACCOUNT_NAME_FIRST']");
    private By lName = By.cssSelector("input[data-aid='CREATE_ACCOUNT_NAME_LAST']");
    private By email = By.cssSelector("input[data-aid='CREATE_ACCOUNT_EMAIL']");
    private By phone = By.cssSelector("input[data-aid='CREATE_ACCOUNT_PHONE']");
    private  By accBtn = By.cssSelector("button[data-ux='ButtonPrimary']");
    private  By confirmMethod = By.cssSelector("button[data-ux='CREATE_ACCOUNT_DESCRIPTION_REND']");


    public CreateAccount(WebDriver driver) {
        this.driver = driver;
    }

    public CreateAccount firstNameInputs(String firstName){
        driver.findElement(fName).sendKeys(firstName);
        return new CreateAccount(driver);
    }
    public CreateAccount lastNameInputs(String lastName){
        driver.findElement(lName).sendKeys(lastName);
        return new CreateAccount(driver);
    }
    public CreateAccount emailInputs(String email_user){
        driver.findElement(email).sendKeys(email_user);
        return new CreateAccount(driver);
    }
    public CreateAccount phoneInputs(String phone_user){
        driver.findElement(phone).sendKeys(phone_user);
        return new CreateAccount(driver);
    }

    public CreateAccount clicCreateAccountBtn(){
        driver.findElement(accBtn).click();
        return  new CreateAccount(driver);
    }
    public String getConfirmationMessage(){
        return driver.findElement(confirmMethod).getText();
    }
}
