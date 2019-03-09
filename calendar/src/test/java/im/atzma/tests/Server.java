package im.atzma.tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import javax.xml.bind.helpers.AbstractMarshallerImpl;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

public class Server {

    @Test
    public void tt () throws MalformedURLException {
        WebDriver driver;
        final Properties properties  = new Properties();

        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setVersion("72.0.3626.121");
        driver = new RemoteWebDriver(new URL("http://192.168.0.102:4444/wd/hub"), capability);

        driver.get("https://echo.msk.ru/");

    }
}
