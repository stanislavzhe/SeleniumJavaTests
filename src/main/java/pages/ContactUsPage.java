package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class='page-heading bottom-indent']")
    private WebElement contuctUsTitle;
    @FindBy(id = "fileUpload")
    private WebElement attachFileInput;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @Step
    public String getContactUsTitle(){
        return contuctUsTitle.getText();
    }

    @Step
    public WebElement attachedFileInputElement(){
        return attachFileInput;
    }


}
