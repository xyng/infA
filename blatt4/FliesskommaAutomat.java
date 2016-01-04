/******************************  FliesskommaAutomat.java  **********************************/

import AlgoTools.IO;

/**
 *  * @version 07.11.15
 *  *
 *  * @author  dmelchior, coelker
 *  */

public class FliesskommaAutomat {

  public static void main(String[] argv) {
    char[] input;
    boolean finished, error, kommaUsed;

    input = IO.readChars("Bitte eine Folge von: V(orzeichen), K(omma), Z(ahl): ");

    finished = error = kommaUsed = false; // alle bools auf false setzen

    for(int i = 0; i < input.length; i++) {
      switch(input[i]) {
        case 'V': case 'v':
          if(i == 0) { // Vorzeichen nur an stelle 0!
            finished = false; // Automat ist nicht in Endzustand!
          } else {
            error = true; // sonst liegt ein fehler vor
            IO.println("Fehler! Ein Vorzeichen darf nur an Stelle 0 stehen.");
          }
          break;
        case 'K': case 'k':
          // wenn vorheriges Zeichen eine Zahl ist und noch kein Komma benutzt wurd
          // und wenn Komma nicht erstes Zeichen
          if(i != 0 && ((input[i-1] == 'Z' || input[i-1] == 'z') && !kommaUsed)) {
            finished = false; // Automat ist nicht in Endzustand!
            kommaUsed = true; // komma wurde benutzt, kein weiteres zulässig
          } else {
            error = true; // sonst liegt ein fehler vor
            IO.println("Fehler! Ein Komma darf nur auf eine Zahl folgen.");
          }
          break;
        case 'Z': case 'z':
          finished = true; // Zahl ist immer ein Endzustand!
          break;
        default:
          // wenn der default case getroffen wird wurde ein ungültiges Zeichen gegeben
          IO.println("Fehler! Unbekanntes Zeichen: " + input[i]);
          break;
      }
    }

    // Die Eingabe ist gültig wenn finished wahr und error falsch ist:
    if(finished && !error) {
      IO.println("Die Eingegebene Zahl ist eine gültige Fließkommazahl!");
    } else {
      IO.println("Die Eingegebene Zahl ist keine gültige Fließkommazahl!");
    }
  }
}