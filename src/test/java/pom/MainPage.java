package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePage {
    List<WebElement> tripTypeCarouselTabsList;
    WebElement destinationRegionTab;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        System.out.println(bookingProperties.getProperty("mainPageUrl"));
        driver.get(bookingProperties.getProperty("mainPageUrl"));
    }

    public SearchResultsPage navigateToSearchResults() {
        return new SearchResultsPage(driver);
    }


    public void locateTripTypeCarouselTabs() {
        tripTypeCarouselTabsList = driver.findElements(By.xpath("//button[@data-testid=\"webcore-filter-carousel-tab-trigger\"]"));
    }

    public boolean isTripTypeCarouselCityTabSelected() {
        return isAriaSelectedAttributeTrue(tripTypeCarouselTabsList.get(0));
    }

    private boolean isAriaSelectedAttributeTrue(WebElement webElement) {
        return webElement.getDomAttribute("aria-selected").contentEquals("true");
    }

    public void locateDestinationsTabs() {
        destinationRegionTab = driver.findElement(By.cssSelector(".bui-tab__link--selected"));
    }

    public boolean isDestinationsRegionTabSelected() {
        return isAriaSelectedAttributeTrue(destinationRegionTab);
    }

    public boolean isTripTypeCarouselCityTabsEmpty() {
        return tripTypeCarouselTabsList.isEmpty();
    }
}
