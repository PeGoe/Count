/*
 * Copyright Goebel Software
 * 
 */

/**
 *
 * @author Goebel
 */
public class Stoppuhr {

    private static Stoppuhr stoppuhr;

    public static double gesamt(String marke) {
        return stoppuhr.gesamtInstance(marke);
    }

    public static void reset() {
        stoppuhr = null;
    }

    public static Stoppuhr start() {
        if (stoppuhr == null) {
            stoppuhr = new Stoppuhr();
        }
        gesamt("");
        return stoppuhr;
    }

    public static double zwischen(String marke) {
        return stoppuhr.zwischenInstance(marke);
    }

    private final long beginn;
    private long letzt;

    private Stoppuhr() {
        this.beginn = System.nanoTime();
        this.letzt = beginn;
    }

    public double gesamtInstance(String marke) {
        letzt = System.nanoTime();
        double sek = diff_in_sek(beginn, letzt);
        System.out.println("Zeitnahme gesamt " + marke + ": " + sek);
        return sek;
    }

    public double zwischenInstance(String marke) {
        long aktuell = System.nanoTime();
        double sek = diff_in_sek(letzt, aktuell);
        letzt = aktuell;
        System.out.println("Zeitnahme zwischen " + marke + ": " + sek);
        return sek;
    }

    private double diff_in_sek(long anfang, long ende) {
        long diffLong = ende - anfang;
        return diffLong / 1000000000.0;
    }

}
