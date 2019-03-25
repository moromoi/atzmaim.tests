package im.atzma.appmanager;

import im.atzma.model.AppointmentData;
import im.atzma.model.ProfileData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AppointmentHelper extends HelperBase {
    WebDriverWait wait = new WebDriverWait(driver, 15);

    @FindBy(xpath = "//p[contains(text(), 'Victor')]/../../../..")
    WebElement appVictorSulema;

    @FindBy(xpath = "//tr[@data-time = \"12:00:00\"]/td[1]")
    WebElement nineAM;

    @FindBy(xpath = "//tr[@data-time]")
    List<WebElement> allInputTime;

    @FindBy(xpath = "(//div[@class='castom-event'])[1]")
    WebElement existingAppointment;

    @FindBy(xpath = "//div[@class='castom-event']")
    List<WebElement> listExistingAppointments;


    @FindBy(xpath = "//div[@class='search']//input")
    WebElement inputSearchClient;

    @FindBy(xpath = "(//span[text() = 'Victor Sulema'])[2]")
    WebElement chooseClient;

    @FindBy(xpath = "//div[@class='filter-clients']//div[@class='all-clients__item']")
    List<WebElement> clientList;

    @FindBy(xpath = "//div[@class='filter-clients']//div[@class='all-clients__item']//span[@class='all-clients__item-name']")
    List<WebElement> clientName;

    @FindBy(xpath = "(//div[@class='category__content'])[1]")
    WebElement btnFirstProcedureBlock;

    @FindBy(xpath = "(//span[@class='procedures-item__add'])[1]")
    WebElement btnFirstProcedure;

    @FindBy(xpath = "//*[@id=\"summary\"]//textarea")
    WebElement commentArea;

    @FindBy(css = ".item-wrap")
    List<WebElement> comment;

    @FindBy(css = ".castom-name.oneRow")
    List<WebElement> appointmentClientNames;

    @FindBy(xpath = "//span[contains(text(), 'הבא')]")
    WebElement btnNext;

    @FindBy(xpath = "//span[contains(text(), 'חזור')]")
    WebElement btnBack;

    @FindBy(xpath = "//span[contains(text(), 'שמור')]")
    WebElement btnSave;

    @FindBy(xpath = "//button[contains(text(), 'ערוך')]")
    WebElement btnEdit;

    @FindBy(css = ".btn-styl.delete")
    WebElement btnDelete;

    @FindBy(xpath = "(//div[@class='price-step'])[1]")
    WebElement btnProcedureList;

    @FindBy(xpath = "//div[@class='category']")
    List<WebElement> mainCategoriesServicesList;

    @FindBy(css = ".procedures-item__name")
    List<WebElement> proceduresList;

    public AppointmentHelper(WebDriver driver) {
        super(driver);
    }

    public void chooseAppointmentTime() throws InterruptedException {
        Thread.sleep(2000);
        click(existingAppointment);
    }

    public void chooseAppointmentTime2() throws InterruptedException {
        Thread.sleep(2000);
        click(nineAM);
    }


    public void searchExistingClient() throws InterruptedException {
        boolean result = false;
        int attempts = 0;
        sendKey(inputSearchClient, "Victor Sulema");
        Thread.sleep(300);
        while (attempts < 2) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(chooseClient)).click();
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }
            attempts++;
        }
    }

    public void chooseProcedure() {
        click(btnFirstProcedureBlock);
        click(btnFirstProcedure);
    }

    public void submitAppointmentCreation() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(btnNext)).click();
        wait.until(ExpectedConditions.elementToBeClickable(btnSave)).click();

    }


    public void deleteAllAppointmentsToday() throws InterruptedException {

//        for (int i = 0; i < listExistingAppointments.size() + 1; i++) {
//            Thread.sleep(1000);
//            JavascriptExecutor js = ((JavascriptExecutor) driver);
//            js.executeScript("arguments[0].scrollIntoView(true);", existingAppointment);
//            click(existingAppointment);
//
//            click(btnDelete);
//            Thread.sleep(1000);
//    }


        for (WebElement el : listExistingAppointments) {

            wait.until(ExpectedConditions.elementToBeClickable(existingAppointment));
            click(existingAppointment);
            click(btnDelete);
            Thread.sleep(1000);
        }
    }

    public void chooseExistingAppointment() throws InterruptedException {
        int s = listExistingAppointments.size();
        for (int i = 0; i < s; i++) {
            click(existingAppointment);

        }
    }

    public void initAppointmentDeletion() {
        click(btnDelete);
    }

    public void createAppointment() throws InterruptedException {
        chooseAppointmentTime2();
        searchExistingClient();
        submitAppointmentCreation();
    }

    public void createAppointment2() throws InterruptedException {

        boolean result = false;
        int attempts = 0;
        Thread.sleep(300);
        while (attempts < 2) {
            try {
                for (int i = 0; i < allInputTime.size(); i++) {
                    click(allInputTime.get(i));
                    searchExistingClient();
                    Thread.sleep(1000);
                    submitAppointmentCreation();
                    Thread.sleep(1000);
                }
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
                e.printStackTrace();
            }
            attempts++;
        }
    }

    public void createTwoDaysAppointment() throws InterruptedException {
        createAppointment2();
    }


    public boolean isThereAppointment() {
        if (listExistingAppointments.size() <= 0) {
            return false;
        }
        return true;
    }

    public boolean isThereAppointment2() {
        if (listExistingAppointments.size() > 0) {
            return true;
        }
        return false;
    }


    public int getAppointmentCount() throws InterruptedException {
        Thread.sleep(500);
        return listExistingAppointments.size();
    }

    public void editAppointment() throws InterruptedException {
        chooseAppointmentTime();
        initAppointmentModification();
    }

    public void initAppointmentModification() throws InterruptedException {
        Thread.sleep(1000);
        click(btnEdit);
//        click(btnProcedureList);
    }

    public void editCommentsToQueue(AppointmentData appointmentData) {
        commentArea.sendKeys(appointmentData.getComment());
        click(btnSave);
    }

    public List<AppointmentData> getAppointmentList() {
        List<AppointmentData> appData = new ArrayList<AppointmentData>();
        List<WebElement> elements = driver.findElements(By.cssSelector(".castom-name.oneRow"));
        for (WebElement element : elements) {
            String name = element.getText();
            AppointmentData appointmentData = new AppointmentData(null, name);
            appData.add(appointmentData);
        }
        System.out.println(appData.get(0).getClientName());

        return appData;
    }

    public void deleteSelectedAppointment() {
        click(existingAppointment);
        click(btnDelete);
    }

    public void createAppointment3(ProfileData profileData) throws InterruptedException {

        String dataTime = allInputTime.get(profileData.getIndexTime()).getAttribute("data-time");
        profileData.setTime(dataTime);
        System.out.println(profileData.getTime());
        System.out.println("input time size: " + allInputTime.size());
        click(allInputTime.get(profileData.getIndexTime()));

        Thread.sleep(300);
        fillText(inputSearchClient, profileData.getChooseLetter());
        Thread.sleep(300);

        String cName = clientName.get(profileData.getIndexClient()).getText();
        profileData.setcName(cName);
        System.out.println(profileData.getcName());
        System.out.println("client list size: " + clientList.size());
        click(clientList.get(profileData.getIndexClient()));

        Thread.sleep(300);
        System.out.println("Categories Services size: " + mainCategoriesServicesList.size());
        moveToElement(mainCategoriesServicesList.get(profileData.getIndexServece()));
        Thread.sleep(1000);
        click(mainCategoriesServicesList.get(profileData.getIndexServece()));

        Thread.sleep(300);
        moveToElement(proceduresList.get(profileData.getIndexProcedure()));
//        String myProcedure = proceduresList.get(profileData.getIndexProcedure()).getText();
//        profileData.setProcedure(myProcedure);
        System.out.println("proceduresList size: " + proceduresList.size());
        try {
            click(proceduresList.get(profileData.getIndexProcedure()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(proceduresList.get(1).getText());

        click(btnNext);
        click(btnSave);
    }
}