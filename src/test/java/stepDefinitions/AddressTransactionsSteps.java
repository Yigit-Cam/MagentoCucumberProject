package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DialogContent;
import pages.LeftNav;
import pages.TabNav;
import utilities.ConfigReader;
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

                GWD.getWait().until(ExpectedConditions.alertIsPresent());
                GWD.getWait().until(ExpectedConditions.visibilityOf(dc.deleteAlertOkButton));
                //GWD.getDriver().switchTo().alert().accept();
                dc.myClick(dc.deleteAlertOkButton);
                tn.verifyContainsMessage(tn.successMessage, "You deleted the address.");

                deleteButtons = dc.deleteAddressButtons;

            } catch (StaleElementReferenceException e) {
                deleteButtons = dc.deleteAddressButtons; // Eğer element kaybolduysa yeniden al
            }
        }
    }

    @And("The user clicks on the Address Book button and then on the Add New Address button")
    public void theUserClicksOnTheAddressBookButtonAndThenOnTheAddNewAddressButton() {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(ln.addressBookButton));
        dc.myClick(ln.addressBookButton);
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(dc.addNewAddressButton));
        dc.jsClick(dc.addNewAddressButton);
    }

    @And("Fills in user address information Checks for the existence of Default Shipping Address and Default Billing Address selections")
    public void fillsInUserAddressInformationChecksForTheExistenceOfDefaultShippingAddressAndDefaultBillingAddressSelections() {
        ConfigReader.updateProperty("company");
        dc.mySendKeys(dc.company, ConfigReader.getProperty("company"));
        ConfigReader.updateProperty("phoneNumber");
        dc.mySendKeys(dc.telephone, ConfigReader.getProperty("phoneNumber"));
        ConfigReader.updateProperty("street");
        dc.mySendKeys(dc.streetAddress, ConfigReader.getProperty("street"));
        ConfigReader.updateProperty("city");
        dc.mySendKeys(dc.city, ConfigReader.getProperty("city"));
        dc.myClick(dc.selectRegion);
        dc.selectByText(dc.selectRegion, "California");
        ConfigReader.updateProperty("postalCode");
        dc.mySendKeys(dc.zipCode, ConfigReader.getProperty("postalCode"));
        dc.myClick(dc.country);
        dc.selectByText(dc.country, "United States");
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(dc.billingAddressCheckbox));
        dc.myClick(dc.billingAddressCheckbox);
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(dc.shippingAddressCheckbox));
        dc.myClick(dc.shippingAddressCheckbox);
    }

    @And("The user clicks on the Save button and verifies the success message")
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
        ConfigReader.updateProperty("company");
        dc.mySendKeys(dc.company, ConfigReader.getProperty("company"));
        ConfigReader.updateProperty("phoneNumber");
        dc.mySendKeys(dc.telephone, ConfigReader.getProperty("phoneNumber"));
        ConfigReader.updateProperty("street");
        dc.mySendKeys(dc.streetAddress, ConfigReader.getProperty("street"));
        ConfigReader.updateProperty("city");
        dc.mySendKeys(dc.city, ConfigReader.getProperty("city"));
        dc.myClick(dc.selectRegion);
        dc.selectByText(dc.selectRegion, "California");
        ConfigReader.updateProperty("postalCode");
        dc.mySendKeys(dc.zipCode, ConfigReader.getProperty("postalCode"));
        dc.myClick(dc.country);
        dc.selectByText(dc.country, "United States");
    }

    @Then("The user clicks on Save button and displays verifies message")
    public void theUserClicksOnSaveButtonAndDisplaysVerifiesMessage() {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(dc.saveButton));
        dc.myClick(dc.saveButton);
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.confirmMessage));
        tn.verifyContainsMessage(dc.confirmMessage, "You saved");
    }
}
