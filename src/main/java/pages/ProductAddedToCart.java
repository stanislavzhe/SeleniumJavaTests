package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductAddedToCart {
    WebDriver driver;

    public ProductAddedToCart(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "cross")
    private WebElement closeWindowButton;

    public WebElement getCloseWindowButton() {
        return closeWindowButton;
    }

    public void clickOnCloseWindowButton() {
        closeWindowButton.click();
    }

    @FindBy(xpath = "//*[@class='btn btn-default button button-medium']")
    private WebElement proceedToCheckoutButton;

    public WebElement getProceedToCheckoutButton() {
        return proceedToCheckoutButton;
    }

    public void clickOnProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }
}
