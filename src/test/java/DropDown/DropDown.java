package DropDown;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropDown extends BaseTest {
    @Test
    public void DropDownTest()
    {
        String name = "Keysight";
        var dropDown = homePage.clickMoreDropDownLink();
        dropDown.selectElementDropDown(name);
        assertTrue(dropDown.getDropDownList().contains(name),
                "Dropdown should contain the item: " + name);
        assertEquals(dropDown.getSelectedValue(),name);

    }

    @Test
    public void DropDownItemCountTest() {
        var dropDown = homePage.clickMoreDropDownLink();

        assertEquals(dropDown.getDropDownSize(), 14);
    }

    @Test
    public void allDropDownItemsAreClickable() {
        var dropDown = homePage.clickMoreDropDownLink();

        for (String item : dropDown.getDropDownList()) {
            dropDown.selectElementDropDown(item);
            assertEquals(dropDown.getSelectedValue(), item,
                    "Item should be selectable: " + item);
        }
    }
}
