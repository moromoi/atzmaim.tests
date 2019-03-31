package im.atzma.tests;

import im.atzma.model.AppointmentData;
import im.atzma.model.ProfileData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Matcher;

public class AppointmentCreationTest extends TestBase {

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (app.getAppointmentHelper().isThereAppointment2()) {
            app.getAppointmentHelper().deleteAllAppointmentsToday();
        }
    }

    @Test
    public void testAppointmentCreationMain() throws InterruptedException {
//        app.getCalendarMenuHelper().flipCalendar();

        List<ProfileData> before = app.getAppointmentHelper().createAppointment3
                (new ProfileData(23, "נונה", 0,
                        0, 0, "test first test"));

        System.out.println("Appointment time, client name, procedure creating: " + before);

        List<ProfileData> after = app.getAppointmentHelper().getProfileList();

        System.out.println("Appointment time, client name, procedure chosen: " + after);

        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }
}
