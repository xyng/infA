/******************************  GraphCreatorTest.java  ***********************/

import AlgoTools.IO;

/**
 * @version 24.01.16
 *
 * @author	dmelchior
 * @author	coelker
 */

public class GraphCreatorTest {
	public static void main(String[] args) {
		double[][] matrix;
		int knoten;

		do {
			knoten = IO.readInt("Anzahl der Knoten: ");
			if (knoten < 2) {
				IO.println("Es müssen mindestens 2 Knoten sein!");
			}
		} while (knoten < 2);

		matrix = new double[knoten][knoten];

		IO.println("Eingabe der Kosten für die Kanten. 0 für keine Kante");

		for (int i = 0; i < knoten; i++) {
			for (int j = 0; j < knoten; j++) {
				if (i != j) {
					double cost;
					do {
						cost = IO.readDouble("Kosten von Knoten " + i +
													" zu Knoten " + j + " ");
						if (cost < 0) {
							IO.println("Eingabe muss >= 0 sein!");
						}
					} while (cost < 0);
					if (cost == 0) {
						matrix[i][j] = Double.POSITIVE_INFINITY;
					} else {
						matrix[i][j] = cost;
					}
				} else {
					matrix[i][j] = 0;
				}
			}
		}

		GraphIO.printGraph(GraphCreator.graphFromAdjazenzmatrix(matrix));
	}
}
