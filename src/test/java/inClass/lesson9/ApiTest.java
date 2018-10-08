package inClass.lesson9;

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
public class ApiTest {

    @Test
    public void stringToObjectTest() {
//        RestAssured.get("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5").
//                thenReturn().body().prettyPrint();
//        String json =  RestAssured.get("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5").
//                thenReturn().asString();
//
//        System.out.println(json);

        ObjectMapper mapper = new ObjectMapper();

        try {
            // Convert JSON string to Object
            String jsonInString = "{\"age\":33,\"messages\":[\"msg 1\",\"msg 2\"],\"name\":\"mkyong\"}";
            User user1 = mapper.readValue(jsonInString, models.User.class);
            System.out.println(user1);
            System.out.println(user1.getAge());
            System.out.println(user1.getMessages());
            System.out.println(user1.getName());

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            List<Currency> currencyList = mapper.readValue(jsonInString, new TypeReference<List<Currency>>(){});
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

