package HomeWork.HW9;

import com.jayway.restassured.RestAssured;
import org.testng.annotations.Test;

/**
 * Created by Stas on 07.10.2018.
 */
public class weatherAPITest {
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

    @Test
    public void apiTest() {
        RestAssured.given().
                param("id", "2643743").
                param("appid", "d487dc4d1e75e13db4a4e0b2122e7a99").
                get("https://api.openweathermap.org/data/2.5/weather").
                body().
                prettyPrint();
    }
}
