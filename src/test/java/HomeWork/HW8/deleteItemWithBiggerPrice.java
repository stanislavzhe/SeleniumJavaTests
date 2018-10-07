package HomeWork.HW8;

import HomeWork.HW7.TestLesson7;
import org.testng.annotations.Test;
import pages.CartPageSummary;
import pages.CategoryPage;
import pages.ProductAddedToCart;
import pages.TopMenuNavigation;

public class deleteItemWithBiggerPrice extends TestLesson7 {

    @Test
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