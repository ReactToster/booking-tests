import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static org.testng.Assert.*;

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

    @Test
    void testHeaderAccommodationTabIsSelectedOnStart() {
        //when
        mainPage.dismissCookies();
        mainPage.locateHeaderTabs();
        //then
        assertTrue(mainPage.isHeaderAccommodationTabSelected());
    }

    @Test
    void testTripTypeCarouselTabIsSelectedOnStart() {
        //when
        mainPage.dismissCookies();
        mainPage.locateTripTypeCarouselTabs();
        //then
        assertTrue(mainPage.isTripTypeCarouselCityTabSelected());
    }

    @Test
    void testHoverStateTripTypeCarouselTab() {
        //when
        mainPage.dismissCookies();
        mainPage.locateTripTypeCarouselRomanceTab();
        mainPage.hoverOnTripTypeCarouselType();
        //then
        assertTrue(mainPage.isTripTypeCarouselTabHoverStateCorrect());
    }

    @Test
    void testDestinationTabsRegionIsSelectedOnStart() {
        //when
        mainPage.dismissCookies();
        mainPage.locateDestinationsTabs();
        //then
        assertTrue(mainPage.isDestinationsRegionTabSelected());
    }

    @Test
    void testBookingLogoShouldDirectToMainPage() {
        //when
        mainPage.dismissCookies();
        mainPage.locateBookingLogo();
        mainPage.clickBookingLogo();
        mainPage.locateTripTypeCarouselTabs();
        //then
        assertFalse(mainPage.isTripTypeCarouselCityTabsEmpty());
    }
}
