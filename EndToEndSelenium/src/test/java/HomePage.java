import org.testng.annotations.Test;
import pageObject.LandingPage;
import resources.*;

import java.io.IOException;

public class HomePage extends Base {

    @Test
    public void basePageNavigation() throws IOException {
        driver = initializeDriver();
        driver.get("http://qaclickacademy.com");

        LandingPage landingPage = new LandingPage(driver);
        landingPage.getLogin().click();


    }
}
