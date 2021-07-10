package com.techproed.day11;

import com.techproed.testBase.TestBaseJsonPlaceHolder;

import com.techproed.testData.TestDataJsonPlaceHolder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;


import java.util.HashMap;
import java.util.jar.JarEntry;

import static org.hamcrest.core.IsEqual.equalTo;

public class PostRequest03 extends TestBaseJsonPlaceHolder {
/*
https://jsonplaceholder.typicode.com/todos URL ine aşağıdaki body gönderildiğinde,
     }
     "userId": 55,
     "title": "Tidy your room",
     "completed": false
   }
Dönen response un Status kodunun 201 ve response body nin aşağıdaki gibi olduğunu test edin
   {
     "userId": 55,
     "title": "Tidy your room",
     "completed": false,
     "id": …
    }
 */
@Test
    public void test(){

    spec01.pathParam("param","todos");

    // request body olusturuyoruz
    TestDataJsonPlaceHolder testData = new TestDataJsonPlaceHolder();
    JSONObject requestBody = testData.getExpectedData();
    System.out.println("requestBody = " + requestBody);

    // request gonder

    Response response = RestAssured.given().
            contentType(ContentType.JSON).spec(spec01).
            auth().basic("admin","password123").
            body(requestBody.toString()).when().post("/{param}");

    response.prettyPrint();


    // De-Serialization -- Gson
    HashMap<String,Object> actualDataMap=response.as(HashMap.class);
    System.out.println(actualDataMap);
    Assert.assertEquals(testData.statusCode,response.getStatusCode());
    Assert.assertEquals(requestBody.getInt("userId"),actualDataMap.get("userId"));
    Assert.assertEquals(requestBody.getString("title"),actualDataMap.get("title"));
    Assert.assertEquals(requestBody.getBoolean("completed"),actualDataMap.get("completed"));


    //JsonPath
    JsonPath json=response.jsonPath();
    Assert.assertEquals(requestBody.getInt("userId"),json.getInt("userId"));
    Assert.assertEquals(requestBody.getString("title"),json.getString("title"));
    Assert.assertEquals(requestBody.getBoolean("completed"),json.getBoolean("completed"));


    // Matchers class
    response.then().
            assertThat().statusCode(testData.statusCode).
            body("userId", equalTo(requestBody.getInt("userId")),
                    "title",equalTo(requestBody.getString("title")),
                    "completed",equalTo(requestBody.getBoolean("completed")));

}

}
