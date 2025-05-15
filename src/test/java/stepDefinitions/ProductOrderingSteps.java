package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.LeftNav;
import pages.TabNav;
import utilities.GWD;

public class ProductOrderingSteps {
    DialogContent dc = new DialogContent();
    TabNav tn = new TabNav();
    LeftNav ln = new LeftNav();
    JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

    @When("User selects the payment transaction")
    public void userSelectsThePaymentTransaction() {
        dc.myClick(dc.proceedCheckout);
    }

    @Then("User clicks next button")
    public void userClicksNextButton() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.nextButton));
        dc.myClick(dc.radioButton);
        dc.myClick(dc.nextButton);
    }

    @And("User makes sure that the billing and shipping address are the same")
    public void userMakesSureThatTheBillingAndShippingAddressAreTheSame() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.clickedButton));
        Assert.assertTrue(dc.clickedButton.isSelected(),"Bill and Shipping address are not the same");
    }

    @And("User selects place order")
    public void userSelectsPlaceOrder() {
        dc.myClick(dc.placeOrderButton);
    }

    @And("The user receives a message that the order has been confirmed")
    public void theUserReceivesAMessageThatTheOrderHasBeenConfirmed() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.purchaseMessage));
        Assert.assertTrue(dc.purchaseMessage.isDisplayed(),"Failed to display purchase confirmation message");
    }
}