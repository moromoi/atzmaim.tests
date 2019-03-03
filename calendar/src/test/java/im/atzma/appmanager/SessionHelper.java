package im.atzma.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SessionHelper extends HelperBase {

    @FindBy (id="login")
    WebElement btnLogin;

    @FindBy (css="input[name ='email']")
    WebElement eUsername;

    @FindBy(css="input[name ='pass']")
    WebElement ePassword;

    @FindBy(css="button[type='submit']")
    WebElement btnSubmit;

    public SessionHelper(WebDriver driver) {
        super(driver);

    }

    public void login(String username, String password) throws InterruptedException {
        click(btnLogin);
        fillText(ePassword, password);
        fillText(eUsername, username);
        eUsername.submit();

    }

}
