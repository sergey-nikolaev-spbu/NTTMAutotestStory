package pages.registrationSteps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import static utils.utilMethods.*;

import static app.Browser.LOG;

public class NetStep1 extends Step{
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "(//*[@role=\"tabpanel\"])[2]")
    private WebElement tabpanel2;
    @FindBy(xpath = "//*[@formcontrolname=\"issueClass\"]")
    private WebElement issueClass;
    @FindBy(xpath = "//*[@formcontrolname=\"priority\"]")
    private WebElement priority;
    @FindBy(xpath = "//*[@formcontrolname=\"networkType\"]")
    private WebElement networkType;
    @FindBy(xpath = "//*[contains(text(), \"ОТМЕНА\")]/..")
    private WebElement cancelButton;

    public NetStep1(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    @Override
    public NetStep1 setDefaultAttributes() {
        LOG.info("Setting attributes by default...");
        tabAndChooseUntilFocus(driver, cancelButton);
        return this;
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public NetStep2 nextStep() {
        return (NetStep2)super.nextStep();
    }

    public void setIssueClass(String value) { selectByValue(driver, issueClass, value); }

    public void setPriority(String value) {
        selectByValue(driver, priority, value);
    }

    public void setNetworkType(String value) {
        selectByValue(driver, networkType, value);
    }
}
