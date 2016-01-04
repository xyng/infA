/*******************************  BuchDaten.java  *****************************/

import AlgoTools.IO;

/**
 * @version 04.12.15
 *
 * @author  dmelchior
 * @author  coelker
 */

/**
 * Einfacher Algorithmus zur Erfassung von Buchdaten mit Hilfe von
 * char-Arrays
 */

public class BuchDaten{

  /**
  * Erzeugt Buchdaten-Array aus uebergebenen Attributen und
  * haengt diese der als char[][][] Array uebergebenen Liste an.
  *
  * @param titel Vorname des anzulegenden Buchdatums
  * @param autor Nachname des anzulegenden Buchdatums
  * @param erscheinungsjahr Alter des anzulegenden Buchdatums
  * @param liste Array mit bereits vorhandenen Buchdaten
  * @return Kopie der Buchdatenliste ergaenzt um das neue Datum
  * @throws RuntimeException falls erscheinungsjahr kleiner 0 oder groesser 2012
  */
  public static char[][][] addBuch(char[] titel, char[] autor,
                                   int erscheinungsjahr, char[][][] liste){
	  if (erscheinungsjahr < 0 || erscheinungsjahr > 2012) {
		  throw new RuntimeException("Erscheinungsjahr muss zwischen 0 und 2012 " +
		  													 "liegen.");
	  }

		// Int zu Char-Array
		// Anzahl der Ziffern bestimmen
	  int yearLength = 0;
	  int jahrTemp = erscheinungsjahr;
	  do {
		  jahrTemp /= 10;
		  yearLength++;
	  } while (jahrTemp > 0);

	  char[] year = new char[yearLength];

		// In Array übertragen
	  for (int i = year.length - 1; i >= 0; i--, erscheinungsjahr /= 10) {
		  year[i] = (char) ('0' + erscheinungsjahr % 10);
	  }

		// Neues Buch erzeugen und Daten setzen
		char[][] book = new char[3][];

		book[0] = titel;
		book[1] = autor;
		book[2] = year;

		// Temporäre Liste erzeugen, die ein Element größer ist als die vorherige
		char[][][] tempBooks = new char[liste.length + 1][][];

		// alte Daten übertragen
		for(int i = 0; i < liste.length; i++) {
			tempBooks[i] = liste[i];
		}

		// neues Buch anhängen
		tempBooks[liste.length] = book;

		// Umrühren - fertig!
	  return tempBooks;
  }

  /**
  * Liesst iteriert Buchendaten ein und gibt die Daten anschliessend
  * auf der Konsole aus.
  */
  public static void main(String[] argv) {

    // Diese Methode soll NICHT geändert werden.

    char[][][] liste = new char[0][][];

    do{

      IO.println("Bitte geben Sie Buchdaten ein.");
      char[] titel=IO.readChars("Bitte den Titel eingeben: ");
      char[] autor=IO.readChars("Bitte den Autor eingeben: ");
      int erscheinungsjahr=IO.readInt("Bitte das Erscheinungsjahr eingeben: ");

      liste=addBuch(titel,autor,erscheinungsjahr,liste);

    }while(IO.readInt("Moechten Sie weitere Buecher eingeben?"
                          +" Abbruch mit 0: ")!=0);


    for(int i=0; i<liste.length; i++){
      IO.println("Buch Nr. "+(i+1));
      IO.println("Titel: ");
      for(int j=0; j<liste[i][0].length; j++){
        IO.print(liste[i][0][j]);
      }
      IO.println();
      IO.println("Autor: ");
      for(int j=0; j<liste[i][1].length; j++){
        IO.print(liste[i][1][j]);
      }
      IO.println();
      IO.println("Erscheinungsjahr: ");
      for(int j=0; j<liste[i][2].length; j++){
        IO.print(liste[i][2][j]);
      }
      IO.println();
    }
  }
}
