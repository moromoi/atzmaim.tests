package im.atzma.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CalendarDateTest extends TestBase {

    @Test
    public void testGetCalendarDate () {
        String worldDate = app.getCalendarMenuHelper().getWorldDate();
        String toDay = app.getCalendarMenuHelper().flipCalendar();
        Assert.assertEquals( worldDate, toDay);
        System.out.println(toDay);

    }
}
