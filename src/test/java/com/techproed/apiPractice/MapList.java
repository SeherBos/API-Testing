package com.techproed.apiPractice;

import com.techproed.testBase.DummyBaseUrl;
import com.techproed.testData.PracticeDummy;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MapList extends DummyBaseUrl {
 /*
     http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
 Status kodun 200 olduğunu,
 5. Çalışan isminin "Airi Satou" olduğunu ,  çalışan sayısının 24 olduğunu,
 Sondan 2. çalışanın maaşının 106450 olduğunu
 40,21 ve 19 yaslarında çalışanlar olup olmadığını
 11. Çalışan bilgilerinin
   {
  “id”:”11”
  "employee_name": "Jena Gaines",
 "employee_salary": "90560",
 "employee_age": "30",
 "profile_image": "" }
 } gibi olduğunu test edin.
      */

    @Test
    public void test(){
    spec.pathParam("param","employees");

        PracticeDummy practiceDummy = new PracticeDummy();

        HashMap<String,Object> expectedData = practiceDummy.setUpData();

        System.out.println(expectedData);

        Response response = RestAssured.given().accept("application/json").spec(spec).when().get("/{param}");

        response.prettyPrint();
        HashMap<String,Object> actualData = response.as(HashMap.class);

        System.out.println(actualData);

   //   Assert.assertEquals(expectedData.get("statusCode"),response.getStatusCode());
        Assert.assertEquals(expectedData.get("fifthEmployee"),
                    ((Map)((List)actualData.get("data")).get(4)).get("employee_name"));

        int dataSize = ((List<?>) actualData.get("data")).size();

        Assert.assertEquals(expectedData.get("employeeNumber"),dataSize-1);
        Assert.assertEquals(expectedData.get("salary"),((List<?>) actualData.get("data")).get(dataSize-2));

        List<Integer> actualAgeList = new ArrayList<>();
        for (int i=0 ; i<dataSize ; i++){
            actualAgeList.add((Integer) ((Map) ((List<?>) actualData.get("data")).get(i)).get("employee_age"));
        }

        Assert.assertTrue(actualAgeList.containsAll((List)expectedData.get("ages")));

        Assert.assertEquals(((Map)expectedData.get("eleven")).get("id"),
                            ((Map)((List<?>) actualData.get("data")).get(10)).get("id"));

        Assert.assertEquals(
                            ((Map) expectedData.get("eleven")).get("employee_name"),
                            ((Map) ((List<?>) actualData.get("data")).get(10)).get("employee_name"));
        Assert.assertEquals(
                            ((Map) expectedData.get("eleven")).get("employee_salary"),
                            ((Map) ((List<?>) actualData.get("data")).get(10)).get("employee_salary"));

        Assert.assertEquals(
                            ((Map) expectedData.get("eleven")).get("employee_age"),
                            ((Map) ((List<?>) actualData.get("data")).get(10)).get("employee_age"));

Assert.assertEquals(((Map) expectedData.get("eleven")).get("profile_image"),
                    ((Map)((List<?>) actualData.get("data")).get(10)).get("profile_image"));


    }


}
