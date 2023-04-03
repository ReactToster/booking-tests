import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.assertTrue;

public class MainTest extends BaseTest {
    LocalDate checkInDate = LocalDate.now().plusDays(1);
    LocalDate checkOutDate = LocalDate.now().plusDays(3);

    @BeforeMethod
    void openMainPage() {
        System.out.println("before in MainTest");
        try {
            mainPage.openPage();
        } catch (Exception e) {
            System.out.println("Exception: " + e.getLocalizedMessage());
        }
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
