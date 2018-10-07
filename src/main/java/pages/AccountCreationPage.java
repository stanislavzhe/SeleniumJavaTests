package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AccountCreationPage {
    private WebDriver driver;

    public AccountCreationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "id_gender1")
    private WebElement genderMrRadioButton;
    public WebElement getGenderMrRadioButton() {
        return genderMrRadioButton;
    }
    public void selectMrGender() {
        genderMrRadioButton.click();
    }

    @FindBy(id = "customer_firstname")
    private WebElement customersFirstNameField;
    public void typeCustomersFirstName(String customersFirstName) {
        customersFirstNameField.sendKeys(customersFirstName);
    }

    @FindBy(id = "customer_lastname")
    private WebElement cusomersLastNameField;
    public void typeCustomersLastName(String customersLastNamestName) {
        cusomersLastNameField.sendKeys(customersLastNamestName);
    }

    @FindBy(id = "passwd")
    private WebElement passwordField;
    public void typePassword(String password) {
        passwordField.sendKeys(password);
    }

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckBox;
    public void typeNewlettersCheckbox() {
        newsletterCheckBox.click();
    }

    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;
    public void typeSpecialOffersCheckbox() {
        specialOffersCheckbox.click();
    }

    @FindBy(id = "firstname")
    private WebElement addressSectionFirstNameField;
    public void typeFirstNameAddressSection(String firstNameAddressSection) {
        addressSectionFirstNameField.clear();
        addressSectionFirstNameField.sendKeys(firstNameAddressSection);
    }

    @FindBy(id = "lastname")
    private WebElement addressSectionLastNameField;
    public void typeLastNameAddressSection(String lastNameAddressSection) {
        addressSectionLastNameField.clear();
        addressSectionLastNameField.sendKeys(lastNameAddressSection);
    }

    @FindBy(id = "company")
    private WebElement companyField;
    public void typeCompanyName(String companyName) {
        companyField.sendKeys(companyName);
    }

    @FindBy(id = "address1")
    private WebElement addressField;
    public void typeAddress(String address) {
        addressField.sendKeys(address);
    }

    @FindBy(id = "city")
    private WebElement cityFiled;
    public void typeCity(String city) {
        cityFiled.sendKeys(city);
    }

    @FindBy(id = "postcode")
    private WebElement zipcodeField;
    public void typeZipcode(String zipcode) {
        zipcodeField.sendKeys(zipcode);
    }

    @FindBy(id = "other")
    private WebElement additionalInfoField;
    public void typeAdditionalInfo(String additionalInfo) {
        additionalInfoField.sendKeys(additionalInfo);
    }

    @FindBy(id = "phone")
    private WebElement phoneField;
    public void typePhone(String phone) {
        phoneField.sendKeys(phone);
    }

    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneField;
    public void typeMobilePhone(String mobilePhone) {
        mobilePhoneField.sendKeys(mobilePhone);
    }

    @FindBy(id = "alias")
    private WebElement addressAliasField;
    public void typeAddressAlias(String addressAlias) {
        addressAliasField.clear();
        addressAliasField.sendKeys(addressAlias);
    }

    @FindBy(id = "days")
    private WebElement daySelect;
    public void selectDay(String elementValue) {
        Select dayFormValue = new Select(daySelect);
        dayFormValue.selectByValue(elementValue);
    }

    @FindBy(id = "months")
    private WebElement monthSelect;
    public void selectMonth(String elementValue) {
        Select montFormValue = new Select(monthSelect);
        montFormValue.selectByValue(elementValue);
    }

    @FindBy(id = "years")
    private WebElement yearSelect;
    public void selectYear(String elementValue) {
        Select yearFormValue = new Select(yearSelect);
        yearFormValue.selectByValue(elementValue);
    }

    @FindBy(id = "id_state")
    private WebElement stateSelect;
    public void selectState(String elementValue) {
        Select stateFormValue = new Select(stateSelect);
        stateFormValue.selectByVisibleText(elementValue);
    }

    @FindBy(id = "id_country")
    private WebElement countrySelect;
    public void selectCountry(String elementValue) {
        Select countryFormValue = new Select(countrySelect);
        countryFormValue.selectByVisibleText(elementValue);
    }

    @FindBy(id = "submitAccount")
    private WebElement registerButton;
    public void clickOnRegisterButton() {
        registerButton.click();
    }
}
