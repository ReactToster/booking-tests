import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class MainTest extends BasePage {
    WebDriver driver;
    LocalDate checkInDate = LocalDate.now().plusDays(1);
    LocalDate checkOutDate = LocalDate.now().plusDays(3);

    @BeforeClass
    void setUpDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "start-maximized",
                "--remote-allow-origins=*"
        );
        driver = new ChromeDriver(options);
        BasePage.driver = driver;
        driver.get("https://www.booking.com/index.html?label=gen173nr-1BCAEoggI46AdIM1gEaLYBiAEBmAEeuAEHyAEM2AEB6AEBiAIBqAIDuAKWveygBsACAdICJDdhNDllMDA5LWY1MjgtNGVmNi1iNGY1LTc5Mjg0NGY3Yzc2YdgCBeACAQ&sid=fcae6461057870fff28ff7a2e583e8ed&keep_landing=1&sb_price_type=total&lang=en-us&soz=1&lang_changed=1");

        searchInputList = driver.findElements(By.cssSelector(".hero-banner-searchbox form > div input"));
        searchDateBtn = driver.findElement(By.xpath("//button[@data-testid='date-display-field-start']"));
        searchOccupancyConfigBtn = driver.findElement(By.xpath("//button[@data-testid='occupancy-config']"));
    }

    @Test
    void testSimpleSearch() {
        //when
        dismissCookies();
        insertLocation("Warsaw");
        pickCheckInDateAndCheckOutDate(checkInDate.toString(), checkOutDate.toString());
        insertOccupancyDetails();
        submitSearchDetails();
        //then
        assertTrue(isThereAnySearchResult());
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
