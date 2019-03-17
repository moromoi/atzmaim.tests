package im.atzma.tests;

import im.atzma.appmanager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.ITestContext;
import org.testng.annotations.*;

import static org.testng.Assert.fail;

@Listeners(MyTestListener.class)
public class TestBase {

    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));

    @BeforeSuite(alwaysRun = true)
    public void setUp(ITestContext context) throws Exception {
        app.init();
        context.setAttribute("app", app);
    }

    @AfterSuite (alwaysRun = true)
    public void tearDown() throws Exception {
        app.stop();
    }

}
