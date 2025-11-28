package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class MoreDropDown {
    private WebDriver driver;
    private By dropdown = By.linkText("More");
    public MoreDropDown(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLinkDropDown() {
        driver.findElement(dropdown).click();
    }

    public Select selectElementDropDown(String elementName) {
        Select select = new Select(driver.findElement(dropdown));
        select.selectByVisibleText(elementName);
        return new Select(driver.findElement(dropdown));
    }

    public  String getSelectedValue(){
        Select select = new Select(driver.findElement(dropdown));
        return select.getFirstSelectedOption().getText();
    }





}
