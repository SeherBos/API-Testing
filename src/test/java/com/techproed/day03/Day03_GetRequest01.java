package com.techproed.day03;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.given;

public class Day03_GetRequest01 {

    /*GetRequest01:
            https://restful-booker.herokuapp.com/booking/3 adresine bir request gonderildiginde donecek cevap(response) icin
            ØHTTP status kodunun 200
            ØContent Type’in Json
            ØVe Status Line’in HTTP/1.1 200 OK
            Oldugunu test edin.
     */

    @Test
    public void test01(){
//      1- URL belirlenmeli

        String url = "https://restful-booker.herokuapp.com/booking/3";

//      2- Expected result belirlenmeli
// Responce Body'den herhangi bir şey kontrol etmediğimiz için Expected Result oluşturmaya gerek yoktur.

//      3- Request gonder

        Response response = given().accept("application/json").when().get(url);

        response.prettyPrint();

//      4- response al (actual result)
            // Body testi yapmadigim icin actual result almiyorum


//      5-Assertion yapalim

        response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");
        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Status Line: " +response.getStatusLine());
        System.out.println("Header: " +response.getHeaders());
        System.out.println("Content Type: " +response.getContentType());

    }


}
