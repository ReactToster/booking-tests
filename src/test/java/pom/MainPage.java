package pom;

import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get("https://www.booking.com/index.html?label=gen173nr-1BCAEoggI46AdIM1gEaLYBiAEBmAEeuAEHyAEM2AEB6AEBiAIBqAIDuAKWveygBsACAdICJDdhNDllMDA5LWY1MjgtNGVmNi1iNGY1LTc5Mjg0NGY3Yzc2YdgCBeACAQ&sid=fcae6461057870fff28ff7a2e583e8ed&keep_landing=1&sb_price_type=total&lang=en-us&soz=1&lang_changed=1");
    }

}
