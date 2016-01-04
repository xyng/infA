/******************************  Tabelle.java  ******************************/

import AlgoTools.IO;

/**
 *  * @version 25.10.15
 *  *
 *  * @description Gibt eine Wertetabelle des Modulo zweier Zahlen aus.
 *  * @author  dmelchior, coelker
 *  */

public class Tabelle {
  public static void main(String[] args) {
    int zahl, i, j;
    do {
      zahl = IO.readInt("Gebe eine Zahl zwischen 1 und 15 ein: ");
      if (zahl < 1 || zahl > 15) {
        IO.println("Die Zahl " + zahl + " liegt nicht zwischen 1 und 15!");
      }
    } while(zahl < 1 || zahl > 15);
    IO.print("  |  "); // linker headerteil der Tabelle
    for (i=1; i<=zahl; i++) {
      IO.print(" " + i + " "); // zahlenreihe im header
    }
    IO.println();
    IO.print("--+-"); // tabellen border
    for (i=1; i<=zahl; i++) {
      if (i >=  10) {
        IO.print("-"); // extra whitespace um größere headerzahl auszugleichen
      }
      IO.print("---"); // tabellen border
    }
    IO.println();
    for (i = 1; i <=zahl; i++) {
      if (i < 10) {
        IO.print(" "); // extra whitespace für einstellige Zahlen
      }
      IO.print(i + "| "); // linke zahlenreihe
      for (j = 1; j <= zahl; j++) {
        if (j >=  10) {
          IO.print(" "); // extra whitespace um größere headerzahl auszugleichen
        }
        if (i%j < 10) {
          IO.print(" "); // extra whitespace für einstellige Zahlen
        }
        IO.print(" " + i%j); // ergebnis ausgeben
      }
      IO.println();
    }
  }
}
