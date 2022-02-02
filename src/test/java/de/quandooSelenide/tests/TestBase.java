package de.quandooSelenide.tests;

import de.quandooSelenide.pages.RestBerlinPage;
import de.quandooSelenide.pages.RestaurantPage;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    RestBerlinPage restBerlinPage;
    RestaurantPage restaurantPage;


    @BeforeEach
    public void setUp() {
        // brew install chromedriver
        System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver.exe");

    }

}
