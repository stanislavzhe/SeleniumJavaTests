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
public class CartPageSummary {
    WebDriver driver;

    @FindBy(id = "cart_title")
    private WebElement cartTitle;
    @FindAll(@FindBy(css = "#cart_summary .cart_item"))
    private List<WebElement> itemsInCartList;
    @FindAll(@FindBy(css = "#cart_summary .cart_item .product-name"))
    private List<WebElement> listOfElementsWithProductNames;
    @FindAll(@FindBy(css = "#cart_summary .cart_total .price"))
    private List<WebElement> listOfElementsWithTotalPriceForItems;
    @FindBy(id = "total_product")
    private WebElement totalProductPrice;
    @FindBy(id = "total_shipping")
    private WebElement totalShippingPrice;
    @FindBy(id = "total_price")
    private WebElement totalPrice;
    @FindBy(xpath = "//*[@class='price-percent-reduction small']")
    private WebElement discountElement;
    @FindBy(xpath = "//*[@class='old-price']")
    private WebElement oldPriceElement;
    @FindBy(css = ".price.special-price")
    private WebElement priceWithDiscountElement;
    @FindBy(xpath = "//*[@class='button btn btn-default standard-checkout button-medium']")
    private WebElement proceedToCheckoutButton;
    @FindAll(@FindBy(css = ".cart_quantity.text-center input:first-child"))
    private List<WebElement> listOfQuantityForItems;
    @FindAll(@FindBy(className = "icon-trash"))
    private List<WebElement> listOfDeleteButtons;

    public CartPageSummary(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getCartTitle() {
        return cartTitle;
    }

    public int getCartItemsSize() {
        return itemsInCartList.size();
    }

    public String getItemTotalPriceByIndex(int index) {
        return listOfElementsWithTotalPriceForItems.get(index).getText();
    }

    public String getNameForProductByIndex(int index) {
        return listOfElementsWithProductNames.get(index).getText();
    }

    public double getSumOfTotalPricesForAllItemsInCart() {
        double sum = 0;
        for (int i = 0; i < listOfElementsWithTotalPriceForItems.size(); i++) {
            sum += getPriceParseToDouble(getPriceWithoutCurrency(getItemTotalPriceByIndex(i)));
        }
        return sum;
    }

    public String getTotalProductPrice() {
        return totalProductPrice.getText();
    }

    public String getTotalShippingPrice() {
        return totalShippingPrice.getText();
    }

    public String getTotalSPrice() {
        return totalPrice.getText();
    }

    public String discountText() {
        return discountElement.getText();
    }

    public double discountDouble() {
        double discount = 0;
        String discountString = discountText().trim();
        discountString = discountString.substring(1, (discountString.length() - 1));
        discount = Double.parseDouble(discountString);
        return discount;
    }

    public String getOldPriceText() {
        return oldPriceElement.getText();
    }

    public String getPriceWithDiscount() {
        return priceWithDiscountElement.getText();
    }

    //TODO: take out to test class
    public String getPriceWithoutCurrency(String priceWithCurrency) {
        return priceWithCurrency.substring(1);
    }

    //TODO: take out to test class
    public double getPriceParseToDouble(String priceWithoutCurrency) {
        return Double.parseDouble(priceWithoutCurrency);
    }

    //TODO: take out to test class
    public double countPriceAfterDiscount(double oldPrice, double discount) {
        return oldPrice - (oldPrice * discount / 100);
    }

    public void clickOnProceedToCheckoutButton() {
        proceedToCheckoutButton.click();
    }

    public String getQuantityForItemByIndex(int index) {
        return listOfQuantityForItems.get(index).getAttribute("value");
    }


    public int getIndexOfBiggestElement() {
        int indexOfBiggestElement = 0;
        double biggestElementValue = 0;
        for (int i = 0; i < listOfElementsWithTotalPriceForItems.size(); i++) {
            double element = getPriceParseToDouble(getPriceWithoutCurrency(getItemTotalPriceByIndex(i)));
            if (element > biggestElementValue) {
                biggestElementValue = element;
                indexOfBiggestElement = i;
            }
        }
        return indexOfBiggestElement;
    }

    public void deleteItemByIndex(int index) {
        listOfDeleteButtons.get(index).click();
    }
}

//    may need to add for final check
//    tbody .cart_unit > .price - Unit price list - css - .cart_item .cart_unit > .price ---
//    tbody .cart_unit .price .special-price - special price - priceWithDiscountElement +++
//    tbody .cart_unit .price-percent-reduction.small - discount value - discountElement +++
//    tbody .cart_unit .old-price - old price - oldPriceElement +++

