/******************************  Labyrinth.java  ******************************/

/**
 * Liest ein Labyrinth ein und berechnet mittels einem Backtracking
 * Algorithmus einen Weg durch dieses.
 *
 * @author Christian Heiden
 * @author Lukas Kalbertodt
 * @author Daniel Melchior
 * @author Charlotte Oelker
 */

import AlgoTools.IO;

public class Labyrinth {

	/** Freies Feld */
	private static final char FREI  = ' ';
	/** Mauer */
	private static final char MAUER = '#';
	/** Startfeld */
	private static final char START = 'S';
	/** Zielfeld */
	private static final char ZIEL  = 'Z';
	/** Besuchtes Feld */
	private static final char PFAD  = '-';


	/**
	 * Findet einen Weg durch das Labyrinth.
	 * Findet den Startpunkt und ruft findeZielRek mit dem Startpunkt auf.
	 *
	 * @param lab Das Labyrinth
	 * @throws RuntimeException Wenn kein Startpunkt gefunden wurde
	 * @return Ob ein Weg gefunden wurde
	 */
	private static boolean findeZiel(char[][] lab) {
		boolean foundStart = false;
		int x = 0;
		int y = 0;

		// Zeilen
		for(x = 0; !foundStart && x < lab.length; x++) {
			// Spalten
			for(y = 0; !foundStart && y < lab[x].length; y++) {
				if(lab[x][y] == START) {
					// Wenn Start gefunden: Suche beenden
					foundStart = true;
				}
			}
		}
		// Dekrement, weil Schleife einmal zu oft Inkremiert
		x--; y--;
		if(foundStart) {
			// Startpunkt gefunden, rekursion starten
			return findeZielRek(lab, x, y);
		} else {
			// Kein Startpunkt!
			throw new RuntimeException("Kein Startpunkt gefunden!");
		}
	}


	/**
	 * Findet rekursiv einen Weg durch das Labyrinth
	 *
	 * @param lab Das Labyrinth
	 * @param x X-Koordinate des Punktes bei dem man steht
	 * @param y Y-Koordinate des Punktes bei dem man steht
	 * @return Ob ein Weg gefunden wurde
	 */
	private static boolean findeZielRek(char[][] lab, int x, int y) {
		// Sind wir schon da?
		if(lab[x][y] == ZIEL) {
			return true;
		}
		/**
		 * Links: wenn nicht Pos y = 0 und vorheriger FREI || Ziel
		 * Rechts: wenn nicht Pos y = lab.length - 1 oder nächster FREI || ZIEL
		 * Oben: wenn nicht Pos x = 0, oder vorheriger FREI || ZIEL
		 * Unten: wenn nicht Pos x = lab.length - 1 oder nächster FREI || ZIEL
		*/
		boolean checkLeft, checkRight, checkTop, checkBottom, next;
		checkLeft = y != 0 && lab[x][y - 1] == FREI || lab[x][y - 1] == ZIEL;
		checkRight = y != lab[x].length - 1 && lab[x][y + 1] == FREI
											|| lab[x][y + 1] == ZIEL;
		checkTop = x != 0 && lab[x - 1][y] == FREI || lab[x -1][y] == ZIEL;
		checkBottom = x != lab.length - 1 && lab[x + 1][y] == FREI
										  || lab[x + 1][y] == ZIEL;

		next = false;

		if(!checkLeft && !checkRight && !checkTop && !checkBottom) {
			next = false;
		} else {
			if(lab[x][y] != START) {
				lab[x][y] = PFAD;
			}
			if(checkLeft && !next) {
				next = findeZielRek(lab, x, y - 1);
				if(!next) {
					lab[x][y - 1] = FREI;
				}
			}
			if(checkRight && !next) {
				next = findeZielRek(lab, x, y + 1);
				if(!next) {
					lab[x][y + 1] = FREI;
				}
			}
			if(checkTop && !next) {
				next = findeZielRek(lab, x - 1, y);
				if(!next) {
					lab[x - 1][y] = FREI;
				}
			}
			if(checkBottom && !next) {
				next = findeZielRek(lab, x + 1, y);
				if(!next) {
					lab[x + 1][y] = FREI;
				}
			}
		}
		return next;
	}

	/**
	 * Zeigt das uebergebene Labyrinth auf dem Terminal an
	 *
	 * @param lab Das anzuzeigende Labyrinth
	 */
	private static void druckeLabyrinth(char[][] lab) {
		for(int i = 0; i < lab.length; i++) {
			for(int j = 0; j < lab[i].length; j++) {
				IO.print(lab[i][j], 2);
			}
			IO.println();
		}
	}


	/**
	 * Liest das Labyrinth vom Terminal ein
	 * @return Das eingelesene Labyrinth
	 */
	private static char[][] leseEingabe() {
		int breite = 0, hoehe = 0;

		// Lese Breite ein
		do {
			breite = IO.readInt("Breite des Labyrinths: ");
		} while(breite <= 0);

		// Lese Hoehe ein
		do {
			hoehe = IO.readInt("Hoehe des Labyrinths: ");
		} while(hoehe <= 0);

		// Lege Array an, welches ausgegeben wird
		char[][] out = new char[hoehe][breite];

		// Fuer jede Zeile
		for(int i = 0; i < hoehe; i++) {
			char[] zeile;

			// lies Zeile mit korrekter Anzahl von Buchstaben ein
			do {
				zeile = IO.readChars("Zeile " + i + " des Labyrinths: ");
			} while(zeile.length != breite);

			out[i] = zeile;
		}
		return out;
	}

	/**
	 * Liest Labyrinth ein und findet einen Weg von S nach Z
	 */
	public static void main(String[]args){

		// Lese Labyrinth ein
		char[][] lab = leseEingabe();

		// Gebe aus
		IO.println();
		IO.println("----- Original-Labyrinth: -----");
		druckeLabyrinth(lab);
		IO.println();

		boolean gefunden = findeZiel(lab);

		if(gefunden) {
			// Gebe aus
			IO.println("-----   Gefundener Weg:   -----");
			druckeLabyrinth(lab);
		} else {
			IO.println("Kein Weg zum Ziel gefunden!");
		}
	}
}
