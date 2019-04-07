package im.atzma.tests;

import im.atzma.model.ProfileData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.*;

public class AppointmentCreationTest extends TestBase {

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        app.getAppointmentHelper().deleteAllAppointmentsToday();
    }

    @Test(dataProvider = "validGroup")
    public void testAppointmentCreationMain(String note) throws InterruptedException {
//        app.getCalendarMenuHelper().flipCalendar();

        List<ProfileData> before = app.getAppointmentHelper().createAppointment3
                (new ProfileData(23, "נונה", 0,
                        0, 0, note));
        ProfileData pd = before.iterator().next();
        Assert.assertEquals(app.getAppointmentHelper().count(), before.size());
        List<ProfileData> after = app.getAppointmentHelper().getProfileList();
        Assert.assertEquals(before, after);
    }

    @DataProvider
    public Iterator<Object[]> validGroup() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[] {"q"});
        list.add(new Object[] {"qqqqqqqq"});
        list.add(new Object[] {"qqqqqqqq"});
        list.add(new Object[] {"qqqqqqqq"});
        list.add(new Object[] {"qqqqqqqq"});
        list.add(new Object[] {"qqqqqqqq"});
        list.add(new Object[] {"qqqqqqqq"});
        list.add(new Object[] {"qqqqqqqq"});


        return list.iterator();
    }
}
