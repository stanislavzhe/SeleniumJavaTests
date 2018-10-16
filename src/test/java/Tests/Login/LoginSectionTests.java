package Tests.Login;

import Tests.BaseTest;
import data.RegistrationPageDataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MenuNavigation;

/**
 * Created by Stas on 06.10.2018.
 */
public class LoginSectionTests extends BaseTest {

    @Test(groups = {"smoke","negative"}, dataProvider = "registerNewUser", dataProviderClass = RegistrationPageDataProvider.class)
    public void loginWithIncorrectCredentials(String email, String pass, String message) {
//      параметры метода которые нам "прилетают" из registerNewUser() метода из Registration DataProvider класса
        MenuNavigation menuNavigation = new MenuNavigation(driver);
        menuNavigation.clickOnSignButton();
        LoginPage loginPage = loginWithInvalidEmailPass(email, pass);
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(message,actualErrorMessage);
    }



    private LoginPage loginWithInvalidEmailPass(String email, String pass) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.typeEmail(email);
        loginPage.typePassword(pass);
        loginPage.clickOnSubmitButton();
        return loginPage;
    }
}
