package im.atzma.tests;

import im.atzma.model.AppointmentData;
import im.atzma.model.ProfileData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

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
//        if (app.getAppointmentHelper().isThereAppointment2()) {
//            app.getAppointmentHelper().deleteAllAppointmentsToday();
//
//        }
//        List<AppointmentData> before = app.getAppointmentHelper().getAppointmentList();
        app.getAppointmentHelper().createAppointment3(new ProfileData(16,"victor" ,
                0, 1, 0));



//        List<AppointmentData> after = app.getAppointmentHelper().getAppointmentList();
//
//        Assert.assertEquals(after, before);
    }
}
