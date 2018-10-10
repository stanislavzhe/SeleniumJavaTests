package Tests.CartTest;

import Tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.CartPageSummary;
import pages.CategoryPage;
import pages.MenuNavigation;
import pages.ProductAddedToCart;

public class DeleteItemWithBiggerPrice extends BaseTest {

    @Test(groups = {"smoke","regression","positive"})
    public void checkDeleteItem() {
        double startPointPrice = 25;
        double endPointPrice = 45;
        MenuNavigation menuNavigation = new MenuNavigation(this.driver);
        CategoryPage categoryPage = new CategoryPage(driver);
        CartPageSummary cartPageSummary = new CartPageSummary(driver);

        menuNavigation.clickOnWomenSFMenuSectionButton();
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