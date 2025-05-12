package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DialogContent;
import pages.LeftNav;
import pages.TabNav;
import utilities.GWD;

import java.util.List;

public class AddressTransactionsSteps {
    DialogContent dc = new DialogContent();
    TabNav tn = new TabNav();
    LeftNav ln = new LeftNav();

    @When("The user clicks on the drop-down menu next to their name in the top right corner and then on the My Account button")
    public void theUserClicksOnTheDropDownMenuNextToTheirNameInTheTopRightCornerAndThenOnTheMyAccountButton() {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(tn.dropDownMenuButton));
        tn.myClick(tn.dropDownMenuButton);
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(tn.myAccountButton));
        tn.myClick(tn.myAccountButton);
    }

    @And("The user clicks on the Delete button and deletes their old address and the verification message is displayed")
    public void theUserClicksOnTheDeleteButtonAndDeletesTheirOldAddressAndTheVerificationMessageIsDisplayed() {
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
                deleteButtons = dc.deleteAddressButtons; // Eğer element kaybolduysa yeniden al
            }
        }
        System.out.println("Delete button clicked successfully.");
    }

    @And("The user clicks on the Address Book button and then on the Add New Address button")
    public void theUserClicksOnTheAddressBookButtonAndThenOnTheAddNewAddressButton() {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(ln.addressBookButton));
        dc.myClick(ln.addressBookButton);
        List<WebElement> addAddressMessageList = dc.addNewAddressMessage;
        while (addAddressMessageList.isEmpty()) {
            dc.addFirstAddress();
            break;
        }
        System.out.println("Address Book button clicked successfully.");
    }

    @And("Fills in user address information Checks for the existence of Default Shipping Address and Default Billing Address selections")
    public void fillsInUserAddressInformationChecksForTheExistenceOfDefaultShippingAddressAndDefaultBillingAddressSelections() {
        List<WebElement> addAddressMessageList = dc.addNewAddressMessage;
        while (!addAddressMessageList.isEmpty()) {
            dc.myClick(dc.addNewAddressButton);
            GWD.getWait().until(ExpectedConditions.visibilityOf(dc.company));
            dc.addNewAddress();
            break;
        }
        System.out.println("Add New Address button clicked successfully.");
    }

    @And("The user clicks on the Save button and verifies the success message")
    public void theUserClicksOnTheSaveButtonAndVerifiesTheSuccessMessage() {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(dc.saveButton));
        dc.myClick(dc.saveButton);
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.confirmMessage));
        tn.verifyContainsMessage(dc.confirmMessage, "You saved");
        System.out.println("Address added successfully.");
    }

    @When("The user clicks on the My Account button in the Left Nav and then on the Edit Address button")
    public void theUserClicksOnTheMyAccountButtonInTheLeftNavAndThenOnTheEditAddressButton() {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(ln.myAccountButtonLeftNav));
        ln.myClick(ln.myAccountButtonLeftNav);
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(dc.editAddressButton));
        dc.jsClick(dc.editAddressButton);
        System.out.println("Edit Address button clicked successfully.");
    }

    @And("The user changes the address information they want to change")
    public void theUserChangesTheAddressInformationTheyWantToChange() {
        dc.addFirstAddress();
    }

    @Then("The user clicks on Save button and displays verifies message")
    public void theUserClicksOnSaveButtonAndDisplaysVerifiesMessage() {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(dc.saveButton));
        dc.myClick(dc.saveButton);
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.confirmMessage));
        tn.verifyContainsMessage(dc.confirmMessage, "You saved");
        System.out.println("Address updated successfully.");
    }

    @And("The user clicks on the Address Book button")
    public void theUserClicksOnTheAddressBookButton() {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(ln.addressBookButton));
        dc.myClick(ln.addressBookButton);
    }
}
