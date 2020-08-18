package pages.registrationSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static app.Browser.LOG;
import static utils.utilMethods.*;

public class Step5 extends Step{
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@formcontrolname=\"closeComment\"]")
    private WebElement closeComment;
    @FindBy(xpath = "//*[@formcontrolname=\"problemCloseCodeControl\"]")
    private WebElement result;
    @FindBy(xpath = "//*[@formcontrolname=\"problemUnitControl\"]")
    private WebElement unit;
    @FindBy(xpath = "//*[@name=\"allUnits\"]")
    private WebElement allUnits;
    @FindBy(xpath = "//*[contains(text(), \"ЗАВЕРШИТЬ РЕГИСТРАЦИЮ\")]")
    private WebElement finish;

    public Step5(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public Step5 setDefaultAttributes() {
        LOG.info("Setting attributes by default...");
        this.setCloseComment("Default autotest")
                .setResult("Инцидент зарегистрирован")
                .setUnit("ГД");
        return this;
    }

    public void finish() {
        LOG.info("Finishing registration...");
        scrollTo(this.getDriver(), finish);
        wait.until(t-> finish.findElement(By.xpath("..")).isEnabled());
        finish.click();
    }

    public Step5 setCloseComment(String value) {
        closeComment.sendKeys(value);
        return this;
    }

    public Step5 setResult(String value) {
        selectByValue(driver, result, value);
        return this;
    }

    public Step5 setUnit(String value) {
        selectByValue(driver, unit, value);
        return this;
    }
}