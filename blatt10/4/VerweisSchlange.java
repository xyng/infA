/******************************  VerweisSchlange.java  ************************/

import AlgoTools.IO;

/**
 *  * @version 02.01.16
 *  *
 *  * @author  dmelchior
 *  */

public class VerweisSchlange implements Schlange {
	// Schlangenanfang
	private Eintrag head;
	// Schlangenende
	private Eintrag tail;

	/**
	 * Initialisiert Verweisschlange
	 */
	public VerweisSchlange() {
		// HEAD und TAIL als Einträge initialisieren
		head = new Eintrag();
		tail = new Eintrag();
	}

	/**
	 * Ermittelt ob Schlange leer ist
	 * @return true wenn Schlange leer, false wenn nicht.
	 */
	public boolean empty() {
		return head.next == null;
	}

	/**
	 * Fügt neues Element ein
	 * @param x beliebiges Objekt
	 * @throws RuntimeException wenn x null ist.
	 */
	public void enq(Object x) {
		if(x == null) {
			throw new RuntimeException("Kein brauchbares Objekt gegeben");
		}

		Eintrag hilf = new Eintrag();
		hilf.inhalt = x;
		hilf.next = null;

		if(this.empty()) {
			head.next = hilf;
			tail = hilf;
		} else {
			tail.next = hilf;
			tail = hilf;
		}
	}

	/**
	 * Gibt das vordere Element aus
	 * @return Objekt des vorderen Elements
	 *
	 * @throws RuntimeException wenn Ende der Schlange erreicht und kein Element
	 *         ausgegeben werden kann.
	 */
	public Object front() {
		if(this.empty()) {
			throw new RuntimeException("Es gibt kein Element zum Ausgeben");
		}
		return head.next.inhalt;
	}

	/**
	 * Entfernt vorderstes Objekt, sofern dieses existiert, und rückt zum
	 * Nächsten Element weiter.
	 *
	 * @throws RuntimeException wenn Ende der Schlange erreicht und kein Element
	 *         entfernt werden kann.
	 */
	public void deq() {
		if(this.empty()) {
			throw new RuntimeException("Es gibt kein Element zum Entfernen");
		}
		head = head.next;
	}
}
