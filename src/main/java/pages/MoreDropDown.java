package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MoreDropDown {
    private WebDriver driver;
    private WebDriverWait wait;

    private By dropdownMenu = By.cssSelector("ul[data-ux='Dropdown']");
    private String selectedValue;

    public MoreDropDown(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void selectElementDropDown(String itemName) {
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownMenu));

        WebElement item = menu.findElement(By.xpath(".//a[normalize-space()='" + itemName + "']"));
        item.click();
        selectedValue = itemName;
    }

    public int getDropDownSize() {
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownMenu));
        return menu.findElements(By.tagName("li")).size();
    }

    public String getSelectedValue() {
        return selectedValue;
    }

    public List<String> getDropDownList() {
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownMenu));
        List<WebElement> items = menu.findElements(By.tagName("li"));

        List<String> texts =  new ArrayList<>();
        for ( WebElement item : items ) {
            texts.add(item.getText());
        }
        return texts;
    }

}
