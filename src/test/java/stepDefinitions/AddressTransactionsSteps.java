package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DialogContent;
import pages.LeftNav;
import pages.TabNav;
import utilities.GWD;

import java.time.Duration;
import java.util.List;

public class AddressTransactionsSteps {
    DialogContent dc = new DialogContent();
    TabNav tn = new TabNav();
    LeftNav ln = new LeftNav();

    @When("The user clicks on the drop-down menu next to their name in the top right corner and then on the My Account button")
    public void theUserClicksOnTheDropDownMenuNextToTheirNameInTheTopRightCornerAndThenOnTheMyAccountButton() {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(tn.dropDownMenuButton));
        tn.action.moveToElement(tn.dropDownMenuButton)
                .click()
                .pause(Duration.ofSeconds(1))
                .moveToElement(tn.myAccountButton)
                .click().build().perform();
    }

    @And("The user clicks on the Address Book button and then fills in the address information")
    public void theUserClicksOnTheAddressBookButtonAndThenFillsInTheAddressInformation() {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(ln.addressBookButton));
        dc.myClick(ln.addressBookButton);
        dc.action.scrollByAmount(0, 200).build().perform();
        try {
            dc.addFirstAddress();
        } catch (TimeoutException e) {
            try {
                GWD.getWait().until(ExpectedConditions.elementToBeClickable(dc.addNewAddressButton));
                System.out.println("Address already exists, opening add new address");
                dc.myClick(dc.addNewAddressButton);
                dc.addNewAddress();
            } catch (TimeoutException ex) {
                System.out.println("Neither Save button nor Add New Address button appeared.");
            }
        }
    }

    @And("Add the new address and Checks for the existence of Default Shipping Address and Default Billing Address selections")
    public void addTheNewAddressAndChecksForTheExistenceOfDefaultShippingAddressAndDefaultBillingAddressSelections() {
        dc.action.scrollByAmount(0, 200).build().perform();
        while (dc.addNewAddressButton.isDisplayed()) {
            dc.myClick(dc.addNewAddressButton);
            dc.addNewAddress();
            break;
        }
    }

    @And("The user clicks on the Delete button and deletes their old address and the verification message is displayed")
    public void theUserClicksOnTheDeleteButtonAndDeletesTheirOldAddressAndTheVerificationMessageIsDisplayed() {
        dc.myClick(dc.addNewAddressButton);
        dc.addFirstAddress();
        dc.myClick(dc.saveButton);
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.confirmMessage));
        tn.verifyContainsMessage(dc.confirmMessage, "You saved");

        dc.action.scrollByAmount(0, 300).build().perform();

        List<WebElement> deleteButtons = dc.deleteAddressButtons;
        while (!deleteButtons.isEmpty()) {
            try {
                WebElement firstDeleteButton = deleteButtons.get(0);
                GWD.getWait().until(ExpectedConditions.elementToBeClickable(firstDeleteButton));
                dc.myClick(firstDeleteButton);
                GWD.getWait().until(ExpectedConditions.elementToBeClickable(dc.deleteAlertOkButton));
                dc.myClick(dc.deleteAlertOkButton);
                tn.verifyContainsMessage(tn.successMessage, "You deleted the address.");
                deleteButtons = dc.deleteAddressButtons;
            } catch (StaleElementReferenceException e) {
                deleteButtons = dc.deleteAddressButtons;
            }
        }
    }

    @Then("The user clicks on the Save button and verifies the success message")
    public void theUserClicksOnTheSaveButtonAndVerifiesTheSuccessMessage() {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(dc.saveButton));
        dc.myClick(dc.saveButton);
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.confirmMessage));
        tn.verifyContainsMessage(dc.confirmMessage, "You saved");
    }

    @When("The user clicks on the My Account button in the Left Nav and then on the Edit Address button")
    public void theUserClicksOnTheMyAccountButtonInTheLeftNavAndThenOnTheEditAddressButton() {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(ln.myAccountButtonLeftNav));
        ln.myClick(ln.myAccountButtonLeftNav);
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(dc.editAddressButton));
        dc.jsClick(dc.editAddressButton);
    }

    @And("The user changes the address information they want to change")
    public void theUserChangesTheAddressInformationTheyWantToChange() {
        dc.addFirstAddress();
    }

    @And("The user clicks on the Address Book button")
    public void theUserClicksOnTheAddressBookButton() {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(ln.addressBookButton));
        dc.myClick(ln.addressBookButton);
    }
}