package HomeWork;

import HW9Objects.APITestObject;
import WeatherPages.BottomMenu;
import WeatherPages.CityPage;
import com.jayway.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Stas on 07.10.2018.
 */
public class weatherAPITest {
    public WebDriver driver;
    private static final String cityName = "Kyiv";
    private static final int timeouts = 10;


//    Задание протестировать endpoint по ссылке:
//    https://www.openweathermap.org/current
//    Использовать API_KEY для параметра: d487dc4d1e75e13db4a4e0b2122e7a99
//    Запрос должен бысть с параметром appid например :
//    http://api.openweathermap.org/data/2.5/weather?id=2643743&appid=d487dc4d1e75e13db4a4e0b2122e7a99,
//    где id это идентификатор города (Лондон)
//    1. Для реализации http запросов использовать rest-assured.
//    2. В качестве группы тестов/теста добавить сравнение полученных данных с weather.com
//    (для получения данных с сайта использовать selenium)
//    3. Сравнить температуру воздуха из API и на сайте
//{
//    "id": 703448,
//        "name": "Kiev",
//        "country": "UA",
//        "coord": {
//    "lon": 30.516666,
//            "lat": 50.433334
//}
//},

    @BeforeMethod
    public void init() {
        System.setProperty("webdriver.chrome.driver", "E:\\megogoTest\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://weather.com/");
    }

    @Test
    public void apiTest() throws InterruptedException {
        RestAssured.given().
                param("id", "703448").
                param("appid", "d487dc4d1e75e13db4a4e0b2122e7a99").
                param("units", "metric").
                param("lang", "ru").
                get("https://api.openweathermap.org/data/2.5/weather").
                body().
                prettyPrint();
        APITestObject apiTestObject = RestAssured.given().
                param("id", "703448").
                param("appid", "d487dc4d1e75e13db4a4e0b2122e7a99").
                param("units", "metric").
                param("lang", "ru").
                get("https://api.openweathermap.org/data/2.5/weather").
                as(APITestObject.class);
        System.out.println(apiTestObject.getName());
        System.out.println(apiTestObject.getMain().getTemp());

        BottomMenu bottomMenu = new BottomMenu(driver);
        elementVisible(bottomMenu.findMeSectionElement());
        bottomMenu.typeCityFiled(cityName);
        elementVisible(bottomMenu.searchResultsTextElement());
        Thread.sleep(5000);
        bottomMenu.clickOnFirstResultContainsKyiv();
        elementVisible(bottomMenu.findMeSectionElement());
        CityPage cityPage = new CityPage(driver);
        System.out.println(cityPage.getCityTitle());
        System.out.println(cityPage.getTemperature());
    }

    @AfterMethod()
    public void close() {
//        driver.close();
    }


    private void elementVisible(WebElement element) {
        new WebDriverWait(driver, timeouts).
                until(ExpectedConditions.visibilityOf(element));
    }

    private void elementClickable(WebElement element) {
        new WebDriverWait(driver, timeouts).
                until(ExpectedConditions.elementToBeClickable(element));
    }
}
