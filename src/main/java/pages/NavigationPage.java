package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationPage {
    private WebDriver driver;

    public NavigationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "header_user_info")
    private WebElement singInButton;

    public void clickOnSignButton() {
        singInButton.click();
    }

    @FindBy(xpath = "(//*[@class='sf-with-ul'])[4]")
    private WebElement dressSFMenuSectionbutton;

    public void clickOnDressSFMenuSectionbutton() {
        dressSFMenuSectionbutton.click();
    }
}
