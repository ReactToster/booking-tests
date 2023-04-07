import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pom.MainPage;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected MainPage mainPage;
    private final long initialDelay = 5;

    @BeforeMethod
    void setUpDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "start-maximized",
                "--remote-allow-origins=*"
        );
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(initialDelay));
        mainPage = new MainPage(driver);
        System.out.println("before in BaseTest");
    }

    @AfterMethod
    void tearDown() {
        System.out.println("after in BaseTest");
        driver.quit();
    }
}
