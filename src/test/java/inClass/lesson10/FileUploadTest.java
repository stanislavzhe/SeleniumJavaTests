package inClass.lesson10;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.ContactUsPage;
import pages.NavigationPage;

import java.io.File;
import java.io.IOException;

public class FileUploadTest {
    private WebDriver driver;

    //TODO move to class with Before after methods
    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {
        if (browser.equals("chrome")){
            ChromeDriverManager.chromedriver().setup(); //instead of setProperty
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            ChromeDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void uploadFileTest(){
        NavigationPage navigationPage = new NavigationPage(driver);
        navigationPage.clickOnContuctUsButton();
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        System.out.println(contactUsPage.getContactUsTitle());

        File file = new File("src\\main\\resources\\newTestFile");
        contactUsPage.attachedFileInputElement().sendKeys(file.getAbsolutePath());
    }

    @AfterMethod(alwaysRun = true)
    public void closeDown(ITestResult testResult) throws IOException {
//        driver.manage().deleteAllCookies();
        if (testResult.getStatus() == ITestResult.FAILURE){
            getScreenshot();
        }
        driver.close();
    }

    //TODO move to class base test with driver open and closeDown methods
    public void getScreenshot() throws IOException {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "./target/screenshots/" + screenshot.getName();
        FileUtils.copyFile(screenshot, new File(path));
    }



}
