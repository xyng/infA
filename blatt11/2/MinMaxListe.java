/******************************* MinMaxListe.java *****************************/
import AlgoTools.IO;

/**
 * Erweitert die VerweisListe um die Funktionalität stets Zugriff
 * auf das größte und kleinste Element zu haben. Dabei wird davon ausgegangen,
 * dass nur Objekte eingefügt werden, die Comparable implementieren.
 *
 * @author  dmelchior
 * @author  coelker
 */
public class MinMaxListe extends VerweisListe {

	private int counter;

	/**
	 * Erzeugt neue MinMaxListe
	 */
	MinMaxListe() {
		super();
		// Anzahl der Elemente auf 0 setzen
		counter = 0;
	}

	/**
	 * Gibt das kleinste Element der Liste zurück
	 *
	 * @return Das kleinste Element
	 */
	public Object getMin() {
		if(!super.empty()) {
			super.reset();
			// kleinestes Element liegt immer an erster Stelle
			return super.elem();
		} else {
			// Wenn Liste leer existiert dieses nicht
			return null;
		}
	}

	/**
	 * Gibt das größte Element der Liste zurück
	 *
	 * @return Das größte Element
	 */
	public Object getMax() {
		if(!super.empty()) {
			super.reset();
			// bis zum letzen Element gehen
			for (int i = 1; i < counter; i++) {
				super.advance();
			}
			// dieses ist das größte
			return super.elem();
		} else {
			// Wenn Liste leer existiert das nicht
			return null;
		}
	}
	/**
	 * Fügt neuen Eintrag in die Liste derart ein, dass der größte und kleinste
	 * Wert bestimmt werden kann
	 * @param x Einzufügendes Objekt (muss Interface Comparable implementieren)
	 */
	public void insert(Object x) {
		// Wert um festzustellen ob Objekt an dieser Stelle gespeichert werden
		// muss
		boolean insert = false;

		// Liste zunächst auf Anfang setzen
		super.reset();

		// Laufe entweder bis Ende oder bis Einfügepunkt gefunden ist
		while(!super.endpos() && !insert) {
			// Einfügen wenn neues Objekt kleiner als aktuelles
			insert = ((Comparable) x).compareTo(super.elem()) < 0;
			if (!insert) {
				// sonst weiterlaufen
				super.advance();
			}
		}

		// Einfügen ausführen
		super.insert(x);

		// Counter erhöhen
		counter++;
	}

	/**
	 * Entfernt aktuelles Element aus der Liste derart, dass nach wie vor
	 * festgestellt werden kann welches das größte oder kleinste Element in
	 * der Liste ist.
	 */
	public void delete() {
		// Aktuelles Element entfernen
		super.delete();
		// Counter verringern
		counter--;
	}
}
