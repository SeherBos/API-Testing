package com.techproed.day03;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Day03_GetRequest02 {

    /*
    https://restful-booker.herokuapp.com/booking url'ine
    accept type'i "application/json" olan
    GET request'i yolladigimda gelen response'un
    status kodunun 200
    content type'inin "application/json" oldugunu test edin

    https://restful-booker.herokuapp.com/booking/1001 url'ine
    accept type'i "application/json" olan GET request'i yolladigimda
    gelen response'un
    status kodunun 404 oldugunu
     */

    @Test
   public void test01(){

    String url = "https://restful-booker.herokuapp.com/booking";

    Response response = given().accept("application/json").when().get(url);
    response.prettyPrint();

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);

     //   System.out.println(response.getHeader("Server"));
        System.out.println("response.body() = " + response.body());

    }
}
