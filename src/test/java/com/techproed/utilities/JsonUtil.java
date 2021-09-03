package com.techproed.utilities;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class JsonUtil {
    //object mapper kullanarak de_serialization yapma yöntemi
    private  static ObjectMapper mapper;
    static{
        mapper=new ObjectMapper();
    }
    //Methodumuzu oluşturacağız. Stringe çevrilmiş json datasını java objesine dönüştürecek.
    //T --> genelde developerların kullandığı generic bir ifadedir.
    // Tüm data type ları kapsar,
    // burada bize gelen json ifadesini kendisi tarıyor ve ne yapması gerektiğine kendisi karar veriyor.

    public static <T> T convertJsonToJava(String json,Class<T> cls){
        T javaResult= null;
        try {
            javaResult = mapper.readValue(json, cls);
            //methoda gelen parametreleri okuyor ve bunu mapper tipinde javaResult a aktarıyor.
        } catch (IOException e) {
            System.err.println("json datası javaya dönüştürülemedi"+e.getMessage());
        }
        return javaResult;
    }

    public static String fromJavaToJson (Object obj){

        String jsonResult = null;
        try {
            jsonResult = mapper.writeValueAsString(obj);
        } catch (IOException e) {
            System.out.println("Could't convert Java Object to Json format" + e.getMessage());
        }
        return  jsonResult;

    }

}
