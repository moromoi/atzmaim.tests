package im.atzma.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    private final Properties properties;
    public WebDriver driver;

    private SessionHelper sessionHelper;
    private CalendarMenuHelper calendarMenuHelper;
    private String browser;

    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();


    public ApplicationManager(String browser)  {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException, InterruptedException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

        if("".equals(properties.getProperty("selenium.server"))) {
            if (browser.equals(BrowserType.FIREFOX)) {
                System.setProperty("webdriver.gecko.driver", "C:\\automation\\browser drivers\\firefox\\geckodriver.exe");
                driver = new FirefoxDriver();

            } else if (browser.equals(BrowserType.CHROME)) {
                System.setProperty("webdriver.chrome.driver", "C:\\automation\\browser drivers\\chromeDriver 2.45\\chromedriver.exe");
                driver = new ChromeDriver();

            }
            else {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setBrowserName(browser);
//                driver = new RemoteWebDriver(new URL(properties.getProperty("selenium.server")), capabilities);
                driver = new RemoteWebDriver(new URL("http://localhost:4444/"), capabilities);

//                DesiredCapabilities capabilities = new DesiredCapabilities();
//                capabilities.setBrowserName("safari");
//                CommandExecutor executor = new SeleneseCommandExecutor(new URL("http://localhost:4444/"), new URL("http://www.google.com/"), capabilities);
//                WebDriver driver = new RemoteWebDriver(executor, capabilities);
            }
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(properties.getProperty("web.BaseURL"));

        sessionHelper = new SessionHelper(driver);
        sessionHelper.login(properties.getProperty("web.adminLogin"), properties.getProperty("web.adminPassword"));

        calendarMenuHelper = new CalendarMenuHelper(driver);

    }


    public void stop() throws IOException {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
//        Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }


    public CalendarMenuHelper getCalendarMenuHelper() {
        return calendarMenuHelper;
    }
}
