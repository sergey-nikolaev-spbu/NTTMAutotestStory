package app;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import pages.StartPage;

import java.net.URL;
import java.util.concurrent.TimeUnit;


//класс инициализации драйверов
public class Browser {

    public static final Logger LOG = LogManager.getLogger();

    // GoogleChrome browser
    private static final String chrome_driver = "webdriver.chrome.driver";
    private static final String chrome_folder = "src/main/resources/chromedriver_win32/chromedriver.exe";
    // IE browser
    private static final String explorer_driver = "webdriver.ie.driver";
    private static final String explorer_folder = "src/main/resources/IEdriver/IEDriverServer_32.exe";
    // Firefox browser
    private static final String firefox_driver = "webdriver.gecko.driver";
    private static final String firefox_folder = "src/main/resources/mozilla/geckodriver_32.exe";

    static {
        LOG.info("Initializing browser");
    }
    //инициализация драйвера хрома
    public static WebDriver initChromeBrouser() {
        System.setProperty(chrome_driver, chrome_folder);
        try {
            WebDriver driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            return driver;
        } catch (Exception e) {
            LOG.error("Driver initializing exception");
            return null;
        }
    }

    public static WebDriver initChromeBrouserProfile(String file_dir) {
        System.setProperty(chrome_driver, chrome_folder);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir="+file_dir);
//        options.setBinary("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
    //инициализация Firefox
    public static WebDriver initFirefoxBrouser() {
        System.setProperty(firefox_driver, firefox_folder);
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
    //инициализация IE
    public static WebDriver initIEBrouser() {
        System.setProperty(explorer_driver, explorer_folder);
        WebDriver driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver;
    }
    //инициализация драйвера для CMS
    public static WebDriver initWinium() {
        DesiredCapabilities dc = new DesiredCapabilities();
        //System.out.println(1);
        dc.setCapability("app", "C:/Program Files (x86)/IBM/Lotus/Notes/notes.exe");
        //System.out.println(2);
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL("http://localhost:9999"), dc);
            Thread.sleep(3000);

        } catch (Exception e) {
        }

        return driver;
    }

    public static StartPage createStartPage(WebDriver driver) {
        return PageFactory.initElements(driver, StartPage.class);
    }
}
