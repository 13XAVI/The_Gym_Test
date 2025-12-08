package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PopupModal {

    private WebDriver driver;
    private By closeModal =  By.id("popup-widget183-close-icon");
    private By modalPopup =  By.id("popup-widget183");


    public PopupModal(WebDriver driver) {
        this.driver = driver;
    }

    public void closeModalVisible(){
        List<WebElement> modal   = driver.findElements(modalPopup);
        if(!modal.isEmpty()){
            WebElement modalPopupElement = modal.get(0);
            modalPopupElement.findElement(closeModal).click();

        }
    }

}
