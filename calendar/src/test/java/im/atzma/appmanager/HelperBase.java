package im.atzma.appmanager;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

public class HelperBase {


    public WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void click(WebElement el) {

        el.click();
    }

    public void moveToElement(WebElement el) {
        WebDriverWait wait = new WebDriverWait(driver, 15);

        try {
            if (el.isEnabled() && el.isDisplayed()) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", el);
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='3px solid red'", el);
//                wait.until(ExpectedConditions.elementToBeClickable(el)).click();
//                ((JavascriptExecutor) driver).executeScript("var el =arguments[0]; setTimeout(function() {elem.click();}, 500)", el);
                el.click();
                System.out.println("-- Clicking on element: " + el.getText());
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
            } else {
                System.out.println("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            System.out.println("Element is not attached to the page document " + e.getStackTrace());
        } catch (NoSuchElementException e) {
            System.out.println("Element was not found in DOM " + e.getStackTrace());
        } catch (Exception e) {
            System.out.println("Unable to click on element " + e.getStackTrace());
        }
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");


    }

    public void fillText(WebElement el, String text) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].style.border='3px solid red'", el);

        if (text != null) {
            String existingText = el.getAttribute("value");
            if (!text.equals(existingText)) {
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
