/******************************  OffeneHashtabelle.java  **********************/

import AlgoTools.IO;

/**
 * @version	17.01.16
 *
 * @author	dmelchior
 * @author	coelker
 */

public class OffeneHashtabelle implements Menge {
	private Liste[] lists;

	/**
	 * Initialisiert Hashtabelle mit 7 Listen
	 */
	OffeneHashtabelle() {
		lists = new Liste[7];

		for (int i = 0; i < 7; i++) {
			lists[i] = new VerweisListe();
		}
	}

	/**
	 * Prüft ob Tabelle leer
	 * @return true wenn leer, false sonst.
	 */
	public boolean empty() {
		// Alle Listen abklappern
		for (int i = 0; i < 7; i++) {
			// Und überprüfen, ob Liste leer
			if (!lists[i].empty()) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Prüfen ob Element in Tabelle liegt
	 * @param  x zu findendes Element
	 * @return   Comparable, falls Element gefunden, null sonst.
	 */
	public Comparable lookup(Comparable x) {
		// Element muss in Liste mit id hashCode % 7 liegen
		Liste list = lists[((Firma) x).hashCode() % 7];

		// Ist diese nicht leer
		if(!list.empty()) {
			// Zunächst zurücksetzen
			list.reset();
			// Dann so lange laufen bis Endpos gefunden
			while(!list.endpos()) {
				Comparable cur = (Comparable) list.elem();
				// Wenn Elemente gleich
				if (cur.compareTo(x) == 0) {
					// Gefundenes Element zurückgeben
					return cur;
				}
				// Ansonsten weiterlaufen
				list.advance();
			}
		}
		// Element nicht gefunden -> null zurückgeben
		return null;
	}

	/**
	 * Neue Firma in Tabelle einfügen
	 * @param  x Firma
	 * @return   true fals element eingefügt, false wenn nicht.
	 */
	public boolean insert(Comparable x) {
		// Existiert Element schon?
		if(lookup(x) != null) {
			// Wenn ja -> nichts neues einfügen und false zurückgeben
			return false;
		}
		// Ansonsten Objekt in entsprechende Liste einsetzen
		lists[((Firma) x).hashCode() % 7].insert(x);
		// Und true zurückgeben
		return true;
	}

	/**
	 * Objekt aus Tabelle löschen
	 * @param  x zu löschendes Objekt
	 * @return   True wenn element gefunden und gelöscht, false sonst.
	 */
	public boolean delete(Comparable x) {
		// Existiert zu löschendes Element=
		if(lookup(x) != null) {
			// Wenn ja -> löschen
			lists[((Firma) x).hashCode() % 7].delete();
			// Und true zurückgeben
			return true;
		}

		// Sonst false zurückgeben
		return false;
	}
}

