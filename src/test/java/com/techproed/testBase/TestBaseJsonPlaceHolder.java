package com.techproed.testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Before;

public class TestBaseJsonPlaceHolder {

    protected RequestSpecification spec01 ;
//    protected ResponseSpecification responseSpec;


    @Before
    public void setUp(){

        spec01 = new RequestSpecBuilder().
                     setBaseUri("https://jsonplaceholder.typicode.com").
                     build();

//        responseSpec = new ResponseSpecBuilder().expectStatusCode(200).
//                expectContentType(ContentType.JSON).
//                build();
    }

}
