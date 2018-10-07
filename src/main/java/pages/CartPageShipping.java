package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Stas on 29.09.2018.
 */
public class CartPageShipping {
    WebDriver driver;

    public CartPageShipping(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@class='button btn btn-default standard-checkout button-medium']")
    private WebElement proceedToCheckoutButton;
    public void clickOnProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }
    public WebElement getProceedToCheckoutButton() {
        return proceedToCheckoutButton;
    }

    @FindBy(id = "cgv")
    private WebElement iAgreeWithTermCheckbox;
    public void selectIAgreeWithTermCheckbox(){
        iAgreeWithTermCheckbox.click();
    }

}
