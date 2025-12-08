package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HoverZombieIpsum {
    private WebDriver driver;
    By contactLink = By.id("menu-item-12");
    By joshImage = By.cssSelector("img[title='Josh Fisher is Undead']");


    public HoverZombieIpsum(WebDriver driver) {
        this.driver = driver;
    }

    public void clickContactLink(){
        driver.findElement(contactLink).click();
    }

    public String hoverOnJoshImage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement image = wait.until(ExpectedConditions.visibilityOfElementLocated(joshImage));

        Actions actions = new Actions(driver);
        actions.moveToElement(image).perform();

        return image.getAttribute("title");
    }


}
