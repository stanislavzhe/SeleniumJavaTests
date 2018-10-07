package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TopMenuNavigation {
    private WebDriver driver;

    public TopMenuNavigation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "header_user_info")
    private WebElement singInButton;
    @FindBy(xpath = "(//*[@class='sf-with-ul'])[4]")
    private WebElement dressSFMenuSectionButton;
    @FindBy(xpath = "(//*[@class='sf-with-ul'])[1]")
    private WebElement womenSFMenuSectionButton;

    public void clickOnSignButton() {
        singInButton.click();
    }

    public String getText() {
        return singInButton.getText();
    }

    public void clickOnDressSFMenuSectionButton() {
        dressSFMenuSectionButton.click();
    }

    public void clickOnWomenSFMenuSectionButton() {
        womenSFMenuSectionButton.click();
    }
}
