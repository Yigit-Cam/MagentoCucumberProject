package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;
import utilities.*;

public class RegisterAndLogin extends ReusableMethods {
    public Actions action;

    public RegisterAndLogin() {
        PageFactory.initElements(GWD.getDriver(), this);
        this.action = new Actions(GWD.getDriver());
    }

    @FindBy(xpath = "//a[text()='Create an Account']")
    public WebElement createAccountBtn;

    @FindBy(xpath = "//span[text()='Create New Customer Account']")
    public WebElement formHeader;

    @FindBy(xpath = "//*[@id='firstname']")
    public WebElement firstNameField;

    @FindBy(id = "lastname")
    public WebElement lastNameField;

    @FindBy(id = "email_address")
    public WebElement emailField;

    @FindBy(xpath = "//input[@name='password' and @id='password']")
    public WebElement passwordField;

    @FindBy(id = "password-confirmation")
    public WebElement confirmPasswordField;

    @FindBy(xpath = "//button[@type='submit' and @title='Create an Account']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
    public WebElement successMessage;

    @FindBy(xpath = "//span[text()='My Account']")
    public WebElement myAccountHeader;

    @FindBy(id = "email")
    public WebElement emailInput;

    @FindBy(xpath = "//input[@id='pass' and @title='Password']")
    public WebElement passwordInput;

    @FindBy(id = "send2")
    public WebElement signInFormBtn;

    @FindBy(xpath = "//a[@class='action remind']/span")
    public WebElement forgotPasswordBtn;

    @FindBy(xpath = "(//span[@class='logged-in'])[1]")
    public WebElement welcomeText;

    @FindBy(id = "email-error")
    public WebElement emailErrorMsg;

    @FindBy(xpath = "(//li[@class='authorization-link' ]/a)[1]")
    public WebElement signInBtn;

    @FindBy(xpath = "//h1[@class='page-title']/span")
    public WebElement customerLoginHeader;

    @FindBy(id = "pass-error")
    public WebElement nullPasswordErrorMsg;

    @FindBy(xpath = "//div[@role='alert']/div/div")
    public WebElement invalidPassErrorMsg;

    @FindBy(xpath = "//h1[@class='page-title']/span")
    public WebElement forgotPasswordPageHeader;

    @FindBy(xpath = "(//span[@role='button']/button[@type='button'])[1]")
    public WebElement customerMenu;

    @FindBy(xpath = "(//li[@class='authorization-link'])/a[1]")
    public WebElement signOutBtn;

    @FindBy(xpath = "//h1[@class='page-title']/span")
    public WebElement signedOutHeader;
}