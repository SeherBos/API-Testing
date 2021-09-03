package com.techproed.day13;

import com.techproed.testBase.TestBaseJsonPlaceHolder;
import com.techproed.utilities.JsonUtil;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class GetRequestWithObjectMapper01 extends TestBaseJsonPlaceHolder {

/*
https://jsonplaceholder.typicode.com/todos/198 url’ine bir get request gönderildiğinde,
Dönen response ‘un status kodunun 200 ve body kısmının
{
   "userId": 10,
   "id": 198,
   "title": "quis eius est sint explicabo",
   "completed": true
}
Olduğunu Object Mapper kullanarak test edin
 */

@Test
    public void test(){

    spec01.pathParams("param1","todos","param2","198");


// EXPECTED DATA OLUSTURMALIYIZ
    // JSON VERISINI STRING'E ATAMALIYIZ

    String jsonData = "{\n" +
            "   \"userId\": 10,\n" +
            "   \"id\": 198,\n" +
            "   \"title\": \"quis eius est sint explicabo\",\n" +
            "   \"completed\": true\n" +
            "}";

// CEVIRMEK ISTEDIGIM TYPE'I BELIRLIYORUZ.-- MAP'E CEVIRMESINI ISTIYORUM
    // OBJECT MAPPER YONTEMI DESERIALIZATION YAPAR.


    Map<String,Object> expectedDataMap = JsonUtil.convertJsonToJava(jsonData,Map.class);

    System.out.println("expectedDataMap = " + expectedDataMap);

    Response response= RestAssured.given().
            accept(ContentType.JSON).
            spec(spec01).
            when().get("/{param1}/{param2}");
    response.prettyPrint();

    Map<String,Object> actualData = JsonUtil.convertJsonToJava(response.asString(),Map.class);

    // convertJsonToJava methodu String bir parametre kabul eder. response String formatta degildir.
    // response String formatta olmadigi icin response.asString() methodunu kullandik.

    Assert.assertEquals(expectedDataMap.get("userId"),actualData.get("userId"));
    Assert.assertEquals(expectedDataMap.get("id"),actualData.get("id"));
    Assert.assertEquals(expectedDataMap.get("title"),actualData.get("title"));
    Assert.assertEquals(expectedDataMap.get("completed"),actualData.get("completed"));
    Assert.assertEquals(200,response.getStatusCode());




}

}
