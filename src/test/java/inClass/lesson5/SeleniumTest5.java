package inClass.lesson5;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeleniumTest5 {
    WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "E:\\megogoTest\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void verifyThatProductPriceDiplayInDemoSection() throws InterruptedException {
        String expectedPrice = "$27.00";
        inputIntoSearchfield("Blouse");
        clickToSubmit();
        switchToListView();
        openProductView();
        String actualPrice = getProductPriceElement().getText();
        Assert.assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void verifyThatCartIsEmptyAndContains5Titles() {
        WebElement cart = driver.findElement(By.xpath("//*[@title='View my shopping cart']"));
        cart.click();

        WebElement firstStep = driver.findElement(By.cssSelector("#order_step li:nth-child(1)"));
        WebElement secondStep = driver.findElement(By.cssSelector("#order_step li:nth-child(2)"));
        WebElement thirdStep = driver.findElement(By.cssSelector("#order_step li:nth-child(3)"));
        WebElement fourthStep = driver.findElement(By.cssSelector("#order_step li:nth-child(4)"));
        WebElement fifthStep = driver.findElement(By.cssSelector("#order_step li:nth-child(5)"));

        Assert.assertEquals("01. Summary", firstStep.getText());
        Assert.assertEquals("02. Sign in", secondStep.getText());
        Assert.assertEquals("03. Address", thirdStep.getText());
        Assert.assertEquals("04. Shipping", fourthStep.getText());
        Assert.assertEquals("05. Payment", fifthStep.getText());

        WebElement emptyCartText = driver.findElement(By.className("alert-warning"));
        Assert.assertEquals("Your shopping cart is empty.", emptyCartText.getText());

        List<WebElement> orderSteps = driver.findElements(By.cssSelector("#order_step li"));
        List<String> actualOrders = new ArrayList<String>();
        for (WebElement order : orderSteps) {
            actualOrders.add(order.getText());
        }
        List<String> expectedOrders = Arrays.asList("01. Summary", "02. Sign in", "03. Address", "04. Shipping", "05. Payment");
//        Assert.assertTrue(expectedOrders.equals(actualOrders));

        for (int i = 0; i < orderSteps.size(); i++) {
            Assert.assertEquals(expectedOrders.get(i), actualOrders.get(i));
        }
    }

    @After
    public void close() {
        driver.close();
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

    private WebElement getProductPriceElement() {
        return driver.findElement(By.id("our_price_display"));
    }
}
