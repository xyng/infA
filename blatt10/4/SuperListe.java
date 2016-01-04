/******************************  SuperListe.java  *****************************/

import AlgoTools.IO;

/**
 * @version 02.01.16
 *
 * @author  dmelchior
 * @author  coelker
 */

public class SuperListe extends VerweisListe implements Liste {

	/**
	 * Initialisiert eine neue SuperListe
	 */
	public SuperListe() {
		super();
	}

	/**
	 * Kehrt die Liste um und setzt die Position auf den Anfang
	 */
	public void umdrehen() {
		Schlange hilf = new VerweisSchlange();

		// Position zunächst auf Anfang setzen
		this.reset();

		// Lese Listenihalt in Schlange und entferne aus Liste
		while(!this.empty()) {
			hilf.enq(this.elem());
			this.delete();
		}

		// Lese Schlangeninhalt in Liste zurück und lösche aus Schlange
		while(!hilf.empty()) {
			this.insert(hilf.front());
			hilf.deq();
		}

		// Position auf Anfang zurücksetzen
		this.reset();
	}

	/**
	 * Entfernt alle Duplikate aus der Liste
	 *
	 * @throws RuntimeException wenn Liste leer
	 */
	public void unique() {
		// In einer leeren Liste können keine Duplikate gesucht werden
		// ggf. überflüssige behandlung, da unique trotzdem laufen sollte
		if(this.empty()) {
			throw new RuntimeException("Diese Liste ist leer!");
		}

		// Hilfsvariablen
		boolean duplicate;
		Object current;
		Liste unique = new VerweisListe();

		// Position zunächst auf Anfang setzen
		this.reset();

		// Solange Liste nicht an Endposition
		while (!this.endpos()) {
			// Duplicat zurücksetzen
			duplicate = false;

			// Aktuelles Element zwischenspeichern
			current = this.elem();

			// Hilfsliste unique durchlaufen und prüfen ob gleiches
			// Element vorhanden
			while (!unique.endpos() && !duplicate) {
				duplicate = unique.elem().equals(current);
				unique.advance();
			}

			// Wenn kein Duplikat gefunden --> Element in unique speichern
			if (!duplicate) {
				unique.insert(current);
			}

			// Unique auf Anfang zurücksetzen
			unique.reset();

			// Aktuelles Element aus Liste entfernen
			this.delete();
		}

		// Hilfsliste Unique in Liste zurücklesen
		while (!unique.endpos()) {
			this.insert(unique.elem());
			unique.delete();
		}
	}

	/**
	 * Geht an die n-te Position in der Liste, sofern diese Existiert
	 * @param  n Position des zurückzugebenen Elements (>= 0)
	 * @return Objekt des n-ten Elementes
	 *
	 * @throws RuntimeException wenn Liste leer und kein n-tes Element exisitert
	 *
	 * @throws RuntimeException wenn n-tes Element der Liste nicht existiert
	 *         (=> Ende der Liste wird vor Position n erreicht)
	 *
	 * @throws RuntimeException wenn n < 0
	 */
	public Object elem(int n) {
		if(n < 0) {
			throw new RuntimeException("n muss >= 0 sein!");
		}

		if(this.empty()) {
			throw new RuntimeException("Liste ist Leer!");
		}

		// Liste auf Anfang zurücksetzen
		this.reset();

		// Bis an n-te Stelle gehen
		for(int i = 0; i < n; i++) {
			// Wenn an Endposition --> FEHLER!
			if(this.endpos()) {
				throw new RuntimeException("Ende der Liste");
			}
			this.advance();
		}

		// Element ausgeben
		return this.elem();
	}
}

