package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class CountryDropDown {

    private WebDriver driver;

    private By countryDropDown = By.id("tCounty");
    private By iFrameLocator = By.cssSelector("iframe[srcdoc]");

    public CountryDropDown(WebDriver driver) {
        this.driver = driver;
    }

    private void switchToIframe() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> {

            driver.switchTo().defaultContent();

            List<WebElement> frames = driver.findElements(iFrameLocator);

            for (int i = 0; i < frames.size(); i++) {

                try {
                    driver.switchTo().defaultContent();
                    WebElement freshFrame = driver.findElements(iFrameLocator).get(i);

                    driver.switchTo().frame(freshFrame);

                    if (!driver.findElements(countryDropDown).isEmpty()) {
                        return true;
                    }

                } catch (StaleElementReferenceException ignored) {
                    ignored.printStackTrace();
                }
            }
            return false;
        });
    }


    public void SelectCountryDropDown(String countryName) {
        switchToIframe();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(
               countryDropDown
        ));
        findDropDown().selectByVisibleText(countryName);
        driver.switchTo().defaultContent();
    }

    public List<String> getSelectedOption() {
        switchToIframe();
        List<WebElement> elements = findDropDown().getAllSelectedOptions();
        driver.switchTo().defaultContent();

        return elements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    private Select findDropDown() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement element = wait.until(ExpectedConditions
                .visibilityOfElementLocated(countryDropDown));
        return new Select(element);
    }
}
