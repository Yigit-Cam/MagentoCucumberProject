package stepDefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.RegisterAndLogin;
import utilities.ConfigReader;
import utilities.GWD;

public class UserLoginPositiveSteps {
    RegisterAndLogin ral = new RegisterAndLogin();

    @When("User enters valid email and password")
    public void userEntersValidEmailAndPassword() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(ral.emailInput));
        ral.mySendKeys(ral.emailInput, ConfigReader.getProperty("email"));
        GWD.getWait().until(ExpectedConditions.visibilityOf(ral.passwordInput));
        ral.mySendKeys(ral.passwordInput, ConfigReader.getProperty("password"));
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(ral.signInFormBtn));
        ral.myClick(ral.signInFormBtn);
        GWD.getWait().until(ExpectedConditions.visibilityOf(ral.welcomeText));
        Assert.assertTrue(ral.welcomeText.isDisplayed(), "Welcome text is not displayed");
    }
}