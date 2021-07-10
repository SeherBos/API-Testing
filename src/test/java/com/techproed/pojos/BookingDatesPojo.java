package com.techproed.pojos;

public class BookingDatesPojo {
//    {
//        "firstname": "Selim",
//            "lastname": "Ak",
//            "totalprice": 15000,
//            "depositpaid": true,
//            "bookingdates": {
//        "checkin": "2020-09-09",
//                "checkout": "2020-09-21"
//    }
//    }
    // nested bit yapi oldugu icin bu datayi iki farkli pojo classina bolmemiz lazim. bookingDates kismini buraya yazdik

    private String checkin;
    private String checkout;

    public BookingDatesPojo() {
    }

    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "BookingDatesPojo02{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
