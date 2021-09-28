package test;

import consts.AdressRgsUrl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected WebDriver webDriver;
//ChromeOptions options = new ChromeOptions();
//options.addArguments("--disable-notifications");
//System.setProperty("webdriver.chrome.driver","path/to/driver/exe");
//WebDriver driver =new ChromeDriver(options);
    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/features/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver","src/main/resources/features/chromedriver.exe");
        webDriver = new ChromeDriver(options);
        webDriver.get(AdressRgsUrl.BASE_URL.getBaseUrl());
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown() {
        webDriver.quit();
    }
}
