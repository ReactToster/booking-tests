package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    protected WebDriver driver;
    public List<WebElement> searchInputList;
    public WebElement searchDateBtn;
    List<WebElement> searchDateTableList;
    public WebElement searchOccupancyConfigBtn;
    WebElement searchSubmitBtn;


    public BasePage(WebDriver driver) {
        this.driver = driver;

    }

    public WebDriver getDriver() {
        return driver;
    }

    public void dismissCookies() {
        WebElement cookieBtn = driver.findElement(By.cssSelector("#onetrust-accept-btn-handler"));
        cookieBtn.click();
    }

    public void locateFormElements() {
        searchInputList = driver.findElements(By.cssSelector(".hero-banner-searchbox form > div input"));
        searchDateBtn = driver.findElement(By.xpath("//button[@data-testid='date-display-field-start']"));
        searchOccupancyConfigBtn = driver.findElement(By.xpath("//button[@data-testid='occupancy-config']"));
    }

    public void insertLocation(String location) {
        WebElement searchLocationInput = searchInputList.get(0);
        searchLocationInput.sendKeys(location);
    }

    public void pickCheckInDateAndCheckOutDate(String checkInDate, String checkOutDate) {
        searchDateBtn.click();

        searchDateTableList = driver.findElements(By.xpath("//table[@role='grid']"));

        WebElement searchDateTableFromBtn = searchDateTableList.get(0).findElement(By.xpath("//tbody/tr/td/span[@data-date='" + checkInDate + "']"));
        searchDateTableFromBtn.click();

        WebElement searchDateTableToBtn = searchDateTableList.get(0).findElement(By.xpath("//tbody/tr/td/span[@data-date='" + checkOutDate + "']"));
        searchDateTableToBtn.click();

        searchDateBtn.click();
    }

    public void insertOccupancyDetails() {
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

    public void submitSearchDetails() {
        searchSubmitBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        searchSubmitBtn.click();
    }


}