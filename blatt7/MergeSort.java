/******************************  MergeSort.java  ******************************/

import AlgoTools.IO;

/**
 * Liest ein Integer-Array ein und sortiert es rekursiv nach dem MergeSort
 * verfahren.
 *
 * @version 29.11.15
 *
 * @author  dmelchior
 * @author  coelker
 *  */

public class MergeSort {

	private static int schritte = 0;

	/**
	 * Sortiert ein Integer-Array rekursiv mit dem MergeSort verfahren
	 *
	 * @param a Das zu sortierende Array
	 * @return Sortiertes Array
	 */
	public static int[] sortRekursiv(int[] a) {
		int[] left, right;

		int center;

		// Mitte (auch für ungerade Arrays) bestimmen
		if(a.length % 2 == 0) {
			center = a.length / 2;
		} else {
			center = a.length / 2 + 1;
		}

		// Entsprechend zwei Teilarrays initialisieren...
		left = new int[center];
		right = new int[a.length - center];

		// ... und diese Befüllen
		for(int i = 0; i < left.length; i++) {
			left[i] = a[i];
		}

		for(int i = 0; i < right.length; i++) {
			// i zählt hier für right hoch. Da dieses nach left ansetzt,
			// muss die Anzahl der Elemente zum Index für a addiert werden,
			// um wirklich die rechte Seite von a zu kopieren.
			right[i] = a[i + left.length];
		}

		// Wenn Teilarrays größer mehr als ein Element haben: Problem weiter
		// herunterbrechen
		if(left.length > 1) {
			left = sortRekursiv(left);
		}

		if(right.length > 1) {
			right = sortRekursiv(right);
		}

		// Jetzt sind beide Arrays genau ein Element groß
		// wir können sie also Zusammenführen. Und sortiert ausgeben.
		// --> Rekursionsanker.
		return merge(left, right);
	}

	public static void main(String[] argv) {
		int[] a = IO.readInts("Bitte Zahlenfolge: ");

		a = sortRekursiv(a);

		for(int i = 0; i < a.length; i++) {
			IO.print(" " + a[i]);
		}

		IO.println();

		IO.println("Benötigte Schritte: " + schritte);
	}

  /**
	 * Methode Merge aus Aufgaben-Anhang. Leicht geändert um Schritte zu zählen.
	 */
	private static int[] merge (int[]a, int[]b) {   // mischt a und b
												                         // liefert Ergebnis zurueck

		int i=0, j=0, k=0;                           // Laufindizes
		int[] c = new int[a.length + b.length];      // Platz fuer Folge c besorgen

		while ((i<a.length) && (j<b.length)) {       // mischen, bis ein Array leer
			schritte++;                                // Schritt zählen
			if (a[i] < b[j])                           // jeweils das kleinere Element
				c[k++] = a[i++];                         // wird nach c uebernommen
			else
				c[k++] = b[j++];
		}

		while (i<a.length) c[k++] = a[i++]; schritte++; // ggf.: Rest von Folge a
		while (j<b.length) c[k++] = b[j++]; schritte++; // ggf.: Rest von Folge b

		return c;                                       // Ergebnis abliefern
	}
}
