package Tests.CartTest;

import Tests.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TotalValueCheck extends BaseTest{

//    Написать тест для automationpactice
//    Сценарий:
//    Открыть главную страницу automationpractice.com
//    В поле поиска ввести “Blouse” и выполнить поиск
//    Переключится на режим просмотра ‘List”
//    Добавить товар в корзину
//    В секции Summary увеличить количество товаров на 1
//    Проверить что значения Total для товара , Total products, Total shipping , Total всех товаров , Tax и TOTAL общий  отображается корректно
//    Удалить товар из корзины
//    Проверить что корзина пустая

    @Test
    public void totalSameForAllFields() throws InterruptedException {
        String itemForSearch = "Blouse";
        String expectedPriceValue = "$27.00";
        String expectedTotalPriceForItemProductValue = "$54.00";
        String expectedTotalPriceForAllCartValue = "$54.00";
        String expectedTotalShippingPriceValue = "$2.00";
        String expectedTotalPriceWithoutTaxValue = "$56.00";
        String expectedTotalTaxValue = "$0.00";
        String expectedTotalPriceValue = "$56.00";
        String expectedEmptyCartMessage = "Your shopping cart is empty.";

        addItemToCart(itemForSearch);
        goToCart();

        WebElement plusButton = driver.findElement(By.id("cart_quantity_up_2_7_0_0"));
        plusButton.click();

        Thread.sleep(5000);//set as other wait
        driver.navigate().refresh();

        String actualPriceValue = driver.findElement(By.xpath("//*[@id=\"product_price_2_7_0\"]/span")).getText();
        Assert.assertEquals(expectedPriceValue,actualPriceValue);
        String actualTotalPriceForItemProductValue = driver.findElement(By.id("total_product_price_2_7_0")).getText();
        Assert.assertEquals(expectedTotalPriceForItemProductValue,actualTotalPriceForItemProductValue);
        String actualTotalPriceForAllCartValue = driver.findElement(By.id("total_product")).getText();
        Assert.assertEquals(expectedTotalPriceForAllCartValue,actualTotalPriceForAllCartValue);
        String actualTotalShippingPriceValue = driver.findElement(By.id("total_shipping")).getText();
        Assert.assertEquals(expectedTotalShippingPriceValue,actualTotalShippingPriceValue);
        String actualTotalPriceWithoutTaxValue = driver.findElement(By.id("total_price_without_tax")).getText();
        Assert.assertEquals(expectedTotalPriceWithoutTaxValue,actualTotalPriceWithoutTaxValue);
        String actualTotalTaxValue = driver.findElement(By.id("total_tax")).getText();
        Assert.assertEquals(expectedTotalTaxValue,actualTotalTaxValue);
        String actualTotalPriceValue = driver.findElement(By.id("total_price")).getText();
        Assert.assertEquals(expectedTotalPriceValue,actualTotalPriceValue);

        clickOnItemDeleteButton();
        waitForElementLocatedByXPath(10,"//p[@class='alert alert-warning']");

        String actualEmptyCartMessage = driver.findElement(By.xpath("//p[@class='alert alert-warning']")).getText();
        Assert.assertEquals(expectedEmptyCartMessage,actualEmptyCartMessage);
    }

    private void addItemToCart(String itemForSearch) {
        inputIntoSearchfield(itemForSearch);
        clickToSubmit();
        switchToListView();
        openProductView();
        clickOnAddToCartButton();
    }

    private void goToCart(){
        waitForElementLocatedByXPath(10,"//*[@class='btn btn-default button button-medium']");
        clickOnCheckoutButton();
    }

    private void clickOnItemDeleteButton() {
        WebElement itemDeleteButton = driver.findElement(By.className("cart_quantity_delete"));
        itemDeleteButton.click();
    }

    private void clickOnCheckoutButton() {
        WebElement proceedToCheckoutButton = driver.
                findElement(By.xpath("//*[@class='btn btn-default button button-medium']"));
        proceedToCheckoutButton.click();
    }

    private void clickOnAddToCartButton() {
        WebElement addToCartButton = driver.findElement(By.id("add_to_cart"));
        addToCartButton.click();
    }

    private void inputIntoSearchfield(String name) {
        WebElement searchField = driver.findElement(By.id("search_query_top"));
        searchField.sendKeys(name);
    }

    private void clickToSubmit() {
        WebElement submitButton = driver.findElement(By.name("submit_search"));
        submitButton.click();
    }

    private void switchToListView() {
        WebElement listView = driver.findElement(By.className("icon-th-list"));
        listView.click();
    }

    private void openProductView() {
        WebElement moreButton = driver.findElement(By.xpath("//*[@title='View']"));
        moreButton.click();
    }

    private void waitForElementLocatedByXPath(int timeout, String XPath){
        new WebDriverWait(driver, timeout).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath(XPath)));
    }
}
