package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.*;
import utilities.*;

import java.util.List;

public class UserLoginNegativeAndExcelRecordSteps {
    DialogContent dc = new DialogContent();
    RegisterAndLogin ral = new RegisterAndLogin();
    ExcelUtility excel = new ExcelUtility();

    @When("The user clicks the Sign In button")
    public void theUserClicksTheSignInButton() {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(ral.signInBtn));
        dc.myClick(ral.signInBtn);
    }

    @Then("The user should see Customer Login page")
    public void theUserShouldSeeCustomerLoginPage() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(ral.customerLoginHeader));
        Assert.assertTrue(ral.customerLoginHeader.getText().contains("Customer Login"));
    }

    @When("The user logs in with credentials from row {int}")
    public void theUserLogsInWithCredentialsFromRow(int rowIndex) {
        List<List<String>> data = excel.getData("src/test/resources/testData/credentials.xlsx", "Sayfa1");
        String email = data.get(rowIndex).get(0);
        String password = data.get(rowIndex).get(1);
        GWD.getWait().until(ExpectedConditions.visibilityOf(ral.emailInput));
        dc.mySendKeys(ral.emailInput, email);
        dc.mySendKeys(ral.passwordInput, password);
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(ral.signInFormBtn));
        dc.myClick(ral.signInFormBtn);
    }

    @Then("The user should be redirected to the Home Page and see {string} text in the upper right")
    public void theUserShouldBeRedirectedToTheHomePageAndSeeTextInTheUpperRight(String welcome) {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(ral.welcomeText));
        Assert.assertTrue(ral.welcomeText.getText().contains(welcome));
    }

    @Then("The user should see for null email error message")
    public void theUserShouldSeeForNullEmailErrorMessage() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(ral.emailErrorMsg));
        Assert.assertTrue(ral.emailErrorMsg.getText().contains("This is a required field."));
    }

    @Then("The user should see for null password error message")
    public void theUserShouldSeeForNullPasswordErrorMessage() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(ral.nullPasswordErrorMsg));
        Assert.assertTrue(ral.nullPasswordErrorMsg.getText().contains("This is a required field."));
    }

    @Then("The user should see invalid email error message")
    public void theUserShouldSeeInvalidEmailErrorMessage() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(ral.emailErrorMsg));
        Assert.assertTrue(ral.emailErrorMsg.getText().contains("Please enter a valid email address"));
    }

    @Then("The user should see wrong password error message")
    public void theUserShouldSeeWrongPasswordErrorMessage() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(ral.invalidPassErrorMsg));
        Assert.assertTrue(ral.invalidPassErrorMsg.isDisplayed());
    }

    @When("The user clicks the Forgot Your Password? link")
    public void theUserClicksTheForgotYourPasswordLink() {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(ral.forgotPasswordBtn));
        dc.myClick(ral.forgotPasswordBtn);
    }

    @Then("The user should see the Forgot Your Password? page")
    public void theUserShouldSeeTheForgotYourPasswordPage() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(ral.forgotPasswordPageHeader));
        Assert.assertTrue(ral.forgotPasswordPageHeader.isDisplayed());
    }

    @When("The user logs out by clicking Sign Out in the Customer dropdown menu.")
    public void theUserLogsOutByClickingSignOutInTheCustomerDropdownMenu() {
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(ral.customerMenu));
        dc.myClick(ral.customerMenu);
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(ral.signOutBtn));
        dc.myClick(ral.signOutBtn);
    }
}