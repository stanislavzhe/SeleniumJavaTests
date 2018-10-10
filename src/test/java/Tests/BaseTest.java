package Tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    public WebDriver driver;
    public static int timeOut = 15;

//    @Parameters("browser")
//    @BeforeMethod
//    public void setUp(@Optional("chrome") String browser) {
//        if (browser.equals("chrome")){
//            ChromeDriverManager.chromedriver().setup(); //instead of setProperty
//            driver = new ChromeDriver();
//        } else if (browser.equals("firefox")) {
//            ChromeDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        }
//        driver.manage().window().maximize();
//        driver.get("http://automationpractice.com/index.php");
//    }

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        ChromeDriverManager.chromedriver().setup(); //instead of setProperty
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }


    @AfterMethod(alwaysRun = true)
    public void closeDown(ITestResult testResult) throws IOException {
//        driver.manage().deleteAllCookies();
        if (testResult.getStatus() == ITestResult.FAILURE) {
            getScreenshot();
        }
        driver.close();
    }

    public void getScreenshot() throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "./target/screenshots/" + screenshot.getName();
        FileUtils.copyFile(screenshot, new File(path));
    }



    protected void elementClickable(WebElement element) {
        new WebDriverWait(driver, timeOut).
                until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void elementVisible(WebElement element, int timeout) {
        new WebDriverWait(driver, timeout).
                until(ExpectedConditions.visibilityOf(element));
    }
}
