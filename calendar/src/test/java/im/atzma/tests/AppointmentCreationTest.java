package im.atzma.tests;

import im.atzma.model.AppointmentData;
import im.atzma.model.ProfileData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

public class AppointmentCreationTest extends TestBase {

    //    @Test
    public void testAppointmentCreation() throws InterruptedException {
        int before = 45;
        if (app.getAppointmentHelper().isThereAppointment2()) {
            app.getAppointmentHelper().deleteAllAppointmentsToday();

        }
        app.getAppointmentHelper().createAppointment2();
        int after = app.getAppointmentHelper().getAppointmentCount();

        Assert.assertEquals(after, before);
    }

    @Test
    public void testAppointmentCreationTwoDays() throws InterruptedException {
        app.getCalendarMenuHelper().flipCalendar();

        if (app.getAppointmentHelper().isThereAppointment2()) {
            app.getAppointmentHelper().deleteAllAppointmentsToday();

        }

        int first = 23;
        app.getAppointmentHelper().createAppointment3(new ProfileData(first , "מ", 1,
                1, 0));
        List<ProfileData> before = app.getAppointmentHelper().getProfileList();

        app.getAppointmentHelper().createAppointment3(new ProfileData(first + 10, "מ", 1,
                1, 0));

        List<ProfileData> after = app.getAppointmentHelper().getProfileList();


        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
