package Tests.CartTest;

import Tests.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmptyCartCheck extends BaseTest {


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



}
