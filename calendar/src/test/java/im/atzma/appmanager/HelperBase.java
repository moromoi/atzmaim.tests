package im.atzma.appmanager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

    public void moveToElement(WebElement el) {
        Actions actions = new Actions(driver);
        actions.moveToElement(el);
        actions.perform();
    }

    public void fillText (WebElement el, String text) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.border='3px solid red'", el);

        if(text != null) {
            String existingText = el.getAttribute("value");
            if(! text.equals(existingText)) {
                el.click();
                el.clear();
                el.sendKeys(text);
            }
        }


    }


    public void sendKey(WebElement el, String text) {
        el.sendKeys(text);
    }
}
