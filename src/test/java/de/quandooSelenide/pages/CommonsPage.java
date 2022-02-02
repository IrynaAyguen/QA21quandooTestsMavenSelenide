package de.quandooSelenide.pages;


import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public class CommonsPage {

    public static final String BASE_URL = "https://www.quandoo.de";

    /** Elements **/
    private static By accCookies = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");

    /** Methods **/

    public void acceptAllCookies() {
        if ($(accCookies).exists()){
            $(accCookies).click();
        }
    }
}
