package com.techproed.testData;

import org.json.JSONObject;

import java.util.HashMap;

public class TestDataJsonPlaceHolder {

    public int statusCode = 201;

    public HashMap<String,Object> setUpTestData() {

        HashMap<String, Object> expectedDataMap = new HashMap<String, Object>();
        expectedDataMap.put("statusCode", 200);
        expectedDataMap.put("completed", false);
        expectedDataMap.put("userId", 1);
        expectedDataMap.put("title", "quis ut nam facilis et officia qui");
        expectedDataMap.put("Via", "1.1 vegur");
        expectedDataMap.put("Server", "cloudflare");

        return  expectedDataMap;
    }


    public JSONObject getExpectedData() {

        JSONObject expectedData = new JSONObject();
        expectedData.put("userId",55);
        expectedData.put("title","Tidy your room");
        expectedData.put("completed",false);
        return expectedData;
    }

    public JSONObject setUpPut01 (){

        JSONObject requestBody = new JSONObject();
        requestBody.put("userId",21);
        requestBody.put("title","Wash the dishes");
        requestBody.put("completed",false);

        return setUpPut01();

    }

    public JSONObject setUpPatch01(){

        JSONObject requestBody = new JSONObject();
        requestBody.put("title", "API calismaliyim");

        return requestBody;
    }
    public JSONObject setUpExpectedBodyPatch01(){

        JSONObject expectedBody = new JSONObject();
        expectedBody.put("title", "API calismaliyim");
        expectedBody.put("userId", 10);
        expectedBody.put("completed",true);

        return expectedBody;
    }

    public JSONObject setUpDelete01(){
        /*
        {
 "status": "success",
 "data": "2",
 "message": "Successfully! Record has been deleted"
}
         */
        JSONObject expectedData=new JSONObject();
        expectedData.put("status","success");
        expectedData.put("data",2);
        expectedData.put("message","Successfully! Record has been deleted");
        expectedData.put("statusCode",200);
        return expectedData;
    }


}
