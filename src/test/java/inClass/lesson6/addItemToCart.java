package inClass.lesson6;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class addItemToCart {
    WebDriver driver;

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "E:\\megogoTest\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verifyThatProductPriceDiplayInDemoSection() throws InterruptedException {
        inputIntoSearchfield("Blouse");
        clickToSubmit();
        switchToListView();
        openProductView();
        WebElement addToCartButton = driver.findElement(By.id("add_to_cart"));
        addToCartButton.click();
        WebElement proceedToCheckoutButton = driver.
                findElement(By.xpath("//*[@class='btn btn-default button button-medium']"));
        proceedToCheckoutButton.click();

        // вынести в отдельный класс. класс должен быть с параметрами
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        new WebDriverWait(driver,10).
                until(ExpectedConditions.visibilityOfElementLocated
                        (By.xpath("//*[@class='btn btn-default button button-medium']"))).click();
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
