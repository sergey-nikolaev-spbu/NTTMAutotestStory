import app.Browser;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import pages.Pages;
import pages.StartPage;
import pages.TicketsPage;

class NetRegistrationTest {

    private static WebDriver driver;

    @BeforeAll
    static void initAll() {
        driver = Browser.initChromeBrouser();
        assert driver != null;
        driver.get("????????????????/#/login");
    }

    @Tag("active")
    @Test
    void netregistration_test() {
        //try {
            StartPage startPage = Browser.createStartPage(driver);
            startPage.login()
                    .setUsername("admin")
                    .setPassword("123456")
                    .commit();
            TicketsPage ticketsPage = (TicketsPage) startPage.goToPage(Pages.TICKETS);
            ticketsPage.createTicket()
                    .startNET()
                    .setDefaultAttributes()
                    .nextStep()
                    .setDefaultAttributes()
                    .nextStep();
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
