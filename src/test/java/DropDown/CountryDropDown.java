package DropDown;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CountryDropDown  extends BaseTest {
    @Test
    public void testCountryDropDown(){
        var dropDown = homePage.clickCountryDropDown();
        String option = "Select a County";
        dropDown.SelectCountryDropDown(option);
        var selectedOption = dropDown.getSelectedOption();
       assertEquals(selectedOption.size(),1, "Wrong number of selected options");
       assertTrue(selectedOption.contains(option), "Option selected not found");
    }
}
