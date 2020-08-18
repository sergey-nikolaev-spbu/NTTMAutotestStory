package pages;

import app.AutorizationToken;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static app.Browser.LOG;

public class StartPage extends Page{

    WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
    }

    public AutorizationToken login() {
        LOG.info("Autorization...");
        return PageFactory.initElements(driver, AutorizationToken.class);
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }
}
