package com.techproed.engbatch;

import com.techproed.testBase.TestBaseHerokuApp;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertTrue;

public class GetRequest05 extends TestBaseHerokuApp {

    // BATCH 14-15 DT NT API 06 FOR MORE DETAILS

    /*
         When
	  		I send a GET request to REST API URL https://restful-booker.herokuapp.com/booking
	  	 Then
	  	    Status code is 200
	  		And Among the data there should be someone whose first name is "Mark" and last name is "Ericsson"
    */
    @Test
    public void get01(){
        //1)Set the URL
        spec02.
                pathParam("first", "booking").
                queryParams("firstname", "Eric",
                        "lastname", "Brown");

        //2)Set the expected data

        //3)Send the request
        Response response = given().spec(spec02).when().get("/{first}");
        response.prettyPrint();

        response.then().assertThat().statusCode(200);

        assertTrue(response.asString().contains("bookingid"));

    }

}
