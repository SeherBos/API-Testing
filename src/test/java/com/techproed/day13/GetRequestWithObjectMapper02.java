package com.techproed.day13;

import com.techproed.testBase.TestBaseHerokuApp;
import com.techproed.utilities.JsonUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class GetRequestWithObjectMapper02 extends TestBaseHerokuApp {

    /*
    https://restful-booker.herokuapp.com/booking/2 url’ine bir get request gönderildiğinde,
status kodun 200 ve response body’nin
{
   "firstname": "Mark",
   "lastname": "Wilson",
   "totalprice": 284,
   "depositpaid": false,
   "bookingdates": {
       "checkin": "2016-08-10",
       "checkout": "2018-06-22"
   }
}
     */

    @Test
    public void test(){

        spec02.pathParams("param1","booking","param2",2);

    String jsonData = "{\n" +
            "   \"firstname\": \"Mark\",\n" +
            "   \"lastname\": \"Wilson\",\n" +
            "   \"totalprice\": 284,\n" +
            "   \"depositpaid\": false,\n" +
            "   \"bookingdates\": {\n" +
            "       \"checkin\": \"2016-08-10\",\n" +
            "       \"checkout\": \"2018-06-22\"\n" +
            "   }\n" +
            "}";

        HashMap<String,Object> expectedDataMap = JsonUtil.convertJsonToJava(jsonData,HashMap.class);

        System.out.println("expectedDataMap = " + expectedDataMap);
        Response response= RestAssured.given().
                accept("application/json").
                spec(spec02).
                when().get("/{param1}/{param2}");
        response.prettyPrint();

        HashMap<String,Object> actualData = JsonUtil.convertJsonToJava(response.asString(),HashMap.class);





    }






}
