package pages.registrationSteps;

import app.options.Options;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static app.Browser.LOG;
import static utils.utilMethods.selectByValue;

public class Step2 extends Step{

    WebDriver driver;

    @FindBy(xpath = "//span[contains(text(), \"ТТ ПО КЛИЕНТУ\")]")
    private WebElement ttPoClientu;
    @FindBy(xpath = "//span[contains(text(), \"ТТ ПО ЗАКАЗУ\")]")
    private WebElement ttPoZakazu;
    @FindBy(xpath = "//span[contains(text(), \"MRTG\")]")
    private WebElement mrtg;
    @FindBy(xpath = "//span[contains(text(), \"TEOCO\")]")
    private WebElement teoko;
    @FindBy(xpath = "//*[@formcontrolname=\"type\"]")
    private WebElement type;
    @FindBy(xpath = "//*[@formcontrolname=\"searchSrt\"]")
    private WebElement searchSrt;
    @FindBy(xpath = "//span[contains(text(), \"НАЙТИ\")]")
    private WebElement find;

    public Step2(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public Step2 setDefaultAttributes() {
        LOG.info("Setting attributes by default...");
        setType("Наименование клиента");
        setSearchSrt("123");
        find().clickClientCheckboxAt(0)
                .clickOrderCheckboxAt(0);
        return this;
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public Step3 nextStep() {
        return (Step3) super.nextStep();
    }

    public Options find() {
        LOG.info("Searching client...");
        find.click();
        return PageFactory.initElements(driver, Options.class);
    }

    public Step2 setType(String value) {
        selectByValue(driver, type, value);
        return this;
    }

    public Step2 setSearchSrt(String value) {
        searchSrt.sendKeys(value);
        return this;
    }
}
