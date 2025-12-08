package hover;

import base.BaseTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class HoverZombieIpsum extends BaseTest {
    @Test
    public void testHoverGetsImageTitle() {
        var zombiePage = homePage.clickZombieIpsum();
        zombiePage.clickContactLink();
        String title = zombiePage.hoverOnJoshImage();
        System.out.println(title);
        assertEquals(title, "Josh Fisher is Undead");
    }

}
