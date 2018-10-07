package HomeWork.HW8;

import HomeWork.HW7.TestLesson7;
import data.RegistrationPageDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.NavigationPage;

/**
 * Created by Stas on 06.10.2018.
 */
public class loginSectionTests extends TestLesson7{

    @Test(dataProvider = "registerNewUser", dataProviderClass = RegistrationPageDataProvider.class)
    public void loginWithIncorrectCredentials(String email, String pass, String message) {
//      параметры метода которые нам "прилетают" из registerNewUser() метода из Registration DataProvider класса
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clickOnSignButton();
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
