package im.atzma.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppointmentDeletionTest extends TestBase {

    @Test
    public void testAppointmentDeletion() throws InterruptedException {
        if (!app.getAppointmentHelper().isThereAppointment()) {
            app.getAppointmentHelper().createAppointment();

        }
        int after = app.getAppointmentHelper().getAppointmentCount();
        app.getAppointmentHelper().deleteSelectedAppointment();
        int before = app.getAppointmentHelper().getAppointmentCount();

        Assert.assertEquals(after, before);
    }
}
