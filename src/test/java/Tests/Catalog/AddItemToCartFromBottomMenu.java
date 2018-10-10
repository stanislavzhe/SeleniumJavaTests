package Tests.Catalog;

import Tests.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MenuNavigation;

public class AddItemToCartFromBottomMenu extends BaseTest{


    @Test
    public void moveToElementCheck(){
        HomePage homePage = new HomePage(driver);
        homePage.moveToFirstItem();
        homePage.clickOnAddToCartButton();
    }

    @Test
    public void verifyThatProductPriceDiplayInDemoSection() throws InterruptedException {
        String expectedPrice = "$27.00";
        MenuNavigation menuNavigation = new MenuNavigation(driver);
        menuNavigation.inputIntoSearchField("Blouse");
        menuNavigation.clickToSubmitSearch();
        switchToListView();
        openProductView();
        String actualPrice = getProductPriceElement().getText();
        Assert.assertEquals(expectedPrice, actualPrice);
    }


    private void switchToListView() {
        WebElement listView = driver.findElement(By.className("icon-th-list"));
        listView.click();
    }

    private void openProductView() {
        WebElement moreButton = driver.findElement(By.xpath("//*[@title='View']"));
        moreButton.click();
    }

    private WebElement getProductPriceElement() {
        return driver.findElement(By.id("our_price_display"));
    }
}
