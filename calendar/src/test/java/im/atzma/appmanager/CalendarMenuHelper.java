package im.atzma.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;
import java.util.ArrayList;

public class CalendarMenuHelper extends HelperBase {
    @FindBy(css = ".daily_wrap.daily_wrap_label")
    WebElement img_view;

    public CalendarMenuHelper(WebDriver driver) {
        super(driver);
    }

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
}
