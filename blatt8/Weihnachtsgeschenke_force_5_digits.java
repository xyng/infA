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
			char[] zahlChar;
			int zahl = 0;
			boolean invalid;
	    do {
		    invalid = false; // wir gehen zunächst von einer gültigen Eingabe aus.
		    zahlChar = IO.readChars("Bitte Paketnummer (5-Stellig): ");
		    if(zahlChar.length < 5) {
			    IO.println("Bitte eine 5-Stellige Paketnummer!");
			    invalid = true;
		    } else {
			    for(int i = 0; i < zahlChar.length && !invalid; i++) {
				    int zahlTemp = zahlChar[i] - '0';
				    if (zahlTemp < 0 || zahlTemp > 9) {
					    invalid = true;
				    } else {
					    // Nullen an temporäre Zahl anhängen und auf Zahl addieren
							for(int p = i; p < zahlChar.length - 1; p++, zahlTemp *= 10);
							zahl += zahlTemp;
						}
		    	}
		    }
		    if(invalid) {
					IO.println("Bitte eine gültige Paketnummer!");
		    }
		  } while (invalid);

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
	    // Paketnummer in char-Array umwandeln um auch führende Nullen auszugeben.
	    int zahl = pakete[i];
	    char[] num = new char[5];
      for (int j = num.length - 1; j >= 0; j--, zahl /= 10) {
			  num[j] = (char) ('0' + zahl % 10);
		  }
		  for (int j = 0; j < num.length; j++) {
			  IO.print(num[j]);
		  }
			IO.println();
    }
  }
}
