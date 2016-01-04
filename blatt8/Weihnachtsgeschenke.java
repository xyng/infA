/******************************  Weihnachtsgeschenke.java  ********************/

import AlgoTools.IO;

/**
 * @version 04.12.15
 *
 * @author  dmelchior
 * @author  coelker
 */

public class Weihnachtsgeschenke {
	/**
	 * Liest 5-Stellige Paketnummern ein und gibt diese sortiert aus.
	 */
  public static void main(String[] argv) {
	  int[] pakete = new int[0];
    do {
			// Neue Zahl einlesen und prüfen
			int zahl;
	    do {
		    zahl = IO.readInt("Bitte eine Paketnummer (maximal 5-Stellig): ");
		    if(zahl < 0 || zahl > 99999) {
					IO.println("Bitte eine gültige Paketnummer!");
		    }
		  } while (zahl < 0 || zahl > 99999);

		  // Pakete-Array um Zahl erweitern
		  int[] tempPakete = new int[pakete.length + 1];
		  for(int i = 0; i < pakete.length; i++) {
			  tempPakete[i] = pakete[i];
		  }
		  tempPakete[pakete.length] = zahl;

		  pakete = tempPakete;

    } while(IO.readInt("Moechten Sie weitere Pakete eingeben?"
                          +" Abbruch mit 0: ")!=0);

    pakete = ElfSort.sort(pakete, 4);

		IO.println("Sortierte Paketnummern:");
    for(int i = 0; i < pakete.length; i++) {
	    // Paketnummer ausgeben
			IO.println(pakete[i]);
    }
  }
}
