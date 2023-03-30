package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage {
    List<WebElement> searchResults;
    public boolean isThereAnySearchResult() {
        searchResults = driver.findElements(By.xpath("//div[@data-testid='property-card']"));
        return searchResults.size() > 0;
    }
}
