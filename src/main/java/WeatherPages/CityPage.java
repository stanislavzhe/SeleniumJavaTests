package WeatherPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CityPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@class='h4 today_nowcard-location']")
    private WebElement cityTitle;
    @FindBy(xpath = "//*[@class='today_nowcard-temp']")
    private WebElement temperature;

    public CityPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getCityTitle(){
        return cityTitle.getText();
    }

    public String getTemperature(){
        return temperature.getText();
    }
}

