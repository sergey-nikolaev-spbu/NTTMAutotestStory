package pages.registrationSteps;

import org.openqa.selenium.WebDriver;

import static app.Browser.LOG;

public class Step4 extends Step{
    WebDriver driver;

    public Step4(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public WebDriver getDriver() {
        return driver;
    }

    @Override
    public Step4 setDefaultAttributes() {
        LOG.info("Setting attributes by default...");
        return this;
    }

    @Override
    public Step5 nextStep() {
        return (Step5) super.nextStep();
    }
}
