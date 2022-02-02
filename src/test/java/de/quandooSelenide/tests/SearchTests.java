package de.quandooSelenide.tests;

import com.codeborne.selenide.Condition;
import de.quandooSelenide.pages.CommonsPage;
import de.quandooSelenide.pages.RestBerlinPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchTests extends TestBase{

    /**
     * UI test for Search of Restaurant https://www.quandoo.de/en/berlin
     */
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
     * input "African" in search field
     * select "African" in menu "Cuisine"
     * check, filtered list of restaurants
     */
    public void searchAfricanCuisineRestaurants() {
        //save total restaurants number to variable
        String restCountBefore = restBerlinPage.restaurantCount().getText();
        //input "African" in search field
        restBerlinPage.inputAfricanInSearchField("African");
        // select African in Cuisine menu
        restBerlinPage.selectAfricanCuisine();
        //assert total number of restaurants changed
        restBerlinPage.restaurantCount().shouldNotHave(Condition.exactText(restCountBefore));
        // assert that the first restaurant has African cuisine label
        restBerlinPage.firstRestaurantCard().shouldHave(text("African"));
    }
}
