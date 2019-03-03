package im.atzma.appmanager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class HelperBase {


    public WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click (WebElement el) {

        el.click();
    }

    public void fillText (WebElement el, String text) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.border='3px solid red'", el);

        el.click();
        el.clear();
        el.sendKeys(text);

    }


    public void sendKey(WebElement el, String text) {
        el.sendKeys(text);
    }
}
