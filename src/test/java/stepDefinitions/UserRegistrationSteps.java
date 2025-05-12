package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.*;
import utilities.*;

import java.util.*;

public class UserRegistrationSteps {
    DialogContent dc = new DialogContent();
    RegisterAndLogin register=new RegisterAndLogin();
    Faker faker = new Faker(new Locale("en-US"));

    @Given("The user opens the Magento homepage")
    public void theUserOpensTheMagentoHomepage() {
        GWD.getDriver().get(ConfigReader.getProperty("homePageUrl"));
    }

    @When("The user click the option to register a create new account")
    public void theUserClickTheOptionToRegisterACreateNewAccount() {
        dc.myClick(register.createAccountBtn);
    }

    @And("The user form is displayed")
    public void theUserFormIsDisplayed() {
        Assert.assertTrue(register.formHeader.getText().contains("Create New Customer Account"));
    }

    @And("The user fills the registration form with the following data")
    public void theUserFillsTheRegistrationFormWithTheFollowingData(DataTable table) {
        List<List<String>> rows = table.asLists();
        List<String> headers = rows.get(0);

        for (int i = 0; i < headers.size(); i++) {
            String field = headers.get(i);

            switch (field){
                case "firstName" :
                    dc.mySendKeys(register.firstNameField, faker.name().firstName());
                    break;
                case "lastName" :
                    dc.mySendKeys(register.lastNameField, faker.name().lastName());
                    break;
                case "email" :
                    ConfigReader.updateProperty("email");
                    dc.mySendKeys(register.emailField, ConfigReader.getProperty("email"));
                    break;
                case  "password" :
                    ConfigReader.updateProperty("password");
                    dc.mySendKeys(register.passwordField, ConfigReader.getProperty("password"));
                    break;
                case "confirmPassword" :
                    dc.mySendKeys(register.confirmPasswordField, ConfigReader.getProperty("password"));
                    break;
                case "action" :
                    dc.myClick(register.submitButton);
                    break;
                default:
                    System.out.println("Unknown field: " + field);
                    break;
            }
        }
    }

    @Then("A success message should be visible confirming the registration")
    public void aSuccessMessageShouldBeVisibleConfirmingTheRegistration() {
        Assert.assertTrue(register.successMessage.getText().contains("Thank you for registering with Main Website Store."));
    }

    @And("The user should see their account dashboard")
    public void theUserShouldSeeTheirAccountDashboard() {
        Assert.assertTrue(register.myAccountHeader.getText().contains("My Account"));
    }
}
