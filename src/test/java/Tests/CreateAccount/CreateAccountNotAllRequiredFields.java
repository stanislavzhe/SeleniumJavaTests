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

public class CreateAccountNotAllRequiredFields extends BaseTest{
//    Написать тест для automationpactice
//    Сценарий:
//    Открыть главную страницу automationpractice.com
//    Открыть форму регистрации нового клиента (Sign in )
//    В секции Create an account ввести корректный емейл
//    Нажать  Create an account
//    На форме регистрации заполнить ВСЕ ОБЯЗАТЕЛЬНЫЕ поля , КРОМЕ выпадающих списков
//    Нажать Register
//    Проверить что сообщение валидации содержит текст  , например “There are 3 errors”

    private static final String emailAuthPage = "asd2@asd1.com";
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

    @Test(groups = "negative")
    public void createAccountWithoutAllRequiredFields() throws InterruptedException {
        String expectedAlertTitleText = "There is 1 error";
        String expectedFirstAlertText = "This country requires you to choose a State.";

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
}
