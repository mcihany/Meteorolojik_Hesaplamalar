package mcy.cihanyeter.meteoroloji.meteorolojihesaplamalar;

/**
 * Created by mcyel on 11.11.2016.
 */

public class hissedilen {

    public static double nemden_hissedilen(double nem,double sicaklik) {
        double deger = 0;
        if (nem >= 0 && nem <= 100)
        {

            double c1 = -42.379;
            double c2 = 2.04901523;
            double c3 = 10.14333127;
            double c4 = -0.22475541;
            double c5 = -6.83783 * Math.pow(10, -3);
            double c6 = -5.481717 * Math.pow(10 ,-2);
            double c7 = 1.22874 * Math.pow(10 , -3);
            double c8 = 8.5282 * Math.pow(10 , -4);
            double c9 = -1.99 * Math.pow(10 , -6);
            deger = c1 + (c2 * sicaklik) + (c3 * nem) + (c4 * nem * sicaklik) + (c5 * (Math.pow(sicaklik, 2))) + (c6 * (Math.pow(nem, 2))) +
                    (c7 * (Math.pow(sicaklik, 2)) * nem) + (c8 * sicaklik * (Math.pow(nem, 2))) + (c9 * (Math.pow(sicaklik, 2)) * Math.pow(nem, 2));
        }
        else {
            deger = -1;
        }
        return deger;
    }

    public static double ruzgardan_hissedilen(double ruzgar, double sicaklik) {
        double deger = 0;

        deger = 35.74 + (0.6215 * sicaklik) - 35.75 * (Math.pow(ruzgar, 0.16)) + 0.4275 * sicaklik * (Math.pow(ruzgar, 0.16));


        return deger;
    }
}
