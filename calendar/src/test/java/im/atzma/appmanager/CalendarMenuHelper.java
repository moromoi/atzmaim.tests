package im.atzma.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class CalendarMenuHelper extends HelperBase {
    @FindBy(css = ".daily_wrap.daily_wrap_label")
    WebElement img_view;

    @FindBy(css=".prev_button")
    WebElement btnPrevDay;

    @FindBy(css=".next_button")
    WebElement btnNextDay;

    @FindBy(css=".current_date_field")
    WebElement calendarCurrentDateField;

    @FindBy(css=".more_wrap")
    WebElement btnMenu;

    @FindBy(xpath ="//div[@class = 'menu-wrapper']//a")
    List<WebElement> calendarMenuItems;

    public CalendarMenuHelper(WebDriver driver) {
        super(driver);
    }
//============================================================================================================//

    public List<String> getViewerText() throws InterruptedException {
        List<String> vT = new ArrayList<>();
        for (int i = 0; i < 4; i++) {

            vT.add(img_view.getText());
            Thread.sleep(100);
            click(img_view);
        }
        return vT;
    }


    public List<String> getViewerList() {
        List<String> vList = new ArrayList<>();
        vList.add("שבועי");
        vList.add("חודשי");
        vList.add("אג'נדה");
        vList.add("יומי");
        return vList;
    }

    public String flipCalendar() {
        for(int i=1; i < 3; i++) {
            click(btnPrevDay);
        }
        String calendarCurrentDayField = calendarCurrentDateField.getText();
        return  calendarCurrentDayField;
    }

    public String getWorldDate() {

        Locale aLocale = new Locale.Builder().setLanguage("iw").setRegion("IL").build();
        DateFormat timeFormat = new SimpleDateFormat("dd E , MMMM", aLocale);

        timeFormat.setTimeZone(TimeZone.getTimeZone("Asia/Jerusalem"));
        String curTime = timeFormat.format(new Date());


        DateFormat dateFormat = new SimpleDateFormat("F");
        Date date = new Date();
        String dateNow = dateFormat.format(date);
        return curTime;
    }

    public List<String> getDefaultMenuItemsList() {
        List<String> itemList = new ArrayList<>();
        itemList.add("יומן");
        itemList.add("מאגר לקוחות");
        itemList.add("תזכורות");
        itemList.add("קבוצות");
        itemList.add("תמיכה");
        itemList.add("הציע לנו פיצ'ר");
        itemList.add("Rate us");
        itemList.add("לצאת");


        return itemList;
    }

    public List<String> getCurrentMenuItemsLIst() {
        click(btnMenu);
        List<String> itemListToday = new ArrayList<>();
        for (int i = 0; i < calendarMenuItems.size(); i++) {
            itemListToday.add(calendarMenuItems.get(i).getText());
            System.out.println(calendarMenuItems.get(i).getText());

        }

        return itemListToday;
    }
}
