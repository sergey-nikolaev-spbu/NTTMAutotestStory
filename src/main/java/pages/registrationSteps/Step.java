package pages.registrationSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static app.Browser.LOG;
import static utils.utilMethods.*;

public abstract class Step {

    public Step nextStep() {
        WebDriverWait wait = new WebDriverWait(this.getDriver(), 20);
        LOG.info("Going to next step...");
        WebElement element = this.getDriver().findElement(By.xpath("//*[contains(text(), \"ПРОДОЛЖИТЬ\")]/.."));
        scrollTo(this.getDriver(), element);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        wait.until(multyClick(element));
        if (this instanceof Step1) {
            waitForTabNumber(2);
            return PageFactory.initElements(this.getDriver(), Step2.class);
        } else if (this instanceof Step2) {
            waitForTabNumber(3);
            return PageFactory.initElements(this.getDriver(), Step3.class);
        } else if (this instanceof Step3){
            waitForTabNumber(4);
            return PageFactory.initElements(this.getDriver(), Step4.class);
        } else if (this instanceof Step4){
            waitForTabNumber(5);
            return PageFactory.initElements(this.getDriver(), Step5.class);
        } else if (this instanceof NetStep1){
            waitForTabNumber(2);
            return PageFactory.initElements(this.getDriver(), NetStep2.class);
//        } else if (this instanceof NetStep2){
//            waitForTabNumber(3);
//            return PageFactory.initElements(this.getDriver(), NetStep3.class);
//        } else if (this instanceof NetStep3){
//            waitForTabNumber(4);
//            return PageFactory.initElements(this.getDriver(), NetStep4.class);
        } else {
            return null;
        }
    }

    public Step goToStep(int number) {
        try {
            String netString = "";
            if (this.getClass().getName().contains("Net")) {
                netString = "Net";
            }
            LOG.info("Going to " + netString + "step " + number + " ...");
            getTab(number).click();
            waitForTabNumber(number);
            return (Step) PageFactory.initElements(this.getDriver(), Class.forName("pages.registrationSteps." + netString + "Step" + number));
        } catch (ClassNotFoundException e) {
            LOG.error("Unknown step... ", e);
            return null;
        }
    }

    abstract WebDriver getDriver();

    abstract Step setDefaultAttributes() ;

    private void waitForTabNumber(int index){
        WebDriverWait wait = new WebDriverWait(this.getDriver(), 20);
        wait.until(
                t -> getTabPanel(index)
                        .getCssValue("visibility")
                        .equals("visible")
        );
    }

    private WebElement getTabPanel(int index) {
        return this.getDriver().findElement(
                By.xpath("(//*[@role=\"tabpanel\"])[" + index + "]")
        );
    }

    private WebElement getTab(int index) {
        return this.getDriver().findElement(
                By.xpath("(//*[@role=\"tab\"])[" + index + "]")
        );
    }
}
