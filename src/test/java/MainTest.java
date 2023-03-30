import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pom.BasePage;
import pom.MainPage;

import java.time.LocalDate;

import static org.testng.Assert.assertTrue;

public class MainTest extends BaseTest {
    WebDriver driver;
    LocalDate checkInDate = LocalDate.now().plusDays(1);
    LocalDate checkOutDate = LocalDate.now().plusDays(3);

    public MainTest(WebDriver driver) {
        super(driver);
    }

    @BeforeClass
    void setUpDriver() {
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
}
