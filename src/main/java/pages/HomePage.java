package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    @FindBy(xpath = "//*[@id = 'homefeatured']/li[1]")
    private WebElement firstItem;
    @FindBy(xpath = "//*[@class = 'button ajax_add_to_cart_button btn btn-default']/span[1]")
    private WebElement addToCartForFirstElement;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void moveToFirstItem(){
        Actions action = new Actions(driver);
        action.moveToElement(firstItem).build().perform();
    }

    public void clickOnAddToCartButton(){
        addToCartForFirstElement.click();
    }

}
