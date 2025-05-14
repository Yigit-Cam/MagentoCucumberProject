package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
    @And("The user clicks on the Add to Favourites button")
    public void theUserClicksOnTheAddToFavouritesButton() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.addToWishList));
        dc.myClick(dc.addToWishList);

        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.womenButton));
        dc.action.moveToElement(dc.womenButton).
                pause(Duration.ofSeconds(1)).
                moveToElement(dc.topsButton).
                pause(Duration.ofSeconds(1)).
                moveToElement(dc.jacketsButton).
                click().build().perform();
        dc.myClick(dc.addToWishList);

    }

    @And("The user confirms that they have added the product to their favourites")
    public void theUserConfirmsThatTheyHaveAddedTheProductToTheirFavourites() {
        Assert.assertTrue(dc.myWishList.isDisplayed(),"My Wish List did not appear");

    }

    @And("The user clicks on the Dropdown Menu and My Account button")
    public void theUserClicksOnTheDropdownMenuAndMyAccountButton() {
            GWD.getWait().until(ExpectedConditions.visibilityOf(dc.removeItemButton));
            dc.myClick(dc.removeItemButton);
    }

    @When("The user clicks on the My Wish List button")
    public void theUserClicksOnTheMyWishListButton() {
        Assert.assertTrue(dc.removedMessage.isDisplayed(), "Wish did not remove from your Lis ");
    }

    @Then("The user confirms that the product is on the favourite list")
    public void theUserConfirmsThatTheProductIsOnTheFavouriteList() {
        Assert.assertTrue(dc.ıltem.isDisplayed(), "  product could not be verified");

    }

    @When("The user hover-overs over the product, user sees the removal icon from fovories")
    public void theUserHoverOversOverTheProductUserSeesTheRemovalIconFromFovories() {
    }

    @And("The user clicks on the {string} button next to the Product.")
    public void theUserClicksOnTheButtonNextToTheProduct(String arg0) {
    }

    @Then("The user Confirms that the Product has been removed from the favourites list")
    public void theUserConfirmsThatTheProductHasBeenRemovedFromTheFavouritesList() {
    }

    @When("The user hovers over the product in the My Wish List and clicks the edit icon")
    public void theUserHoversOverTheProductInTheMyWishListAndClicksTheEditIcon() {
    }

    @Then("The user is directed to the page with product details")
    public void theUserIsDirectedToThePageWithProductDetails() {
    }
}
