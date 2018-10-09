package WeatherPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class='theme__inputElement__4bZUj input__inputElement__1GjGE']")
    private WebElement cityFieldInput;
    @FindBy(xpath = "//*[@class='styles__title__2W1hP']")
    private WebElement searchResultsText;
    @FindBy(xpath = "//*[@class='styles__inner__3moHD styles__menu__-Qyt7']//*[contains(text(),'Kyiv')]")
    private List<WebElement> searchResultsWithKyivText;
    @FindBy(xpath = "//*[@class='styles__findMeButton__2lM4b styles__findMeButton__2SE4S js-onboarding__find-me']")
    private WebElement findMeSection;
    @FindBy(xpath = "//*[@class='theme__linear__3vxHj progress__linear__38esV theme__indeterminate__1gPzb']")
    private WebElement loaderIcon;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void typeCityFiled(String city){
        cityFieldInput.sendKeys(city);
    }

    public WebElement searchResultsTextElement(){
        return searchResultsText;
    }

    public void clickOnFirstResultContainsKyiv(){
        searchResultsWithKyivText.get(0).click();
    }

    public WebElement findMeSectionElement(){
        return findMeSection;
    }

    public WebElement firstResultElement(){
        return searchResultsWithKyivText.get(0);
    }

    public void loaderSectionNotShown(int timeout) {
        new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(By.
                        xpath("//*[@class='theme__linear__3vxHj progress__linear__38esV theme__indeterminate__1gPzb']")));
        new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOfElementLocated(By.
                        xpath("//*[@class='theme__linear__3vxHj progress__linear__38esV theme__indeterminate__1gPzb']")));
    }
}
