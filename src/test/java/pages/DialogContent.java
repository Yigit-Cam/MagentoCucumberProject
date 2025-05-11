package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

import java.util.List;

public class DialogContent extends ReusableMethods {
    public Actions action;

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
        this.action = new Actions(GWD.getDriver());
    }























    ///add new address
    @FindBy(css = "[title='Add New Address']")
    public WebElement addNewAddressButton;

    @FindBy(id = "company")
    public WebElement company;

    @FindBy(id = "telephone")
    public WebElement telephone;

    @FindBy(id = "street_1")
    public WebElement streetAddress;

    @FindBy(id = "city")
    public WebElement city;

    @FindBy(id = "region_id")
    public WebElement selectRegion;

    @FindBy(id = "zip")
    public WebElement zipCode;

    @FindBy(id = "country")
    public WebElement country;

    @FindBy(css = "#primary_billing")
    public WebElement billingAddressCheckbox;

    @FindBy(css = "#primary_shipping")
    public WebElement shippingAddressCheckbox;

    @FindBy(css = "[class='action save primary']")
    public WebElement saveButton;

    @FindBy(xpath = "//a[@class='action delete'][@role='delete-address']")
    public List<WebElement> deleteAddressButtons;

    @FindBy(xpath = "(//div[@class='box-actions']//span[text()='Edit Address'])[1]")
    public WebElement editAddressButton;

    @FindBy(css = "[data-ui-id='message-success']")
    public WebElement confirmMessage;

    @FindBy(xpath = "//button[@class='action-primary action-accept']/span")
    public WebElement deleteAlertOkButton;
}