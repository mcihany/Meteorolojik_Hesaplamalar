package mcy.cihanyeter.meteoroloji.meteorolojihesaplamalar;

/**
 * Created by mcyel on 11.11.2016.
 */

public class cevirimler {


    public static double fahrenayt_to_celcius(double f){

        double deger = 0;
        deger = (f - 32) / 1.8;
        return deger;
    }

    public static double celcius_to_fahrenayt(double cel)
    {
        double deger = 0;
        deger = (cel * 1.8) +32;
        return deger;
    }

    public static double mph_to_knot(double mph) {
        double deger = 0;
        deger = mph * 0.868976242;
        return deger;
    }
    public static double knot_to_mph(double knot)
    {
        double deger = 0;
        deger = knot / 0.868976242;
        return deger;
    }
    public static double mph_to_kmh(double mph)
    {
        double deger = 0;
        deger = mph * 1.609344;
        return deger;
    }

    public static double kmh_to_mph(double kmh) {

        double deger = 0;
        deger = kmh * 0.621371;
        return deger;
    }
}
