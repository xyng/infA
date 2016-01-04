/******************************  FloatToBit.java  **********************************/

import AlgoTools.IO;

/**
 *  * @version 01.11.15
 *  *
 *  * @author  dmelchior, coelker
 *  */

public class FloatToBit {

  public static void main(String[] argv) {
    int expLength, mantLength,
        exp, expHelper, expCounter;
    float zahl, mant;


    // Länge von Exponent und Mantisse festlegen
    expLength = 8;
    mantLength = 23;

    // Zahl einlesen
    // -------------------------------------------------------------------------

    do {
      zahl = IO.readFloat("Gebe eine Gleitkommazahl >= 1 oder >= -1 ein: ");
    } while (zahl > -1.0 && zahl < 1.0);

    // -------------------------------------------------------------------------
    // Ende Zahl einlesen

    // Header erzeugen
    // -------------------------------------------------------------------------

    IO.print(" S  "); // Vorzeichen plus extra whitespace

    IO.print("Exp  "); // Exponent plus extra whitespace

    for (int i = 1; i < expLength - 3; i++) { // kompensiere "Exp"
      IO.print(" ");
    }

    IO.print("M");

    for (int i = 0; i < mantLength - 1; i++) {
      IO.print(" ");
    }
    IO.println();

    // -------------------------------------------------------------------------
    // Ende Header

    // Zahl ausgeben
    // -------------------------------------------------------------------------

    // Vorzeichen: wenn zahl positiv 0, wenn negativ 1
    if (zahl >= 1.0) {
      IO.print(" 0  ");
    } else {
      IO.print(" 1  ");
      // ab jetzt soll die zahl wie eine positive behandelt werden, daher * -1
      // um das abgelesene Vorzeichen zu entfernen
      zahl *= -1.0;
    }

    // Exponent
    // -------------------------------------------------------------------------

    // Exponent berechnen
    // -------------------------------------------------------------------------
    // wähle Exponent = 0, sowie ExponentCounter und ExponentHelper 2^0 = 1
    // der ExponentHelper ist 2^Exponent

    exp = 0;
    expHelper = 1;
    expCounter = 1;

    while (expHelper < zahl) {
      expHelper *= 2; // erhöhe Potenz des Exponenten solange kleiner als Zahl
      exp++;
    }

    // dekrementiere den Exponenten, da die schleife einmal zu oft läuft
    exp--;

    // teile expHelper aus gleichem Grund durch zwei
    expHelper /= 2;

    // -------------------------------------------------------------------------
    // Ende Exponent berechnen

    // Exponent codieren
    // -------------------------------------------------------------------------
    // Potenzieren des Counters sodass er die höchstmögliche 2er Potenz erreicht
    // die mit der gegebenen Exponentenlänge möglich ist
    for (int i = 1; i < expLength; i++) {
      expCounter *= 2;
    }

    while (expCounter != 0) { // laufe bis counter 0 (letzte iteration counter=1)
      if (expCounter > exp) {
        IO.print("0"); // wenn counter größer als exp => passt nicht rein => 0
      } else {
        IO.print("1"); // sonst passt er rein => 1
        exp = exp - expCounter; //exponent um counter verringern
                                //da sonst alle folgenden Zahlen auch 1 geben
      }
      expCounter /= 2;
    }
    // -------------------------------------------------------------------------
    // Ende Exponent codieren

    // -------------------------------------------------------------------------
    // Ende Exponent

    // whitespace für bessere Formatierung
    IO.print(" ");

    // Mantisse
    // -------------------------------------------------------------------------

    // Mantisse berechnen
    // -------------------------------------------------------------------------

    // Zahl durch 2^Exponent = Mantisse. Dies -1 => Reduzierte Mantisse
    mant = (zahl / expHelper) - 1;

    // -------------------------------------------------------------------------
    // Ende Mantisse berechnen

    // Mantisse codieren
    // -------------------------------------------------------------------------

    for (int i = 0; i < mantLength; i++) { // laufe bis gesetze länge erreicht
      mant *= 2;
      if(mant >= 1) { // wenn Mantisse >= 1 ist, war sie >= 1/2^(-i)
        IO.print("1"); // daher dann 1 notieren
        mant = mant - 1; // und reduzieren
      } else {
        IO.print("0");
      }
    }

    // -------------------------------------------------------------------------
    // Ende Mantisse codieren

    // -------------------------------------------------------------------------
    // Ende Mantisse

    // -------------------------------------------------------------------------
    // Ende Zahl ausgeben

    IO.println();
  }
}
