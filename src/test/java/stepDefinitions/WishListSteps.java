package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TabNav;
import utilities.GWD;

import java.time.Duration;

public class WishListSteps {
    DialogContent dc = new DialogContent();
    TabNav tn = new TabNav();
    JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

    @And("The user clicks on the Add to Favorites button")
    public void theUserClicksOnTheAddToFavouritesButton() {
        js.executeScript("window.scrollBy(0, 300);");

        dc.action.moveToElement(dc.windJacket).build().perform();
                dc.action.pause(Duration.ofSeconds(3)).click().build().perform();
       // GWD.getWait().until(ExpectedConditions.visibilityOf(dc.windJacket));

        js.executeScript("window.scrollBy(0, 300);");

        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.productAddWishListButton));
        Assert.assertTrue(dc.productAddWishListButton.isDisplayed());
        dc.action.moveToElement(dc.productAddWishListButton).build().perform();
        dc.action.pause(Duration.ofSeconds(1));
        dc.action.click(dc.productAddWishListButton).build().perform();

        GWD.getWait().until(ExpectedConditions.visibilityOf(tn.womenButton));
        dc.action.moveToElement(tn.womenButton)
                .pause(Duration.ofSeconds(1))
                .moveToElement(tn.topsButtonWomen)
                .pause(Duration.ofSeconds(1))
                .moveToElement(tn.jacketsButtonWomen)
                .click().perform();

        js.executeScript("window.scrollBy(0, 300);");
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.lightJacket));
        dc.action.moveToElement(dc.lightJacket)
                .pause(Duration.ofSeconds(1)).click().build().perform();

        js.executeScript("window.scrollBy(0, 300);");

        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.productAddWishListButton));
        Assert.assertTrue(dc.productAddWishListButton.isDisplayed());
        dc.action.moveToElement(dc.productAddWishListButton)
                .pause(Duration.ofSeconds(1))
                .click().build().perform();
    }

    @And("The user confirms that they have added the product to their favorites")
    public void theUserConfirmsThatTheyHaveAddedTheProductToTheirFavourites() {
        Assert.assertTrue(dc.myWishList.isDisplayed(), "My Wish List did not appear");
    }

    @And("User deletes a product from wishlist")
    public void userDeletesAProductFromWishlist() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.removeItemButton));
        dc.myClick(dc.removeItemButton);
    }

    @Then("the user checks the number of products in the wishlist")
    public void theUserChecksTheNumberOfProductsInTheWishlist() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.removedMessage));
        Assert.assertTrue(dc.removedMessage.isDisplayed(), "Wish did not remove from your List ");
    }
}