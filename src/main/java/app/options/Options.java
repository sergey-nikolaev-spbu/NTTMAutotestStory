package app.options;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.JSWaiter;

import java.util.List;

import static app.Browser.LOG;

public class Options {
    //(//mat-grid-tile//mat-selection-list)[1]//mat-pseudo-checkbox

    WebDriver driver;
    WebDriverWait wait;
    private final String xPath = "(//mat-grid-tile//mat-selection-list)";
    @FindBy(xpath = xPath + "[1]//*[@class = \"mat-line\"]")
    List<WebElement> clientInfoList;
    @FindBy(xpath = xPath + "[2]//*[@class = \"mat-line\"]")
    List<WebElement> orderInfoList;
    @FindBy(xpath = xPath + "[1]//*[@class=\"mat-pseudo-checkbox\"]")
    List<WebElement> clientCheckboxList;
    @FindBy(xpath = xPath + "[2]//*[@class=\"mat-pseudo-checkbox\"]")
    List<WebElement> orderCheckboxList;
    @FindBy(xpath = "//span[contains(text(), \"ТТ ПО КЛИЕНТУ\")]")
    private WebElement ttPoClientu;
    @FindBy(xpath = "//span[contains(text(), \"ТТ ПО ЗАКАЗУ\")]")
    private WebElement ttPoZakazy;

    public Options(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 20);
    }

    public String getClientInfoAt(int index) {
        LOG.info("Returning client info...");
        return clientInfoList.get(index).getText();
    }

    public String getOrderInfoAt(int index) {
        LOG.info("Returning order info...");
        return orderInfoList.get(index).getText();
    }

    public Options clickOrderCheckboxAt(int index) {
        LOG.info("Click on checkbox at index ... " + index);
        orderCheckboxList.get(index).click();
        wait.until((t) -> ttPoZakazy.isEnabled());
        return this;
    }

    public Options clickClientCheckboxAt(int index) {
        LOG.info("Click on checkbox at index ... " + index);
        clientCheckboxList.get(index).click();
        wait.until(t-> ttPoClientu.isEnabled());
        return this;
    }
}
