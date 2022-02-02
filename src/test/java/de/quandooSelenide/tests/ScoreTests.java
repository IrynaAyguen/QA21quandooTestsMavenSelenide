package de.quandooSelenide.tests;

import de.quandooSelenide.pages.CommonsPage;
import de.quandooSelenide.pages.RestBerlinPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTests extends TestBase{

    String scoreOfFirstRestaurantInList;

    /**
     * UI test for Score of Restaurant https://www.quandoo.de/en/berlin
     */

    @BeforeEach
    public void ensurePreconditions() {
        //open  Restaurants in Berlin page
        restBerlinPage= new RestBerlinPage().openPage();
        //accept cookies
        new CommonsPage().acceptAllCookies();
        //save Score of first restaurant in list of "Restaurants in Berlin" page to variable
        scoreOfFirstRestaurantInList = restBerlinPage.getScoreOfFirstRestaurant();
        //click on first restaurant in list of "Restaurants in Berlin" page
        restaurantPage =restBerlinPage.clickOnFirstRestaurant();
    }

    @Test
    /**
     * Test:
     * check, Score of first restaurant in "Restaurants in Berlin" page is
     * Score  in Restaurant card
     */
    public void CheckScoreOfRestaurantInListIsScoreInCard() {
        //assert, Score of first restaurant in list  is  Score in the Restaurant card
        assertEquals(restaurantPage.getScoreInCard(), scoreOfFirstRestaurantInList);
    }


    @Test
    /**
     * Test:
     * check, Score of first restaurant in "Restaurants in Berlin" page is
     * Score by click on Reviews tab in the Restaurant card
     */
    public void CheckScoreOfRestaurantInListIsScoreInReviews() {
        // click on ReviewsTab in the Restaurant card
        restaurantPage.clickOnReviewsTab();
        //assert, Score of first restaurant in list  is  Score in the Restaurant card
        assertEquals(restaurantPage.getScoreInReviews(), scoreOfFirstRestaurantInList);
    }

}
