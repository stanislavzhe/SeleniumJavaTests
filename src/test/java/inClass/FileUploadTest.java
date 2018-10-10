package inClass;

import Tests.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.ContactUsPage;
import pages.MenuNavigation;

import java.io.File;

public class FileUploadTest extends BaseTest {
    private WebDriver driver;

    @Test
    public void uploadFileTest(){
        MenuNavigation menuNavigation = new MenuNavigation(driver);
        menuNavigation.clickOnContactUsButton();
        ContactUsPage contactUsPage = new ContactUsPage(driver);
        System.out.println(contactUsPage.getContactUsTitle());

        File file = new File("src\\main\\resources\\newTestFile");
        contactUsPage.attachedFileInputElement().sendKeys(file.getAbsolutePath());
    }
}
