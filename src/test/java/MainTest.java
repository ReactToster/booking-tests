import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class MainTest {
    WebDriver driver;
    List<WebElement> searchInputList;
    WebElement searchDateBtn;
    List<WebElement> searchDateTableList;

    WebElement searchOccupancyConfigBtn;

    WebElement searchSubmitBtn;

    @BeforeClass
    void setUpDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "start-maximized",
                "--remote-allow-origins=*"
        );
        driver = new ChromeDriver(options);
        driver.get("https://www.booking.com/index.html?label=gen173nr-1BCAEoggI46AdIM1gEaLYBiAEBmAEeuAEHyAEM2AEB6AEBiAIBqAIDuAKWveygBsACAdICJDdhNDllMDA5LWY1MjgtNGVmNi1iNGY1LTc5Mjg0NGY3Yzc2YdgCBeACAQ&sid=fcae6461057870fff28ff7a2e583e8ed&keep_landing=1&sb_price_type=total&lang=en-us&soz=1&lang_changed=1");

        searchInputList = driver.findElements(By.cssSelector(".hero-banner-searchbox form > div input"));
        searchDateBtn = driver.findElement(By.xpath("//button[@data-testid='date-display-field-start']"));
        searchOccupancyConfigBtn = driver.findElement(By.xpath("//button[@data-testid='occupancy-config']"));

    }

    @Test
    void testSimpleSearch() {
        dismissCookies();
        insertLocation("Warsaw");
        pickCheckInDateAndCheckOutDate("2023-03-28", "2023-03-30");
        insertOccupancyDetails();
        submitSearchDetails();
    }

    private void dismissCookies() {
        WebElement cookieBtn = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
        cookieBtn.click();
    }

    private void insertLocation(String location) {
        WebElement searchLocationInput = searchInputList.get(0);
        searchLocationInput.sendKeys(location);
    }

    private void pickCheckInDateAndCheckOutDate(String checkInDate, String checkOutDate) {
        searchDateBtn.click();

        searchDateTableList = driver.findElements(By.xpath("//table[@role='grid']"));

        WebElement searchDateTableFromBtn = searchDateTableList.get(0).findElement(By.xpath("//tbody/tr/td/span[@data-date='" + checkInDate + "']"));
        searchDateTableFromBtn.click();

        WebElement searchDateTableToBtn = searchDateTableList.get(0).findElement(By.xpath("//tbody/tr/td/span[@data-date='" + checkOutDate + "']"));
        searchDateTableToBtn.click();

        searchDateBtn.click();
    }

    private void insertOccupancyDetails() {
        searchOccupancyConfigBtn.click();

        List<WebElement> searchOccupancyBtnList = driver.findElements(By.xpath("//div[@data-testid='occupancy-popup']/div/div/div/button"));
        WebElement searchOccupancyChildPlusBtn = searchOccupancyBtnList.get(3);

        searchOccupancyChildPlusBtn.click();
        searchOccupancyChildPlusBtn.click();

        List<WebElement> searchOccupancyChildAgeSelectList = driver.findElements(By.xpath("//select[@name='age']"));
        List<WebElement> searchOccupancyFirstChildAgeSelectOptions = searchOccupancyChildAgeSelectList.get(0).findElements(By.xpath("//option[@value='5']"));
        searchOccupancyChildAgeSelectList.get(0).click();
        searchOccupancyFirstChildAgeSelectOptions.get(0).click();

        List<WebElement> searchOccupancySecondChildAgeSelectOptions = searchOccupancyChildAgeSelectList.get(1).findElements(By.xpath("//option[@value='7']"));
        searchOccupancyChildAgeSelectList.get(1).click();
        searchOccupancySecondChildAgeSelectOptions.get(1).click();
    }

    private void submitSearchDetails() {
        searchSubmitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        searchSubmitBtn.click();
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
