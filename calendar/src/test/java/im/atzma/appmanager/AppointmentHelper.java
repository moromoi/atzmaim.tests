package im.atzma.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppointmentHelper extends HelperBase {

    @FindBy(xpath = "//tr[@data-time = \"09:00:00\"]/td[1]")
    WebElement nineAM;

    @FindBy(xpath = "(//div[@class='castom-event'])[1]")
    WebElement existingAppointment;

    @FindBy(xpath = "//div[@class='search']//input")
    WebElement inputSearchClient;

    @FindBy(xpath = "(.//div[@class='all-clients__item'])[21]")
    WebElement chooseClient;

    @FindBy(xpath = "(//div[@class='category__content'])[1]")
    WebElement btnFirstProcedureBlock;

    @FindBy(xpath = "(//span[@class='procedures-item__add'])[1]")
    WebElement btnFirstProcedure;

    @FindBy(xpath = "//span[contains(text(), 'הבא')]")
    WebElement btnNext;

    @FindBy(xpath = "//span[contains(text(), 'שמור')]")
    WebElement btnSave;

    @FindBy(css = ".btn-styl.edite")
    WebElement btnEdit;

    @FindBy(css = ".btn-styl.delete")
    WebElement btnDelete;

    @FindBy(xpath = "(//div[@class='price-step'])[1]")
    WebElement btnProcedureList;

    public AppointmentHelper(WebDriver driver) {
        super(driver);
    }

    public void chooseAppointmentTime() {
        click(nineAM);
    }

    public void searchExistingClient() {
        sendKey(inputSearchClient, "Victor Sulema");
        click(chooseClient);
    }

    public void chooseProcedure() {
        click(btnFirstProcedureBlock);
        click(btnFirstProcedure);
    }

    public void submitAppointmentCreation() {
        click(btnNext);
        click(btnSave);
    }

    public void initModifyProsedure() {
        click(btnEdit);
        click(btnProcedureList);
    }

    public void chooseExistingAppointment() {
        click(existingAppointment);
    }

    public void initAppointmentDeletion() {
        click(btnDelete);
    }
}
