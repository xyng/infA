/******************************  VerweisSchlange.java  ************************/

import AlgoTools.IO;

/**
 * @version 02.01.16
 *
 * @author  dmelchior
 * @author coelker
 */

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
		// Wenn HEAD kein Folgeobjekt hat ist die Schlange leer
		return head.next == null;
	}

	/**
	 * Fügt neues Element ein
	 * @param x beliebiges Objekt
	 * @throws RuntimeException wenn x null ist.
	 */
	public void enq(Object x) {
		// Wenn x null ist, ist es nicht brauchbar
		if(x == null) {
			throw new RuntimeException("Kein brauchbares Objekt gegeben");
		}

		// Neuen Eintrag erstellen und verknüpfen
		Eintrag neu = new Eintrag();
		neu.inhalt = x;
		// Neuer Eintrag wird am Ende eingehängt, hat also null als Nächstes.
		neu.next = null;

		if(this.empty()) {
			// Wenn die Schlange leer ist wird neu als Folgeelement von HEAD
			// eingehängt
			head.next = neu;
			// Und ist gleichzeitig TAIL
			tail = neu;
		} else {
			// Wenn sie nicht leer ist wird neu das neue Folgelement vom "alten"
			// Tail
			tail.next = neu;
			// Und dann selber zum Tail
			tail = neu;
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
		// Wenn die Schlange leer ist kann nichts ausgegeben werden
		if(this.empty()) {
			throw new RuntimeException("Es gibt kein Element zum Ausgeben");
		}
		// Erstes Element liegt in HEAD.next
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
		// Wenn die Schlange leer ist kann kein Element abgeschnitten werden
		if(this.empty()) {
			throw new RuntimeException("Es gibt kein Element zum Entfernen");
		}
		// Folgelement von HEAD auf Folgeelement des Folgeelementes setzen
		head.next = head.next.next;
	}
}
