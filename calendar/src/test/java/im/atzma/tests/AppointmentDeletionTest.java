package im.atzma.tests;

import im.atzma.appmanager.HelperBase;
import org.testng.annotations.Test;

public class AppointmentDeletionTest extends TestBase {

    @Test
    public void testAppointmentDeletion() {
        app.getAppointmentHelper().chooseExistingAppointment();
        app.getAppointmentHelper().initAppointmentDeletion();
    }
}
