package Tests.CreateAccount;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;

public class CreateAccount {
//    Доработать тест для automationpactice
//    Сценарий:
//    Открыть главную страницу automationpractice.com
//    Открыть форму регистрации нового клиента (Sign in )
//    В секции Create an account ввести корректный емейл
//    Нажать  Create an account
//    На форме регистрации заполнить ВСЕ поля корректно
//    Нажать Register
//    Проверить что пользователь зарегистрировался успешно
    WebDriver driver;
    public static String emailAuthPage = "ab@abc.com";
    public static final String cutomersFirstName = "Stas";
    public static final String cutomersLastName = "Zheleznov";
    public static final String password = "12345";
    public static final String firstNameAddressSection = "First Name Address";
    public static final String lastNameAddressSection = "Last Name Address";
    public static final String companyName = "Company Name";
    public static final String address = "Country, City, Street, 99";
    public static final String city = "City";
    public static final String zipcode = "02139";
    public static final String additionalInfo = "Hello\nHow are your?";
    public static final String phone = "044 063 63 63";
    public static final String mobilePhone = "063 063 63 63";
    public static final String addressAlias = "my address alias";
    public static final String dayValue = "16";
    public static final String monthValue = "6";
    public static final String yearValue = "1988";
    public static final String stateValue = "32";
    public static final String countryValue = "21";

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "E:\\megogoTest\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void createAccountTest() throws InterruptedException {
        String expectedTitleAfterLogin = "MY ACCOUNT";
        String expectedTextOnAccountButton = cutomersFirstName + " " + cutomersLastName;
        String expectedTextOnLogoutButton = "Sign out";

        //need to generate email for register (timestamp + email)
        Date date = new Date();
        long time = date.getTime();
        emailAuthPage = time + emailAuthPage;

        fillAndSubmitCreateAccountForm();

