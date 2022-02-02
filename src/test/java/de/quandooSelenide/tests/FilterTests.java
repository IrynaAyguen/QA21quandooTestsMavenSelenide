package de.quandooSelenide.tests;

import com.codeborne.selenide.Condition;
import de.quandooSelenide.pages.CommonsPage;
import de.quandooSelenide.pages.RestBerlinPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * UI test for search filter https://www.quandoo.de/en/berlin
 */
public class FilterTests extends TestBase{


    @BeforeEach
    public void ensurePreconditions() {
        //open  Restaurants in Berlin page
        restBerlinPage= new RestBerlinPage().openPage();
        //accept cookies
        new CommonsPage().acceptAllCookies();
    }

    @Test
    /**
     * Test:
     * click filter Top rated;
     * check, total number of restaurants is changed
     * select first item in Cuisine filter;
     * check number of displayed restaurants
     */
    public void TopRatedAfricanFilterTest() {
        //save total restaurants number to variable
        String restCountBefore = restBerlinPage.restaurantCount().getText();
        //click filter Top rated
        restBerlinPage.clickOnTopRated();
        // assert that the rating of the first restaurant is more than 4
        assertTrue(restBerlinPage.getFirstRestaurantRating() >= 4);
        //assert total number of restaurants changed
        restBerlinPage.restaurantCount().shouldNotHave(Condition.exactValue(restCountBefore));
        // click African in Cuisine filter
        restBerlinPage.selectAfricanCuisineFilter();
        // assert that the first restaurant has African cuisine label
        restBerlinPage.firstRestaurantCard().shouldHave(text("African"));
        //assert correct number of displayed restaurants
        assertEquals(restBerlinPage.getAfricanRestaurantCount(), restBerlinPage.getRestaurantListSize());
    }

}
