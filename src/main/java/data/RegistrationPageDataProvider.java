package data;

import org.testng.annotations.DataProvider;

public class RegistrationPageDataProvider {

    @DataProvider
    public static Object[][] registerNewUser() {
        return new Object[][]{
                {"", "", "An email address required."},
                {"email@gmail.com", "", "Password is required."},
                {"1", "", "Invalid email address."},
                {"email@gmail.com", "1", "Invalid password."},
                {"", "12345", "An email address required."}};
    }
}