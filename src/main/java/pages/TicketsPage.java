package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static app.Browser.LOG;

public class TicketsPage extends Page {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//*[@identifier=\"btnInitTicket\"]")
    private WebElement createButton;

    public TicketsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 20);
    }

    public CreateTicketPage createTicket() {
        LOG.info("Creating ticket...");
        wait.until(ExpectedConditions.visibilityOf(createButton));
        createButton.click();
        return PageFactory.initElements(driver, CreateTicketPage.class);
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
