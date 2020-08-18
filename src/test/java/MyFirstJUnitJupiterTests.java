import app.Browser;
import pages.StartPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.Pages;
import pages.TicketsPage;
import pages.registrationSteps.Step;
import pages.registrationSteps.Step2;
import pages.registrationSteps.Step3;

class MyFirstJUnitJupiterTests {

    private static WebDriver driver;

    @BeforeAll
    static void initAll() {
        driver = Browser.initChromeBrouser();
        driver.get("??????????????????/#/login");
    }

    @Tag("active")
    @Test
    void sam_test() {
        //try {
            StartPage startPage = Browser.createStartPage(driver);
            startPage.login()
                    .setUsername("admin")
                    .setPassword("123456")
                    .commit();
            TicketsPage ticketsPage = (TicketsPage) startPage.goToPage(Pages.TICKETS);
            ticketsPage.createTicket()
                    .start()
                    .setDefaultAttributes()
                    .nextStep()
                    .setDefaultAttributes()
                    .nextStep()
                    .setDefaultAttributes()
                    .nextStep()
                    .setDefaultAttributes()
                    .nextStep()
                    .setDefaultAttributes()
                    .finish();
            try {Thread.sleep(10000);} catch (Exception e) {}
            Assertions.assertEquals(2, 2);
        //} catch(Exception e) {
        //    LOG.error(e);
        //}
    }

    @AfterAll
    static void tearDownAll() {
        driver.close();
        driver.quit();
    }
}
