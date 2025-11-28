package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private  By navbarItems = By.id("nav-67");
    private By home = By.linkText("Home");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public   int getNavItemsCount(){
        return driver.findElements(navbarItems).size();
    }

    public void clickLink(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public HomePage clickHomePage(){
         clickLink("Home");
        return  new HomePage(driver);
    }
    public CreateAccount clickCreateAccount(){
         clickLink("Create Account");
        return new CreateAccount(driver);
    }
    public BritishComputerSociety clickBritishComputerSocietyLink(){
         clickLink("British Computer Society");
         return new BritishComputerSociety(driver);
    }
    public MoreDropDown clickMoreDropDownLink(){

        clickLink("More");
        return new MoreDropDown(driver);
    }


    public LoginPage clickLogin(){
        clickLink("JOIN US");
        return new LoginPage(driver);
    }


    public boolean isHomePageDisplayed(){
        return driver.findElement(home).isDisplayed();
    }


}
