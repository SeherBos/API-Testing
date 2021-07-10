package com.techproed.testData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PracticeDummy {
     /*
     http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
 Status kodun 200 olduğunu,
 5. Çalışan isminin "Airi Satou" olduğunu ,  çalışan sayısının 24 olduğunu,
 Sondan 2. çalışanın maaşının 106450 olduğunu
 40,21 ve 19 yaslarında çalışanlar olup olmadığını
 11. Çalışan bilgilerinin
   {
  “id”:”11”
  "employee_name": "Jena Gaines",
 "employee_salary": "90560",
 "employee_age": "30",
 "profile_image": "" }
 } gibi olduğunu test edin.
      */

    public HashMap<String,Object> setUpData(){

        HashMap<String,Object> expectedDataMapFromTestData= new HashMap<>();

        List<Integer> age = new ArrayList<Integer>();
        age.add(40);
        age.add(21);
        age.add(19);

        Map<String,Object> eleventh = new HashMap<String,Object>();
        eleventh.put("id",11);
        eleventh.put("employee_name","Jena Gaines");
        eleventh.put("employee_salary",90560);
        eleventh.put("employee_age",30);
        eleventh.put("profile_image","");

        expectedDataMapFromTestData.put("statusCode",200);
        expectedDataMapFromTestData.put("employeeNumber",24);
        expectedDataMapFromTestData.put("salary",106450);
        expectedDataMapFromTestData.put("fifthEmployee","Airi Satou");
        expectedDataMapFromTestData.put("eleven",eleventh);
        expectedDataMapFromTestData.put("ages",age);

        return expectedDataMapFromTestData;
    }

}
