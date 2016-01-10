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

	MinMaxListe() {
		super();
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

			return super.elem();
		} else {
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

			for (int i = 1; i < counter; i++) {
				super.advance();
			}

			return super.elem();
		} else {
			return null;
		}
	}

	public void insert(Object x) {
		boolean insert = false;

		super.reset();

		while(!super.endpos() && !insert) {
			insert = ((Comparable) x).compareTo(super.elem()) < 0;
			if (!insert) {
				super.advance();
			}
		}

		super.insert(x);

		counter++;
	}

	public void delete() {
		super.delete();

		counter--;
	}
}
