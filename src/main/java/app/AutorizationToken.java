package app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static app.Browser.LOG;


public class AutorizationToken {
    private String username = null;
    private String password = null;
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement usernameBy;
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement passwordBy;
    @FindBy(xpath = "//*[@id=\"label6\"]"   )
    private WebElement loginButton;

    public AutorizationToken(WebDriver driver) {
        this.driver = driver;
    }

    public AutorizationToken setUsername(String username) {
        LOG.info("Setting username...");
        this.username = username;
        return this;
    }

    public AutorizationToken setPassword(String password) {
        LOG.info("Setting password...");
        this.password = password;
        return this;
    }

    public void commit() {
        LOG.info("Load main page...");
        if (username != null && password != null) {
            usernameBy.sendKeys(username);
            passwordBy.sendKeys(password);
            loginButton.click();
        } else {
            throw new WebDriverException();
        }
    }
}
