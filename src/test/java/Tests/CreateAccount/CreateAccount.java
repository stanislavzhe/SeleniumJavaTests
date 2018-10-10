package Tests.CreateAccount;

import Tests.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.AccountCreationPage;
import pages.AuthenticationPage;
import pages.MenuNavigation;

import java.util.Date;

public class CreateAccount extends BaseTest {
    //    Написать тест для automationpactice
//    Сценарий:
//    Открыть главную страницу automationpractice.com
//    Открыть форму регистрации нового клиента (Sign in )
//    В секции Create an account ввести корректный емейл
//    Нажать  Create an account
//    На форме регистрации заполнить ВСЕ ОБЯЗАТЕЛЬНЫЕ поля , КРОМЕ выпадающих списков
//    Нажать Register
//    Проверить что сообщение валидации содержит текст  , например “There are 3 errors”
    private static String emailAuthPage = "ab@abc.com";
    private static final String cutomersFirstName = "Stas";
    private static final String cutomersLastName = "Zheleznov";
    private static final String password = "12345";
    private static final String firstNameAddressSection = "First Name Address";
    private static final String lastNameAddressSection = "Last Name Address";
    private static final String companyName = "Company Name";
    private static final String address = "Country, City, Street, 99";
    private static final String city = "City";
    private static final String zipcode = "02139";
    private static final String additionalInfo = "Hello\nHow are your?";
    private static final String phone = "044 063 63 63";
    private static final String mobilePhone = "063 063 63 63";
    private static final String addressAlias = "my address alias";
    private static final String dayValue = "16";
    private static final String monthValue = "6";
    private static final String yearValue = "1988";
    private static final String stateValue = "New York"; // or value "32"//
    private static final String countryValue = "United States"; // or value "21"//

    @Test(groups = "negative")
    public void createAccountWithoutAllRequiredFields() throws InterruptedException {
        String expectedAlertTitleText = "There is 1 error";
        String expectedFirstAlertText = "This country requires you to choose a State.";

        //need to generate email for register (timestamp + email)
        Date date = new Date();
        long time = date.getTime();
        emailAuthPage = time + emailAuthPage;

        MenuNavigation menuNavigation = new MenuNavigation(driver);
        menuNavigation.clickOnSignButton();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.typeEmailOnAuthPage(emailAuthPage);
        authenticationPage.clickOnSubmitButtonAuthPage();

        AccountCreationPage accountCreationPage = new AccountCreationPage(driver);
        new WebDriverWait(driver, timeOut).
                until(ExpectedConditions.visibilityOf(accountCreationPage.getGenderMrRadioButton()));

        accountCreationPage.
                selectMrGender().
                typeCustomersFirstName(cutomersFirstName).
                typeCustomersLastName(cutomersLastName).
                typePassword(password).
                clickOnNewlettersCheckbox().
                clickOnSpecialOffersCheckbox().
                typeFirstNameAddressSection(firstNameAddressSection).
                typeLastNameAddressSection(lastNameAddressSection).
                typeCompanyName(companyName).
                typeAddress(address).
                typeCity(city).
                typeZipcode(zipcode).
                typeAdditionalInfo(additionalInfo).
                typePhone(phone).
                typeMobilePhone(mobilePhone).
                typeAddressAlias(addressAlias).
                clickOnRegisterButton();
        Thread.sleep(3000);

        WebElement alertTitle = driver.findElement(By.cssSelector(".alert-danger p"));
        String actualAlertTitleText = alertTitle.getText();
        Assert.assertEquals(expectedAlertTitleText, actualAlertTitleText);

        WebElement firstAlert = driver.findElement(By.cssSelector(".alert-danger li"));
        String actualFirstAlertText = firstAlert.getText();
        Assert.assertEquals(expectedFirstAlertText, actualFirstAlertText);
    }

    @Test(groups = "positive")
    public void createAccountTest() throws InterruptedException {
        String expectedTitleAfterLogin = "MY ACCOUNT";
        String expectedTextOnAccountButton = cutomersFirstName + " " + cutomersLastName;
        String expectedTextOnLogoutButton = "Sign out";

        //need to generate email for register (timestamp + email)
        Date date = new Date();
        long time = date.getTime();
        emailAuthPage = time + emailAuthPage;

        MenuNavigation menuNavigation = new MenuNavigation(driver);
        menuNavigation.clickOnSignButton();

        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        authenticationPage.typeEmailOnAuthPage(emailAuthPage);
        authenticationPage.clickOnSubmitButtonAuthPage();

        AccountCreationPage accountCreationPage = new AccountCreationPage(driver);
        new WebDriverWait(driver, timeOut).
                until(ExpectedConditions.visibilityOf(accountCreationPage.getGenderMrRadioButton()));

        accountCreationPage.
                selectMrGender().
                typeCustomersFirstName(cutomersFirstName).
                typeCustomersLastName(cutomersLastName).
                typePassword(password).
                clickOnNewlettersCheckbox().
                clickOnSpecialOffersCheckbox().
                typeFirstNameAddressSection(firstNameAddressSection).
                typeLastNameAddressSection(lastNameAddressSection).
                typeCompanyName(companyName).
                typeAddress(address).
                typeCity(city).
                typeZipcode(zipcode).
                typeAdditionalInfo(additionalInfo).
                typePhone(phone).
                typeMobilePhone(mobilePhone).
                typeAddressAlias(addressAlias).
                selectDay(dayValue).
                selectMonth(monthValue).
                selectYear(yearValue).
                selectState(stateValue).
                selectCountry(countryValue).
                clickOnRegisterButton();
        Thread.sleep(3000);

        String actualTitleAfterLogin = driver.findElement(By.className("page-heading")).getText();
        Assert.assertEquals(actualTitleAfterLogin, expectedTitleAfterLogin);
        String actualTextOnAccountButton = driver.findElement(By.className("account")).getText();
        Assert.assertEquals(actualTextOnAccountButton, expectedTextOnAccountButton);
        String actualTextOnLogoutButton = driver.findElement(By.className("logout")).getText();
        Assert.assertEquals(actualTextOnLogoutButton, expectedTextOnLogoutButton);
    }
}
