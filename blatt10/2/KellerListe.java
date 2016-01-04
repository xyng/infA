/******************************  KellerListe.java  ****************************/

import AlgoTools.IO;

/**
 * @version 02.01.16
 *
 * @author  dmelchior
 * @author  coelker
 */

public class KellerListe implements Liste {
	// enthält alle Elemente bis pos
	private VerweisKeller vorne;
	// enthält alle Elemente ab dem aktuellen Element
	private VerweisKeller hinten;

	/**
	 * Initialisiert eine neue Liste mithilfe von Kellern
	 */
	public KellerListe() {
		// Keller initialisieren
		vorne = new VerweisKeller();
		hinten = new VerweisKeller();
	}

	/**
	 * Ermittelt ob Liste leer ist
	 * @return true wenn Liste leer, false wenn nicht.
	 */
	public boolean empty() {
		// wenn beide Keller leer sind, so ist auch die Liste leer
		return vorne.empty() || hinten.empty();
	}

	/**
	 * Ermittelt ob Endposition (=> kein nächstes Element mehr) erreicht
	 * @return true wenn Endposition erreicht, false wenn nicht.
	 */
	public boolean endpos() {
		// wenn Pos keinen Nächsten hat (der in hinten liegt) ist die endpos
		// erreicht
		return hinten.empty();
	}

	/**
	 * Setzt Position in Liste auf den Anfang
	 */
	public void reset() {
		while(!vorne.empty()) {
			hinten.push(vorne.top());
			vorne.pop();
		}
	}

	/**
	 * Rückt Position um ein Element weiter, sofern dieses existiert.
	 *
	 * @throws RuntimeException wenn Ende der Liste erreicht und kein Element
	 *         weiter gerückt werden kann.
	 */
	public void advance() {
		if(this.endpos()) {
			throw new RuntimeException("Endposition erreicht");
		}
		vorne.push(hinten.top());
		hinten.pop();
	}

	/**
	 * Gibt das aktuelle Element aus
	 * @return Objekt des aktuellen Elements
	 *
	 * @throws RuntimeException wenn Ende der Liste erreicht und kein Element
	 *         ausgegeben werden kann.
	 */
	public Object elem() {
		if(this.endpos()) {
			throw new RuntimeException("Kein aktuelles Objekt vorhanden");
		}
		return hinten.top();
	}

	/**
	 * Fügt neues Element ein
	 * @param x beliebiges Objekt
	 * @throws RuntimeException wenn x null ist.
	 */
	public void insert(Object x) {
		if(x == null) {
			throw new RuntimeException("Kein brauchbares Objekt gegeben");
		}
		hinten.push(x);
	}

	/**
	 * Entfernt aktuelles Objekt, sofern dieses existiert
	 *
	 * @throws RuntimeException wenn Ende der Liste erreicht und kein Element
	 *         entfernt werden kann.
	 */
	public void delete() {
		if(this.endpos()) {
			throw new RuntimeException("Kein aktuelles Objekt vorhanden");
		}
		hinten.pop();
	}
}
