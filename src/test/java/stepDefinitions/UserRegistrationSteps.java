package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.*;
import utilities.*;

import java.util.*;

public class UserRegistrationSteps {
    DialogContent dc = new DialogContent();
    RegisterAndLogin ral =new RegisterAndLogin();
    Faker faker = new Faker(new Locale("en-US"));

    @Given("The user opens the Magento homepage")
    public void theUserOpensTheMagentoHomepage() {
        GWD.getDriver().get(ConfigReader.getProperty("homePageUrl"));
    }

    @When("The user click the option to register a create new account")
    public void theUserClickTheOptionToRegisterACreateNewAccount() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(ral.createAccountBtn));
        dc.myClick(ral.createAccountBtn);
    }

    @And("The user form is displayed")
    public void theUserFormIsDisplayed() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(ral.formHeader));
        Assert.assertTrue(ral.formHeader.getText().contains("Create New Customer Account"));
    }

    @And("The user fills the registration form with the following data")
    public void theUserFillsTheRegistrationFormWithTheFollowingData(DataTable table) {
        List<List<String>> rows = table.asLists();
        List<String> headers = rows.get(0);

        for (int i = 0; i < headers.size(); i++) {
            String field = headers.get(i);

            switch (field){
                case "firstName" :
                    dc.mySendKeys(ral.firstNameField, faker.name().firstName());
                    break;
                case "lastName" :
                    dc.mySendKeys(ral.lastNameField, faker.name().lastName());
                    break;
                case "email" :
                    ConfigReader.updateProperty("email");
                    dc.mySendKeys(ral.emailField, ConfigReader.getProperty("email"));
                    break;
                case  "password" :
                    ConfigReader.updateProperty("password");
                    dc.mySendKeys(ral.passwordField, ConfigReader.getProperty("password"));
                    break;
                case "confirmPassword" :
                    dc.mySendKeys(ral.confirmPasswordField, ConfigReader.getProperty("password"));
                    break;
                case "action" :
                    dc.myClick(ral.submitButton);
                    break;
                default:
                    System.out.println("Unknown field: " + field);
                    break;
            }
        }
    }

    @Then("A success message should be visible confirming the registration")
    public void aSuccessMessageShouldBeVisibleConfirmingTheRegistration() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(ral.successMessage));
        Assert.assertTrue(ral.successMessage.getText().contains("Thank you for registering with Main Website Store."));
    }

    @And("The user should see their account dashboard")
    public void theUserShouldSeeTheirAccountDashboard() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(ral.myAccountHeader));
        Assert.assertTrue(ral.myAccountHeader.getText().contains("My Account"));
    }
}