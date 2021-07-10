package com.techproed.apiPractice;

import com.techproed.testBase.DummyBaseUrl;
import com.techproed.testData.PracticeDummy;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MapJson extends DummyBaseUrl {

    /*
   http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
Status kodun 200 olduğunu,
5. Çalışan isminin "Airi Satou" olduğunu ,
çalışan sayısının 24 olduğunu,
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
        spec.pathParam("param" ,"employees");

       PracticeDummy practiceDummy = new PracticeDummy();

       HashMap<String,Object> expectedData = practiceDummy.setUpData();

       Response response = given().accept("application/json").spec(spec).when().get("/{param}");

       System.out.println(expectedData);
       response.prettyPrint();

       JsonPath json = response.jsonPath();
       Assert.assertEquals(expectedData.get("statusCode"),response.getStatusCode());
       Assert.assertEquals(expectedData.get("fifthEmployee"),json.getString("data[4].employee_name"));
       Assert.assertEquals(expectedData.get("employeeNumber"),json.getList("data.id").size());
       Assert.assertEquals(expectedData.get("salary"),json.getList("data[-2].employee_salary"));
       Assert.assertTrue(json.getList("data.employee_age").containsAll ((List)(expectedData.get("ages"))) );
       Assert.assertEquals(
               ((Map)expectedData.get("eleven")).get("id"),json.getInt("data[10].id"));
       Assert.assertEquals(
               ((Map)expectedData.get("eleven")).get("employee_name"),json.getString("data[10].employee_name"));
       Assert.assertEquals(
               ((Map<?, ?>) expectedData.get("eleven")).get("employee_age"),json.getInt("data[10].employee_age"));
       Assert.assertEquals(
               ((Map<?, ?>) expectedData.get("eleven")).get("profile_image"),json.getString("data.[10].profile_image"));

    }


}
