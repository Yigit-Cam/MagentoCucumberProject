package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.*;

import java.util.List;

public class TabNav extends ReusableMethods {
    public Actions action;

    public TabNav() {
        PageFactory.initElements(GWD.getDriver(), this);
        this.action = new Actions(GWD.getDriver());
    }

    @FindBy(xpath = "//input[@id='search']")
    public WebElement searchBar;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement searchButton;

    @FindBy(xpath = "//a[contains(text(),'Lando')]")
    public WebElement productName;

    @FindBy(xpath = "//a[@class='logo']")
    public WebElement logo;

    @FindBy(xpath = "(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[4]")
    public WebElement menButton;

    @FindBy(xpath = "(//span[@class='ui-menu-icon ui-icon ui-icon-carat-1-e'])[5]")
    public WebElement topsButton;

    @FindBy(xpath = "(//span[text()='Jackets'])[2]")
    public WebElement jacketsButton;

    @FindBy(xpath = "//div[text()='MJ08']")
    public WebElement skuNumber;

    @FindBy(xpath = "//div[contains(text(),'Your search returned no results.')]")
    public WebElement noResultsMessage;

    @FindBy(xpath = "//nav[@class='navigation']/ul/li")
    public List<WebElement> tabMenuElementList;

    @FindBy(id = "page-title-heading")
    public WebElement pageTitleHeading;

    @FindBy(xpath = "//div[@class='categories-menu']//span")
    public List<WebElement> categoriesMenuList;

    @FindBy(xpath = "(//nav[@class='navigation']/ul/li/ul)[1]/li/a")
    public List<WebElement> roleMenuListWomen;

    @FindBy(xpath = "(//nav[@class='navigation']/ul/li/ul)[2]/li/a")
    public List<WebElement> roleMenuListMen;

    @FindBy(xpath = "//ol[@class='products list items product-items']/li")
    public List<WebElement> productList;




























    ///add new address
    @FindBy(xpath = "(//ul[@class='header links']//button)[1]")
    public WebElement dropDownMenuButton;

    @FindBy(xpath = "(//ul[@class='header links']//a)[1]")
    public WebElement myAccountButton;

    @FindBy(xpath = "//*[@class='message-success success message']/div")
    public WebElement successMessage;

}