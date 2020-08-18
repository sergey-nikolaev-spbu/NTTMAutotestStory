package pages.registrationSteps;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static app.Browser.LOG;
import static utils.utilMethods.tabAndChooseUntilFocus;

public class Step3 extends Step{

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//span[contains(text(), \"ПРОДОЛЖИТЬ\")]/..")
    private WebElement nextButton;
    @FindBy(xpath = "//*[contains(text(), \"ОТЛОЖИТЬ\")]/..")
    private WebElement laterButton;

    public Step3(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    @Override
    public Step3 setDefaultAttributes() {
        LOG.info("Setting attributes by default...");
        tabAndChooseUntilFocus(driver, laterButton);
        return this;
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public Step4 nextStep() {
        return (Step4) super.nextStep();
    }
}
