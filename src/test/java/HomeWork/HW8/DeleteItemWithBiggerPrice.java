package HomeWork.HW8;

import HomeWork.HW7.TestLesson7;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.CartPageSummary;
import pages.CategoryPage;
import pages.ProductAddedToCart;
import pages.TopMenuNavigation;

public class DeleteItemWithBiggerPrice extends TestLesson7 {
    public WebDriver driver;

    @Test(groups = {"smoke","regression"})
    public void checkDeleteItem() {
        double startPointPrice = 25;
        double endPointPrice = 45;
        TopMenuNavigation topMenuNavigation = new TopMenuNavigation(this.driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        CartPageSummary cartPageSummary = new CartPageSummary(driver);

        topMenuNavigation.clickOnWomenSFMenuSectionButton();
        categoryPage.clickOnListViewButton().
                drugFirstSliderToPrice(startPointPrice).
                drugEndSliderToPrice(endPointPrice);

        categoryPage.addToCartElementWithDressText(timeOut);
        closeAddToCartPage();
        categoryPage.addToCartElementWithDisoount();
        openCart();
        cartPageSummary.deleteItemByIndex(cartPageSummary.getIndexOfBiggestElement());
    }

    private void openCart() {
        ProductAddedToCart productAddedToCart = new ProductAddedToCart(driver);
        elementClickable(productAddedToCart.getProceedToCheckoutButton());
        productAddedToCart.clickOnProceedToCheckoutButton();
    }

    private void closeAddToCartPage() {
        ProductAddedToCart productAddedToCart = new ProductAddedToCart(driver);
        elementClickable(productAddedToCart.getCloseWindowButton());
        productAddedToCart.clickOnCloseWindowButton();
    }
}