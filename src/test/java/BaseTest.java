import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import pom.BasePage;

public class BaseTest {
    protected WebDriver driver;

    public BaseTest(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeClass
    void setUpDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "start-maximized",
                "--remote-allow-origins=*"
        );
        driver = new ChromeDriver(options);
    }

    @Test
    void testIsWebDriverNotNull() {
        Assert.assertNotNull(driver);
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
