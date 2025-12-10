package scroll;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class ScrollMoreMenu extends BaseTest {


    @Test
    public void testScrollMoreMenu() {
        var dropDown = homePage.clickScrollMoreMenu();

        var items = dropDown.getDropDownList();
        WebElement lastItem = items.getLast();

        dropDown.scrollTo(lastItem);
        assertTrue(lastItem.isDisplayed(), "Last dropdown item should be visible after scrolling");
    }

}