        String actualTitleAfterLogin = driver.findElement(By.className("page-heading")).getText();
        Assert.assertEquals(actualTitleAfterLogin,expectedTitleAfterLogin);
        String actualTextOnAccountButton = driver.findElement(By.className("account")).getText();
        Assert.assertEquals(actualTextOnAccountButton,expectedTextOnAccountButton);
        String actualTextOnLogoutButton = driver.findElement(By.className("logout")).getText();
        Assert.assertEquals(actualTextOnLogoutButton,expectedTextOnLogoutButton);
    }

    private void fillAndSubmitCreateAccountForm() {
        clickOnSignButtonAuthPage();
        typeEmailOnAuthPage(emailAuthPage);
        clickOnSubmitButtonAuthPage();
        waitForElementLocatedByID(10,"id_gender1");
        selectMrGender();
        typeCustomersFirstName(cutomersFirstName);
        typeCustomersLastName(cutomersLastName);
        typePassword(password);
        typeNewlettersCheckbox();
        typeSpecialOffersCheckbox();
        typeFirstNameAddressSection(firstNameAddressSection);
        typeLastNameAddressSection(lastNameAddressSection);
        typeCompanyName(companyName);
        typeAddress(address);
        typeCity(city);
        typeZipcode(zipcode);
        typeAdditionalInfo(additionalInfo);
        typePhone(phone);
        typeMobilePhone(mobilePhone);
        typeAddressAlias(addressAlias);
        selectDay(dayValue);
        selectMonth(monthValue);
        selectYear(yearValue);
        selectState(stateValue);
        selectCountry(countryValue);
        clickOnRegisterButton();
    }

    private void clickOnRegisterButton() {
        WebElement registerButton = driver.findElement(By.id("submitAccount"));
        registerButton.click();
    }

    private void typeAddressAlias(String addressAlias) {
        WebElement addressAliasField = driver.findElement(By.id("alias"));
        addressAliasField.clear();
        addressAliasField.sendKeys(addressAlias);
    }

    private void typeMobilePhone(String mobilePhone) {
        WebElement mobilePhoneField = driver.findElement(By.id("phone_mobile"));
        mobilePhoneField.sendKeys(mobilePhone);
    }

    private void typePhone(String phone) {
        WebElement phoneField = driver.findElement(By.id("phone"));
        phoneField.sendKeys(phone);
    }

    private void typeAdditionalInfo(String additionalInfo) {
        WebElement additionalInfoField = driver.findElement(By.id("other"));
        additionalInfoField.sendKeys(additionalInfo);
    }

    private void typeZipcode(String zipcode) {
        WebElement zipcodeField = driver.findElement(By.id("postcode"));
        zipcodeField.sendKeys(zipcode);
    }

    private void typeCity(String city) {
        WebElement cityFiled = driver.findElement(By.id("city"));
        cityFiled.sendKeys(city);
    }

    private void typeAddress(String address) {
        WebElement addressField = driver.findElement(By.id("address1"));
        addressField.sendKeys(address);
    }

    private void typeCompanyName(String companyName) {
        WebElement companyField = driver.findElement(By.id("company"));
        companyField.sendKeys(companyName);
    }

    private void typeLastNameAddressSection(String lastNameAddressSection) {
        WebElement addressSectionLastNameField = driver.findElement(By.id("lastname"));
        addressSectionLastNameField.clear();
        addressSectionLastNameField.sendKeys(lastNameAddressSection);
    }

    private void typeFirstNameAddressSection(String firstNameAddressSection) {
        WebElement addressSectionFirstNameField = driver.findElement(By.id("firstname"));
        addressSectionFirstNameField.clear();
        addressSectionFirstNameField.sendKeys(firstNameAddressSection);
    }

    private void typeSpecialOffersCheckbox() {
        WebElement specialOffersCheckbox = driver.findElement(By.id("optin"));
        specialOffersCheckbox.click();
    }

    private void typeNewlettersCheckbox() {
        WebElement newsletterCheckBox = driver.findElement(By.id("newsletter"));
        newsletterCheckBox.click();
    }

    private void typePassword(String password) {
        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys(password);
    }

    private void typeCustomersLastName(String customersLastNamestName) {
        WebElement cusomersLastNameField = driver.findElement(By.id("customer_lastname"));
        cusomersLastNameField.sendKeys(customersLastNamestName);
    }

    private void typeCustomersFirstName(String customersFirstName) {
        WebElement customersFirstNameField = driver.findElement(By.id("customer_firstname"));
        customersFirstNameField.sendKeys(customersFirstName);
    }

    private void selectMrGender() {
        WebElement genderMrRadioButton = driver.findElement(By.id("id_gender1"));
        genderMrRadioButton.click();
    }

    private void clickOnSubmitButtonAuthPage() {
        WebElement submitButtonAuthenticationPage = driver.findElement(By.id("SubmitCreate"));
        submitButtonAuthenticationPage.click();
    }

    private void typeEmailOnAuthPage(String emailName) {
        WebElement emailFieldAuthenticationPage = driver.findElement(By.id("email_create"));
        emailFieldAuthenticationPage.sendKeys(emailName);
    }

    private void clickOnSignButtonAuthPage() {
        WebElement singInButton = driver.findElement(By.className("header_user_info"));
        singInButton.click();
    }

    private void selectDay(String elementValue) {
        WebElement daySelect = driver.findElement(By.id("days"));
        Select dayFormValue = new Select(daySelect);
        dayFormValue.selectByValue(elementValue);
    }

    private void selectMonth(String elementValue) {
        WebElement monthSelect = driver.findElement(By.id("months"));
        Select montFormValue = new Select(monthSelect);
        montFormValue.selectByValue(elementValue);
    }

    private void selectYear(String elementValue) {
        WebElement yearSelect = driver.findElement(By.id("years"));
        Select yearFormValue = new Select(yearSelect);
        yearFormValue.selectByValue(elementValue);
    }

    private void selectState(String elementValue) {
        WebElement stateSelect = driver.findElement(By.id("id_state"));
        Select stateFormValue = new Select(stateSelect);
        stateFormValue.selectByValue(elementValue);
    }

    private void selectCountry(String elementValue) {
        WebElement countrySelect = driver.findElement(By.id("id_country"));
        Select countryFormValue = new Select(countrySelect);
        countryFormValue.selectByValue(elementValue);
    }

    private void waitForElementLocatedByID(int timeout, String id){
        new WebDriverWait(driver, timeout).
                until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    @After()
    public void close() {
        driver.close();
    }
}
