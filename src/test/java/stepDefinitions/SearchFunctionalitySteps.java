package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.TabNav;
import utilities.*;

public class SearchFunctionalitySteps {
    TabNav tb = new TabNav();

    @Given("The user navigate to the homepage")
    public void theUserNavigateToTheHomepage() {
        GWD.getDriver().get(ConfigReader.getProperty("homePageUrl"));
    }

    @And("The user see the search bar")
    public void theUserSeeTheSearchBar() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(tb.searchBar));
        Assert.assertTrue(tb.searchBar.isDisplayed(), "Search bar is not displayed");
    }

    @When("The user enter in the search bar")
    public void theUserEnterInTheSearchBar() {
        tb.mySendKeys(tb.searchBar, ConfigReader.getProperty("productNumber"));
    }

    @And("The user click the search button")
    public void theUserClickTheSearchButton() {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(tb.searchButton));
        tb.myClick(tb.searchButton);
    }

    @Then("The user should see a list of Lando Gym Jacket")
    public void theUserShouldSeeAListOfLandoGymJacket() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(tb.productName));
        Assert.assertTrue(tb.productName.isDisplayed(), "Product name is not displayed");
    }

    @And("The user clicks on the product Lando Gym Jacket by following Home > Men > Tops > Jackets.")
    public void theUserClicksOnTheProductLandoGymJacketByFollowingHomeMenTopsJackets() {
        tb.myClick(tb.logo);
        tb.action.moveToElement(tb.menButton)
                .pause(1000)
                .moveToElement(tb.topsButton)
                .pause(1000)
                .moveToElement(tb.jacketsButton)
                .click()
                .build()
                .perform();
        tb.action.scrollToElement(tb.productName).perform();
        tb.myClick(tb.productName);
    }

    @Then("The user verifies that the SKU number is MJ08 on the product detail page.")
    public void theUserVerifiesThatTheSKUNumberIsOnTheProductDetailPage() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(tb.skuNumber));
        Assert.assertEquals(tb.skuNumber.getText(), ConfigReader.getProperty("productNumber"), "SKU number does not match");
    }

    @When("The user enters the wrong word in the search bar")
    public void theUserEntersTheWrongWordInTheSearchBar() {
        tb.myClick(tb.logo);
        GWD.getWait().until(ExpectedConditions.visibilityOf(tb.searchBar));
        tb.mySendKeys(tb.searchBar, ConfigReader.getProperty("invalidProductNumber"));
    }

    @Then("The user should see a message saying Your search returned no results.")
    public void theUserShouldSeeAMessageSaying() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(tb.noResultsMessage));
        Assert.assertTrue(tb.noResultsMessage.isDisplayed(), "No results message is not displayed");
    }
}