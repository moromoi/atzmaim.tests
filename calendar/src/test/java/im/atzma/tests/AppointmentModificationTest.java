package im.atzma.tests;

import org.testng.annotations.Test;

import static im.atzma.tests.TestBase.app;

public class AppointmentModificationTest extends TestBase{

    @Test
    public void testAppointmentModification() {
        app.getAppointmentHelper().chooseExistingAppointment();
        app.getAppointmentHelper().initModifyProsedure();
        app.getAppointmentHelper().chooseProcedure();
        app.getAppointmentHelper().submitAppointmentCreation();
    }
}
