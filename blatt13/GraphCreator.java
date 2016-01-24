/******************************  GraphCreator.java  ***************************/

import AlgoTools.IO;

/**
 * @version 24.01.16
 *
 * @author	dmelchior
 * @author	coelker
 */

public class GraphCreator {
	/**
	 * Wandelt Adjazenzmatrix in einen Graph (Adjazenzliste) um.
	 * @param  matrix Adjazenzmatrix
	 * @return        Adjazenzliste
	 */
	public static Graph graphFromAdjazenzmatrix(double[][] matrix) {
		Graph graph = new Graph();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				double cost = matrix[i][j];
				// Wenn Kosten kleiner als unendlich sind lege eine neue Kante an
				if (cost > 0 && cost < Double.POSITIVE_INFINITY) {
					// Array-Indizes zu Strings konvertieren um Knotennamen zu erhalten
					graph.addEdge(Integer.toString(i), Integer.toString(j), cost);
				}
			}
		}
		// Umrühren, fertig.
		return graph;
	}
}
