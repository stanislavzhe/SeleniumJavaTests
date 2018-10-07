package inClass.lesson9;

import com.jayway.restassured.RestAssured;
import models.POJOTest;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Stas on 06.10.2018.
 */
public class ApiTest {

    @Test
    public void testApi() {
        RestAssured.get("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5").
                thenReturn().body().prettyPrint();
        String json =  RestAssured.get("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5").
                thenReturn().asString();

        System.out.println(json);

        ObjectMapper mapper = new ObjectMapper();
        List<POJOTest> list = new ArrayList<POJOTest>();
        try{
            list = Arrays.asList(mapper.readValue(json,POJOTest.class));
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(list.size());

    }
}

