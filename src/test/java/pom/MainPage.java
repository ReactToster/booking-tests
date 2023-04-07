package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BasePage {
    List<WebElement> tripTypeCarouselTabsList;
    WebElement destinationRegionTab;
    String mainPageUrl = "https://www.booking.com/index.html?label=gen173nr-1BCAEoggI46AdIM1gEaLYBiAEBmAEeuAEHyAEM2AEB6AEBiAIBqAIDuAKWveygBsACAdICJDdhNDllMDA5LWY1MjgtNGVmNi1iNGY1LTc5Mjg0NGY3Yzc2YdgCBeACAQ&sid=fcae6461057870fff28ff7a2e583e8ed&keep_landing=1&sb_price_type=total&lang=en-us&soz=1&lang_changed=1";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(mainPageUrl);
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

    public String getMainPageUrl() {
        return mainPageUrl;
    }

    public boolean isTripTypeCarouselCityTabsEmpty() {
        return tripTypeCarouselTabsList.isEmpty();
    }
}
