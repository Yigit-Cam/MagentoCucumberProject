package stepDefinitions;

import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.LeftNav;
import pages.TabNav;
import utilities.GWD;

import java.time.Duration;

public class AddingAndRemovingShoppingCartsteps {
    DialogContent dc = new DialogContent();
    TabNav tn = new TabNav();
    LeftNav ln = new LeftNav();
    JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();


    @Given("The user goes to the product selection page")
    public void theUserGoesToTheProductSelectionPage() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(tn.menButton));
        tn.action.moveToElement(tn.menButton).
                pause(Duration.ofSeconds(1)).
                moveToElement(tn.topsButton).
                pause(Duration.ofSeconds(1)).
                moveToElement(tn.jacketsButton).
                click().build().perform();
    }

    @When("User adds the product to the cart")
    public void userAddsTheProductToTheCart() {
        js.executeScript("window.scrollBy(0, 250);");
        dc.action.moveToElement(dc.windJacket).
                pause(Duration.ofSeconds(1)).
                click().build().perform();
    }

    @Then("Fills in the required information for the product")
    public void fillsInTheRequiredInformationForTheProduct() {
        dc.myClick(dc.size);
        dc.myClick(dc.color);
        dc.myClick(dc.numberQty);
        dc.numberQty.clear();
        dc.mySendKeys(dc.numberQty, "2");
        dc.myClick(dc.addToCart);

    }

    @And("See confirmation message added to cart")
    public void seeConfirmationMessageAddedToCart() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.addMessage));
        Assert.assertTrue(dc.addMessage.isDisplayed(), "No added product");
    }

    @Given("User goes to the cart page")
    public void userGoesToTheCartPage() {
        js.executeScript("window.scrollBy(0, -500);");
        GWD.getWait().until(ExpectedConditions.visibilityOf(tn.counterQty));
        tn.myClick(tn.counterQty);
        dc.myClick(dc.viewEditCart);

    }

    @When("User changes the number of products")
    public void userChangesTheNumberOfProducts() {
        js.executeScript("window.scrollBy(0, -500);");
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.cartItemQty));
        dc.myClick(dc.cartItemQty);
        dc.cartItemQty.clear();
        dc.mySendKeys(dc.cartItemQty,"1");
    }

    @Then("User updates the product")
    public void userUpdatesTheProduct() {
        js.executeScript("window.scrollBy(0, -500);");
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.updateShoppingCart));
        dc.myClick(dc.updateShoppingCart);
        Assert.assertNotEquals("Did not change the prices of the product",dc.subtotal1.getText(),dc.subtotal2.getText());
    }

    @And("User deletes the product")
    public void userDeletesTheProduct() {
        js.executeScript("window.scrollBy(0, -500);");
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.removeItem));
        dc.myClick(dc.removeItem);
    }

    @And("The user receives a confirmation message that the product is not available")
    public void theUserReceivesAConfirmationMessageThatTheProductIsNotAvailable() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.cartEmptyMessage));
        Assert.assertTrue(dc.cartEmptyMessage.isDisplayed(),"Cart is no empty");
    }
}
