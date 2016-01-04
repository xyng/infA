/******************************  Quersumme.java  ******************************/

import AlgoTools.IO;

/**
 *  * @version 25.10.15
 *  *
 *  * @author  dmelchior, coelker
 *  */

public class Quersumme {

  public static void main(String[] argv) {
    int zahl, summe; // initialisiere Variablen als integer

    summe = 0; // wähle summe neutral

    do {
      zahl = IO.readInt("Gebe eine positive Zahl ein: ");
      // lasse n mithilfe der AlgoTools vom Nutzer eingeben
    } while (zahl <= 0);

    while (zahl != 0) {
      summe = summe + (zahl % 10);
      // helper um n modulo 10 erhöhen (=> letzte Ziffer von n).
      zahl /= 10; // n durch 10 entfernt die letzte ziffer.
    }

    IO.println("Die Quersumme ist: " + summe);
    }
}
