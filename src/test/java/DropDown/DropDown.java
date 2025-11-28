package DropDown;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class DropDown extends BaseTest {
    @Test
    public void DropDownTest()
    {
        String name = "Halloween Party";
        var dropDown = homePage.clickMoreDropDownLink();
        dropDown.selectElementDropDown(name);
        assertEquals(dropDown.getSelectedValue(),name);

    }
}
