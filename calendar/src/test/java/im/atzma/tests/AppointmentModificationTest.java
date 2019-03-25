package im.atzma.tests;

import im.atzma.model.AppointmentData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class AppointmentModificationTest extends TestBase{

    @Test
    public void testAppointmentModification() throws InterruptedException {
        if (!app.getAppointmentHelper().isThereAppointment2()) {
            app.getAppointmentHelper().createAppointment();
        }
        List<AppointmentData> before = app.getAppointmentHelper().getAppointmentList();

        app.getAppointmentHelper().editAppointment();
        app.getAppointmentHelper().editCommentsToQueue(new AppointmentData("test1", null));
        List<AppointmentData> after = app.getAppointmentHelper().getAppointmentList();

        Assert.assertEquals(after.size(), before.size() +1);
    }
}
