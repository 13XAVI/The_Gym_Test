package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ScrollMoreMenu {
    private WebDriver driver;
    private WebDriverWait wait;
    private By dropdownMenu = By.cssSelector("ul[data-ux='Dropdown']");

    public ScrollMoreMenu(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public List<WebElement> getDropDownList() {
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownMenu));
        return menu.findElements(By.tagName("li"));
    }


    public void scrollTo(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
