package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.*;
import utilities.*;

import java.util.List;

public class UserLoginSteps {
    DialogContent dc = new DialogContent();
    RegisterAndLogin register = new RegisterAndLogin();
    ExcelUtility excel = new ExcelUtility();

    @When("The user clicks the Sign In button")
    public void theUserClicksTheSignInButton() {
        dc.myClick(register.signInBtn);
    }

    @Then("The user should see Customer Login page")
    public void theUserShouldSeeCustomerLoginPage() {
        Assert.assertTrue(register.customerLoginHeader.getText().contains("Customer Login"));
    }

    @When("The user logs in with credentials from row {int}")
    public void theUserLogsInWithCredentialsFromRow(int rowIndex) {
        List<List<String>> data = excel.getData("src/test/resources/testData/credentials.xlsx", "Sayfa1");
        String email = data.get(rowIndex).get(0);
        String password = data.get(rowIndex).get(1);

        dc.mySendKeys(register.emailInput, email);
        dc.mySendKeys(register.passwordInput, password);
        dc.myClick(register.signInFormBtn);
    }

    @Then("The user should be redirected to the Home Page and see {string} text in the upper right")
    public void theUserShouldBeRedirectedToTheHomePageAndSeeTextInTheUpperRight(String welcome) {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(register.welcomeText));
        Assert.assertTrue(register.welcomeText.getText().contains(welcome));
    }

    @Then("The user should see for null email error message")
    public void theUserShouldSeeForNullEmailErrorMessage() {
        Assert.assertTrue(register.emailErrorMsg.getText().contains("This is a required field."));
    }

    @Then("The user should see for null password error message")
    public void theUserShouldSeeForNullPasswordErrorMessage() {
        Assert.assertTrue(register.nullPasswordErrorMsg.getText().contains("This is a required field."));
    }

    @Then("The user should see invalid email error message")
    public void theUserShouldSeeInvalidEmailErrorMessage() {
        Assert.assertTrue(register.emailErrorMsg.getText().contains("Please enter a valid email address"));
    }

    @Then("The user should see wrong password error message")
    public void theUserShouldSeeWrongPasswordErrorMessage() {
        Assert.assertTrue(register.invalidPassErrorMsg.isDisplayed());
    }

    @When("The user clicks the Forgot Your Password? link")
    public void theUserClicksTheForgotYourPasswordLink() {
        dc.myClick(register.forgotPasswordBtn);
    }

    @Then("The user should see the Forgot Your Password? page")
    public void theUserShouldSeeTheForgotYourPasswordPage() {
        Assert.assertTrue(register.forgotPasswordPageHeader.isDisplayed());
    }

    @When("The user logs out by clicking Sign Out in the Customer dropdown menu.")
    public void theUserLogsOutByClickingSignOutInTheCustomerDropdownMenu() {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(register.customerMenu));
        dc.myClick(register.customerMenu);
        dc.myClick(register.signOutBtn);
        Assert.assertTrue(register.signedOutHeader.isDisplayed());
    }
}