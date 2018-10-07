package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Stas on 29.09.2018.
 */
public class CartPagePayment {
    WebDriver driver;

    public CartPagePayment(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "bankwire")
    private WebElement payByBankWireButton;
    public WebElement getPayByBankWireButton() {
        return payByBankWireButton;
    }
    public String payByBankWireButtonText() {
        return payByBankWireButton.getText();
    }

    @FindAll(@FindBy(css = "tbody tr .product-name a"))
    private List<WebElement> listOfElementsWithProductNames;
    public String getNameForProductByIndex(int index) {
        return listOfElementsWithProductNames.get(index).getText();
    }

    @FindAll(@FindBy(css = ".cart_quantity.text-center span"))
    private List<WebElement> listOfQuantityForItems;
    public String getQuantityForItemVyIndex(int index) {
        return listOfQuantityForItems.get(index).getText();
    }

    @FindAll(@FindBy(css = ".cart_total .price"))
    private List<WebElement> listOfElementsWithTotalPriceForItems;
    public String getItemTotalPriceByIndex(int index) {
        return listOfElementsWithTotalPriceForItems.get(index).getText();
    }

    @FindBy(id = "total_product")
    private WebElement totalProductPrice;
    public String getTotalProductPrice() {
        return totalProductPrice.getText();
    }

    @FindBy(id = "total_shipping")
    private WebElement totalShippingPrice;
    public String getTotalShippingPrice() {
        return totalShippingPrice.getText();
    }

    @FindBy(id = "total_price")
    private WebElement totalPrice;
    public String getTotalSPrice() {
        return totalPrice.getText();
    }
}

//    may need to add for final check
//    tbody .cart_unit > .price - Unit price list
//    tbody .cart_unit .price .special-price - special price
//    tbody .cart_unit .price-percent-reduction.small - discount value
//    tbody .cart_unit .old-price - old price
