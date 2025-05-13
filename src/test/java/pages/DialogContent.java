package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.ConfigReader;
import utilities.GWD;
import utilities.ReusableMethods;

import java.util.List;

public class DialogContent extends ReusableMethods {
    public Actions action;

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
        this.action = new Actions(GWD.getDriver());

    }
    //Add Shoppingcart
    @FindBy(xpath = "//div[@option-label='XS']")
    public WebElement size;

    @FindBy(xpath = " //img[@alt='Montana Wind Jacket']")
    public WebElement windJacket;

    @FindBy(xpath = " //div[@option-label='Black']")
    public WebElement color;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement numberQty;

    @FindBy(xpath = "//span[text()='Add to Cart']")
    public WebElement addToCart;

    @FindBy(xpath = "//div[contains(text(), 'You added')]")
    public WebElement addMessage;

    @FindBy(xpath = "//span[text()='View and Edit Cart']")
    public WebElement viewEditCart;

    @FindBy(xpath = "//input[@data-role='cart-item-qty']")
    public WebElement cartItemQty;

    @FindBy(xpath = "//span[text()='Update Shopping Cart']")
    public WebElement updateShoppingCart;

    @FindBy(xpath = "(//span[@class='price'])[1]")
    public WebElement subtotal1;

    @FindBy(xpath = "(//span[@class='price'])[1]")
    public WebElement subtotal2;

    @FindBy(xpath = "(//a[@title='Remove item'])[1]")
    public WebElement removeItem;

    @FindBy(xpath = "(//*[text()='You have no items in your shopping cart.'])[2]")
    public WebElement cartEmptyMessage;

//Product Order
@FindBy(xpath = "(//*[text()='Proceed to Checkout'])[2]")
public WebElement proceedCheckout;

    @FindBy(xpath = "//span[text()='Next']")
    public WebElement nextButton;

    @FindBy(xpath = "//input[@id='billing-address-same-as-shipping-checkmo']")
    public WebElement clickedButton;

    @FindBy(xpath = "//span[text()='Place Order']")
    public WebElement placeOrderButton;

    @FindBy(xpath = "//span[text()='Thank you for your purchase!']")
    public WebElement purchaseMessage;


































    ///add new address
    @FindBy(css = "[title='Add New Address']")
    public WebElement addNewAddressButton;

    @FindBy(xpath = "//span[@data-ui-id='page-title-wrapper']")
    public List<WebElement> addNewAddressMessage;

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

    public void addFirstAddress() {
        ConfigReader.updateProperty("company");
        mySendKeys(company, ConfigReader.getProperty("company"));
        ConfigReader.updateProperty("phoneNumber");
        mySendKeys(telephone, ConfigReader.getProperty("phoneNumber"));
        ConfigReader.updateProperty("street");
        mySendKeys(streetAddress, ConfigReader.getProperty("street"));
        ConfigReader.updateProperty("city");
        mySendKeys(city, ConfigReader.getProperty("city"));
        myClick(selectRegion);
        selectByText(selectRegion, "California");
        ConfigReader.updateProperty("postalCode");
        mySendKeys(zipCode, ConfigReader.getProperty("postalCode"));
        myClick(country);
        selectByText(country, "United States");
    }
    public void addNewAddress() {
        addFirstAddress();
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(billingAddressCheckbox));
        myClick(billingAddressCheckbox);
        GWD.getWait().until(ExpectedConditions.elementToBeClickable(shippingAddressCheckbox));
        myClick(shippingAddressCheckbox);
    }
}