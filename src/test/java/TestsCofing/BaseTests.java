package TestsCofing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseTests{
    protected WebDriver driver;
    protected Properties properties;
    protected Logger logger;

    @BeforeTest
    public void beforeTest() {
        properties = new Properties();
        try {
            FileInputStream input = new FileInputStream(System.getProperty("user.dir") +
                    "/src/main/resources/config/config.properties");
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Can't find the properties file");
        }
    }

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "/src/main/resources/config/chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver",
                    System.getProperty("user.dir") + "/src/main/resources/config/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        logger = LogManager.getLogger(((RemoteWebDriver)driver).getCapabilities().getBrowserName());
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}
