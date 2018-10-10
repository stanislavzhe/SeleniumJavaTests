package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuNavigation {
    private WebDriver driver;


    @FindBy(className = "header_user_info")
    private WebElement singInButton;
    @FindBy(xpath = "(//*[@class='sf-with-ul'])[4]")
    private WebElement dressSFMenuSectionButton;
    @FindBy(xpath = "(//*[@class='sf-with-ul'])[1]")
    private WebElement womenSFMenuSectionButton;
    @FindBy(id = "contact-link")
    private WebElement contuctUsButton;
    @FindBy(xpath = "(//*[@class='sf-with-ul'])[4]")
    private WebElement dressSFMenuSectionbutton;
    @FindBy(id = "search_query_top")
    private WebElement searchField;
    @FindBy(name = "submit_search")
    private WebElement submitButton;


    public MenuNavigation(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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

    public void clickOnDressSFMenuSectionbutton() {
        dressSFMenuSectionbutton.click();
    }

    public void clickOnContactUsButton() {
        contuctUsButton.click();
    }

    public void inputIntoSearchField(String name) {
        searchField.sendKeys(name);
    }
    public void clickToSubmit() {
        submitButton.click();
    }
}

