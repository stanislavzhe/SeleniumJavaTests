package Tests.CreateAccount;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateAccountNotAllRequiredFields {
//    Написать тест для automationpactice
//    Сценарий:
//    Открыть главную страницу automationpractice.com
//    Открыть форму регистрации нового клиента (Sign in )
//    В секции Create an account ввести корректный емейл
//    Нажать  Create an account
//    На форме регистрации заполнить ВСЕ ОБЯЗАТЕЛЬНЫЕ поля , КРОМЕ выпадающих списков
//    Нажать Register
//    Проверить что сообщение валидации содержит текст  , например “There are 3 errors”

    WebDriver driver;
    public static final String emailAuthPage = "asd2@asd1.com";
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

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "E:\\megogoTest\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test// negative case
    public void createAccountWithoutAllRequiredFields() throws InterruptedException {
        String expectedAlertTitleText = "There is 1 error";
        String expectedFirstAlertText = "This country requires you to choose a State.";

        clickOnSignButtonAuthPage();
        enterEmailOnAuthPage(emailAuthPage);
        clickOnSubmitButtonAuthPage();
        Thread.sleep(3000);

        selectMrGender();
        setCustomersFirstName(cutomersFirstName);
        setCustomersLastName(cutomersLastName);
        setPassword(password);
        setNewlettersCheckbox();
        setSpecialOffersCheckbox();
        setFirstNameAddressSection(firstNameAddressSection);
        setLastNameAddressSection(lastNameAddressSection);
        setCompanyName(companyName);
        setAddress(address);
        setCity(city);
        setZipcode(zipcode);
        setAdditionalInfo(additionalInfo);
        setPhone(phone);
        setMobilePhone(mobilePhone);
        setAddressAlias(addressAlias);
        clickOnRegisterButton();
        Thread.sleep(3000);

        WebElement alertTitle = driver.findElement(By.cssSelector(".alert-danger p"));
        String actualAlertTitleText = alertTitle.getText();
        Assert.assertEquals(expectedAlertTitleText, actualAlertTitleText);

        WebElement firstAlert = driver.findElement(By.cssSelector(".alert-danger li"));
        String actualFirstAlertText = firstAlert.getText();
        Assert.assertEquals(expectedFirstAlertText, actualFirstAlertText);
    }

    private void clickOnRegisterButton() {
        WebElement registerButton = driver.findElement(By.id("submitAccount"));
        registerButton.click();
    }

    private void setAddressAlias(String addressAlias) {
        WebElement addressAliasField = driver.findElement(By.id("alias"));
        addressAliasField.clear();
        addressAliasField.sendKeys(addressAlias);
    }

    private void setMobilePhone(String mobilePhone) {
        WebElement mobilePhoneField = driver.findElement(By.id("phone_mobile"));
        mobilePhoneField.sendKeys(mobilePhone);
    }

    private void setPhone(String phone) {
        WebElement phoneField = driver.findElement(By.id("phone"));
        phoneField.sendKeys(phone);
    }

    private void setAdditionalInfo(String additionalInfo) {
        WebElement additionalInfoField = driver.findElement(By.id("other"));
        additionalInfoField.sendKeys(additionalInfo);
    }

    private void setZipcode(String zipcode) {
        WebElement zipcodeField = driver.findElement(By.id("postcode"));
        zipcodeField.sendKeys(zipcode);
    }

    private void setCity(String city) {
        WebElement cityFiled = driver.findElement(By.id("city"));
        cityFiled.sendKeys(city);
    }

    private void setAddress(String address) {
        WebElement addressField = driver.findElement(By.id("address1"));
        addressField.sendKeys(address);
    }

    private void setCompanyName(String companyName) {
        WebElement companyField = driver.findElement(By.id("company"));
        companyField.sendKeys(companyName);
    }

    private void setLastNameAddressSection(String lastNameAddressSection) {
        WebElement addressSectionLastNameField = driver.findElement(By.id("lastname"));
        addressSectionLastNameField.clear();
        addressSectionLastNameField.sendKeys(lastNameAddressSection);
    }

    private void setFirstNameAddressSection(String firstNameAddressSection) {
        WebElement addressSectionFirstNameField = driver.findElement(By.id("firstname"));
        addressSectionFirstNameField.clear();
        addressSectionFirstNameField.sendKeys(firstNameAddressSection);
    }

    private void setSpecialOffersCheckbox() {
        WebElement specialOffersCheckbox = driver.findElement(By.id("optin"));
        specialOffersCheckbox.click();
    }

    private void setNewlettersCheckbox() {
        WebElement newsletterCheckBox = driver.findElement(By.id("newsletter"));
        newsletterCheckBox.click();
    }

    private void setPassword(String password) {
        WebElement passwordField = driver.findElement(By.id("passwd"));
        passwordField.sendKeys(password);
    }

    private void setCustomersLastName(String customersLastNamestName) {
        WebElement cusomersLastNameField = driver.findElement(By.id("customer_lastname"));
        cusomersLastNameField.sendKeys(customersLastNamestName);
    }

    private void setCustomersFirstName(String customersFirstName) {
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

    private void enterEmailOnAuthPage(String emailName) {
        WebElement emailFieldAuthenticationPage = driver.findElement(By.id("email_create"));
        emailFieldAuthenticationPage.sendKeys(emailName);
    }

    private void clickOnSignButtonAuthPage() {
        WebElement singInButton = driver.findElement(By.className("header_user_info"));
        singInButton.click();
    }

    @After()
    public void close() {
        driver.close();
    }
}
