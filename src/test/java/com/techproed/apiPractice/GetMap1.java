package com.techproed.apiPractice;

import com.techproed.testBase.TestBaseJsonPlaceHolder;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import static io.restassured.RestAssured.given;

import java.util.HashMap;

public class GetMap1 extends TestBaseJsonPlaceHolder {
    /*
https://jsonplaceholder.typicode.com/todos/2 url ‘ine istek gönderildiğinde,
 Dönen response un
 Status kodunun 200,
 dönen body de, "completed": değerinin false
"title”: değerinin “quis ut nam facilis et officia qui”
"userId" sinin 1 ve header değerlerinden
 "Via" değerinin “1.1 vegur” ve
 "Server" değerinin “cloudflare” olduğunu test edin…
 */

@Test
    public void test(){

    spec01.pathParams("param1","todos" ,"param2",2);


    HashMap<String,Object> expectedData = new HashMap<String,Object>();
    expectedData.put("completed",false);
    expectedData.put("title","quis ut nam facilis et officia qui");
    expectedData.put("userId",1);
    expectedData.put("Via","1.1 vegur");
    expectedData.put("Server","cloudflare");
    expectedData.put("statusCode",200);


    System.out.println(expectedData);

    Response response = given().accept("application/json").spec(spec01).when().get("/{param1}/{param2}");

 //   response.prettyPrint();

    HashMap<String,Object> actualData = response.as(HashMap.class);
    System.out.println(actualData);

    Assert.assertEquals(expectedData.get("statusCode"),response.getStatusCode());
    Assert.assertEquals(expectedData.get("userId"),actualData.get("userId"));
  //   Assert.assertEquals(expectedData.get("id"),actualData.get("id"));
     Assert.assertEquals(expectedData.get("title"),actualData.get("title"));
     Assert.assertEquals(expectedData.get("completed"),actualData.get("completed"));




}
}
