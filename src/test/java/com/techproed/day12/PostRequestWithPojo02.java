package com.techproed.day12;

import com.techproed.pojos.ActualBookingPojo;
import com.techproed.pojos.BookingDatesPojo;
import com.techproed.pojos.BookingPojo;
import com.techproed.testBase.TestBaseHerokuApp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostRequestWithPojo02 extends TestBaseHerokuApp {

/*
https://restful-booker.herokuapp.com/booking
    request body {
                   "firstname": "Selim",
                   "lastname": "Ak",
                   "totalprice": 15000,
                   "depositpaid": true,
                   "bookingdates": {
                       "checkin": "2020-09-09",
                       "checkout": "2020-09-21"
                    }
                 }
   Status code is 200
    response body  {
                            "bookingid": 11,
                            "booking": {
                                "firstname": "Selim",
                                "lastname": "Ak",
                                "totalprice": 15000,
                                "depositpaid": true,
                                "bookingdates": {
                                    "checkin": "2020-09-09",
                                    "checkout": "2020-09-21"
                                }
                            }
                         }
 */

    @Test
    public void test(){
        spec02.pathParam("param1","booking");

        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2020-09-09","2020-09-21");
        BookingPojo booking = new BookingPojo("Selim","Ak",15000,true,bookingDatesPojo);
       //en ic katmandan en dis katmana dogru tanimlamalar yapilir,
        // Dolayisiyla once booking dates tanimladik ve ardindan "booking" adinda olan katmanin son elemani olarak "bookingDatesPojo"
        // diyerek nested yapiyi olusturmus olduk.

        Response response=given().contentType("application/json").
                spec(spec02).auth().basic("admin","password123").body(booking).when().post("/{name}");

        response.prettyPrint();


        ActualBookingPojo actualBookingPojo =(response.as(ActualBookingPojo.class));
        System.out.println(actualBookingPojo);

        Assert.assertEquals(booking.getFirstname(),actualBookingPojo.getBooking().getFirstname());
        // actual datada olan first name'e ulasmak icin once booking katmanina gitmem gerekiyor ki first name'e ulasabileyim.
        // dolayisiyle actualBookingPojo.getBooking().getFirstname()); yazip karsilastirmis olduk.

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(booking.getLastname(),actualBookingPojo.getBooking().getLastname());
        Assert.assertEquals(booking.getTotalprice(),actualBookingPojo.getBooking().getTotalprice());
        Assert.assertEquals(booking.isDepositpaid(),actualBookingPojo.getBooking().isDepositpaid());
        Assert.assertEquals(booking.getBookingdates().getCheckin(),
                  actualBookingPojo.getBooking().getBookingdates().getCheckin());
        Assert.assertEquals(booking.getBookingdates().getCheckout(),
                actualBookingPojo.getBooking().getBookingdates().getCheckout());



    }


}
