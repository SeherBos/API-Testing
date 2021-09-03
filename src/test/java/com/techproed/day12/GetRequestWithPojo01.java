package com.techproed.day12;

import com.google.gson.Gson;
import com.techproed.pojos.DataPojo;
import com.techproed.pojos.EmployeePojo;
import com.techproed.testBase.DummyBaseUrl;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

public class GetRequestWithPojo01 extends DummyBaseUrl {
    /*
    GET Request to the URL http://dummy.restapiexample.com/api/v1/employee/1
            Status code is 200
             {
                                  "status": "success",
                                  "data": {
                                      "id": 1,
                                      "employee_name": "Tiger Nixon",
                                      "employee_salary": 320800,
                                      "employee_age": 61,
                                      "profile_image": ""
                                  },
                                  "message": "Successfully! Record has been fetched."
                                 }

     */

    @Test
    public void test(){

        spec.pathParams("param1","employee","param2",1);


        DataPojo dataPojo = new DataPojo(1,"Tiger Nixon",320800,61,"");
        EmployeePojo expectedData= new EmployeePojo("success",dataPojo,"Successfully! Record has been fetched.");

        System.out.println("expectedData = " + expectedData);
        Response response= RestAssured.given().
                accept(ContentType.JSON).
                spec(spec).when().get("/{param1}/{param2}");

        response.prettyPrint();

        EmployeePojo actualData = response.as(EmployeePojo.class);

        System.out.println("actualData = " + actualData);


        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(expectedData.getStatus(),actualData.getStatus());
        Assert.assertEquals(expectedData.getData().getId(),actualData.getData().getId());
        Assert.assertEquals(expectedData.getData().getEmployee_age(),actualData.getData().getEmployee_age());
        Assert.assertEquals(expectedData.getData().getEmployee_name(),actualData.getData().getEmployee_name());
        Assert.assertEquals(expectedData.getData().getEmployee_salary(),actualData.getData().getEmployee_salary());
        Assert.assertEquals(expectedData.getData().getProfile_image(),actualData.getData().getProfile_image());
        Assert.assertEquals(expectedData.getMessage(),actualData.getMessage());

        //Serialization işlemi ile java objesini json objesine çeviririm
        //Gson sınıfından bir obje üreteceğim
        Gson gson=new Gson();
        String jsonFromJava=gson.toJson(actualData);
        //ürettiğim obje üzerinde toJson methodunu kullandım
        System.out.println(jsonFromJava);

    }












}
