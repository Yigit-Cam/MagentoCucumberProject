package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

public class TabNav extends ReusableMethods {
    public Actions action;

    public TabNav() {
        PageFactory.initElements(GWD.getDriver(), this);
        this.action = new Actions(GWD.getDriver());
    }






























    ///add new address
    @FindBy(xpath = "(//ul[@class='header links']//button)[1]")
    public WebElement dropDownMenuButton;

    @FindBy(xpath = "(//ul[@class='header links']//a)[1]")
    public WebElement myAccountButton;

    @FindBy(xpath = "//*[@class='message-success success message']/div")
    public WebElement successMessage;

}