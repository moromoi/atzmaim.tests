package im.atzma.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;


public class CalendarViewersTest extends TestBase {

    @Test
    public void testViewText() throws InterruptedException {
        List<String> before = app.getCalendarMenuHelper().getViewerList();
        List<String> after = app.getCalendarMenuHelper().getViewerText();

        Assert.assertEquals(after, before);
    }


}
