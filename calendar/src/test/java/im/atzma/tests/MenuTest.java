package im.atzma.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MenuTest extends TestBase {

    @Test
    public void checkMenuItems() {
        List<String> before = app.getCalendarMenuHelper().getDefaultMenuItemsList();
        List<String> after = app.getCalendarMenuHelper().getCurrentMenuItemsLIst();

        Assert.assertEquals(after, before);
    }


}
