package im.atzma.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class AppointmentCreationTest extends TestBase {

    @Test
    public void testAppointmentCreation() {
        app.getAppointmentHelper().chooseAppointmentTime();
        app.getAppointmentHelper().searchExistingClient();
        app.getAppointmentHelper().submitAppointmentCreation();
    }
}
