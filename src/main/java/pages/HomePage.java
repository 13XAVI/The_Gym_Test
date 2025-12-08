package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By utilitiesMenuButton = By.cssSelector("[data-ux='UtilitiesMenuLink']");
    private  By navMore = By.cssSelector("[data-aid='NAV_MORE']");
    private  By alert = By.cssSelector("[data-aid='HEADER_PHONE_RENDERED']");
    private By createAccountLink = By.id("n-5599-membership-create-account");
    private By zombieIpsum = By.cssSelector("[data-aid='CONTENT_CTA_BTN6_RENDERED']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }


    public void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public CreateAccount clickCreateAccount(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(utilitiesMenuButton));
        menuButton.click();

        WebElement createAccount = wait.until(
                ExpectedConditions.elementToBeClickable(createAccountLink)
        );
        createAccount.click();

        return new CreateAccount(driver);
    }

    public CountryDropDown clickCountryDropDown(){
        return new CountryDropDown(driver);
    }

    public LoginPage clickLogin(){
        clickLink("JOIN US");
        return new LoginPage(driver);
    }

    public  MoreDropDown clickMoreDropDownLink(){
        driver.findElement(navMore).click();
        return new MoreDropDown(driver);
    }

    public  ScrollMoreMenu clickScrollMoreMenu(){
        driver.findElement(navMore).click();
        return new ScrollMoreMenu(driver);
    }

    public void clickPhoneNumberAlert() {
        driver.findElement(alert).click();
        wait.until(ExpectedConditions.alertIsPresent());

        driver.switchTo().alert().accept();
    }


    public HoverZombieIpsum clickZombieIpsum() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(zombieIpsum));
        scrollToZombieIpsum(element);

        String originalWindow = driver.getWindowHandle();
        switchToNewTab(originalWindow);
        return new HoverZombieIpsum(driver);
    }

    public void switchToNewTab(String originalWindow) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(driver -> driver.getWindowHandles().size() > 1);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }



    public void scrollToZombieIpsum(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        }catch (ElementClickInterceptedException e){
            js.executeScript("arguments[0].click();", element);
        }
    }


}
