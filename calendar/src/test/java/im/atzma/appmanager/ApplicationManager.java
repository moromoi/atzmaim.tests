package im.atzma.appmanager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class ApplicationManager {
    public WebDriver driver;


    public boolean acceptNextAlert = true;
    public StringBuffer verificationErrors = new StringBuffer();

    private SessionHelper sessionHelper;
    private CalendarMenuHelper calendarMenuHelper;


    public void init() throws IOException, InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\browser drivers\\chromeDriver 2.45\\chromedriver.exe");


        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://atzma.im/ru/home");

        sessionHelper = new SessionHelper(driver);
        sessionHelper.login("admin@email.com", "admin");

        calendarMenuHelper = new CalendarMenuHelper(driver);
        calendarMenuHelper.getViewerText();
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
