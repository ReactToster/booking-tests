package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class MainPage extends BasePage {
    List<WebElement> tripTypeCarouselTabsList;
    WebElement destinationRegionTab;
    WebElement tripTypeCarouselSkiTab;
    String hoverStateBackgroundColor1 = "rgba(0, 0, 0, 0.06)";
    String hoverStateBackgroundColor2 = "rgba(26, 26, 26, 0.06)";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(bookingProperties.getProperty("mainPageUrl"));
    }

    public SearchResultsPage navigateToSearchResults() {
        return new SearchResultsPage(driver);
    }


    public void locateTripTypeCarouselTabs() {
        tripTypeCarouselTabsList = driver.findElements(By.xpath("//button[@data-testid=\"webcore-filter-carousel-tab-trigger\"]"));
    }

    public void locateTripTypeCarouselRomanceTab() {
        tripTypeCarouselSkiTab = driver.findElement(By.xpath("//button[@aria-controls=\"SKI\"]"));
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

    public boolean isTripTypeCarouselTabHoverStateCorrect() {
        return tripTypeCarouselSkiTab.getCssValue("background-color").contentEquals(hoverStateBackgroundColor1) || tripTypeCarouselSkiTab.getCssValue("background-color").contentEquals(hoverStateBackgroundColor2);
    }

    public boolean isDestinationsRegionTabSelected() {
        return isAriaSelectedAttributeTrue(destinationRegionTab);
    }

    public boolean isTripTypeCarouselCityTabsEmpty() {
        return tripTypeCarouselTabsList.isEmpty();
    }

    public void hoverOnTripTypeCarouselType() {
        Actions actions = new Actions(driver);
        Action action = actions.moveToElement(tripTypeCarouselSkiTab).build();
        action.perform();
    }
}
