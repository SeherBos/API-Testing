package com.techproed.day11;

import com.techproed.testBase.TestBaseJsonPlaceHolder;
import com.techproed.testData.TestDataJsonPlaceHolder;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class PatchRequest01 extends TestBaseJsonPlaceHolder {
    /*
    https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönderdiğimde
   {

      "title": "API calismaliyim"

     }
Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
{
 "userId": 10,
 "title": "API calismaliyim"
 "completed": true,
 "id": 198
}
     */

    @Test
    public void test() {
        spec01.pathParams("first", "todos",
                "second", 198);
        TestDataJsonPlaceHolder expected = new TestDataJsonPlaceHolder();
        JSONObject requestBody = expected.setUpExpectedBodyPatch01();

        Response response = RestAssured.
                given().
                spec(spec01).contentType(ContentType.JSON).
                body(expected.setUpExpectedBodyPatch01()).
                when().
                patch("/{param1}/{param2}");
        response.prettyPrint();


        //De-Seriallization
        HashMap<String, Object> actualDataMap = response.as(HashMap.class);
        System.out.println(actualDataMap);
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertEquals(requestBody.getBoolean("completed"), actualDataMap.get("completed"));
        Assert.assertEquals(requestBody.getInt("userId"), actualDataMap.get("userId"));
        Assert.assertEquals(requestBody.getString("title"), actualDataMap.get("title"));

    }
}