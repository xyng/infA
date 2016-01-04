/******************************  MatrixMultiplikation.java  **********************************/

import AlgoTools.IO;

/**
 *  * @version 07.11.15
 *  *
 *  * @author  dmelchior, coelker
 *  */

public class MatrixMultiplikation {

  public static void main(String[] argv) {
    int rowsMatA, rowsMatB, colsMatA, colsMatB;
    int[][] matA, matB, matC;

    IO.println("Matrix A");
    do {
      rowsMatA = IO.readInt("Reihen: ");
      rowsMatB = colsMatA = IO.readInt("Spalten: ");
      if (rowsMatA <= 0 || colsMatA <= 0) {
        IO.println("Maße der Matrix müssen größer als 0 sein!");
      }
    } while(rowsMatA <= 0 || colsMatA <= 0);

    IO.println("Matrix B");
    do {
      colsMatB = IO.readInt("Spalten: ");
      if (colsMatA <= 0) {
        IO.println("Maße der Matrix müssen größer als 0 sein!");
      }
    } while(colsMatB <= 0);

    // Matrizen initialisieren
    matA = new int[rowsMatA][colsMatA];
    matB = new int[rowsMatB][colsMatB];
    matC = new int[rowsMatA][colsMatB];

    // Matrizen einlesen

    // Matrix A
    IO.println();
    IO.println("Daten für Matrix A");
    for(int i = 0; i < matA.length; i++) {
      do {
        matA[i] = IO.readInts("Zahlen für Reihe " + (i+1) + ": ");
        if(matA[i].length < colsMatA) {
          IO.println("Eingabe zu kurz! Bitte " + (colsMatA) + " Zahlen eingeben!");
        } else if(matA[i].length > colsMatA) {
          IO.println("Eingabe zu lang! Bitte " + (colsMatA) + " Zahlen eingeben!");
        }
      } while(matA[i].length != colsMatA);
    }

    // Matrix B
    IO.println();
    IO.println("Daten für Matrix B");
    for(int i = 0; i < matB.length; i++) {
      do {
        matB[i] = IO.readInts("Zahlen für Reihe " + (i+1) + ": ");
        if(matB[i].length < colsMatB) {
          IO.println("Eingabe zu kurz! Bitte " + (colsMatB) + " Zahlen eingeben!");
        } else if(matB[i].length > colsMatB) {
          IO.println("Eingabe zu lang! Bitte " + (colsMatB) + " Zahlen eingeben!");
        }
      } while(matB[i].length != colsMatB);
    }

    // Matrizen multiplizieren nach gegebener Summenformel
    for(int i = 0; i < rowsMatA; i++) {
      for(int j = 0; j < colsMatB; j++) {
        matC[i][j] = 0;
        for(int k = 0; k < colsMatA; k++) {
          matC[i][j] += matA[i][k] * matB[k][j];
        }
      }
    }

    // Ergebnis ausgeben
    IO.println();
    IO.println("Ergebnis: ");
    for(int i = 0; i < matC.length; i++) {
      for(int j = 0; j < matC[i].length; j++) {
        IO.print(matC[i][j] + "  ");
      }
      IO.println();
    }
  }
}