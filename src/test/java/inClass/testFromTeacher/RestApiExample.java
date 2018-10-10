package inClass.testFromTeacher;

import com.jayway.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestApiExample {


    @Test
    public void verifyMainApi() {

        String ID = "2172797";
        MainApi expectedMainApi = new MainApi.MainApiBuilder().
                films("https://swapi.co/api/films/").
                people("https://swapi.co/api/people/").
                planets("https://swapi.co/api/planets/").
                species("https://swapi.co/api/species/").
                starships("https://swapi.co/api/starships/").
                vehicles("https://swapi.co/api/vehicles/").
                create();
        String actualMainApi = RestAssured.given().param(ID).get("https://swapi.co/api/").
                as(MainApi.class).getFilms();
        Assert.assertEquals(expectedMainApi.getFilms(),actualMainApi);
    }

}
