/******************************  Primzahltest.java  ***************************/

import AlgoTools.IO;
/**
 *  * @version 28.10.15
 *  *
 *  * @author  dmelchior, coelker
 *  */

public class Primzahltest {

  public static void main(String[] argv) {
    int n, i, helper;

    do { // Zahl einlesen
      n = IO.readInt("Bitte eine positive ganze Zahl > 1: ");
      if (n <= 1) {
        IO.println(n + " ist keine positive ganze Zahl > 1!");
      }
    } while(n <= 1);

    /*
     * Teilersuche fuer n.
     * Da Wurzelziehen nicht moeglich ist, wird der modulo genommen bis
     * dieser entweder 0 ist oder der teiler bei n / 2 angekommen ist
     * (<= optimierung).
     *
     * Zu beginn wird i = 2 gesetzt um iterationen zu sparen, sofern n > 2
     */

    if (n > 2) {
      i = 2;
      do {
        helper = n % i;
        i+=2;
      } while(helper != 0 && i < (n / 2));

      /*
      * Nach ablauf der Schleife ist der Rest entweder 0 (=> keine Prim)
      * oder > 0 (Prim).
      */

      if (helper != 0) {
        IO.println(n + " ist eine Primzahl.");
      } else {
        IO.println(n + " ist keine Primzahl.");
      }
    } else {
      IO.println("2 ist eine Primzahl."); // sonderfall 2
    }
  }
}

