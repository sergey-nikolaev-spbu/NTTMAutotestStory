package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static app.Browser.LOG;

public abstract class Page {

    WebDriver driver;
    WebDriverWait wait;

    abstract public WebDriver getDriver();

    @FindBy(xpath = "//mat-icon[normalize-space(text())=\"menu\"]")
    private WebElement menu;
    @FindBy(xpath = "//a[@href=\"#/tickets\"]")
    private WebElement ticketsValue;
    @FindBy(xpath = "//mat-sidenav[@style]")
    private WebElement sidePanel;

    public Page goToPage(Pages pages) {
        wait = new WebDriverWait(this.getDriver(), 20);
        Page page = null;
        LOG.info("going to page " + pages.name());
        wait.until(ExpectedConditions.visibilityOf(menu));
        menu.click();
        wait.until((t) -> !sidePanel.getCssValue("visibility").equals("hidden"));
        switch (pages) {
            case TICKETS:
                page = PageFactory.initElements(this.getDriver(), TicketsPage.class);
                ticketsValue.click();
                break;
            case TASKS:
                page = PageFactory.initElements(this.getDriver(), TasksPage.class);
                break;
            case ADMIN:
                page = PageFactory.initElements(this.getDriver(), null);
                break;
        }
        wait.until((t) -> sidePanel.getCssValue("visibility").equals("hidden"));
        return page;
    }

}
