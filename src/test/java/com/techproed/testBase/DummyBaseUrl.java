package com.techproed.testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Before;

public class DummyBaseUrl {

    //Create RequestSpecification object
    protected RequestSpecification spec;

    //If you use @Before annotation before a method, it means the method will be executed before every test method
    @Before
    public void setUp(){
        spec = new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com/api/v1").build();

    }
}
