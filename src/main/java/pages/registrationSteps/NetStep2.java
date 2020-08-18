package pages.registrationSteps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static app.Browser.LOG;

public class NetStep2 extends Step{
    WebDriver driver;
    WebDriverWait wait;
    @FindBy(xpath = "(//*[@role=\"tabpanel\"])[2]")
    private WebElement tabpanel2;

    public NetStep2(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    @Override
    public NetStep2 setDefaultAttributes() {
        LOG.info("Setting attributes by default...");
        return this;
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public NetStep2 nextStep() {
        return (NetStep2) super.nextStep();
    }
}
