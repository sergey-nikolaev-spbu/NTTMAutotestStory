package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.registrationSteps.NetStep1;
import pages.registrationSteps.Step1;

import static app.Browser.LOG;

public class CreateTicketPage extends Page {
    WebDriver driver;
    @FindBy(xpath = "//*[@value=\"NETWORK\"]")
    private WebElement networkButton;

    public CreateTicketPage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    public Step1 start() {
        LOG.info("Starting registration...");
        return PageFactory.initElements(driver, Step1.class);
    }

    public NetStep1 startNET() {
        LOG.info("Network Starting registration...");
        networkButton.click();
        return PageFactory.initElements(driver, NetStep1.class);
    }

}
