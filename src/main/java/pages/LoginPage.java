package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    private WebDriver driver;

    @FindBy(id = "email")
    private WebElement emailField;
    @FindBy(id = "passwd")
    private WebElement passwordField;
    @FindBy(id = "SubmitLogin")
    private WebElement submitButton;
    @FindBy(css = ".page-heading + .alert.alert-danger li")
    private List<WebElement> listOfErrorMessages;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LoginPage typeEmail(String email) {
        emailField.sendKeys(email);
        return this;
    }

    public LoginPage typePassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    public String getErrorMessage() {
        return listOfErrorMessages.get(0).getText();
    }
}
