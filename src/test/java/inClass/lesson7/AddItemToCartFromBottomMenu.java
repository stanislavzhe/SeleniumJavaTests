package inClass.lesson7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class AddItemToCartFromBottomMenu {
    WebDriver driver;

    @BeforeMethod
    public void init() {
        System.setProperty("webdriver.chrome.driver", "E:\\megogoTest\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void moveToElementCheck(){
        HomePage homePage = new HomePage(driver);
        homePage.moveToFirstItem();
        homePage.clickOnAddToCartButton();

    }

    @AfterMethod()
    public void close() {
//        driver.close();
    }
}
