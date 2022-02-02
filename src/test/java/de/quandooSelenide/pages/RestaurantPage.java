package de.quandooSelenide.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;


public class RestaurantPage extends CommonsPage {

    private static By scoreInRestaurantCard = By.xpath("//span[@data-qa='reviews-score']//span [@class='r91qah-1 DYnWo']");
    private static By reviewTab = By.xpath("//a[@data-qa='sub-nav-tab-tab-reviews']");
    private static By scoreInReviews = By.cssSelector(".sc-fzozJi:nth-child(2) > .sc-fzozJi > .sc-fzozJi > .sc-fzozJi > .sc-fzozJi > .sc-fzozJi > .r91qah-0 > .r91qah-1:nth-child(1)");


    public String getScoreInCard() {
        return $(scoreInRestaurantCard).getText();
    }

    public void clickOnReviewsTab() {
        $(reviewTab).click();
    }

    public String getScoreInReviews() {
        return $(scoreInReviews).getText();
    }
}
