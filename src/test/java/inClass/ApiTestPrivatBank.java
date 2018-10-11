package inClass;

import HomeWork.lesson2HomeWork.BankAccount;
import Tests.BaseTest;
import com.jayway.restassured.RestAssured;
import models.Currency;
import models.User;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by Stas on 06.10.2018.
 */
public class ApiTestPrivatBank extends BaseTest{

    @Test
    public void stringToObjectTest() {
//        RestAssured.get("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5").
//                thenReturn().body().prettyPrint();
//        String json =  RestAssured.get("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5").
//                thenReturn().asString();
//
//        System.out.println(json);


        // Convert JSON string to Object
//        String jsonInString = "{\"ccy\": USD,\"base_ccy\": UAH,\"buy\": 27.90000,\"sale\": 28.15000}";
//        Currency currency1 = RestAssured.get(jsonInString).as(Currency.class);
//        System.out.println(currency1);
//        System.out.println(currency1.getCcy());
//        System.out.println(currency1.getBase_ccy());
//        System.out.println(currency1.getBuy());
//        System.out.println(currency1.getSale());

    }

    @Test
    public void apiTest() {
        RestAssured.get("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5").
                thenReturn().body().prettyPrint();
//        String json =  RestAssured.get("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5").
//                thenReturn().asString();
//        System.out.println(json);

        ObjectMapper mapper = new ObjectMapper();

        try {
            String jsonInString = RestAssured.get("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5").
                    thenReturn().asString();
            List<Currency> currencyList = mapper.readValue(jsonInString, new TypeReference<List<Currency>>() {
            });
            System.out.println(currencyList);
            System.out.println(currencyList.size());
            System.out.println(currencyList.get(0).toString());
            System.out.println(currencyList.get(1).toString());


        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

