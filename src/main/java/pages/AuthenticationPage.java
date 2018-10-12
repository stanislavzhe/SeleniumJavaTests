package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Log;

public class AuthenticationPage {
    private WebDriver driver;

    public AuthenticationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "email_create")
    private WebElement emailFieldAuthenticationPage;
    public void typeEmailOnAuthPage(String emailName) {
        Log.LOG.info("Typing email: " + emailName);
        emailFieldAuthenticationPage.sendKeys(emailName);
    }

    @FindBy(id = "SubmitCreate")
    private WebElement submitButtonAuthenticationPage;

    public void clickOnSubmitButtonAuthPage() {
        Log.LOG.info("Clicking on button submit, authPage");
        submitButtonAuthenticationPage.click();
    }
}
