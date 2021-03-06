package com.techproed.day06;

import com.techproed.testBase.DummyBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest08 extends DummyBaseUrl {

    /*
    http://dummy.restapiexample.com/api/v1/employees url’inde bulunan
   1) Butun calisanlarin isimlerini consola yazdıralim
   2) 3. calisan kisinin ismini konsola yazdıralim
   3) Ilk 5 calisanin adini konsola yazdiralim
   4) En son calisanin adini konsola yazdiralim
     */

    @Test
    public void test(){

        spec.pathParam("parametre1","employees");

        Response response=given().
                accept("application/json").
                spec(spec).when().
                get("/{parametre1}");

        response.prettyPrint();

        JsonPath json=response.jsonPath();

        System.out.println(json.getList("data.employee_name"));
        // response daki tüm employee leri bulur ve getirir.
        System.out.println(json.getString("data.employee_name[2]"));
        System.out.println(json.getString("data.employee_name[0,1,2,3,4]"));
        System.out.println(json.getString("data.employee_name[-1]"));
    }

}