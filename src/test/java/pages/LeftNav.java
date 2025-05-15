package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class LeftNav extends ReusableMethods {
    public Actions action;

    public LeftNav() {
        PageFactory.initElements(GWD.getDriver(), this);
        this.action = new Actions(GWD.getDriver());
    }

    /// add new address
    @FindBy(linkText = "My Account")
    public WebElement myAccountButtonLeftNav;

    @FindBy(linkText = "Address Book")
    public WebElement addressBookButton;
}