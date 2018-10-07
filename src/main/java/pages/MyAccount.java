package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Stas on 29.09.2018.
 */
public class MyAccount {
    WebDriver driver;

    public MyAccount(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(className = "page-heading")
    private WebElement pageHeading;
    public String getPageHeadingText(){
        return pageHeading.getText();
    }

    @FindBy(className = "account")
    private WebElement accountButton;
    public String getAccountButtonText(){
        return accountButton.getText();
    }

    @FindBy(className = "logout")
    private WebElement logoutButton;
    public String getLogoutButtonText(){
        return logoutButton.getText();
    }
}
