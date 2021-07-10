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

public class PutRequest01 extends TestBaseJsonPlaceHolder {
    /*
    https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönerdiğimde
   {
      "userId": 21,
      "title": "Wash the dishes",
      "completed": false
     }
Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
{
 "userId": 21,
 "title": "Wash the dishes",
 "completed": false,
 "id": 198
}
     */

    @Test
    public void test(){
        spec01.pathParams("param1","todos", "param2",198);

        //      request / expected data
        TestDataJsonPlaceHolder testData = new TestDataJsonPlaceHolder();
        JSONObject requestBody = testData.setUpPut01();


//request gönder

        Response response= RestAssured.
                given().
                    contentType(ContentType.JSON).
                    spec(spec01).
                    auth().basic("admin","password123").
                    body(requestBody.toString()).
                when().
                    put("/{parametre1}/{parametre2}")
              //  .then().spec()
                ;
        response.prettyPrint();

        //JsonPath ile
        JsonPath json=response.jsonPath();
        // json.prettyPrint();
     //   Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(requestBody.getInt("userId"),json.getInt("userId"));
        Assert.assertEquals(requestBody.getString("title"),json.getString("title"));
        Assert.assertEquals(requestBody.getBoolean("completed"),json.getBoolean("completed"));


    }

}
