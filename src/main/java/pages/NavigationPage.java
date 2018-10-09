package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage {
    private WebDriver driver;

    @FindBy(id = "contact-link")
    private WebElement contuctUsButton;
    @FindBy(className = "header_user_info")
    private WebElement singInButton;
    @FindBy(xpath = "(//*[@class='sf-with-ul'])[4]")
    private WebElement dressSFMenuSectionbutton;

    public NavigationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickOnSignButton() {
        singInButton.click();
    }

    public void clickOnDressSFMenuSectionbutton() {
        dressSFMenuSectionbutton.click();
    }

    public void clickOnContuctUsButton(){
        contuctUsButton.click();
    }


}
