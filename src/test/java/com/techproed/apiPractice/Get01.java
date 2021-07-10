package com.techproed.apiPractice;

import com.techproed.testBase.TestBaseHerokuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class Get01 extends TestBaseHerokuApp {
    /*
         Positive Scenario:
         When Asagidaki Endpoint'e bir GET request yolladim
         https://restful-booker.herokuapp.com/booking/10
     And Accept type “application/json” dir
     Then
     HTTP Status Code 200
     And Response format "application/json"
     And firstname "Mark"
     And lastname "Wilson"
     And depositpaid true
     And checkin date "2016-06-19"
     And checkout date "2019-08-26"
     1.Adim Url'i olustur
     2.Adim Data'yi oluştur
     3.Adim Request gönder
     4.Adim Validation yap
        */

    @Test
    public void test(){

        spec02.pathParams("param1", "booking", "param2" , 10);

        Response response = given().spec(spec02).accept("application/json").spec(spec02).when().get("{/param1}/{param2}");

        response.then().assertThat().contentType("application/json").statusCode(200);

        response.prettyPrint();

    //    response.body(Matchers.equalTo(""));


    }
}
