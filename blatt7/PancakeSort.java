/******************************  PancakeSort.java  ****************************/

import AlgoTools.IO;

/**
 * Sortiert eine Zahlenfolge mit dem PancakeSort-Verfahren.
 *
 * @version 29.11.15
 *
 * @author  dmelchior
 * @author coelker
 */

public class PancakeSort {
  /**
   * Dreht die Reihenfolge der ersten <tt>count</tt> Element in
   * <tt>array</tt> um.
   *
   * @param array das zu sortierende Array
   * @param count Anzahl zu flippender Elemente
   *
   * @throws RuntimeException wenn <tt>count</tt> > <tt>array.length</tt>
   */
  public static void flip(int[] array, int count) {
    int temp, pos = 0;

    if(count < array.length) throw new RuntimeException("Count < array length");

    while(pos < count) {
	    temp = array[pos];
	    array[pos] = array[count];
	    array[count] = temp;

			// Count verringern, position erhöhen
	    count--;
	    pos++;
    }
  }

  /**
   * Gibt ein Array auf dem Terminal aus.
   *
   * Beispiel: Ein Array mit den Zahlen 1, 2 und 3 als Inhalt
   * wird ausgegeben als: 1 2 3
   *
   * @param array Das auszugebene Array
   */
  public static void printArray(int[] array) {
    IO.println();
    for(int i = 0; i < array.length; i++) {
	    IO.print(" " + array[i]);
    }
    IO.println();
  }

  /**
   * Sortiert das gegebene <tt>array</tt> mit dem PancakeSort Verfahren.
   *
   * @param array zu sortierendes Array
   */
  public static void sort(int[] array) {
	  // Mit vollständigem Array anfangen und nach und nach kleiner werden
    for(int size = array.length; size > 1; size--) {
			// Größtes Element des aktuell betrachteten Bereichs finden
			int max = 0;
			for(int i = 0; i < size; i++) {
				if(array[i] > array[max]) max = i;
			}

			// Wenn das größte Element nicht schon unten ist, muss es dorthin
			// "gewendet" werden
			if(max != size - 1) {
				// Größtes Element des Bereichs zunächst nach oben befördern
				flip(array, max);
				 // Ganzen Bereich wenden um größtes Element nach unten zu bringen
				flip(array, size - 1);
			}
    }
  }

  public static void main(String[] args) {
  	int[] a = IO.readInts("Bitte Zahlenfolge: ");
		// Array sortiern und ausgeben
		printArray(sort(a));
  }
}
