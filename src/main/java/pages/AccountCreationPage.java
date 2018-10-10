package pages;

import org.omg.PortableInterceptor.ACTIVE;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage {
    private WebDriver driver;

    @FindBy(id = "id_gender1")
    private WebElement genderMrRadioButton;
    @FindBy(id = "customer_firstname")
    private WebElement customersFirstNameField;
    @FindBy(id = "customer_lastname")
    private WebElement cusomersLastNameField;
    @FindBy(id = "passwd")
    private WebElement passwordField;
    @FindBy(id = "newsletter")
    private WebElement newsletterCheckBox;
    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;
    @FindBy(id = "firstname")
    private WebElement addressSectionFirstNameField;
    @FindBy(id = "lastname")
    private WebElement addressSectionLastNameField;
    @FindBy(id = "company")
    private WebElement companyField;
    @FindBy(id = "address1")
    private WebElement addressField;
    @FindBy(id = "city")
    private WebElement cityFiled;
    @FindBy(id = "postcode")
    private WebElement zipcodeField;
    @FindBy(id = "other")
    private WebElement additionalInfoField;
    @FindBy(id = "phone")
    private WebElement phoneField;
    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneField;
    @FindBy(id = "alias")
    private WebElement addressAliasField;
    @FindBy(id = "days")
    private WebElement daySelect;
    @FindBy(id = "months")
    private WebElement monthSelect;
    @FindBy(id = "years")
    private WebElement yearSelect;
    @FindBy(id = "id_state")
    private WebElement stateSelect;
    @FindBy(id = "id_country")
    private WebElement countrySelect;
    @FindBy(id = "submitAccount")
    private WebElement registerButton;

    public AccountCreationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getGenderMrRadioButton() {
        return genderMrRadioButton;
    }

    public AccountCreationPage selectMrGender() {
        genderMrRadioButton.click();
        return this;
    }

    public AccountCreationPage typeCustomersFirstName(String customersFirstName) {
        customersFirstNameField.sendKeys(customersFirstName);
        return this;
    }

    public AccountCreationPage typeCustomersLastName(String customersLastNamestName) {
        cusomersLastNameField.sendKeys(customersLastNamestName);
        return this;
    }

    public AccountCreationPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public AccountCreationPage clickOnNewlettersCheckbox() {
        newsletterCheckBox.click();
        return this;
    }

    public AccountCreationPage clickOnSpecialOffersCheckbox() {
        specialOffersCheckbox.click();
        return this;
    }

    public AccountCreationPage typeFirstNameAddressSection(String firstNameAddressSection) {
        addressSectionFirstNameField.clear();
        addressSectionFirstNameField.sendKeys(firstNameAddressSection);
        return this;
    }

    public AccountCreationPage typeLastNameAddressSection(String lastNameAddressSection) {
        addressSectionLastNameField.clear();
        addressSectionLastNameField.sendKeys(lastNameAddressSection);
        return this;
    }

    public AccountCreationPage typeCompanyName(String companyName) {
        companyField.sendKeys(companyName);
        return this;
    }

    public AccountCreationPage typeAddress(String address) {
        addressField.sendKeys(address);
        return this;
    }

    public AccountCreationPage typeCity(String city) {
        cityFiled.sendKeys(city);
        return this;
    }

    public AccountCreationPage typeZipcode(String zipcode) {
        zipcodeField.sendKeys(zipcode);
        return this;
    }

    public AccountCreationPage typeAdditionalInfo(String additionalInfo) {
        additionalInfoField.sendKeys(additionalInfo);
        return this;
    }

    public AccountCreationPage typePhone(String phone) {
        phoneField.sendKeys(phone);
        return this;
    }

    public AccountCreationPage typeMobilePhone(String mobilePhone) {
        mobilePhoneField.sendKeys(mobilePhone);
        return this;
    }

    public AccountCreationPage typeAddressAlias(String addressAlias) {
        addressAliasField.clear();
        addressAliasField.sendKeys(addressAlias);
        return this;
    }

    public AccountCreationPage selectDay(String elementValue) {
        Select dayFormValue = new Select(daySelect);
        dayFormValue.selectByValue(elementValue);
        return this;
    }

    public AccountCreationPage selectMonth(String elementValue) {
        Select montFormValue = new Select(monthSelect);
        montFormValue.selectByValue(elementValue);
        return this;
    }

    public AccountCreationPage selectYear(String elementValue) {
        Select yearFormValue = new Select(yearSelect);
        yearFormValue.selectByValue(elementValue);
        return this;
    }

    public AccountCreationPage selectState(String elementValue) {
        Select stateFormValue = new Select(stateSelect);
        stateFormValue.selectByVisibleText(elementValue);
        return this;
    }

    public AccountCreationPage selectCountry(String elementValue) {
        Select countryFormValue = new Select(countrySelect);
        countryFormValue.selectByVisibleText(elementValue);
        return this;
    }

    public void clickOnRegisterButton() {
        registerButton.click();
    }
}
