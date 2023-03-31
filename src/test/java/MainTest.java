import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pom.BasePage;
import pom.MainPage;

import java.time.LocalDate;

import static org.testng.Assert.assertTrue;

public class MainTest extends BaseTest {
    LocalDate checkInDate = LocalDate.now().plusDays(1);
    LocalDate checkOutDate = LocalDate.now().plusDays(3);

    @BeforeTest
    void openMainPage() {
        System.out.println("before in MainTest");
        mainPage.openPage();
    }



    @Test
    void testSimpleSearch() {
        //when
        mainPage.dismissCookies();
        mainPage.locateFormElements();
        mainPage.insertLocation("Warsaw");
        mainPage.pickCheckInDateAndCheckOutDate(checkInDate.toString(), checkOutDate.toString());
        mainPage.insertOccupancyDetails();
        mainPage.submitSearchDetails();
        //then
        assertTrue(mainPage.navigateToSearchResults().isThereAnySearchResult());
    }
}
