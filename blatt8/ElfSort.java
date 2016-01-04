/******************************  ElfSort.java  ********************************/

import AlgoTools.IO;

/**
 * @version 04.12.15
 *
 * @author  dmelchior
 * @author  coelker
 */

public class ElfSort {
	private static int findeZiffer(int zahl, int ziffer) {
		// Zahl bis zur gewünschten Stelle durch 10 teilen
		// ==> hintere Stellen entfernen
		for (int i = 0; i < ziffer; i++, zahl /= 10);
		// Mod 10 von Zahl zurückgeben um gewünschte Stelle zu isolieren
		return zahl % 10;
	}
	/**
	 * Sortiert Array von 5-Stelligen Paketnummern.
	 *
	 * @param pakete Zu sortierendes Array
	 * @param ziffer Zu betrachtene Stelle der Paketnummer
	 * @return Sortierte Pakete
	 */
  public static int[] sort(int[] pakete, int ziffer) {
	  // wenn nur noch ein Paket gegeben oder keine weiteren Ziffern
		if (pakete.length == 1 || ziffer == -1) return pakete;

		// 10 leere Fächer "Unterelfen" erstellen
		int[][] elfen = new int[10][0];

		// Pakete auf Unterelfen verteilen
		for(int i = 0; i < pakete.length; i++) {
			int nr = pakete[i];
			// Wert für Ziffer finden == Fachnummer
			int fach = findeZiffer(nr, ziffer);
			elfen[fach] = legeInFach(elfen[fach], nr);
		}

		// Laufwert für Ausgangsarray muss vor Schleife initialisiert werden
		int paket = 0;

		// Jedes Unterarray sortieren und in Ausgangsarray zurückführen
		for(int elf = 0; elf < elfen.length; elf++) {
			elfen[elf] = sort(elfen[elf], ziffer - 1);
			for(int elfPaket = 0; elfPaket < elfen[elf].length; elfPaket++, paket++) {
					pakete[paket] = elfen[elf][elfPaket];
			}
		}
		// Sortiertes Paket-Array zurückgeben
		return pakete;
  }

  private static int[] legeInFach(int[] ablagefach, int paketnr) {
		// Temporäres Fach erzeugen, das ein Element größer ist als die vorherige
		int[] tempAblage = new int[ablagefach.length + 1];

		// alte Daten übertragen
		for(int i = 0; i < ablagefach.length; i++) {
			tempAblage[i] = ablagefach[i];
		}

		// neue Paketnummer anhängen
		tempAblage[ablagefach.length] = paketnr;

		// Umrühren - fertig!
	  return tempAblage;
  }
}
