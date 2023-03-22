import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MainTest {
    WebDriver driver;

    @BeforeClass
    void setUpDriver() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "start-maximized",
                "--remote-allow-origins=*"
        );
        driver = new ChromeDriver(options);

        driver.get("https://www.booking.com/index.html?label=gen173nr-1BCAEoggI46AdIM1gEaLYBiAEBmAEeuAEHyAEM2AEB6AEBiAIBqAIDuAKWveygBsACAdICJDdhNDllMDA5LWY1MjgtNGVmNi1iNGY1LTc5Mjg0NGY3Yzc2YdgCBeACAQ&sid=fcae6461057870fff28ff7a2e583e8ed&keep_landing=1&sb_price_type=total&lang=en-us&soz=1&lang_changed=1");
    }

    @Test
    void verificationTest() {
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
