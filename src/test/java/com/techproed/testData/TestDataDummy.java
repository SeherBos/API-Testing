package com.techproed.testData;

import java.util.*;

public class TestDataDummy {
    /*
        http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
    Status kodun 200 olduğunu,
    5. Çalışan isminin "Airi Satou" olduğunu ,
    çalışan sayısının 24 olduğunu,
    Sondan 2. çalışanın maaşının 106450 olduğunu
    40,21 ve 19 yaslarında çalışanlar olup olmadığını
    11. Çalışan bilgilerinin
      {
     "id":11
     "employee_name": "Jena Gaines",
    "employee_salary": 90560,
    "employee_age": 30,
    "profile_image": "" }
    } gibi olduğunu test edin.
         */
    public HashMap<String,Object> setUpTestData(){
        HashMap<String,Object> expectedDataMap=new HashMap<String, Object>();

        List<Integer>yaslar=new ArrayList<Integer>();
        yaslar.add(40);
        yaslar.add(21);
        yaslar.add(19);

        HashMap<String,Object> onbirinci=new HashMap<String, Object>();

        onbirinci.put("id",11);
        onbirinci.put("employee_name","Jena Gaines");
        onbirinci.put("employee_salary",90560);
        onbirinci.put("employee_age",30);
        onbirinci.put("profile_image","");

        expectedDataMap.put("yasListesi",yaslar);
        expectedDataMap.put("employe11",onbirinci);
        expectedDataMap.put("statusCode",200);
        expectedDataMap.put("besinciCalisan","Airi Satou");
        expectedDataMap.put("calisanSayisi",24);
        expectedDataMap.put("istenenMaas",106450);
        return expectedDataMap;
    }
    /*
    Status kodun 200 olduğunu,
    En yüksek maaşın 725000 olduğunu,
    En küçük yaşın 19 olduğunu,
    İkinci en yüksek maaşın 675000
     */

    public HashMap<String,Integer> setUpTestData2 (){
        HashMap <String,Integer> expectedDataMap = new HashMap<String,Integer>();

        expectedDataMap.put("statusCode",200);
        expectedDataMap.put("enYuksekMaas",725000);
        expectedDataMap.put("enKucukYas",19);
        expectedDataMap.put("enYuksekMaas2",675000);
        return  expectedDataMap;

    }

    public HashMap<String, Object> setUp3(){
/*

    "name":"Ahmet Aksoy",
           "salary":"1000",
           "age":"18",
           "profile_image": ""
 */
        HashMap<String,Object> requestBodyMap = new HashMap<String,Object>();
        requestBodyMap.put("name","Ahmet Aksoy");
        requestBodyMap.put("salary",1000);
        requestBodyMap.put("age",18);
        requestBodyMap.put("profile_image","");
        return requestBodyMap;
    }

}